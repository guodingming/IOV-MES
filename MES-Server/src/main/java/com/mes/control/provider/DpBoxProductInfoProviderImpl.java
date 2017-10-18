package com.mes.control.provider;

import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.framework.rest.view.Page;
import com.mes.common.utils.IDGenerator;
import com.mes.common.utils.StringUtils;
import com.mes.control.mapper.DpBoxMapper;
import com.mes.control.mapper.DpBoxProductInfoMapper;
import com.mes.control.mapper.PdProductInfoMapper;
import com.mes.control.mapper.PdProductInfoNumberMapper;
import com.mes.dubbo.interprovider.control.IAgentProvider;
import com.mes.dubbo.interprovider.control.IDpBoxProductInfoProvider;
import com.mes.dubbo.interprovider.control.IDpRoutesProvider;
import com.mes.entity.control.DpBox;
import com.mes.entity.control.DpBoxProductInfo;
import com.mes.entity.control.PdProductInfo;
import com.mes.entity.control.PdProductInfoNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 开发平台-包装箱-产品
 * Created by xiuyou.xu on 2017/7/4.
 */
public class DpBoxProductInfoProviderImpl extends BaseProviderImpl<DpBoxProductInfo> implements IDpBoxProductInfoProvider {
    private static Logger logger = LoggerFactory.getLogger(DpBoxProductInfoProviderImpl.class);

    @Autowired
    @Qualifier("dpBoxProductInfoMapper")
    private DpBoxProductInfoMapper dpBoxProductInfoMapper;

    @Autowired
    @Qualifier("pdProductInfoNumberMapper")
    private PdProductInfoNumberMapper pdProductInfoNumberMapper;

    @Autowired
    @Qualifier("pdProductInfoMapper")
    private PdProductInfoMapper pdProductInfoMapper;

    @Autowired
    @Qualifier("dpBoxMapper")
    private DpBoxMapper dpBoxMapper;

    @Autowired
    @Qualifier("agentProvider")
    private IAgentProvider agentProvider;

    @Autowired
    @Qualifier("dpRoutesProvider")
    private IDpRoutesProvider dpRoutesProvider;



    @Override
    public DpBoxProductInfoMapper getBaseInterfaceMapper() {
        return dpBoxProductInfoMapper;
    }

    /**
     * 产品和包装箱绑定
     *
     * @param number
     * @param boxKey
     * @return ledengyun--2017/09/08
     * @throws DubboProviderException
     */
    public boolean saveProductToBox(String number, String boxKey) throws DubboProviderException {
        PdProductInfoNumber pdProductInfoNumber = pdProductInfoNumberMapper.findByNumber(number);
        if (pdProductInfoNumber != null) {
            PdProductInfo pdProductInfo = pdProductInfoMapper.findById(pdProductInfoNumber.getPdProductInfoId());
            if (pdProductInfo != null) {
                DpBox dpBox = dpBoxMapper.findByPdId(pdProductInfo.getPdId(), boxKey);
                DpBoxProductInfo boxProductInfo = this.dpBoxProductInfoMapper.findByProIdAndBoxKey(pdProductInfo.getId(), dpBox.getId());
                if (boxProductInfo == null) {
                    if (dpBox != null) {
                        String id = IDGenerator.getID();
                        DpBoxProductInfo dpBoxProductInfo = new DpBoxProductInfo();
                        dpBoxProductInfo.setId(id);
                        dpBoxProductInfo.setPdName(pdProductInfo.getPdName());
                        dpBoxProductInfo.setPdProductInfoId(pdProductInfoNumber.getPdProductInfoId());
                        dpBoxProductInfo.setHardVersion(pdProductInfo.getHardVersion());
                        dpBoxProductInfo.setSoftVersion(pdProductInfo.getSoftVersion());
                        dpBoxProductInfo.setPdId(pdProductInfo.getPdId());
                        dpBoxProductInfo.setWorkOrderId(pdProductInfo.getWorkOrderId());
                        dpBoxProductInfo.setWorkOrderBatchNum(pdProductInfo.getWorkOrderBatchNum());
                        dpBoxProductInfo.setBoxId(dpBox.getId());
                        dpBoxProductInfo.setCreateDate(new Date());
                        dpBoxProductInfoMapper.save(dpBoxProductInfo);
                        Long dd = dpBox.getQuantity();
                        if (dd != null) {
                            dpBox.setQuantity(dpBox.getQuantity() + 1L);
                        } else {
                            dpBox.setQuantity(1L);
                        }
                        dpBoxMapper.update(dpBox);
                        if (dpBox.getCapacity() == dpBox.getQuantity()) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }



    /**
     * 验证产品与包装箱是否已经绑定
     *
     * @param number
     * @param boxKey
     * @return ledengyun--2017/09/08
     * @throws DubboProviderException
     */
    public JsonViewObject checkCode(String number, String boxKey) throws DubboProviderException {
        JsonViewObject jsonView = new JsonViewObject();
        Map<String, Object> map = Maps.newHashMap();
        String pdProductInfoId = null;
        String boxId = null;
        PdProductInfoNumber pdProductInfoNumber = pdProductInfoNumberMapper.findByNumber(number);
        if (pdProductInfoNumber != null) {
            pdProductInfoId = pdProductInfoNumber.getPdProductInfoId();
            DpBox dpBox = dpBoxMapper.findByBoxKey(boxKey);
            if (dpBox != null) {
                boxId = dpBox.getId();
            }
            map.put("pdProductInfoId", pdProductInfoId);
            map.put("boxId", boxId);
            List list = dpBoxProductInfoMapper.findByMap(map);
            if (list.size() > 0) {
                jsonView.successPack(true, "该产品与该包装箱已经绑定");
            } else {
                jsonView.successPack(false, "该产品可以正常装箱");
            }
        } else {
            jsonView.failPack("void", "无该产品信息");
        }
        return jsonView;
    }

    /**
     * 解除产品和包装箱的绑定
     *
     * @param number
     * @param boxKey
     * @return ledengyun--2017/09/08
     * @throws DubboProviderException
     */
    public boolean deleteByNum(String number, String boxKey) throws DubboProviderException {
        boolean flag = false;
        String pdProductInfoId = null;
        String boxId = null;
        PdProductInfoNumber pdProductInfoNumber = pdProductInfoNumberMapper.findByNumber(number);
        if (pdProductInfoNumber != null) {
            pdProductInfoId = pdProductInfoNumber.getPdProductInfoId();
            DpBox dpBox = dpBoxMapper.findByBoxKey(boxKey);
            if (dpBox != null) {
                boxId = dpBox.getId();
                DpBoxProductInfo dpBoxProductInfo = dpBoxProductInfoMapper.findByProIdAndBoxKey(pdProductInfoId, boxId);
                if (dpBoxProductInfo != null) {
                    String id = dpBoxProductInfo.getId();
                    dpBoxProductInfoMapper.deleteById(id);
                    DpBox dpBox1 = new DpBox();
                    dpBox1.setId(boxId);
                    dpBox1.setQuantity(dpBox.getQuantity() - 1L);
                    dpBoxMapper.update(dpBox1);
                    flag = true;
                }
            }

        }

        return flag;
    }

    @Override
    public Page productBoxByPage(Page page, Map<String, Object> map) throws DubboProviderException {
        Page pageLoad = page;
        try {
            pageLoad.setTotal(this.dpBoxProductInfoMapper.getProductBoxCount(map));
            map.put("startRowNum", page.getStartRowNum());
            map.put("pageSize", page.getPageSize());
            pageLoad.setRows(this.dpBoxProductInfoMapper.productBoxByPage(map));
        } catch (Exception e) {
            log.error("DpBoxProductInfoProviderImpl productBoxByPage ", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
        return pageLoad;
    }

    @Override
    public JsonViewObject updateProductUnionBox(String sourceBoxKey, String targetBoxKey, String boxProductInfoIds) throws DubboProviderException {
        JsonViewObject jsonView = new JsonViewObject();
        try {
            DpBox sourceBox = this.dpBoxMapper.findByBoxKey(sourceBoxKey);
            DpBox targetBox = this.dpBoxMapper.findByBoxKey(targetBoxKey);
            if (StringUtils.isNotBlank(boxProductInfoIds) &&
                    null != sourceBox &&
                    null != targetBox) {
                List<String> boxProductInfoIdList = Arrays.asList(boxProductInfoIds.split(","));
                if (!boxProductInfoIdList.isEmpty()) {
                    for (String boxProductInfoId : boxProductInfoIdList) {
                        DpBoxProductInfo dpBoxProductInfo = this.dpBoxProductInfoMapper.findById(boxProductInfoId);
                        //移入目标箱 修改产品绑定的包装箱ID
                        dpBoxProductInfo.setBoxId(targetBox.getId());
                        this.dpBoxProductInfoMapper.update(dpBoxProductInfo);
                        //修改目标箱已装产品数量
                        targetBox.setQuantity(targetBox.getQuantity() == null?1:targetBox.getQuantity() + 1);
                        this.dpBoxMapper.update(targetBox);
                        //修改原箱已装产品数量
                        sourceBox.setQuantity(sourceBox.getQuantity() - 1);
                        this.dpBoxMapper.update(sourceBox);
                    }
                }
                jsonView.successPack(true, "拆并箱移动产品成功");
            } else {
                jsonView.successPack(false, "拆并箱移动产品失败");
            }
        }catch (Exception e){
            jsonView.failPack(false, "拆并箱移动产品失败");
            log.error("DpBoxProductInfoProviderImpl unionBox", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
        return jsonView;
    }

    @Override
    public JsonViewObject updateUnBox(String boxKey, String boxProductInfoIds) throws DubboProviderException {
        JsonViewObject jsonView = new JsonViewObject();
        try {
            DpBox box = this.dpBoxMapper.findByBoxKey(boxKey);
            if (null != box) {
                List<String> boxProductInfoIdList = Arrays.asList(boxProductInfoIds.split(","));
                if (!boxProductInfoIdList.isEmpty()) {
                    for (String boxProductInfoId : boxProductInfoIdList) {
                        //修改原箱已装产品数量
                        if (box.getQuantity() > 0) {
                            DpBoxProductInfo dpBoxProductInfo = this.dpBoxProductInfoMapper.findById(boxProductInfoId);
                            this.dpBoxProductInfoMapper.deleteById(dpBoxProductInfo.getId());
                            box.setQuantity(box.getQuantity() - 1);
                            this.dpBoxMapper.update(box);
                            jsonView.successPack(true, "拆箱成功");
                        }
                    }
                }
            } else {
                jsonView.successPack(false, "拆箱失败");
            }
        }catch (Exception e){
            jsonView.failPack(false, "拆箱失败");
            log.error("DpBoxProductInfoProviderImpl updateUnBox", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
        return jsonView;
    }

    @Override
    public JsonViewObject getBoxProduct(String boxKey) throws DubboProviderException {
        JsonViewObject jsonView = new JsonViewObject();
        try {
            Map<String, Object> query = Maps.newHashMap();
            query.put("boxKey", boxKey);
            List<DpBoxProductInfo> boxProductInfoList = this.dpBoxProductInfoMapper.productBoxByAll(query);
            jsonView.successPack(boxProductInfoList, "查询箱产品信息成功");
        } catch (Exception e) {
            jsonView.failPack("查询箱产品信息失败");
            log.error("DpBoxProductInfoProviderImpl productBoxByPage ", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
        return jsonView;
    }

    @Override
    public JsonViewObject findBoxProductByNumber(String number, String boxKey) throws DubboProviderException {
        JsonViewObject jsonView = new JsonViewObject();
        try {
            PdProductInfoNumber productInfoNumber = this.pdProductInfoNumberMapper.findByNumber(number);
            DpBox box = this.dpBoxMapper.findByBoxKey(boxKey);
            if (null != productInfoNumber && null != box) {
                DpBoxProductInfo boxProductInfo = this.dpBoxProductInfoMapper.findByProIdAndBoxKey(productInfoNumber.getPdProductInfoId(), box.getId());
                jsonView.successPack(boxProductInfo, "查询装箱产品信息成功");
            } else {
                jsonView.failPack("请确认输入条码");
            }
        }catch (Exception e){
            jsonView.failPack("查询装箱产品信息失败");
            log.error("DpBoxProductInfoProviderImpl findBoxProductByNumber", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
        return jsonView;
    }

    @Override
    public boolean passStation(String boxKey, String userId, String produceProcessId) throws DubboProviderException {
        boolean flag = true;
        try {
            DpBox box = this.dpBoxMapper.findByBoxKey(boxKey);
            Map<String, Object> query = Maps.newHashMap();
            query.put("boxId", box.getId());
            List<DpBoxProductInfo> dpBoxProductInfoList = this.dpBoxProductInfoMapper.findByMap(query);
            if (!dpBoxProductInfoList.isEmpty()) {
                for (DpBoxProductInfo dpBoxProductInfo : dpBoxProductInfoList) {
                    PdProductInfo pdProductInfo = this.pdProductInfoMapper.findById(dpBoxProductInfo.getPdProductInfoId());
                    this.dpRoutesProvider.completeTask(pdProductInfo.getId(), userId, produceProcessId, "1");
                    this.pdProductInfoMapper.update(pdProductInfo);
                }
            }
        } catch (Exception e) {
            flag = false;
            throw new DubboProviderException(e.getMessage(), e);
        }
        return flag;
    }
}
