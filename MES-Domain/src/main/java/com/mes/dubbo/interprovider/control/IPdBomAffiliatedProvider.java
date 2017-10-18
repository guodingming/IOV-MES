package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.PdBomAffiliated;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * 产品管理-BOM-附属信息
*/
public interface IPdBomAffiliatedProvider extends DubboBaseInterface<PdBomAffiliated> {

    /**
     * 批量保存产品BOM属性
     * @param bomAffiliateds
     * @return
     * @throws DubboProviderException
     */
    public boolean saveBomAffiliates(List<PdBomAffiliated> bomAffiliateds) throws DubboProviderException;

    /**
     * 批量更新产品BOM属性
     * @param bomAffiliateds
     * @return
     * @throws DubboProviderException
     */
    public boolean updateBomAffiliates(List<PdBomAffiliated> bomAffiliateds) throws DubboProviderException;

    /**
     * 根据条件查询产品单项配置
     * @param pdId
     * @param attrKey
     * @param bomProduceId
     * @return
     * @throws DubboProviderException
     */
    List<PdBomAffiliated> findAffiliates(String pdId, String attrKey, String bomProduceId) throws DubboProviderException;

    /**
     * 根据产品属性key查询属性值信息
     * @param map 包含key：pdId, attrKey, bomProduceId
     * @return
     */
    List<PdBomAffiliated> getByAttrKey(Map<String, Object> map) throws DubboProviderException;

    /**
     * 单项配置模板导出
     * @param queryMap
     * @param file
     * @throws DubboProviderException
     * ledengyun--2017/09/26
     */
  public   void downLoad(Map<String,Object> queryMap, File file)throws DubboProviderException;

  public void upload(String path,String pdId,String bomProduceId)throws DubboProviderException;
}
