package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.DpBarcode;

import java.util.List;
import java.util.Map;

/**
 * 开发平台-条码
*/
public interface IDpBarcodeProvider extends DubboBaseInterface<DpBarcode> {
    public List<DpBarcode> findByTypeId(String typeId) throws DubboProviderException;

    /**
     * 获取条码分类
     *
     * @return
     * @throws DubboProviderException
     */
    public List<Map<String, Object>> findBarCodeTypes() throws DubboProviderException;

    /**
     * 根据base_replace进行转换
     *
     * @param tableName
     * @param originalValue
     * @return
     * @throws DubboProviderException
     */
    String getBaseReplace(String tableName, String originalValue) throws DubboProviderException;
}
