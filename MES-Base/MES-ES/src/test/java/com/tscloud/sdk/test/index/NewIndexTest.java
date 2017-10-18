package com.tscloud.sdk.test.index;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.es.cloudindex.CloudIndexClient;
import com.mes.es.cloudindex.CloudIndexClientConfig;
import com.mes.es.cloudindex.ICloudIndexManager;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 147458 on 2017/3/23.
 */
public class NewIndexTest {
    private CloudIndexClient cloudIndexClient;
    private ICloudIndexManager manager;
    private String index = "bjtkk";
    private String type = "ck_changzhurenkou";

    @Before
    public void before() throws Exception {
        CloudIndexClientConfig config = new CloudIndexClientConfig();
        config.setClusterName("mes-es");
        config.setTransportSniff(true);
        List<InetSocketTransportAddress> hosts = new ArrayList<InetSocketTransportAddress>();
        hosts.add(new InetSocketTransportAddress(InetAddress.getByName("192.168.5.3"), 9300));
        config.setHosts(hosts);
        cloudIndexClient = new CloudIndexClient(config);
        manager = cloudIndexClient.getManager();
    }

    @After
    public void after() throws Exception {
        if (cloudIndexClient != null) {
            cloudIndexClient.close();
        }
    }

    @Test
    public void testBulkIndex() throws Exception {
        long start = System.currentTimeMillis();

        List<Map<String, Object>> list = Lists.newArrayList();
        for (int i = 0; i < 10000000; i++) {
            Map<String, Object> map = Maps.newHashMap();
            map.put(CloudIndexClient.INDEX_ID, i + "");
            map.put("id", i);
            map.put("name", "name" + i);
            map.put("gender", i % 2 == 0);

            list.add(map);
            if (list.size() == 10000) {
                cloudIndexClient.bulkIndex(index, type, list);

                list.clear();
            }
        }
        System.out.println("took time: " + (System.currentTimeMillis() - start) + "ms");
    }

    @Test
    public void testPagination() throws Exception {
        long start = System.currentTimeMillis();

//        List<String> ids = Lists.newArrayList();
        int size = 10000;
        FieldSortBuilder sb = SortBuilders.fieldSort("number").order(SortOrder.ASC);
//        Map<String, Object> doc = cloudIndexClient.get(index, type, QueryBuilders.matchAllQuery(), size - 1, sb);
//        if (doc != null && !doc.isEmpty()) {
//            ids.add((Integer) doc.get("id"));
//        }
//        int i = 0;
//        while (true) {
//            doc = cloudIndexClient.get(index, type, QueryBuilders.rangeQuery("id").gte(ids.get(i)), size - 1, sb);
//            if (doc != null && !doc.isEmpty()) {
//                ids.add((Integer) doc.get("id"));
//                i++;
//            } else break;
//        }

        List<Map<String, Object>> list = cloudIndexClient.getSplitterByScroll(index, type, QueryBuilders.matchAllQuery(), size, sb);
        System.out.println("getSplitterByScroll took: "+(System.currentTimeMillis()-start)+"ms, size: "+list.size());

        if (list != null) {
            ExecutorService pool = Executors.newFixedThreadPool(100);
            CountDownLatch latch = new CountDownLatch(list.size());
//            for (Map<String, Object> map : list) {
//                ids.add((String) map.get("number"));
//            }
            List<Integer> sizes = Lists.newArrayList();
            for (int i = 0; i < list.size() - 1; i++) {
                pool.submit(new QueryThread(cloudIndexClient, index, type, (String) list.get(i).get("number"), (String) list.get(i + 1).get("number"), latch, sizes));
            }
            pool.submit(new QueryThread(cloudIndexClient, index, type, (String) list.get(list.size() - 1).get("number"), null, latch, sizes));

            latch.await();

            int count = 0;
            for(int s:sizes) {
                count+=s;
            }
            System.out.println("total fetch size: "+count);

            pool.shutdown();
        }
//        for (String id : ids) {
//            System.out.println(id);
//        }
        System.out.println("fetch time: " + (System.currentTimeMillis() - start) + "ms");
    }

    private static class QueryThread extends Thread {
        private CloudIndexClient cloudIndexClient;
        private String index;
        private String type;
        private String start;
        private String end;
        private CountDownLatch latch;
        private List<Integer> sizes;

        public QueryThread(CloudIndexClient cloudIndexClient, String index, String type, String start, String end, CountDownLatch latch, List<Integer> sizes) {
            this.cloudIndexClient = cloudIndexClient;
            this.index = index;
            this.type = type;
            this.start = start;
            this.end = end;
            this.latch = latch;
            this.sizes = sizes;
        }

        public void run() {
            try {
                RangeQueryBuilder qb = QueryBuilders.rangeQuery("number").gte(start);
                if (end != null && !end.isEmpty()) {
                    qb.lt(end);
                }
                List<Map<String, Object>> list = cloudIndexClient.searchByQuery(index, type, qb, 0, 10000, SortBuilders.fieldSort("number").order(SortOrder.ASC));
                if (list != null && !list.isEmpty()) {
                    System.out.println(JSON.toJSONString(list.get(0)));
                    for (Map<String, Object> d : list) {
                    }
                    this.sizes.add(list.size());
                } else {
                    this.sizes.add(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        }
    }


    public static void main(String[] args) throws Exception {
        CloudIndexClientConfig config = new CloudIndexClientConfig();
        config.setClusterName("es5.1.1");
        config.setTransportSniff(true);
        List<InetSocketTransportAddress> hosts = new ArrayList<InetSocketTransportAddress>();
        hosts.add(new InetSocketTransportAddress(InetAddress.getByName("172.31.68.204"), 9300));
        config.setHosts(hosts);
        CloudIndexClient client = new CloudIndexClient(config);

        ICloudIndexManager manager = client.getManager();

//        String index = "xxy_test";
        String index = "xxy_test";
//        String type = "test";
        String type = "tab1";

        long start = System.currentTimeMillis();

//        String mapping = getMapping(type);

//        List<Map<String, Object>> list = client.searchByQuery(index, type, QueryBuilders.boolQuery().mustNot(QueryBuilders.existsQuery("workflow_id")));
//        System.out.println(list.size());

//        client.countByQuery(index, type, QueryBuilders.matchAllQuery());

//        FieldSortBuilder sortBuilder = SortBuilders.fieldSort("field").order(SortOrder.DESC);

//        List<Map<String, Object>> docs = client.searchByQuery(index, type, QueryBuilders.matchAllQuery(), SortBuilders.fieldSort("id").order(SortOrder.DESC));
//        System.out.println(docs);

//        client.deleteDocByQuery(index, type, QueryBuilders.matchAllQuery());

//        client.saveDoc(index, type, "{\"r\":\"abc\",\"e\":3000,\"ddd\":false}", true);
//        Map<String, Object> updateMap = Maps.newHashMap();
//        updateMap.put("r", "r60000");
//        System.out.println(client.updateDoc(index, type, "AVtEUYHnJVwMsT8z4Y-2", updateMap, true));;

        List<Map<String, Object>> list = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            Map<String, Object> map = Maps.newHashMap();
            map.put(CloudIndexClient.INDEX_ID, i + "");
            map.put("id", i);
            map.put("name", "name" + i);
            map.put("gender", i % 2 == 0);

            list.add(map);
        }

//        client.bulkIndex(index, type, list, true);
//        list.clear();

        for (int i = 0; i < 50; i++) {
            Map<String, Object> map = Maps.newHashMap();
            map.put(CloudIndexClient.INDEX_ID, i + "");
            map.put("addr", "my addr is road st no " + i);
            list.add(map);
        }
        client.bulkUpsert(index, type, list, true);

//        List<Map<String, Object>> list = Lists.newArrayList();
//        Map<String, Object> updateMap = Maps.newHashMap();
//        updateMap.put("r", "r60000t");
//        updateMap.put(ICloudIndexClient.INDEX_ID, "AVtEUYHnJVwMsT8z4Y-2");
//        list.add(updateMap);
//        client.bulkUpdate(index, type, list);
//        System.out.println(list);

//        long start = System.currentTimeMillis();
//        List<Map<String, Object>> resultSetList = client.searchByQuery(index, type, QueryBuilders.matchAllQuery(),40000, 10000);
//        System.out.println(resultSetList.size());
//        System.out.println("time: " + (System.currentTimeMillis() - start));


//        if(!manager.existIndex(index)) {
//            manager.createIndex(index, 1,1);
//        }
//
//        if (!manager.existMapping(index, type)) {
//            manager.createMapping(index, type, mapping);
//        }

        // delete doc
//        client.deleteDocByQuery(index, type, QueryBuilders.matchAllQuery());

        // index doc
//        List<Map<String, Object>> bulk = Lists.newArrayList();
//        int k = 0;
//        for (int i = 0 ; i < 100000000; i++) {
//            Map<String, Object> map = Maps.newHashMap();
//            map.put("id", i);
//            map.put("name", "name" + i);
//            map.put("gender", i%2==0);
//
//            bulk.add(map);
//            k++;
//            if(k==2000) {
//                client.bulkIndex(index, type, bulk);
//                k=0;
//                bulk.clear();
//            }
////            client.saveDoc(index, type, map);
//        }
//        client.bulkIndex(index, type, bulk);

//        client.searchByQuery(index, type, );
//        Client c = client.getClient();
//        SearchResponse response = c.prepareSearch().setIndices(index).setTypes(type).addAggregation(AggregationBuilders.max("max").field("e")).get();
//        SearchResponse response = c.prepareSearch().setIndices(index).setTypes(type).addAggregation(AggregationBuilders.avg("avg").field("e")).get();
//        Aggregation aggregation = response.getAggregations().get("avg");
//        Avg avg = (Avg) aggregation;
//        System.out.println(avg.getValue());

        // 测试聚合查询
//        Map<String, Aggregation> aggs = client.aggregate(index, type, null, AggregationBuilders.max("max").field("e"), AggregationBuilders.avg("avg").field("e"));
//        Iterator<String> it = aggs.keySet().iterator();
//        while (it.hasNext()) {
//            String key = it.next();
//            System.out.println(key + " " + ((NumericMetricsAggregation.SingleValue)aggs.get(key)).value());
//        }

//        List<Map<String, Object>> hits = client.searchByQuery(index, type, QueryBuilders.wildcardQuery("r", "?60*"));
//        System.out.println(hits.size());

//        List<Map<String, Object>> list = client.searchByQuery(index, type, QueryBuilders.wildcardQuery("name", "*me*00*"), 500000, 1000, SortBuilders.fieldSort("id").order(SortOrder.ASC));
//        System.out.println(client.countByQuery(index, type, QueryBuilders.wildcardQuery("name", "*me*00*")));
//        System.out.println(list.size());
//        System.out.println(JSON.toJSONString(list));

//        int i=0;
//        while(true) {
//            ClusterHealthResponse health = client.getClient().admin().cluster().prepareHealth().get();
//            System.out.println(health.getNumberOfNodes());
//
//            System.out.println(client.countByQuery(index, type, QueryBuilders.wildcardQuery("name", "*me*00*")));
//
//            i++;
//            Thread.sleep(5000L);
//            if(i>1000) {
//                break;
//            }
//        }

//        List<Map<String, Object>> list = client.searchByQuery(index, type, QueryBuilders.boolQuery().mustNot(QueryBuilders.termQuery("name", "name68001")), 300, 1000, SortBuilders.fieldSort("id").order(SortOrder.ASC));
//        System.out.println(list.size());

//        System.out.println(client.countByQuery(index, type, QueryBuilders.boolQuery().mustNot(QueryBuilders.termQuery("gender", true))));

        // scroll search
//        Client cli = client.getClient();
//        TimeValue t = new TimeValue(500);
//        SearchRequestBuilder builder = cli.prepareSearch().setIndices(index).setTypes(type).setScroll(t).setQuery(QueryBuilders.wildcardQuery("r", "*6*"));
//        SearchResponse response = builder.get();
//        String scrollId = response.getScrollId();
//
//        List<Map<String, Object>> list = Lists.newArrayList();
//        while (true) {
//            SearchHit[] hits = response.getHits().getHits();
//            if (hits != null && hits.length > 0) {
//                for (SearchHit hit : hits) {
//                    list.add(hit.getSource());
//                }
//            } else {
//                break;
//            }
//            response = cli.prepareSearchScroll(scrollId).setScroll(t).get();
//            scrollId = response.getScrollId();
//        }
//        cli.prepareClearScroll().addScrollId(scrollId).get();
//        System.out.println(list.size());

//        List<Map<String, Object>> list = client.searchByQuery(index, type, QueryBuilders.matchAllQuery());
//        System.out.println(list.size());

        System.out.println("took time: " + (System.currentTimeMillis() - start) + "ms");

        client.close();
    }

    public static String getMapping(String docType) {
        HashMap properties = new HashMap();
        HashMap nameMap = new HashMap();
//        nameMap.put("type", "string");
        nameMap.put("type", "keyword");
        nameMap.put("store", "yes");
//        nameMap.put("index", "not_analyzed");
        properties.put("name", nameMap);
        HashMap tfsnameMap = new HashMap();
//        tfsnameMap.put("type", "string");
        tfsnameMap.put("type", "keyword");
        tfsnameMap.put("store", "yes");
//        tfsnameMap.put("index", "not_analyzed");
        properties.put("tfsname", tfsnameMap);
        HashMap pathMap = new HashMap();
//        pathMap.put("type", "string");
        pathMap.put("type", "keyword");
        pathMap.put("store", "yes");
//        pathMap.put("index", "not_analyzed");
        properties.put("path", pathMap);
        HashMap parentMap = new HashMap();
//        parentMap.put("type", "string");
        parentMap.put("type", "keyword");
        parentMap.put("store", "yes");
//        parentMap.put("index", "not_analyzed");
        properties.put("parent", parentMap);
        HashMap lengthMap = new HashMap();
        lengthMap.put("type", "long");
        lengthMap.put("store", "yes");
        properties.put("length", lengthMap);
        HashMap fileMap = new HashMap();
        fileMap.put("type", "boolean");
        fileMap.put("store", "yes");
        properties.put("file", fileMap);
        HashMap tokenMap = new HashMap();
//        tokenMap.put("type", "string");
        tokenMap.put("type", "keyword");
        tokenMap.put("store", "yes");
//        tokenMap.put("index", "not_analyzed");
        properties.put("token", tokenMap);
        HashMap delflag = new HashMap();
        delflag.put("type", "boolean");
        delflag.put("store", "yes");
        delflag.put("index", "not_analyzed");
        properties.put("delflag", delflag);
        HashMap docTypeMap = new HashMap();
        docTypeMap.put("properties", properties);
        HashMap retMap = new HashMap();
        retMap.put(docType, docTypeMap);
        return JSON.toJSONString(retMap);
    }
}
