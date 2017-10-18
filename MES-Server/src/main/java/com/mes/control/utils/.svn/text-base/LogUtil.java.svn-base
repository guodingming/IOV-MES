package com.mes.control.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Lists;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.rest.view.Page;
import com.mes.es.cloudindex.CloudIndexClient;
import com.mes.es.cloudindex.CloudIndexClientConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.metrics.valuecount.InternalValueCount;
import org.elasticsearch.search.sort.SortBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 系统日志和用户操作日志工具类
 * <p>
 * Created by xiuyou.xu on 2017/8/4.
 */
public class LogUtil {
    private static Logger logger = LoggerFactory.getLogger(LogUtil.class);
    //    private static ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
    private static CloudIndexClient client;
    private static KafkaConsumer userOpLogConsumer;
    private static KafkaConsumer sysLogConsumer;
    private static KafkaConsumer serviceInvocationConsumer;

    static {
        init();
    }

    private static void init() {
        try {
            CloudIndexClientConfig config = new CloudIndexClientConfig();
            config.setClusterName(ConfigHelper.getValue("es.cluster.name"));
            config.setTransportSniff(true);
            List<InetSocketTransportAddress> hosts = new ArrayList<InetSocketTransportAddress>();
            String[] addresses = ConfigHelper.getValue("es.addresses").split(",");
            if (addresses != null && addresses.length > 0) {
                for (String address : addresses) {
                    String[] a = address.split(":");
                    hosts.add(new InetSocketTransportAddress(InetAddress.getByName(a[0]), Integer.parseInt(a[1])));
                }
            }
            config.setHosts(hosts);
            client = new CloudIndexClient(config);

            userOpLogConsumer = KafkaConsumerUtil.createConsumer(Lists.newArrayList(ConfigHelper.getValue("log.kafka.url")), "mes_user_op_log");
            sysLogConsumer = KafkaConsumerUtil.createConsumer(Lists.newArrayList(ConfigHelper.getValue("log.kafka.url")), "mes_sys_log");
            serviceInvocationConsumer = KafkaConsumerUtil.createConsumer(Lists.newArrayList(ConfigHelper.getValue("log.kafka.url")), "mes_service_invocation");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
    }


    /**
     * 处理用户操作日志
     */
    public static void handleUserOpLog() {
        try {
            String index = ConfigHelper.getValue("es.user.op.index");
            String type = ConfigHelper.getValue("es.user.op.type");
            if (!client.getManager().existIndex(index)) {
                client.getManager().createIndex(index, 1, 0);
            }
            if (!client.getManager().existMapping(index, type)) {
                client.getManager().createMapping(index, type, getUserOpLogMapping(type));
            }
            new Thread() {
                public void run() {
                    try {
                        userOpLogConsumer.subscribe(Lists.newArrayList(ConfigHelper.getValue("log.user.op.topic")));
                        while (true) {
                            ConsumerRecords<String, String> records = userOpLogConsumer.poll(3000);
                            List<Map<String, Object>> list = Lists.newArrayList();
                            records.forEach(record -> {
                                list.add(JSON.parseObject(record.value(), new TypeReference<Map<String, Object>>() {
                                }));
                            });
                            client.bulkIndex(index, type, list, true);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getUserOpLogMapping(String docType) {
        HashMap properties = new HashMap();
        HashMap userIdMap = new HashMap();
//        userIdMap.put("type", "string");
        userIdMap.put("type", "keyword");
        userIdMap.put("store", "yes");
//        userIdMap.put("index", "not_analyzed");
        properties.put("userId", userIdMap);

        HashMap userNameMap = new HashMap();
//        userNameMap.put("type", "string");
        userNameMap.put("type", "keyword");
        userNameMap.put("store", "yes");
//        userNameMap.put("index", "not_analyzed");
        properties.put("userName", userNameMap);

        HashMap pathMap = new HashMap();
//        pathMap.put("type", "string");
        pathMap.put("type", "keyword");
        pathMap.put("store", "yes");
//        pathMap.put("index", "not_analyzed");
        properties.put("path", pathMap);

        HashMap descriptionMap = new HashMap();
//        descriptionMap.put("type", "string");
        descriptionMap.put("type", "keyword");
        descriptionMap.put("store", "yes");
//        descriptionMap.put("index", "not_analyzed");
        properties.put("description", descriptionMap);

        HashMap startTimeMap = new HashMap();
//        startTimeMap.put("type", "string");
        startTimeMap.put("type", "keyword");
        startTimeMap.put("store", "yes");
//        startTimeMap.put("index", "not_analyzed");
        properties.put("startTime", startTimeMap);

        HashMap tookTimeMap = new HashMap();
        tookTimeMap.put("type", "keyword");
        tookTimeMap.put("store", "yes");
        properties.put("tookTime", tookTimeMap);

        HashMap statusMap = new HashMap();
        statusMap.put("type", "keyword");
        statusMap.put("store", "yes");
        properties.put("status", statusMap);

        HashMap responseMap = new HashMap();
//        responseMap.put("type", "string");
        responseMap.put("type", "keyword");
        responseMap.put("store", "yes");
//        responseMap.put("index", "not_analyzed");
        properties.put("response", responseMap);

//        HashMap delflag = new HashMap();
//        delflag.put("type", "boolean");
//        delflag.put("store", "yes");
//        delflag.put("index", "not_analyzed");
//        properties.put("delflag", delflag);

        HashMap docTypeMap = new HashMap();
        docTypeMap.put("properties", properties);
        HashMap retMap = new HashMap();
        retMap.put(docType, docTypeMap);
        return JSON.toJSONString(retMap);
    }

    public static Page query(Page page, String index, String type, SortBuilder... sortBuilders) {
        final BoolQueryBuilder qb = QueryBuilders.boolQuery();
        Object c = page.getCondition();
        if (c != null && Map.class.isInstance(c)) {
            Map<String, Object> condition = (Map<String, Object>) c;
            condition.keySet().forEach(key -> {
                if (condition.get(key) != null && !condition.get(key).toString().trim().isEmpty()) {
                    qb.should(QueryBuilders.wildcardQuery(key, "*" + condition.get(key) + "*"));
                }
            });
        }
        QueryBuilder queryBuilder = qb;
        List<Map<String, Object>> rows = null;
        try {
            page.setTotal((int) client.countByQuery(index, type, queryBuilder));
            rows = client.searchByQuery(index, type, queryBuilder, page.getStartRowNum(), page.getPageSize(), sortBuilders);
        } catch (Exception e) {
            e.printStackTrace();
        }
        page.setRows(rows);
        return page;
    }

    public static Page query(Page page, String index, String type, String code, SortBuilder... sortBuilders) {
        final BoolQueryBuilder qb = QueryBuilders.boolQuery();
        if (code != null && !code.isEmpty()) {
            qb.must(QueryBuilders.termQuery("code", code));
        }
        Object c = page.getCondition();
        if (c != null && Map.class.isInstance(c)) {
            BoolQueryBuilder or = QueryBuilders.boolQuery();
            Map<String, Object> condition = (Map<String, Object>) c;
            condition.keySet().forEach(key -> {
                if (condition.get(key) != null && !condition.get(key).toString().trim().isEmpty()) {
                    or.should(QueryBuilders.wildcardQuery(key, "*" + condition.get(key) + "*"));
                }
            });
            qb.must(or);
        }
        QueryBuilder queryBuilder = qb;
        List<Map<String, Object>> rows = null;
        try {
            page.setTotal((int) client.countByQuery(index, type, queryBuilder));
            rows = client.searchByQuery(index, type, queryBuilder, page.getStartRowNum(), page.getPageSize(), sortBuilders);
        } catch (Exception e) {
            e.printStackTrace();
        }
        page.setRows(rows);
        return page;
    }

    /**
     * 处理系统日志
     */
    public static void handleSysLog() {
        try {
            String index = ConfigHelper.getValue("es.sys.log.index");
            String type = ConfigHelper.getValue("es.sys.log.type");
            if (!client.getManager().existIndex(index)) {
                client.getManager().createIndex(index, 1, 0);
            }
            if (!client.getManager().existMapping(index, type)) {
                client.getManager().createMapping(index, type, getSysLogMapping(type));
            }
            new Thread() {
                public void run() {
                    try {
                        sysLogConsumer.subscribe(Lists.newArrayList(ConfigHelper.getValue("log.sys.log.topic")));
                        while (true) {
                            ConsumerRecords<String, String> records = sysLogConsumer.poll(3000);
                            List<Map<String, Object>> list = Lists.newArrayList();
                            records.forEach(record -> {
                                list.add(JSON.parseObject(record.value(), new TypeReference<Map<String, Object>>() {
                                }));
                            });
                            client.bulkIndex(index, type, list, true);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getSysLogMapping(String docType) {
        HashMap properties = new HashMap();

        Map levelMap = new HashMap();
        levelMap.put("type", "keyword");
        levelMap.put("store", "yes");
        properties.put("level", levelMap);

        Map barCodeMap = new HashMap();
        barCodeMap.put("type", "keyword");
        barCodeMap.put("store", "yes");
        properties.put("barCode", barCodeMap);

        Map pdLineIdMap = new HashMap();
        pdLineIdMap.put("type", "keyword");
        pdLineIdMap.put("store", "yes");
        properties.put("pdLineId", pdLineIdMap);

        Map pdLineNameMap = new HashMap();
        pdLineNameMap.put("type", "keyword");
        pdLineNameMap.put("store", "yes");
        properties.put("pdLineName", pdLineNameMap);

        Map pdIdMap = new HashMap();
        pdIdMap.put("type", "keyword");
        pdIdMap.put("store", "yes");
        properties.put("pdId", pdIdMap);

        Map pdNameMap = new HashMap();
        pdNameMap.put("type", "keyword");
        pdNameMap.put("store", "yes");
        properties.put("pdName", pdNameMap);

        Map processIdMap = new HashMap();
        processIdMap.put("type", "keyword");
        processIdMap.put("store", "yes");
        properties.put("processId", processIdMap);

        Map processNameMap = new HashMap();
        processNameMap.put("type", "keyword");
        processNameMap.put("store", "yes");
        properties.put("processName", processNameMap);

        Map workOrderIdMap = new HashMap();
        workOrderIdMap.put("type", "keyword");
        workOrderIdMap.put("store", "yes");
        properties.put("workOrderId", workOrderIdMap);

        Map workOrderNumMap = new HashMap();
        workOrderNumMap.put("type", "keyword");
        workOrderNumMap.put("store", "yes");
        properties.put("workOrderNum", workOrderNumMap);

        Map contentMap = new HashMap();
        contentMap.put("type", "keyword");
        contentMap.put("store", "yes");
        properties.put("content", contentMap);

        Map timeMap = new HashMap();
        timeMap.put("type", "keyword");
        timeMap.put("store", "yes");
        properties.put("time", timeMap);

        HashMap docTypeMap = new HashMap();
        docTypeMap.put("properties", properties);
        HashMap retMap = new HashMap();
        retMap.put(docType, docTypeMap);
        return JSON.toJSONString(retMap);
    }

    /**
     * 处理服务调用结果
     */
    public static void handleServiceInvocation() {
        try {
            String index = ConfigHelper.getValue("es.service.invocation.index");
            String type = ConfigHelper.getValue("es.service.invocation.type");
            client.getManager().close();
            if (!client.getManager().existIndex(index)) {
                client.getManager().createIndex(index, 1, 0);
            }
            if (!client.getManager().existMapping(index, type)) {
                client.getManager().createMapping(index, type, getServiceInvocationMapping(type));
            }
            new Thread() {
                public void run() {
                    try {
                        serviceInvocationConsumer.subscribe(Lists.newArrayList(ConfigHelper.getValue("log.service.invocation.topic")));
                        while (true) {
                            ConsumerRecords<String, String> records = serviceInvocationConsumer.poll(3000);
                            List<Map<String, Object>> list = Lists.newArrayList();
                            records.forEach(record -> {
                                list.add(JSON.parseObject(record.value(), new TypeReference<Map<String, Object>>() {
                                }));
                            });
                            client.bulkIndex(index, type, list, true);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getServiceInvocationMapping(String docType) {
        HashMap properties = new HashMap();
        HashMap codeMap = new HashMap();
//        codeMap.put("type", "string");
        codeMap.put("type", "keyword");
        codeMap.put("store", "yes");
//        codeMap.put("index", "not_analyzed");
        properties.put("code", codeMap);

        HashMap pathMap = new HashMap();
//        pathMap.put("type", "string");
        pathMap.put("type", "keyword");
        pathMap.put("store", "yes");
//        pathMap.put("index", "not_analyzed");
        properties.put("path", pathMap);

        HashMap startTimeMap = new HashMap();
//        startTimeMap.put("type", "string");
        startTimeMap.put("type", "keyword");
        startTimeMap.put("store", "yes");
//        startTimeMap.put("index", "not_analyzed");
        properties.put("startTime", startTimeMap);

        HashMap tookTimeMap = new HashMap();
        tookTimeMap.put("type", "keyword");
        tookTimeMap.put("store", "yes");
        properties.put("tookTime", tookTimeMap);

        HashMap resultTimeMap = new HashMap();
        resultTimeMap.put("type", "keyword");
        resultTimeMap.put("store", "yes");
        properties.put("result", resultTimeMap);

        HashMap statusMap = new HashMap();
        statusMap.put("type", "keyword");
        statusMap.put("store", "yes");
        properties.put("status", statusMap);

        HashMap paramsMap = new HashMap();
//        paramsMap.put("type", "string");
        paramsMap.put("type", "keyword");
        paramsMap.put("store", "yes");
//        paramsMap.put("index", "not_analyzed");
        properties.put("params", paramsMap);

//        HashMap delflag = new HashMap();
//        delflag.put("type", "boolean");
//        delflag.put("store", "yes");
//        delflag.put("index", "not_analyzed");
//        properties.put("delflag", delflag);

        HashMap docTypeMap = new HashMap();
        docTypeMap.put("properties", properties);
        HashMap retMap = new HashMap();
        retMap.put(docType, docTypeMap);
        return JSON.toJSONString(retMap);
    }

    /**
     * 查询指定时间段内、指定调用状态的服务调用次数
     *
     * @param serviceCode 服务编码
     * @param start       时间段开始
     * @param end         时间段结束
     * @param status      调用状态
     * @return
     */
    public static long queryServiceInvocationStat(String serviceCode, Date start, Date end, String status) {
        String index = ConfigHelper.getValue("es.service.invocation.index");
        String type = ConfigHelper.getValue("es.service.invocation.type");
        BoolQueryBuilder qb = QueryBuilders.boolQuery();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        qb.must(QueryBuilders.termQuery("code", serviceCode)).must(QueryBuilders.rangeQuery("startTime").gte(sdf.format(start)).lt(sdf.format(end))).must(QueryBuilders.termQuery("status", status));
        try {
            Map<String, Aggregation> agg = client.aggregate(index, type, qb, AggregationBuilders.count("count").field("code"));
            InternalValueCount count = (InternalValueCount) agg.get("count");
            return count.getValue();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}
