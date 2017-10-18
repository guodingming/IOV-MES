package com.mes.es.cloudindex;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.index.VersionType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.sort.SortBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ES客户端接口
 * 如果是查询或者插入数据，直接使用此接口的方法来操作
 * 如果是对es的index和doctype进行管理则需要getManager()来获取ICloudIndexManager来进行操作
 * 注： index对应的为索引库
 *      doctype或者文档类型对应的为索引表
 * Created by Administrator on 2015/9/2.
 */
public interface ICloudIndexClient extends AutoCloseable {

    public static final String INDEX_ID = "_index_id";

    /**
     * 设置配置
     * @param config 配置文件
     * @throws Exception
     */
    public void setConfig(CloudIndexClientConfig config) throws Exception;

    /**
     * 保存文档
     * @param indexName 索引名
     * @param docType   文档类型
     * @param doc       文档描述
     * @param refresh   使保存文档立即生效
     * @return          此文档的ID
     * @throws Exception
     */
    public String saveDoc(String indexName, String docType, Map<String, Object> doc, boolean refresh) throws Exception;

    /**
     * 保存文档
     * @param indexName 索引库名
     * @param docType   索引doctype
     * @param builder   内容构建器
     * @param refresh   使保存文档立即生效
     * @return          此文档的ID
     * @throws Exception
     */
    public String saveDoc(String indexName, String docType, XContentBuilder builder, boolean refresh) throws Exception;

    /**
     * 保存文档
     * @param indexName 索引名
     * @param docType   文档类型
     * @param id        文档ID
     * @param doc       文档描述
     * @param refresh   使保存文档立即生效
     * @return          此文档的ID
     * @throws Exception
     */
    public String saveDoc(String indexName, String docType, String id, Map<String, Object> doc, boolean refresh)
            throws Exception;

    /**
     * 保存文档
     * @param indexName 索引名
     * @param docType   文档类型
     * @param id        文档ID
     * @param doc       文档描述
     * @param refresh   使保存文档立即生效
     * @param vt        版本对比方式
     * @param version   版本号
     * @return          此文档的ID
     * @throws Exception
     */
    public String saveDoc(String indexName, String docType, String id, Map<String, Object> doc,
                          boolean refresh, VersionType vt, long version)throws Exception;
    /**
     * 保存文档
     * @param indexName 索引名
     * @param docType   文档类型
     * @param docJson   文档描述
     * @param refresh   使保存文档立即生效
     * @return          此文档的ID
     * @throws Exception
     */
    public String saveDoc(String indexName, String docType, String docJson, boolean refresh) throws Exception;

    /**
     * 保存文档
     * @param indexName 索引名
     * @param docType   文档类型
     * @param id        文档ID
     * @param docJson   文档描述
     * @param refresh   使保存文档立即生效
     * @return          此文档的ID
     * @throws Exception
     */
    public String saveDoc(String indexName, String docType, String id, String docJson, boolean refresh) throws Exception;

    /**
     * 保存文档
     * @param indexName 索引名
     * @param docType   文档类型
     * @param doc       文档描述
     * @return          此文档的ID
     * @throws Exception
     */
    public String saveDoc(String indexName, String docType, Map<String, Object> doc) throws Exception;

    /**
     * 保存文档
     * @param indexName 索引库名称
     * @param docType   索引doctype
     * @param builder   文档内容构建器
     * @return          此文档的ID
     * @throws Exception
     */
    public String saveDoc(String indexName, String docType, XContentBuilder builder) throws Exception;

    /**
     * 保存文档
     * @param indexName 索引名
     * @param docType   文档类型
     * @param id        文档ID
     * @param doc       文档描述
     * @return          此文档的ID
     * @throws Exception
     */
    public String saveDoc(String indexName, String docType, String id, Map<String, Object> doc) throws Exception;

    /**
     * 保存文档
     * @param indexName 索引名
     * @param docType   文档类型
     * @param docJson   文档描述
     * @return          此文档的ID
     * @throws Exception
     */
    public String saveDoc(String indexName, String docType, String docJson) throws Exception;

    /**
     * 保存文档
     * @param indexName 索引名
     * @param docType   文档类型
     * @param id        文档ID
     * @param docJson   文档描述
     * @return          此文档的ID
     * @throws Exception
     */
    public String saveDoc(String indexName, String docType, String id, String docJson) throws Exception;

    /**
     * 更新文档
     * @param indexName 索引名
     * @param docType   文档类型
     * @param id        文档ID
     * @param map       更新内容
     * @return          更新是否成功
     * @throws Exception
     */
    public boolean updateDoc(String indexName, String docType, String id, Map<String, Object> map) throws Exception;

    /**
     * 更新文档
     * @param indexName 索引名
     * @param docType   文档类型
     * @param id        文档ID
     * @param map       更新内容
     * @param refresh   是否立即生效
     * @return          更新是否成功
     * @throws Exception
     */
    public boolean updateDoc(String indexName, String docType, String id, Map<String, Object> map, boolean refresh) throws Exception;

    /**
     * 更新文档
     * @param indexName 索引名
     * @param docType   文档类型
     * @param id        文档ID
     * @param script    文档描述
     * @return          更新是否成功
     * @throws Exception
     */
    public boolean updateDoc(String indexName, String docType, String id, String script) throws Exception;

    /**
     * 更新文档
     * @param indexName 索引名
     * @param docType   文档类型
     * @param id        文档ID
     * @param script    文档描述
     * @param refresh   是否立即生效
     * @return          更新是否成功
     * @throws Exception
     */
    public boolean updateDoc(String indexName, String docType, String id, String script, boolean refresh)
            throws Exception;
    /**
     * 更新文档，如果文档不存在则更新文档
     * @param indexName 索引名
     * @param docType   文档类型
     * @param id        文档ID
     * @param updateMap 更新内容
     * @param insertMap 插入内容
     * @return          更新是否成功
     * @throws Exception
     */
    public boolean upsertDoc(String indexName, String docType, String id, Map<String, Object> updateMap,
                             Map<String, Object> insertMap) throws Exception;

    /**
     * 更新文档，如果文档不存在则更新文档
     * @param indexName 索引名
     * @param docType   文档类型
     * @param id        文档ID
     * @param updateMap 更新内容
     * @param insertMap 插入内容
     * @param refresh   是否立即生效
     * @return          更新是否成功
     * @throws Exception
     */
    public boolean upsertDoc(String indexName, String docType, String id, Map<String, Object> updateMap,
                             Map<String, Object> insertMap, boolean refresh) throws Exception;
    /**
     * 删除文档
     * @param indexName 索引名
     * @param docType   文档类型
     * @param id        文档ID
     * @return          删除是否成功
     * @throws Exception
     */
    public boolean deleteDoc(String indexName, String docType, String id) throws Exception;

    /**
     * 删除文档
     * @param indexName 索引库名
     * @param docType   索引doctype
     * @param id        文档ID
     * @param refresh   删除后是否立即生效
     * @return          删除是否成功
     * @throws Exception
     */
    public boolean deleteDoc(String indexName, String docType, String id, boolean refresh) throws Exception;

    /**
     *按照查询条件删除文档
     * @param indexName 索引名
     * @param docType   文档类型
     * @param queryBuilder  查询提交
     * @return              删除是否成功
     * @throws Exception
     */
    public boolean deleteDocByQuery(String indexName, String docType, QueryBuilder queryBuilder) throws Exception;

    /**
     *获取文档
     * @param indexName 索引名
     * @param docType   文档类型
     * @param id        文档ID
     * @return          获取文档
     * @throws Exception
     */
    public Map<String,Object> getDocByID(String indexName, String docType, String id) throws Exception;

    /**
     *获取文档计数
     * @param indexName 索引名
     * @param docType   文档类型
     * @return          文件数量
     * @throws Exception
     */
    public long getDocCount(String indexName, String docType) throws Exception;

    /**
     * 按照查询获取文档计数
     * @param indexName 索引名
     * @param docType   文档类型
     * @param qb        查询描述
     * @return          文档数量
     * @throws Exception
     */
    public long getDocCount(String indexName, String docType, QueryBuilder qb) throws Exception;

    /**
     * 查询文档
     * @param indexName 索引名
     * @param docType   文档类型
     * @param QueryBuilder 查询条件
     * @return              查询结果
     * @throws Exception
     */
    public List<Map<String,Object>> searchByFilter(String indexName, String docType, QueryBuilder QueryBuilder, SortBuilder... sort) throws Exception;

    /**
     * 查询文档
     * @param indexName     索引库名
     * @param docType       docType名称
     * @param QueryBuilder 过滤器
     * @param size          返回结果条数
     * @param sort          排序方式
     * @return              查询结果
     * @throws Exception
     */
    public List<Map<String,Object>> searchByFilter(String indexName, String docType, QueryBuilder QueryBuilder, Integer size, SortBuilder... sort) throws Exception;

    /**
     * 分页查询文档
     * @param indexName     索引名
     * @param docType       文档类型
     * @param QueryBuilder 查询条件
     * @param from          开始下标
     * @param size          显示条数
     * @return
     * @throws Exception
     */
    //public List<Map<String, Object>> searchByFilter(String indexName, String docType, QueryBuilder QueryBuilder, int from, int size ) throws Exception;

    /**
     * 分页查询文档
     * @param indexName     索引库名
     * @param docType       文档类型
     * @param QueryBuilder 查询条件
     * @param from          开始下标
     * @param size          显示条数
     * @return              查询结果
     * @throws Exception
     */
    public List<Map<String, Object>> searchByFilter(String indexName, String docType, QueryBuilder QueryBuilder, int from, int size, SortBuilder... sort) throws Exception;

    /**
     * 按照filter统计条数
     * @param indexName     索引库名
     * @param docType       索引表名
     * @param QueryBuilder 过滤器
     * @return              统计条数
     * @throws Exception
     */
    public long countByFilter(String indexName, String docType, QueryBuilder QueryBuilder) throws Exception;

    /**
     *查询文档
     * @param indexName 索引名
     * @param docType   文档类型
     * @param queryBuilder 查询条件
     * @return              查询结果
     * @throws Exception
     */
    public List<Map<String,Object>> searchByQuery(String indexName, String docType, QueryBuilder queryBuilder, SortBuilder... sort) throws Exception;

    /**
     * 查询文档
     * @param indexName 索引名
     * @param docType   文档类型
     * @param queryBuilder 查询条件
     * @param size      返回结果条数
     * @param sort      排序方法
     * @return          查询结果
     * @throws Exception
     */
    public List<Map<String,Object>> searchByQuery(String indexName, String docType, QueryBuilder queryBuilder, Integer size, SortBuilder... sort) throws Exception;

    /**
     * 按照query统计条数
     * @param indexName 索引名
     * @param docType   文档类型
     * @param query     查询条件
     * @return          统计结果
     * @throws Exception
     */
    public long countByQuery(String indexName, String docType, QueryBuilder query) throws Exception;

    /**
     * 按照query统计条数
     * @param indexName 索引名
     * @param docType   文档类型
     * @param query     查询条件
     * @return          统计结果
     * @throws Exception
     */
    public long countByQueryAndFilter(String indexName, String docType, QueryBuilder query, QueryBuilder filter) throws Exception;
    /**
     * 查询文档
     * @param indexName     索引名
     * @param docType       文档类型
     * @param queryBuilder  查询条件
     * @param QueryBuilder 过滤条件
     * @param sort          排序方法
     * @return              查询结果
     * @throws Exception
     */
    public List<Map<String,Object>> searchByQuery(String indexName, String docType, QueryBuilder queryBuilder, QueryBuilder QueryBuilder, SortBuilder... sort) throws Exception;


    /**
     * 查询文档
     * @param indexName     索引名
     * @param docType       文档类型
     * @param queryBuilder  查询条件
     * @param QueryBuilder 过滤条件
     * @param size          获取条数
     * @param sort          排序方法
     * @return              查询结果
     * @throws Exception
     */
    public List<Map<String,Object>> searchByQuery(String indexName, String docType, QueryBuilder queryBuilder, QueryBuilder QueryBuilder, Integer size, SortBuilder... sort) throws Exception;

    /**
     * 查询文档
     * @param indexName     索引名
     * @param docType       文档类型
     * @param queryBuilder  查询条件
     * @param QueryBuilder 过滤条件
     * @param from          开始位置
     * @param size          获取条数
     * @param sort          排序方法
     * @return              查询结果
     * @throws Exception
     */
    public List<Map<String,Object>> searchByQuery(String indexName, String docType, QueryBuilder queryBuilder, QueryBuilder QueryBuilder, int from, int size, SortBuilder... sort) throws Exception;

    /**
     * 分页查询
     * @param indexName         索引名
     * @param docType           文档类型
     * @param queryBuilder      查询条件
     * @param from              开始下标
     * @param size              显示条数
     * @return
     * @throws Exception
     */
    //public List<Map<String, Object>> searchByQuery(String indexName, String docType, QueryBuilder queryBuilder, int from, int size ) throws Exception;

    List<Map<String, Object>> getSplitterBySearchAfter(String index, String type, QueryBuilder queryBuilder, int splitSize, SortBuilder... sort) throws Exception;

    /**
     * 查询处于分页边界的文档集合
     * @param index
     * @param type
     * @param queryBuilder
     * @param splitSize
     * @param sort
     * @return
     * @throws Exception
     */
    List<Map<String, Object>> getSplitterByScroll(String index, String type, QueryBuilder queryBuilder, int splitSize, SortBuilder... sort) throws Exception;

    /**
     * 查询第i个文档（按给定排序方法排序）
     * @param index
     * @param type
     * @param queryBuilder
     * @param i
     * @param sort
     * @return
     * @throws Exception
     */
    Map<String, Object> get(String index, String type, QueryBuilder queryBuilder, int i, SortBuilder... sort) throws Exception;

    /**
     * 分页查询
     * @param indexName         索引名
     * @param docType           文档类型
     * @param queryBuilder      查询条件
     * @param from              开始下标
     * @param size              显示条数
     * @return                  查询结果
     * @throws Exception
     */
    public List<Map<String, Object>> searchByQuery(String indexName, String docType, QueryBuilder queryBuilder, int from, int size, SortBuilder... sort) throws Exception;

    /**
     * 获取manager
     * @return  ES的管理客户端
     */
    public ICloudIndexManager getManager();

    /**
     * 批量插入
     * @param index     索引库
     * @param docType   文档类型
     * @param requests  插入请求
     * @return          批量插入结果
     */
    public Map<Integer,Boolean> bulkRequest(String index, String docType, IndexRequest[] requests);

    /**
     * 批量更新
     * @param index     索引库
     * @param docType   文档类型
     * @param list      更新内容
     * @return          更新结果
     */
    public Map<Integer, Boolean> bulkUpdate(String index, String docType, List<Map<String, Object>> list);

    /**
     * 批量upsert，对于不存在的doc，会进行插入，存在的会进行更新
     * @param index
     * @param docType
     * @param list
     * @return
     * @throws Exception
     */
    Map<Integer, Boolean> bulkUpsert(String index, String docType,
                                     List<Map<String, Object>> list) throws Exception;

    /**
     * 批量upsert，对于不存在的doc，会进行插入，存在的会进行更新
     * @param index
     * @param docType
     * @param list
     * @param refresh
     * @return
     * @throws Exception
     */
    Map<Integer, Boolean> bulkUpsert(String index, String docType,
                                     List<Map<String, Object>> list, boolean refresh) throws Exception;

    /**
     * 批量更新
     * @param index     索引库
     * @param docType   文档类型
     * @param list      更新内容
     * @param refresh   是否立即生效
     * @return          更新结果
     */
    public Map<Integer, Boolean> bulkUpdate(String index, String docType, List<Map<String, Object>> list, boolean refresh);

    /**
     * 批量插入
     * @param index     索引库
     * @param docType   文档类型
     * @param list      插入内容
     * @return          插入结果
     * @throws Exception
     */
    public Map<Integer, Boolean> bulkIndex(String index, String docType, List<Map<String, Object>> list) throws Exception;

    /**
     * 批量插入
     * @param index     索引库
     * @param docType   文档类型
     * @param list      插入内容
     * @param refresh   是否立即生效
     * @return          插入结果
     * @throws Exception
     */
    public Map<Integer, Boolean> bulkIndex(String index, String docType, List<Map<String, Object>> list,
                                           boolean refresh) throws Exception ;

    /**
     * 批量插入
     * @param index     索引库
     * @param docType   文档类型
     * @param list      插入内容
     * @param refresh   是否立即生效
     * @return          插入结果
     * @throws Exception
     */
    public Map<Integer, Boolean> bulkIndex(String index, String docType, List<Map<String, Object>> list,
                                           boolean refresh, VersionType vt, long version) throws Exception ;

    /**
     * 通过字段模糊查询，目前只支持一个字段，
     * 如果fields传入多个值，只用第一个
     * @param index     索引库
     * @param docType   文档类型
     * @param fields    匹配字段
     * @param from      开始位置
     * @param size      条数
     * @return          查询结果
     * @throws Exception
     */
    public SearchResponse searchByFieldFuzzyLikeFilter(String index, String docType, HashMap fields, int from, int size)throws Exception;


    /**
     * 通过字段匹配，精确匹配
     * @param index     索引库
     * @param docType   文档类型
     * @param fields    匹配字段
     * @param from      开始位置
     * @param size      条数
     * @return          查询结果
     * @throws Exception
     */
    public SearchResponse searchByFieldsFilter(String index, String docType, HashMap fields, int from, int size)throws Exception;

    /**
     * 以JSON格式导出数据到指定的文件
     * @param indexName     索引库
     * @param docType       文档类型
     */
    public void exportData(String indexName, String docType, String path) throws IOException;

    /**
     * 导入数据
     * @param indexName     索引库
     * @param docType       文档类型
     * @param path          导出路径
     */
    public void importData(String indexName, String docType, String path) throws Exception;

    /**
     * 滚动查询
     * @param indexName     索引库
     * @param docType       文档类型
     * @param queryBuilder  查询条件构建器
     * @param timeout       超时时间，如果在超时时间内没有取完查询结果则会被清空
     * @return              查询结果
     * @throws Exception
     */
    public ScrollResult scrollResult(String indexName, String docType, QueryBuilder queryBuilder, int pageSize, long timeout) throws Exception;

    /**
     * 执行给定的聚合查询
     * @param indexName
     * @param docType
     * @param queryBuilder
     * @param builders 聚合查询的AggregationBuilder，可以是多个聚合查询
     * @return
     * @throws Exception
     */
    public Map<String, Aggregation> aggregate(String indexName, String docType, QueryBuilder queryBuilder, AggregationBuilder... builders) throws Exception;
}
