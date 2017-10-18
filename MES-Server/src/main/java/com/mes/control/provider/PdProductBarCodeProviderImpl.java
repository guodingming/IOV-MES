package com.mes.control.provider;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.utils.IDGenerator;
import com.mes.common.utils.StringUtils;
import com.mes.control.mapper.DpBarcodeMapper;
import com.mes.control.mapper.PdProductBarCodeMapper;
import com.mes.dubbo.interprovider.control.IPdProductBarCodeProvider;
import com.mes.entity.control.DpBarcode;
import com.mes.entity.control.PdProductBarCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 产品管理-产品条码
 * Created by xiuyou.xu on 2017/09/28.
 */
public class PdProductBarCodeProviderImpl extends BaseProviderImpl<PdProductBarCode> implements IPdProductBarCodeProvider {
    private static Logger logger = LoggerFactory.getLogger(PdProductBarCodeProviderImpl.class);

    @Autowired
    @Qualifier("pdProductBarCodeMapper")
    private PdProductBarCodeMapper pdProductBarCodeMapper;

    @Autowired
    @Qualifier("dpBarcodeMapper")
    private DpBarcodeMapper dpBarcodeMapper;

    @Override
    public PdProductBarCodeMapper getBaseInterfaceMapper() {
        return pdProductBarCodeMapper;
    }

    @Override
    public boolean updateConfigBarCode(PdProductBarCode pdProductBarCode) throws DubboProviderException {
        boolean flag = true;
        try {
            String barCodes = pdProductBarCode.getBarCodes();
            if (StringUtils.isNotBlank(barCodes)) {
                List<String> barCodeList = Arrays.asList(barCodes.split(","));
                //删除原有
                this.pdProductBarCodeMapper.deleteAll(pdProductBarCode.getPdId());
                for (String s : barCodeList) {
                    DpBarcode dpBarcode = this.dpBarcodeMapper.findById(s);
                    pdProductBarCode.setBarCodeId(dpBarcode.getId());
                    pdProductBarCode.setBarCodeName(dpBarcode.getName());
                    pdProductBarCode.setId(IDGenerator.getID());
                    pdProductBarCode.setCreateDate(new Date());
                    pdProductBarCodeMapper.save(pdProductBarCode);
                }
            } else {
                this.pdProductBarCodeMapper.deleteAll(pdProductBarCode.getPdId());
            }
        } catch (Exception e) {
            flag = false;
            throw new DubboProviderException(e.getMessage(), e);
        }
        return flag;
    }
}
