package com.mes.es.cloudindex;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.mes.es.exception.InitException;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.index.VersionType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.script.Script;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * Created by Administrator on 2015/9/2.
 */
public class CloudIndexClient implements ICloudIndexClient {

    private static final Logger log = LoggerFactory.getLogger(CloudIndexClient.class);
    public static final int MAX_QUERY_TERMS = 20;

    private CloudIndexClientConfig config;
    private Client elasticSearchClient;
    private ICloudIndexManager manager;


    public CloudIndexClient(CloudIndexClientConfig config) throws Exception {
        this.config = config;
        init();
    }

    public void init() throws Exception {
        try {
            Settings settings = Settings.builder()
                    .put(CloudIndexClientConfig.CLIENT_TRANSPORT_SNIFF, config.isTransportSniff())
                    .put(CloudIndexClientConfig.CLUSTER_NAME, config.getClusterName())
                    .build();
            TransportClient client = new PreBuiltTransportClient(settings);
            for (InetSocketTransportAddress host : config.getHosts()) {
                client.addTransportAddress(host);
            }
            this.elasticSearchClient = client;
            this.manager = new CloudIndexManager(client);
        } catch (Exception e) {
            log.error("create elasticsearch's connection error.", e);
            throw new InitException("create elasticsearch's connection error.", e);
        }
    }

    @Override
    public void setConfig(CloudIndexClientConfig config) throws Exception {
        this.config = config;
        init();
    }

    private XContentBuilder buildDoc(Map<String, Object> doc) throws Exception {
        XContentBuilder xContentBuilder = jsonBuilder().startObject();
        Iterator iterator = doc.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            xContentBuilder.field((String) entry.getKey(), entry.getValue());
        }
        xContentBuilder.endObject();

        return xContentBuilder;
    }

    @Override
    public String saveDoc(String indexName, String docType, XContentBuilder builder, boolean refresh)
            throws Exception {
        IndexResponse response = elasticSearchClient.prepareIndex(indexName, docType)
                .setRefreshPolicy(WriteRequest.RefreshPolicy.parse(refresh + ""))
                .setSource(builder).execute().actionGet();
        return response.getId();
    }

    @Override
    public String saveDoc(String indexName, String docType, Map<String, Object> doc, boolean refresh)
            throws Exception {
        IndexResponse response = elasticSearchClient.prepareIndex(indexName, docType)
                .setRefreshPolicy(WriteRequest.RefreshPolicy.parse(refresh + ""))
                .setSource(buildDoc(doc)).execute().actionGet();
        return response.getId();
    }

    @Override
    public String saveDoc(String indexName, String docType, String id, Map<String, Object> doc, boolean refresh)
            throws Exception {
        IndexResponse response = elasticSearchClient.prepareIndex(indexName, docType, id)
                .setRefreshPolicy(WriteRequest.RefreshPolicy.parse(refresh + ""))
                .setSource(buildDoc(doc)).execute().actionGet();
        return response.getId();
    }

    @Override
    public String saveDoc(String indexName, String docType, String id, Map<String, Object> doc,
                          boolean refresh, VersionType vt, long version) throws Exception {
        IndexResponse response = elasticSearchClient.prepareIndex(indexName, docType, id)
                .setRefreshPolicy(WriteRequest.RefreshPolicy.parse(refresh + ""))
                .setSource(buildDoc(doc))
                .setVersionType(vt)
                .setVersion(version)
                .execute().actionGet();
        return response.getId();
    }

    @Override
    public String saveDoc(String indexName, String docType, String docJson, boolean refresh)
            throws Exception {
        IndexResponse response = elasticSearchClient.prepareIndex(indexName, docType)
                .setRefreshPolicy(WriteRequest.RefreshPolicy.parse(refresh + ""))
                .setSource(docJson).execute().actionGet();
        return response.getId();
    }

    @Override
    public String saveDoc(String indexName, String docType, String id, String docJson, boolean refresh)
            throws Exception {
        IndexResponse response = elasticSearchClient.prepareIndex(indexName, docType, id)
                .setRefreshPolicy(WriteRequest.RefreshPolicy.parse(refresh + ""))
                .setSource(docJson).execute().actionGet();
        return response.getId();
    }

    @Override
    public String saveDoc(String indexName, String docType, XContentBuilder builder) throws Exception {
        IndexResponse response = elasticSearchClient.prepareIndex(indexName, docType)
                .setSource(builder).execute().actionGet();
        return response.getId();
    }

    @Override
    public String saveDoc(String indexName, String docType, Map<String, Object> doc) throws Exception {
        IndexResponse response = elasticSearchClient.prepareIndex(indexName, docType)
                .setSource(buildDoc(doc)).execute().actionGet();
        return response.getId();
    }

    @Override
    public String saveDoc(String indexName, String docType, String id, Map<String, Object> doc) throws Exception {
        IndexResponse response = elasticSearchClient.prepareIndex(indexName, docType, id)
                .setSource(buildDoc(doc)).execute().actionGet();
        return response.getId();
    }

    @Override
    public String saveDoc(String indexName, String docType, String docJson) throws Exception {
        IndexResponse response = elasticSearchClient.prepareIndex(indexName, docType)
                .setSource(docJson).execute().actionGet();
        return response.getId();
    }

    @Override
    public String saveDoc(String indexName, String docType, String id, String docJson) throws Exception {
        IndexResponse response = elasticSearchClient.prepareIndex(indexName, docType, id)
                .setSource(docJson).execute().actionGet();
        return response.getId();
    }

    @Override
    public boolean updateDoc(String indexName, String docType, String id, Map<String, Object> map, boolean refresh) throws Exception {
        UpdateRequest request = new UpdateRequest()
                .setRefreshPolicy(WriteRequest.RefreshPolicy.parse(refresh + ""));
        request.index(indexName);
        request.type(docType);
        request.id(id);
        request.doc(buildDoc(map));
        UpdateResponse response = elasticSearchClient.update(request).get();
        //elasticSearchClient.prepareUpdate( indexName, docType, id ).setSource( buildDoc( map ) ).get();
        return true;
    }

    @Override
    public boolean updateDoc(String indexName, String docType, String id, Map<String, Object> map)
            throws Exception {
        UpdateRequest request = new UpdateRequest();
        request.index(indexName);
        request.type(docType);
        request.id(id);
        request.doc(buildDoc(map));
        UpdateResponse response = elasticSearchClient.update(request).get();
        //elasticSearchClient.prepareUpdate( indexName, docType, id ).setSource( buildDoc( map ) ).get();
        return true;
    }

    @Override
    public boolean updateDoc(String indexName, String docType, String id, String script, boolean refresh)
            throws Exception {
        UpdateResponse response = elasticSearchClient.prepareUpdate(indexName, docType, id)
                .setRefreshPolicy(WriteRequest.RefreshPolicy.parse(refresh + ""))
                .setScript(new Script(script)).get();
        return true;
    }

    @Override
    public boolean updateDoc(String indexName, String docType, String id, String script) throws Exception {
        UpdateResponse response = elasticSearchClient.prepareUpdate(indexName, docType, id)
                .setScript(new Script(script)).get();
        return true;
    }

    @Override
    public boolean upsertDoc(String indexName, String docType, String id, Map<String, Object> updateMap,
                             Map<String, Object> insertMap, boolean refresh) throws Exception {
        IndexRequest insert = new IndexRequest(indexName, docType, id).source(buildDoc(insertMap));
        UpdateRequest update = new UpdateRequest(indexName, docType, id).doc(buildDoc(updateMap))
                .setRefreshPolicy(WriteRequest.RefreshPolicy.parse(refresh + "")).upsert(insert);
        UpdateResponse response = elasticSearchClient.update(update).get();
        return true;
    }

    @Override
    public boolean upsertDoc(String indexName, String docType, String id,
                             Map<String, Object> updateMap, Map<String, Object> insertMap) throws Exception {

        IndexRequest insert = new IndexRequest(indexName, docType, id).source(buildDoc(insertMap));
        UpdateRequest update = new UpdateRequest(indexName, docType, id).doc(buildDoc(updateMap))
                .upsert(insert);
        UpdateResponse response = elasticSearchClient.update(update).get();
        return true;
    }

    @Override
    public boolean deleteDoc(String indexName, String docType, String id) throws Exception {
        DeleteResponse response = elasticSearchClient.prepareDelete(indexName, docType, id).execute().actionGet();
        return response.getResult() == DocWriteResponse.Result.DELETED;
    }

    @Override
    public boolean deleteDoc(String indexName, String docType, String id, boolean refresh) throws Exception {
        DeleteResponse response = elasticSearchClient.prepareDelete(indexName, docType, id)
                .setRefreshPolicy(WriteRequest.RefreshPolicy.parse(refresh + "")).execute().actionGet();
        return response.getResult() == DocWriteResponse.Result.DELETED;
    }

    @Override
    public boolean deleteDocByQuery(String indexName, String docType, QueryBuilder queryBuilder) throws Exception {
//        DeleteByQueryAction.INSTANCE.newRequestBuilder(elasticSearchClient)
//                .filter(queryBuilder).source(indexName).get();

        SearchResponse response = elasticSearchClient.prepareSearch(indexName)
                .setTypes(docType)
                .setQuery(queryBuilder)
                .setSize(10000)
                .execute().actionGet();

        SearchHit[] searchHits = response.getHits().getHits();

        while (searchHits.length > 0) {
            // Create bulk request
            final BulkRequestBuilder bulkRequest = elasticSearchClient.prepareBulk().setRefreshPolicy("true");
            // Add search results to bulk request
            for (final SearchHit searchHit : searchHits) {
                final DeleteRequest deleteRequest = new DeleteRequest(indexName, docType, searchHit.getId());
                bulkRequest.add(deleteRequest);
            }
            // Run bulk request
            final BulkResponse bulkResponse = bulkRequest.execute().actionGet();
            if (bulkResponse.hasFailures()) {
                return false;
            }

            // After deleting, we should check for more records
            response = elasticSearchClient.prepareSearch(indexName)
                    .setTypes(docType)
                    .setQuery(queryBuilder)
                    .setSize(10000)
                    .execute().actionGet();

            searchHits = response.getHits().getHits();
        }


        return true;
    }

    @Override
    public Map<String, Object> getDocByID(String indexName, String docType, String id) throws Exception {
        GetResponse response = elasticSearchClient.prepareGet(indexName, docType, id).execute().actionGet();
        Map<String, Object> resMap = null;
        if (response != null && response.isExists()) {
            resMap = response.getSource();
            resMap.put(INDEX_ID, response.getId());
        }
        return resMap;
    }

    public long getDocCount(String indexName, String docType, QueryBuilder qb) throws Exception {
        SearchRequestBuilder builder = elasticSearchClient.prepareSearch(indexName).setTypes(docType).setSearchType(SearchType.DEFAULT).setSize(0);
        if (qb != null) {
            builder.setQuery(qb);
        }
        SearchResponse sr = builder.get();
        return sr.getHits().getTotalHits();
    }

    @Override
    public long getDocCount(String indexName, String docType) throws Exception {
        return getDocCount(indexName, docType, null);
    }

    /**
     * scroll方式进行全部文档查询
     *
     * @param list
     * @param builder
     */
    private void scrollSearch(List<Map<String, Object>> list, SearchRequestBuilder builder) {
        TimeValue t = new TimeValue(30000);
        SearchResponse response = builder.setScroll(t).setSize(10000).get();
        String scrollId = response.getScrollId();

        while (true) {
            SearchHit[] hits = response.getHits().getHits();
            if (hits != null && hits.length > 0) {
                for (SearchHit hit : hits) {
                    Map<String, Object> map = hit.getSource();
                    map.put(INDEX_ID, hit.getId());
                    list.add(map);
                }
            } else {
                break;
            }
            response = elasticSearchClient.prepareSearchScroll(scrollId).setScroll(t).get();
            scrollId = response.getScrollId();
        }
    }

    /**
     * scroll方式进行分页查询。当from+size大于10000时，在SearchRequestBuilder中设置from和size会报错，只能采用这种方式进行分页查询
     *
     * @param list
     * @param builder
     * @param from
     * @param size
     */
    private void scrollSearch(List<Map<String, Object>> list, SearchRequestBuilder builder, int from, int size) {
        TimeValue t = new TimeValue(30000);
        SearchResponse response = builder.setScroll(t).setSize(10000).get();
        String scrollId = response.getScrollId();

        int to = from + size;
        int index = 0;
        while (true) {
            SearchHit[] hits = response.getHits().getHits();
            if (hits != null && hits.length > 0) {
                // optimize the "for loop", [from, from+size] and [index, index+hits.length] should have intercourse
                if (from > index + hits.length || to < index) {
                    index += hits.length;
                } else {
                    for (SearchHit hit : hits) {
                        if (index >= from && index < to) {
                            Map<String, Object> map = hit.getSource();
                            map.put(INDEX_ID, hit.getId());
                            list.add(map);
                        }

                        index++;
                        if (index >= to) {
                            break;
                        }
                    }
                    // optimize "while loop"
                    if (index >= to) {
                        break;
                    }
                }
                response = elasticSearchClient.prepareSearchScroll(scrollId).setScroll(t).get();
                scrollId = response.getScrollId();
            } else {
                break;
            }
        }
    }

    @Override
    public List<Map<String, Object>> searchByFilter(String indexName, String docType
            , QueryBuilder QueryBuilder, SortBuilder... sort) throws Exception {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        long size = this.countByFilter(indexName, docType, QueryBuilder);
        SearchRequestBuilder request = elasticSearchClient.prepareSearch(indexName)
                .setTypes(docType).setPostFilter(QueryBuilder).setSize((int) size);
        if (sort != null) {
            for (SortBuilder s : sort) {
                if (s == null) {
                    continue;
                }
                request.addSort(s);
            }
        }
//        SearchResponse sr = request.setExplain(true).execute().actionGet();
//        SearchHit[] shs = sr.getHits().hits();
//        for (SearchHit sh : shs) {
//            Map<String, Object> map = sh.getSource();
//            map.put(INDEX_ID, sh.getId());
//            list.add(map);
//        }
        scrollSearch(list, request);
        return list;
    }

    @Override
    public List<Map<String, Object>> searchByFilter(String indexName, String docType,
                                                    QueryBuilder QueryBuilder, Integer size, SortBuilder... sort) throws Exception {
        if (size == null) {
            size = (int) this.countByFilter(indexName, docType, QueryBuilder);
        }
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        SearchRequestBuilder request = elasticSearchClient.prepareSearch(indexName)
                .setTypes(docType).setPostFilter(QueryBuilder).setSize(size);
        if (sort != null) {
            for (SortBuilder s : sort) {
                if (s == null) {
                    continue;
                }
                request.addSort(s);
            }
        }
        SearchResponse sr = request.setExplain(true).execute().actionGet();
        SearchHit[] shs = sr.getHits().hits();
        for (SearchHit sh : shs) {
            Map<String, Object> map = sh.getSource();
            map.put(INDEX_ID, sh.getId());
            list.add(map);
        }
        return list;
    }

    @Override
    public List<Map<String, Object>> searchByQuery(String indexName, String docType,
                                                   QueryBuilder queryBuilder, SortBuilder... sort) throws Exception {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        long size = this.countByQuery(indexName, docType, queryBuilder);
        SearchRequestBuilder request = elasticSearchClient.prepareSearch(indexName)
                .setTypes(docType).setQuery(queryBuilder).setSize((int) size);
        if (sort != null) {
            for (SortBuilder s : sort) {
                if (s == null) {
                    continue;
                }
                request.addSort(s);
            }
        }
//        SearchResponse sr = request.execute().actionGet();
//        SearchHit[] shs = sr.getHits().hits();
//        for (SearchHit sh : shs) {
//            Map<String, Object> map = sh.getSource();
//            map.put(INDEX_ID, sh.getId());
//            list.add(map);
//        }
        scrollSearch(list, request);
        return list;
    }

    @Override
    public List<Map<String, Object>> searchByQuery(String indexName, String docType,
                                                   QueryBuilder queryBuilder, Integer size, SortBuilder... sort) throws Exception {
        if (size == null) {
            size = (int) this.countByQuery(indexName, docType, queryBuilder);
        }
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        SearchRequestBuilder request = elasticSearchClient.prepareSearch(indexName)
                .setTypes(docType).setQuery(queryBuilder).setSize(size);
        if (sort != null) {
            for (SortBuilder s : sort) {
                if (s == null) {
                    continue;
                }
                request.addSort(s);
            }
        }
        SearchResponse sr = request.execute().actionGet();
        SearchHit[] shs = sr.getHits().hits();
        for (SearchHit sh : shs) {
            Map<String, Object> map = sh.getSource();
            map.put(INDEX_ID, sh.getId());
            list.add(map);
        }
        return list;
    }

    @Override
    public long countByQuery(String indexName, String docType, QueryBuilder query) throws Exception {
        //SearchResponse response = elasticSearchClient.prepareSearch(indexName)
        //                                      .setTypes( docType ).setQuery( query ).execute().actionGet();
//        CountResponse response = elasticSearchClient.prepareCount(indexName)
//                .setTypes(docType).setQuery(query).execute().actionGet();
//        return response.getCount();
        SearchRequestBuilder builder = elasticSearchClient.prepareSearch(indexName).setTypes(docType).setSearchType(SearchType.DEFAULT).setSize(0);
        if (query != null) {
            builder.setQuery(query);
        }
        SearchResponse sr = builder.get();
        return sr.getHits().getTotalHits();
    }

    @Override
    public long countByQueryAndFilter(String indexName, String docType, QueryBuilder query, QueryBuilder filter)
            throws Exception {
        SearchRequestBuilder request = elasticSearchClient.prepareSearch(indexName)
                .setTypes(docType).setQuery(query).setPostFilter(filter).setSize(1);
        return request.execute().actionGet().getHits().getTotalHits();
    }

    @Override
    public List<Map<String, Object>> searchByQuery(String indexName, String docType,
                                                   QueryBuilder queryBuilder, QueryBuilder QueryBuilder, SortBuilder... sort) throws Exception {

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        int size = (int) this.countByQuery(indexName, docType, queryBuilder);
        SearchRequestBuilder request = elasticSearchClient.prepareSearch(indexName)
                .setTypes(docType).setQuery(queryBuilder).setSize(size);
        if (sort != null) {
            for (SortBuilder s : sort) {
                if (s == null) {
                    continue;
                }
                request.addSort(s);
            }
        }
//        SearchResponse sr = request.setPostFilter(QueryBuilder).execute().actionGet();
//        SearchHit[] shs = sr.getHits().hits();
//        for (SearchHit sh : shs) {
//            Map<String, Object> map = sh.getSource();
//            map.put(INDEX_ID, sh.getId());
//            list.add(map);
//        }
        scrollSearch(list, request);
        return list;
    }

    @Override
    public List<Map<String, Object>> searchByQuery(String indexName, String docType,
                                                   QueryBuilder queryBuilder, QueryBuilder QueryBuilder, Integer size, SortBuilder... sort) throws Exception {
        if (size == null) {
            size = (int) this.countByQuery(indexName, docType, queryBuilder);
        }
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        SearchRequestBuilder request = elasticSearchClient.prepareSearch(indexName)
                .setTypes(docType).setQuery(queryBuilder).setSize(size);
        if (sort != null) {
            for (SortBuilder s : sort) {
                if (s == null) {
                    continue;
                }
                request.addSort(s);
            }
        }
        SearchResponse sr = request.setPostFilter(QueryBuilder).execute().actionGet();
        SearchHit[] shs = sr.getHits().hits();
        for (SearchHit sh : shs) {
            Map<String, Object> map = sh.getSource();
            map.put(INDEX_ID, sh.getId());
            list.add(map);
        }
        return list;
    }

    @Override
    public List<Map<String, Object>> searchByQuery(String indexName, String docType, QueryBuilder queryBuilder,
                                                   QueryBuilder QueryBuilder, int from, int size, SortBuilder... sort) throws Exception {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        SearchRequestBuilder request = elasticSearchClient.prepareSearch(indexName)
                .setTypes(docType).setQuery(queryBuilder);
        if (sort != null) {
            for (SortBuilder sb : sort) {
                if (sb == null) {
                    continue;
                }
                request.addSort(sb);
            }
        }
//        SearchResponse sr = request.setPostFilter(QueryBuilder).setFrom(from)
//                .setSize(size).execute().actionGet();
//        SearchHit[] shs = sr.getHits().hits();
//        for (SearchHit sh : shs) {
//            Map<String, Object> map = sh.getSource();
//            map.put(INDEX_ID, sh.getId());
//            list.add(map);
//        }
        scrollSearch(list, request, from, size);
        return list;
    }

    @Override
    public List<Map<String, Object>> searchByFilter(String indexName, String docType,
                                                    QueryBuilder QueryBuilder, int from, int size, SortBuilder... sort) throws Exception {

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        SearchRequestBuilder request = elasticSearchClient.prepareSearch(indexName)
                .setTypes(docType).setPostFilter(QueryBuilder);
        if (sort != null) {
            for (SortBuilder sb : sort) {
                if (sb == null) {
                    continue;
                }
                request.addSort(sb);
            }
        }
//        SearchResponse sr = request.setFrom(from).setSize(size).execute().actionGet();
//        SearchHit[] shs = sr.getHits().hits();
//        for (SearchHit sh : shs) {
//            Map<String, Object> map = sh.getSource();
//            map.put(INDEX_ID, sh.getId());
//            list.add(map);
//        }
        scrollSearch(list, request, from, size);
        return list;
    }

    @Override
    public long countByFilter(String indexName, String docType, QueryBuilder QueryBuilder)
            throws Exception {
        SearchResponse response = elasticSearchClient.prepareSearch(indexName).setTypes(docType).setSize(0)
                .setPostFilter(QueryBuilder).execute().actionGet();
        return response.getHits().getTotalHits();
    }

    @Override
    public List<Map<String, Object>> getSplitterBySearchAfter(String index, String type, QueryBuilder queryBuilder, int splitSize, SortBuilder... sort) throws Exception {
        long count = countByQuery(index, type, queryBuilder);
        int size = (int) (count / splitSize);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>(size);

        SearchRequestBuilder request = elasticSearchClient.prepareSearch(index).setTypes(type);
        if (queryBuilder != null) {
            request.setQuery(queryBuilder);
        }
        if (sort != null) {
            for (SortBuilder sb : sort) {
                if (sb == null) {
                    continue;
                }
                request.addSort(sb);
            }
        }
        SearchResponse response = request.setSize(10000).get();

        int start = 0;
        int end;
        int curSplit = 0;
        long startTime = 0;
        while (true) {
            SearchHit[] hits = response.getHits().getHits();
            if (hits != null && hits.length > 0) {
                end = start + hits.length;
                while (curSplit >= start && curSplit < end) {
                    Map<String, Object> map = hits[curSplit - start].getSource();
                    map.put(INDEX_ID, hits[curSplit - start].getId());
                    list.add(map);

                    curSplit += splitSize;
                }
                start = end;
//                if(startTime>0) {
//                    System.out.println("loop time: "+(System.currentTimeMillis()-startTime)+"ms");
//                }
                startTime = System.currentTimeMillis();
                response = request.searchAfter(hits[hits.length-1].getSortValues()).get();
            } else {
                break;
            }
        }
        return list;
    }

    @Override
    public List<Map<String, Object>> getSplitterByScroll(String index, String type, QueryBuilder queryBuilder, int splitSize, SortBuilder... sort) throws Exception {
        long count = countByQuery(index, type, queryBuilder);
        int size = (int) (count / splitSize);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>(size);

        SearchRequestBuilder request = elasticSearchClient.prepareSearch(index).setTypes(type);
        if (queryBuilder != null) {
            request.setQuery(queryBuilder);
        }
        if (sort != null) {
            for (SortBuilder sb : sort) {
                if (sb == null) {
                    continue;
                }
                request.addSort(sb);
            }
        }
        TimeValue t = new TimeValue(30000);
        SearchResponse response = request.setScroll(t).setSize(10000).get();
        String scrollId = response.getScrollId();

        int start = 0;
        int end;
        int curSplit = 0;
        long startTime = 0;
        while (true) {
            SearchHit[] hits = response.getHits().getHits();
            if (hits != null && hits.length > 0) {
                end = start + hits.length;
                while (curSplit >= start && curSplit < end) {
                    Map<String, Object> map = hits[curSplit - start].getSource();
                    map.put(INDEX_ID, hits[curSplit - start].getId());
                    list.add(map);

                    curSplit += splitSize;
                }
                start = end;
//                if(startTime>0) {
//                    System.out.println("loop time: "+(System.currentTimeMillis()-startTime)+"ms");
//                }
                startTime = System.currentTimeMillis();
//                elasticSearchClient.prepareSearch(index).setTypes(type).searchAfter(hits[hits.length-1].getSortValues());
                response = elasticSearchClient.prepareSearchScroll(scrollId).setScroll(t).get();
                scrollId = response.getScrollId();
//                System.out.println(scrollId);
            } else {
                break;
            }
        }
        return list;
    }

    @Override
    public Map<String, Object> get(String index, String type, QueryBuilder queryBuilder, int i, SortBuilder... sort) throws Exception {
        SearchRequestBuilder request = elasticSearchClient.prepareSearch(index).setTypes(type);
        if (queryBuilder != null) {
            request.setQuery(queryBuilder);
        }
        if (sort != null) {
            for (SortBuilder sb : sort) {
                if (sb == null) {
                    continue;
                }
                request.addSort(sb);
            }
        }
        TimeValue t = new TimeValue(30000);
        SearchResponse response = request.setScroll(t).setSize(10000).get();
        String scrollId = response.getScrollId();

        int h = 0;
        while (true) {
            SearchHit[] hits = response.getHits().getHits();
            if (hits != null && hits.length > 0) {
                // optimize the "for loop", [from, from+size] and [index, index+hits.length] should have intercourse
                if (h + hits.length < i + 1) {
                    h += hits.length;
                } else {
                    Map<String, Object> map = hits[i - h].getSource();
                    map.put(INDEX_ID, hits[i - h].getId());
                    return map;
                }
                response = elasticSearchClient.prepareSearchScroll(scrollId).setScroll(t).get();
                scrollId = response.getScrollId();
            } else {
                break;
            }
        }
        return null;
    }

    @Override
    public List<Map<String, Object>> searchByQuery(String indexName, String docType,
                                                   QueryBuilder queryBuilder, int from, int size, SortBuilder... sort) throws Exception {

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        SearchRequestBuilder request = elasticSearchClient.prepareSearch(indexName)
                .setTypes(docType);
        if (queryBuilder != null) {
            request.setQuery(queryBuilder);
        }
        if (sort != null) {
            for (SortBuilder sb : sort) {
                if (sb == null) {
                    continue;
                }
                request.addSort(sb);
            }
        }
//        SearchResponse sr = request.setFrom(from).setSize(size).execute().actionGet();
//        SearchHit[] shs = sr.getHits().hits();
//        for (SearchHit sh : shs) {
//            Map<String, Object> map = sh.getSource();
//            map.put(INDEX_ID, sh.getId());
//            list.add(map);
//        }
        scrollSearch(list, request, from, size);
        return list;
    }

    @Override
    public ICloudIndexManager getManager() {
        return manager;
    }

    private Map<Integer, Boolean> getBulkMap(BulkResponse bulkResponse) {
        BulkItemResponse[] birs = bulkResponse.getItems();
        Map<Integer, Boolean> resMap = new HashMap<Integer, Boolean>();
        if (birs != null) {
            for (BulkItemResponse bir : birs) {
                resMap.put(bir.getItemId(), !bir.isFailed());
            }
        }
        return resMap;
    }

    @Override
    public Map<Integer, Boolean> bulkRequest(String index, String docType, IndexRequest[] requests) {
        if (requests != null) {
            BulkRequestBuilder bulkRequest = elasticSearchClient.prepareBulk();
            for (IndexRequest ir : requests) {
                bulkRequest.add(ir);
            }
            BulkResponse bulkResponse = bulkRequest.execute().actionGet();
            return getBulkMap(bulkResponse);
        }
        return null;
    }

    @Override
    public Map<Integer, Boolean> bulkUpsert(String index, String docType,
                                            List<Map<String, Object>> list) throws Exception {
        return bulkUpsert(index, docType, list, false);
    }

    @Override
    public Map<Integer, Boolean> bulkUpsert(String index, String docType,
                                            List<Map<String, Object>> list, boolean refresh) throws Exception {
        if (list != null && list.size() > 0) {
            List<String> ids = Lists.newArrayList();
            List<Boolean> hasIds = Lists.newArrayList();
            BulkRequestBuilder bulkRequest = elasticSearchClient.prepareBulk().setRefreshPolicy(WriteRequest.RefreshPolicy.parse(refresh + ""));
            for (Map<String, Object> map : list) {
                if (map.containsKey(INDEX_ID)) {
                    hasIds.add(true);
                } else {
                    hasIds.add(false);
                }

                String id = (String) map.remove(INDEX_ID);
                if (id == null) {
                    bulkRequest.add(elasticSearchClient.prepareIndex(index, docType).setSource(buildDoc(map)));
                } else {
                    XContentBuilder source = buildDoc(map);
                    bulkRequest.add(elasticSearchClient.prepareUpdate(index, docType, id).setDoc(source).setUpsert(source));
//                    bulkRequest.add(elasticSearchClient.prepareIndex(index, docType, id).setSource(source));
                }
                ids.add(id);
            }
            BulkResponse bulkResponse = bulkRequest.execute().actionGet();
            // reset id for each doc
            for (int i = 0; i < list.size(); i++) {
                if (hasIds.get(i)) {
                    list.get(i).put(INDEX_ID, ids.get(i));
                }
            }
            return getBulkMap(bulkResponse);
        }
        return null;
    }

    @Override
    public Map<Integer, Boolean> bulkUpdate(String index, String docType,
                                            List<Map<String, Object>> list, boolean refresh) {
        if (list != null && list.size() > 0) {
            List<String> ids = Lists.newArrayList();
            BulkRequestBuilder bulkRequest = elasticSearchClient.prepareBulk().setRefreshPolicy(WriteRequest.RefreshPolicy.parse(refresh + ""));
            for (Map<String, Object> map : list) {
                String id = (String) map.remove(INDEX_ID);
                bulkRequest.add(elasticSearchClient.prepareUpdate(index, docType, id).setDoc(map));
                ids.add(id);
            }
            BulkResponse bulkResponse = bulkRequest.execute().actionGet();
            // reset id for each doc
            for (int i = 0; i < list.size(); i++) {
                list.get(i).put(INDEX_ID, ids.get(i));
            }
            return getBulkMap(bulkResponse);
        }
        return null;
    }

    @Override
    public Map<Integer, Boolean> bulkUpdate(String index, String docType, List<Map<String, Object>> list) {
        return bulkUpdate(index, docType, list, false);
    }

    @Override
    public Map<Integer, Boolean> bulkIndex(String index, String docType,
                                           List<Map<String, Object>> list, boolean refresh) throws Exception {
        if (list != null && list.size() > 0) {
            List<String> ids = Lists.newArrayList();
            List<Boolean> hasIds = Lists.newArrayList();
            BulkRequestBuilder bulkRequest = elasticSearchClient.prepareBulk().setRefreshPolicy(WriteRequest.RefreshPolicy.parse(refresh + ""));
            for (Map<String, Object> map : list) {
                if (map.containsKey(INDEX_ID)) {
                    hasIds.add(true);
                } else {
                    hasIds.add(false);
                }

                String id = (String) map.remove(INDEX_ID);
                if (id == null) {
                    bulkRequest.add(elasticSearchClient.prepareIndex(index, docType).setSource(buildDoc(map)));
                } else {
                    bulkRequest.add(elasticSearchClient.prepareIndex(index, docType, id).setSource(buildDoc(map)));
                }
                ids.add(id);
            }
            BulkResponse bulkResponse = bulkRequest.execute().actionGet();
            // reset id for each doc
            for (int i = 0; i < list.size(); i++) {
                if (hasIds.get(i)) {
                    list.get(i).put(INDEX_ID, ids.get(i));
                }
            }
            return getBulkMap(bulkResponse);
        }
        return null;
    }

    @Override
    public Map<Integer, Boolean> bulkIndex(String index, String docType, List<Map<String, Object>> list,
                                           boolean refresh, VersionType vt, long version) throws Exception {
        if (list != null && list.size() > 0) {
            List<String> ids = Lists.newArrayList();
            List<Boolean> hasIds = Lists.newArrayList();
            BulkRequestBuilder bulkRequest = elasticSearchClient.prepareBulk().setRefreshPolicy(WriteRequest.RefreshPolicy.parse(refresh + ""));
            for (Map<String, Object> map : list) {
                if (map.containsKey(INDEX_ID)) {
                    hasIds.add(true);
                } else {
                    hasIds.add(false);
                }
                String id = (String) map.remove(INDEX_ID);
                if (id == null) {
                    bulkRequest.add(elasticSearchClient.prepareIndex(index, docType)
                            .setSource(buildDoc(map))
                            .setVersionType(vt)
                            .setVersion(version));
                } else {
                    bulkRequest.add(elasticSearchClient.prepareIndex(index, docType, id)
                            .setSource(buildDoc(map))
                            .setVersion(version)
                            .setVersionType(vt));
                }
                ids.add(id);
            }
            BulkResponse bulkResponse = bulkRequest.execute().actionGet();
            // reset id for each doc
            for (int i = 0; i < list.size(); i++) {
                if (hasIds.get(i)) {
                    list.get(i).put(INDEX_ID, ids.get(i));
                }
            }
            return getBulkMap(bulkResponse);
        }
        return null;
    }

    @Override
    public Map<Integer, Boolean> bulkIndex(String index, String docType,
                                           List<Map<String, Object>> list) throws Exception {
        return bulkIndex(index, docType, list, false);
    }

    @Override
    public SearchResponse searchByFieldFuzzyLikeFilter(String index, String docType,
                                                       HashMap fields, int from, int size) throws Exception {
        try {
//            QueryBuilder queryBuilder = null;
            String[] fuzzyFields = new String[MAX_QUERY_TERMS];
            String fuzzyValue = null;
            int n = 0;
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

            //support only one like , use if not while here
            if (fields != null && !fields.isEmpty()) {
                //support only one like , use if not while here
                Iterator iterator = fields.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry entry = (Map.Entry) iterator.next();
                    fuzzyFields[n++] = (String) entry.getKey();
                    fuzzyValue = (String) entry.getValue();

                    boolQueryBuilder.must(QueryBuilders.fuzzyQuery((String) entry.getKey(), (String) entry.getValue()));
                }
//                queryBuilder = QueryBuilders.fuzzyLikeThisQuery(fuzzyFields)
//                        .likeText(fuzzyValue).maxQueryTerms(MAX_QUERY_TERMS);
            }

            SearchRequestBuilder requestBuilder = this.getClient().prepareSearch(index)
                    .setTypes(docType).setFrom(from).setSize(size);
            requestBuilder.setQuery(boolQueryBuilder);
//            if (queryBuilder != null) {
//                requestBuilder.setQuery(queryBuilder);
//            }

            SearchResponse response = requestBuilder.execute().actionGet();
            return response;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public SearchResponse searchByFieldsFilter(String index, String docType, HashMap fields, int from, int size)
            throws Exception {
        try {
            BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();

            if (fields != null && !fields.isEmpty()) {
                Iterator iterator = fields.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry entry = (Map.Entry) iterator.next();
                    queryBuilder.must(QueryBuilders.termQuery((String) entry.getKey(), entry.getValue()));
                }
            }

            SearchRequestBuilder requestBuilder = this.getClient().prepareSearch(index)
                    .setTypes(docType).setFrom(from).setSize(size);
            if (queryBuilder != null) {
                requestBuilder.setQuery(queryBuilder);
            }

            SearchResponse response = requestBuilder.execute().actionGet();
            return response;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void exportData(String indexName, String docType, String path) throws IOException {
        File outFile = new File(path);
        FileOutputStream out = new FileOutputStream(outFile);
        try {
            SearchResponse scrollResp = getClient().prepareSearch(indexName)
                    .setTypes(docType)
                    .setSearchType(SearchType.DEFAULT)
                    .setScroll(new TimeValue(600000))
                    .setQuery(QueryBuilders.matchAllQuery())
                    .setSize(1000).execute().actionGet();
            boolean flag = true;
            while (flag) {
                scrollResp = getClient().prepareSearchScroll(scrollResp.getScrollId())
                        .setScroll(new TimeValue(600000)).execute().actionGet();
                SearchHit[] searchHits = scrollResp.getHits().hits();
                long len = searchHits.length;
                if (len == 0) {
                    flag = false;
                }
                for (SearchHit sh : searchHits) {
                    out.write((JSON.toJSONString(sh.getSource()) + "\n").getBytes());
                }
            }
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void importData(String indexName, String docType, String path) throws Exception {
        File inFile = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(inFile));
        try {
            String line = reader.readLine();
            while (line != null) {
                this.saveDoc(indexName, docType, line);
                line = reader.readLine();
            }
        } finally {
            reader.close();
        }
    }

    @Override
    public ScrollResult scrollResult(String indexName, String docType, QueryBuilder queryBuilder,
                                     int pageSize, long timeout) throws Exception {

        SearchResponse scrollResp = this.getClient().prepareSearch(indexName)
                .setTypes(docType)
                .setSearchType(SearchType.DEFAULT)
                .setScroll(new TimeValue(timeout))
                .setQuery(queryBuilder)
                .setSize(pageSize).execute().actionGet();
        return new ScrollResult(this.getClient(), scrollResp, timeout);
    }

    public Client getClient() {
        return elasticSearchClient;
    }

    @Override
    public void close() throws Exception {
        this.getManager().close();
    }

    public Map<String, Aggregation> aggregate(String indexName, String docType, QueryBuilder queryBuilder, AggregationBuilder... builders) throws Exception {
        SearchRequestBuilder requestBuilder = this.getClient().prepareSearch().setIndices(indexName).setTypes(docType);
        if (queryBuilder != null) {
            requestBuilder.setQuery(queryBuilder);
        }
        for (AggregationBuilder builder : builders) {
            requestBuilder.addAggregation(builder);
        }
        SearchResponse response = requestBuilder.get();

        return response.getAggregations().asMap();
    }
}
