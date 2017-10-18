package com.mes.control.provider;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.groovy.GroovyUtil;
import com.mes.common.framework.rest.view.Node;
import com.mes.common.framework.rest.view.Page;
import com.mes.common.utils.ExcelHandler;
import com.mes.common.utils.FileUtils;
import com.mes.control.mapper.DpFunctionMapper;
import com.mes.control.mapper.FtyDeviceConfigInfoMapper;
import com.mes.control.mapper.FtyDeviceMapper;
import com.mes.control.mapper.FtyDeviceTypeMapper;
import com.mes.control.utils.JaxbUtil;
import com.mes.dubbo.interprovider.control.IFtyDeviceConfigInfoProvider;
import com.mes.dubbo.interprovider.control.IFtyDeviceConfigProvider;
import com.mes.entity.control.*;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Created by xiuyou.xu on 2017/7/19.
 */
public class FtyDeviceConfigInfoProviderImpl extends BaseProviderImpl<FtyDeviceConfigInfo> implements IFtyDeviceConfigInfoProvider {
    @Autowired
    @Qualifier("ftyDeviceConfigInfoMapper")
    private FtyDeviceConfigInfoMapper ftyDeviceConfigInfoMapper;

    @Autowired
    @Qualifier("ftyDeviceMapper")
    private FtyDeviceMapper ftyDeviceMapper;

    @Autowired
    @Qualifier("ftyDeviceConfigProvider")
    private IFtyDeviceConfigProvider ftyDeviceConfigProvider;

    @Autowired
    @Qualifier("ftyDeviceTypeMapper")
    private FtyDeviceTypeMapper ftyDeviceTypeMapper;

    @Autowired
    @Qualifier("dpFunctionMapper")
    private DpFunctionMapper dpFunctionMapper;

    @Override
    public List<Node> getDevicesTypedTree(String areaId) {
        List<Node> nodes = Lists.newArrayList();

        List<FtyDeviceType> types = ftyDeviceTypeMapper.findAll();

        Map<String, Object> params = Maps.newHashMap();
        if (areaId.equals("undefined")) {
            areaId = null;
        }
        params.put("areaId", areaId);
        List<FtyDevice> devices = ftyDeviceMapper.findByMap(params);

        if (types != null && !types.isEmpty()) {
            types.stream().forEach(type -> {
                Node node = new Node();
                node.setId(type.getId());
                node.setName(type.getName());
                List<Node> children = Lists.newArrayList();

                if (devices != null && !devices.isEmpty()) {
                    devices.stream().filter(device -> {
                        return type.getId().equals(device.getDeviceTypeId());
                    }).forEach(device -> {
                        Node n = new Node();
                        n.setId(device.getId());
                        n.setName(device.getName());
                        n.setDescription(device.getDescription());

                        children.add(n);
                    });
                }
                node.setChildren(children);
                nodes.add(node);
            });
        } else {
            if (devices != null && !devices.isEmpty()) {
                devices.stream().forEach(device -> {
                    Node node = new Node();
                    node.setId(device.getId());
                    node.setName(device.getName());
                    node.setDescription(device.getDescription());

                    nodes.add(node);
                });
            }
        }

        return nodes;
    }

    @Override
    public Page getPageByConfigType(String deviceId, String deviceConfigTypeId, Page page) {
        Map<String, Object> params = Maps.newHashMap();
        if (page.getCondition() != null && Map.class.isInstance(page.getCondition())) {
            params = (Map<String, Object>) page.getCondition();
        }
        params.put("deviceId", deviceId);
        params.put("deviceConfigTypeId", deviceConfigTypeId);

        page.setTotal(this.getBaseInterfaceMapper().getCountByConfigType(params));
        params.put("startRowNum", page.getStartRowNum());
        params.put("pageSize", page.getPageSize());
        page.setRows(this.getBaseInterfaceMapper().findByPageByConfigType(params));
        return page;
    }

    @Override
    public List<FtyDeviceConfigInfo> getAllByConfigType(String deviceId, String deviceConfigTypeId) throws DubboProviderException {
        List<FtyDeviceConfigInfo> result = Lists.newArrayList();
        try {
            Map<String, Object> params = Maps.newHashMap();
            params.put("deviceId", deviceId);
            params.put("deviceConfigTypeId", deviceConfigTypeId);
            result = this.ftyDeviceConfigInfoMapper.findAllByConfigType(params);
        } catch (Exception e) {
            log.error("根据设备ID和设备配置类型ID查询设备配置信息失败!");
            throw new DubboProviderException("FtyDeviceConfigInfoProviderImpl getAllByConfigType is error" + e.getMessage(), e);
        }
        return result;
    }

    @Override
    public List<DpDataDictionary> getDeviceConfigTypes(String deviceId) {
        return ftyDeviceTypeMapper.getDeviceConfigTypes(deviceId);
    }

    @Override
    public String saveUploadConfigInfo(FtyDeviceConfig config, FtyDeviceConfigInfo info) throws DubboProviderException {
        try {
            Map<String, Object> params = Maps.newHashMap();
            params.put("deviceId", config.getDeviceId());
            params.put("deviceConfigTypeId", config.getDeviceConfigTypeId());
            List<FtyDeviceConfig> configs = ftyDeviceConfigProvider.findByMap(params);
            String configId = null;
            if (config == null || configs.isEmpty()) {
                configId = ftyDeviceConfigProvider.save(config);
            } else {
                configId = configs.get(0).getId();
            }
            info.setDeviceConfigId(configId);

            // 文件类型配置
            if ("file".equalsIgnoreCase(info.getType())) {
                String filePath = info.getFilePath();
                String filename = info.getFilename();
                String file = ConfigHelper.getValue("shared.fs.dir") + filePath + "/" + filename;
                File f = new File(file);
                String ext = FileUtils.getExt(f);
                if ("xml".equalsIgnoreCase(ext) || "txt".equalsIgnoreCase(ext)) {
                    String xml = FileUtils.readToString(f);
                    info.setFileContent(JaxbUtil.format(xml));
                }
                if ("xls".equalsIgnoreCase(ext) || "xlsx".equalsIgnoreCase(ext)) {
                    String fnId = info.getFnId();
                    if(fnId==null||fnId.isEmpty()) {
                        throw new Exception("未为Excel配置文件设置转换XML格式的函数！");
                    }
                    DpFunction dpFunction = dpFunctionMapper.findById(fnId);
                    List<Sheet> sheets = ExcelHandler.getSheetList(ext, new FileInputStream(f));
                    String xml = (String) GroovyUtil.invokeFnInScript(dpFunction.getScript(), "handle", null, sheets);
                    info.setFileContent(JaxbUtil.format(xml));
                }
            }

            return super.save(info);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DubboProviderException(e);
        }
    }

    @Override
    public String getRemoteConfigXml(String fileTypeCode, String produceProcessId, String deviceId, String deviceConfigType) throws DubboProviderException {
        try {
            Map<String, Object> params = Maps.newHashMap();
            params.put("fileTypeCode", fileTypeCode);
            params.put("produceProcessId", produceProcessId);
            params.put("deviceId", deviceId);
            params.put("deviceConfigType", deviceConfigType);
            String path = ftyDeviceConfigInfoMapper.getRemoteConfig(params);
            if (path != null && !path.isEmpty()) {
                File file = new File(ConfigHelper.getValue("shared.fs.dir") + path);
                InputStream is = new FileInputStream(file);
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                IOUtils.copy(is, os);
                IOUtils.closeQuietly(is);
                IOUtils.closeQuietly(os);
                return new String(os.toByteArray());
            }
            return null;
        } catch (Exception e) {
            throw new DubboProviderException(e);
        }
    }

    @Override
    public FtyDeviceConfigInfoMapper getBaseInterfaceMapper() {
        return ftyDeviceConfigInfoMapper;
    }
}
