package com.mes.es.cloudindex;

import org.elasticsearch.client.Client;

import java.util.Map;

/**
 * ES的管理客户端，主要负责index和doctype的创建、修改以及查询
 *
 * Created by Administrator on 2015/9/2.
 */
public interface ICloudIndexManager {

    /**
     * 设置es客户端
     * @param elasticSearchClient   es客户端
     * @throws Exception
     */
    public void setClient(Client elasticSearchClient) throws Exception;

    /**
     * 创建索引
     * @param index         索引名
     * @param shardsNum     主分片数量
     * @param replicasNum   备份数量
     * @return              是否创建成功
     * @throws Exception
     */
    public boolean createIndex(String index, int shardsNum, int replicasNum) throws Exception;

    /**
     * 创建Mapping
     * @param indexName     索引名
     * @param docType       文档类型
     * @param mapping       mapping描述
     * @return              是否创建成功
     * @throws Exception
     */
    public boolean createMapping(String indexName, String docType, Map<String, Object> mapping)throws Exception;

    /**
     * 创建Mapping
     * @param indexName     索引名
     * @param docType       文档类型
     * @param jsonMapping   mapping描述
     * @return              是否创建成功
     * @throws Exception
     */
    public boolean createMapping(String indexName, String docType, String jsonMapping)throws Exception;

    /**
     * 删除index
     * @param index     索引名
     * @return          是否删除成功
     * @throws Exception
     */
    public boolean deleteIndex(String index) throws Exception;

    /**
     * 删除mapping
     * @param index     索引名
     * @param docType   文档类型
     * @return          是否删除成功
     * @throws Exception
     */
    public boolean deleteMapping(String index, String docType) throws Exception;

    /**
     * 获取mapping信息
     * @param index     索引名
     * @param docType   文档类型
     * @return          mapping信息
     * @throws Exception
     */
    public Map<String,Object> getMapping(String index, String docType) throws Exception;

    /**
     * 关闭
     * @param client    客户端
     */
    public void closeClient(Client client);

    /**
     * 获取mapping中的列描述
     *
     * @param index     索引名
     * @param docType   doctype名
     * @param field     列名
     * @return          列描述
     * @throws Exception
     */

    public Map<String, Object> getFiledMapping(String index, String docType, String field) throws Exception ;

    /**
     * 索引是否存在
     * @param index 索引名
     * @return      是否存在此索引
     */
    public boolean existIndex(String index);

    /**
     * mapping是否存在
     * @param index     索引名
     * @param docType   doc类型
     * @return          是否存在此mapping
     * @throws Exception
     */
    public boolean existMapping(String index, String docType) throws Exception ;

    /**
     * 获取所有的index
     * @return      index名称列表
     */
    public String[] getIndexs();

    /**
     * 获取index的mapping
     * @param index index名称，可以传递多个index
     * @return      mapping的信息
     */
    public Map<String,String[]> getMappings(String... index);

    /**
     * 关闭
     */
    public void close();

    /**
     * 更新配置
     * @param map   更新index的配置
     */
    public void updateSetting(Map<String, String> map, String index);
}
