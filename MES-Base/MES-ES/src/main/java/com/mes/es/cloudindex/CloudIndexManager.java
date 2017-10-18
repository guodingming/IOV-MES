package com.mes.es.cloudindex;

import com.mes.es.exception.ExistIndexException;
import com.mes.es.exception.NotFoundIndexException;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.admin.indices.mapping.get.GetFieldMappingsResponse;
import org.elasticsearch.action.admin.indices.mapping.get.GetMappingsResponse;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingResponse;
import org.elasticsearch.action.admin.indices.settings.put.UpdateSettingsResponse;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.util.*;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 *
 * Created by Administrator on 2015/9/2.
 */
public class CloudIndexManager implements ICloudIndexManager {

    private static Logger log = LoggerFactory.getLogger( CloudIndexManager.class );

    private Client elasticSearchClient;

    public CloudIndexManager( Client elasticSearchClient ){
        this.elasticSearchClient = elasticSearchClient;
    }

    @Override
    public void setClient( Client elasticSearchClient ) throws Exception {
        this.elasticSearchClient = elasticSearchClient;
    }

    @Override
    public boolean createIndex(String index, int shardsNum, int replicasNum) throws Exception {
        if( !existIndex( index ) ){
            HashMap<String, Object> settings = new HashMap<String, Object>();
            settings.put( CloudIndexClientConfig.SETTING_NUMBER_OF_SHARDS, shardsNum);
            settings.put( CloudIndexClientConfig.SETTING_NUMBER_OF_RESPLICAS, replicasNum);
            this.elasticSearchClient.admin().indices().prepareCreate( index ).setSettings( settings ).execute().actionGet();
            return true;
        } else {
            throw new ExistIndexException("has existed index [" + index + "].");
        }
    }

    @Override
    public boolean createMapping(String indexName, String docType, Map<String, Object> mapping) throws Exception {
        if( !existIndex( indexName ) ){
            throw new NotFoundIndexException();
        }
        // only allow one mapping for one index
//        Map<String, String[]> mappings = getMappings(indexName);
//        if (mappings != null && mappings.size() == 1) {
//            throw new ExistMappingException("index [" + indexName + "] already has a type with name: " + docType);
//        }
        XContentBuilder mappingBuilder = jsonBuilder();
        mappingBuilder.startObject().startObject(docType).startObject("properties");

        Set<Map.Entry<String, Object>> set = mapping.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = set.iterator();
        while( iterator.hasNext() ){
            Map.Entry<String,Object> e = iterator.next();
            mappingBuilder.startObject( e.getKey() )
                              .field("type", e.getValue())
                              .field("store", "yes")
                          .endObject();
        }
        mappingBuilder.endObject().endObject().endObject();

        PutMappingResponse response = this.elasticSearchClient.admin().indices().preparePutMapping( indexName ).setType( docType )
                    .setSource(mappingBuilder).execute().actionGet();
        return true;
    }

    @Override
    public boolean existIndex( String index ){
        IndicesExistsResponse res = this.elasticSearchClient.admin().indices().prepareExists( index ).execute().actionGet();
        return res.isExists();
    }

    @Override
    public boolean createMapping(String indexName, String docType, String jsonMapping) throws Exception {
        if( !existIndex( indexName ) ){
            throw new NotFoundIndexException();
        }
        PutMappingResponse response = this.elasticSearchClient.admin().indices().preparePutMapping( indexName ).setType( docType )
                .setSource( jsonMapping ).execute().actionGet();
        return true;
    }

    @Override
    public boolean deleteIndex(String index) throws Exception {
        DeleteIndexResponse idr = this.elasticSearchClient.admin().indices().prepareDelete( index ).execute().actionGet();
        return true;
    }

    @Override
    public boolean deleteMapping(String index, String docType) throws Exception {
        // only delete documents, keep the type mapping
        SearchResponse response = elasticSearchClient.prepareSearch(index)
                .setTypes(docType)
                .setQuery(QueryBuilders.matchAllQuery())
                .setSize(10000)
                .execute().actionGet();

        SearchHit[] searchHits = response.getHits().getHits();

        while (searchHits.length > 0) {
            // Create bulk request
            final BulkRequestBuilder bulkRequest = elasticSearchClient.prepareBulk().setRefreshPolicy("true");
            // Add search results to bulk request
            for (final SearchHit searchHit : searchHits) {
                final DeleteRequest deleteRequest = new DeleteRequest(index, docType, searchHit.getId());
                bulkRequest.add(deleteRequest);
            }
            // Run bulk request
            final BulkResponse bulkResponse = bulkRequest.execute().actionGet();
            if (bulkResponse.hasFailures()) {
                return false;
            }

            // After deleting, we should check for more records
            response = elasticSearchClient.prepareSearch(index)
                    .setTypes(docType)
                    .setQuery(QueryBuilders.matchAllQuery())
                    .setSize(10000)
                    .execute().actionGet();

            searchHits = response.getHits().getHits();
        }

        elasticSearchClient.admin().indices().preparePutMapping().setIndices(index).setType(docType).setSource("{\n" +
                "  \"properties\": {\n" +
                "  }\n" +
                "}").get();
//        this.elasticSearchClient.admin().indices().prepareDelete(index).get();
        return true;
    }

    @Override
    public Map<String, Object> getMapping(String index, String docType) throws Exception {
        GetMappingsResponse res = this.elasticSearchClient.admin().indices().prepareGetMappings( index ).setTypes( docType ).execute().actionGet();
        return res.getMappings().get( index ).get( docType ).getSourceAsMap();
    }

    @Override
    public boolean existMapping(String index, String docType) throws Exception {
        GetMappingsResponse res = this.elasticSearchClient.admin().indices().prepareGetMappings( index ).setTypes( docType ).execute().actionGet();
        return res.getMappings().size() > 0;
    }

    @Override
    public String[] getIndexs() {
        GetMappingsResponse response = this.elasticSearchClient.admin().indices().prepareGetMappings().execute().actionGet();
        return response.getMappings().keys().toArray( String.class );
    }

    @Override
    public Map<String, String[]> getMappings(String... index) {
        Map<String, String[]> map = new HashMap<String,String[]>();
        GetMappingsResponse response = this.elasticSearchClient.admin().indices().prepareGetMappings( index ).execute().actionGet();
        String[] keys = response.getMappings().keys().toArray( String.class );
        for ( String key : keys ) {
            map.put( key, response.getMappings().get(key).keys().toArray(String.class) );
        }
        return map;
    }

    @Override
    public void close() {
        this.elasticSearchClient.close();
    }

    @Override
    public void updateSetting( Map<String, String> map, String index ) {
        Settings settings  = Settings.builder().put( map ).build();
        UpdateSettingsResponse updateSettingsResponse = elasticSearchClient.admin().indices()
                .prepareUpdateSettings( index ).setSettings(settings).execute().actionGet();

    }

    @Override
    public void closeClient( Client client ) {
        try {
            if(client!=null) {
                client.close();
            }
        } catch (ElasticsearchException e) {
            //ignore exception
        }
    }

    @Override
    public Map<String, Object> getFiledMapping( String index, String docType, String field ) throws Exception {
        GetFieldMappingsResponse res =  this.elasticSearchClient.admin().indices().prepareGetFieldMappings( index ).setTypes( docType ).execute().actionGet();
        return res.fieldMappings( index, docType, field ).sourceAsMap();
    }

    /**
     * 检查链接是否生效
     * @return
     * @throws Exception
     */
    public static boolean checkCon( String ips, String clusterName ) throws Exception {
        boolean flag = false;
        TransportClient client = null;
        try {
            Settings settings = Settings.builder().put("client.transport.sniff", true)
                    .put("cluster.name", clusterName)
                    .build();

            client = new PreBuiltTransportClient(settings);
            for (String ip : ips.split(",")) {
                String[] host = ip.split( ":" );
                client.addTransportAddress( new InetSocketTransportAddress( InetAddress.getByName(host[0]), Integer.parseInt( host[1] ) ) );
            }

            List immutableList = client.connectedNodes();
            if (immutableList.size() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            log.error("获取验证elasticsearch连接失败", e);
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            try {
                if(client!=null) {
                    client.close();
                }
            } catch (ElasticsearchException e) {
                //ignore exception
            }
        }
        return flag;
    }

}
