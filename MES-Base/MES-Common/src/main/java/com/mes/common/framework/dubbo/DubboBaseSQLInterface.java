package com.mes.common.framework.dubbo;

import com.mes.common.framework.Exception.DubboProviderException;

import java.util.LinkedHashMap;
import java.util.List;


/**
 * dubbo抽象接口，  所有dubbo的接口都需要继承
 */
public interface DubboBaseSQLInterface {

    public void saveToSql(String sql) throws DubboProviderException;

    public void updateToSql(String sql) throws DubboProviderException;

    public void deleteToSql(String sql) throws DubboProviderException;

    public List<LinkedHashMap<String, Object>> findToSql(String sql) throws DubboProviderException;

    public Integer getCountToSql(String sql) throws DubboProviderException;

    public List<LinkedHashMap<String, Object>> findByPageToSql(String sql) throws DubboProviderException;

    /**
     * 根据实体类名称获取对应的扩展表名
     *
     * @param entityClass
     * @return
     * @throws DubboProviderException
     */
    public String getExpandTableName(String entityClass) throws DubboProviderException;

    /**
     * 根据扩展表名称查询扩展表关联主表外键字段名称
     *
     * @param expandTableName
     * @return
     * @throws DubboProviderException
     */
    public String getExpandTablePkColumnName(String expandTableName) throws DubboProviderException;

}
