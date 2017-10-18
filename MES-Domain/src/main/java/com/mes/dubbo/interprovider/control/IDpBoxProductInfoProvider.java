package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.framework.rest.view.Page;
import com.mes.entity.control.DpBoxProductInfo;

import java.util.Map;

/**
* 开发平台-包装箱-产品
* Created by xiuyou.xu on 2017/7/4.
*/
public interface IDpBoxProductInfoProvider extends DubboBaseInterface<DpBoxProductInfo> {

    /**
     * c产品和包装箱绑定
     * @param number
     * @param boxKey
     * @return
     * ledengyun--2017/09/08
     * @throws DubboProviderException
     */
    public boolean saveProductToBox(String number, String boxKey) throws DubboProviderException;

    /**
     * 验证产品是否已经和包装箱绑定
     * @param number
     * @return
     * ledengyun--2017/09/08
     * @throws DubboProviderException
     */
    public JsonViewObject checkCode(String number, String boxKey)throws DubboProviderException;

    /**
     * 解除产品与包装箱的绑定
     * @param number
     * @param boxKey
     * @return
     * ledengyun--2017/09/08
     * @throws DubboProviderException
     */
    public boolean deleteByNum(String number,String boxKey) throws DubboProviderException;

    /**
     * 包装信息分页查询
     *
     * @param page
     * @param map
     * @return
     * @throws DubboProviderException
     */
    public Page productBoxByPage(Page page, Map<String, Object> map) throws DubboProviderException;

    /**
     *将原包装箱产品移至目标包装箱
     *
     * @param sourceBoxKey 原箱号
     * @param targetBoxKey 目标箱号
     * @param boxProductInfoIds 待移动箱产品
     * @return
     * @throws DubboProviderException
     */
    public JsonViewObject updateProductUnionBox(String sourceBoxKey, String targetBoxKey, String boxProductInfoIds) throws DubboProviderException;

    /**
     * 拆箱
     *
     * @param boxKey 箱号
     * @param boxProductInfoIds 待移动箱产品
     * @return
     * @throws DubboProviderException
     */
    public JsonViewObject updateUnBox(String boxKey, String boxProductInfoIds) throws DubboProviderException;

    /**
     * 获取指定箱中的所有产品
     *
     * @param boxKey
     * @return
     * @throws DubboProviderException
     */
    public JsonViewObject getBoxProduct(String boxKey) throws DubboProviderException;

    /**
     * 根据产品条码查询装箱产品信息
     *
     * @param number
     * @param boxKey
     * @return
     * @throws DubboProviderException
     */
    public JsonViewObject findBoxProductByNumber(String number, String boxKey) throws DubboProviderException;

    /**
     * 根据包装箱号批量过站
     *
     * @param boxKey
     * @param userId
     * @param produceProcessId
     * @return
     * @throws DubboProviderException
     */
    public boolean passStation(String boxKey, String userId, String produceProcessId) throws DubboProviderException;

}
