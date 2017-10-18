package com.tscloud.sdk.test.index;

import com.alibaba.fastjson.JSON;
import com.mes.es.cloudindex.CloudIndexClient;
import com.mes.es.cloudindex.CloudIndexClientConfig;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.common.geo.GeoDistance;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHitField;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * Created by Administrator on 2015/9/4.
 */
public class CloudIndexClientTest {
    private CloudIndexClient client;

    private static String index = "yl_index";
    private static String docType = "yl_index";

    @Before
    public void before() throws UnknownHostException {

        CloudIndexClientConfig config = new CloudIndexClientConfig();
        config.setClusterName( "truecloud_db_development" );
        config.setTransportSniff( true );
        //byte[] address = {(byte)192,(byte)168,10,61};
        //InetSocketTransportAddress host = new InetSocketTransportAddress( InetAddress.getByAddress(address), 9300 );
        InetSocketTransportAddress host = new InetSocketTransportAddress( InetAddress.getByName("172.192.100.52"), 9300 );
        List<InetSocketTransportAddress> list = new ArrayList<InetSocketTransportAddress>();
        list.add( host );
        config.setHosts( list );

        try {
            client = new CloudIndexClient( config );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSync() throws Exception {
        QueryBuilder qb = QueryBuilders.matchQuery("id", "23");
        Map<String,Object> map = new HashMap<String,Object>();
        map.put( "id", "23" );
        client.saveDoc(index, docType, map, true );
        for ( int i = 0 ; i < 1000 ; i ++ ){
            System.out.println( client.searchByQuery(index, docType, qb).size() );
        }
    }

    @Test
    public void testDelByQuery() throws Exception {
        QueryBuilder qb = QueryBuilders.regexpQuery( "path", "/yl_bf/newRename.*");
        client.deleteDocByQuery(index,docType,qb);
    }

    @Test
    public void testUpdateByQuery() throws Exception {
        //QueryBuilder qb = QueryBuilders.matchQuery( "delflag", "" );
        QueryBuilder qb = QueryBuilders.boolQuery().mustNot(QueryBuilders.existsQuery("delflag"));

//        FilterBuilder fb = FilterBuilders.missingFilter("delflag");
        //fb.
        List<Map<String,Object>> list = client.searchByFilter(index, docType, qb);
        List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
        for ( Map<String,Object> map : list ){
            Map<String,Object> m = new HashMap<String,Object>();
            m.put( CloudIndexClient.INDEX_ID, map.get( CloudIndexClient.INDEX_ID ) );
            m.put( "delflag", false );
            list2.add( m );
        }
        client.bulkUpdate( index, docType, list2 );
    }

    @Test
    public void testUpdate() throws Exception {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("path","/save_file.txt");
        client.updateDoc( "dl_nodir_smallfile","dl_sf_nodir","AVVS-dqma_vMo-1uisSa", map );
    }

    @Test
    public void updateMapping(){
        Map<String,String> map = new HashMap<String,String>();
        map.put("number_of_replicas","1");
        //map.put("number_of_shards","5");
        client.getManager().updateSetting(map,"tfs_small2");
    }

    @Test
    public void testCreateIndex(){
        try {
            Assert.assertTrue( client.getManager().createIndex( index, 2, 3 ) );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreateMapping(){
        try {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("name","string");
            map.put("sex","boolean");
            Assert.assertTrue( client.getManager().createMapping( index, docType, map ) );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void saveDoc() throws Exception {
      /*  final Map<String,Object> map = new HashMap<String,Object>();
        map.put("id","1");
        for ( int i = 0 ; i < 1000; i++ ){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        client.saveDoc( index, docType, "12345", map, false, VersionType.EXTERNAL, 1 );
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        Thread.sleep( 10000l );*/
        Map<String,Object> map = new HashMap<String,Object>();
        client.saveDoc("yl_dbindex","dd", map);
    }

    @Test
    public void testCreateDoc() throws Exception {
       /* Map<String,Object> map = new HashMap<String,Object>();
        map.put("id","1");
        for ( int i = 0 ; i < 100; i++ ) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        client.saveDoc( index, docType, "123",map );
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        System.in.read();*/
        /*Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","test2");
        map.put("sex",false);
        String flag = null;
        try {
            flag = client.saveDoc( index, docType, map );


            client.saveDoc( index, docType, map );
            Map<String,Object> map1 = new HashMap<String,Object>();
            map1.put("name","te3");
            map1.put("sex",true);
            client.saveDoc( index, docType, map1 );
            Map<String,Object> map2 = new HashMap<String,Object>();
            map2.put("name","tet");
            map2.put("sex",true);
            Map<String,Object> map3 = new HashMap<String,Object>();
            map3.put("name","test3");
            map3.put("sex",true);
            client.saveDoc( index, docType, map3 );

        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue( flag != null );*/
    }

    @Test
    public void testSearchFilter() throws Exception {
//        FilterBuilder fb = FilterBuilders.termFilter( "name", "test3/test3" );
        QueryBuilder fb = QueryBuilders.termQuery("name", "test3/test3");
        List<Map<String,Object>> list = client.searchByFilter( index, docType, fb );
        System.out.println(JSON.toJSONString( list ) );
    }

    @Test
    public void testSearchQuery() throws Exception {
        QueryBuilder qb = QueryBuilders.regexpQuery( "path", "/yl_bf_dir.*" );
        //client.deleteDocByQuery(index,docType,qb);
        System.out.println(JSON.toJSONString( client.searchByQuery( index, docType, qb ) ) );
    }

    @Test
    public void rmIndex(){
        try {
            client.getManager().deleteIndex("tfs_small2");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void rmMapping(){
        try {
            //Map<String, Object> map = client.getManager().getMapping( "yl_smcon", "yl_smcon" );
            client.getManager().deleteMapping("yl_bf","bigfile2");
            //client.getManager().createMapping( "yl_smcon", "yl_smcon", JSON.toJSONString( map ) );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getMappings(){
        try{
            Map<String,String[]> indexs = client.getManager().getMappings( "fs" );
            System.out.println( JSON.toJSONString( indexs ) );
            System.out.println( JSON.toJSONString( client.getManager().getMapping("dltest","instu") ) );
        } catch ( Exception e ){
            e.printStackTrace();
        }
    }

    @Test
    public void query() throws Exception {
        QueryBuilder qb = QueryBuilders.regexpQuery( "path", "/gisdata/v1/18_217135_145514.png" );
        //FilterBuilder fb = geoDistanceFilter(1.0,1.0,1.0);
        List<Map<String, Object>> list = client.searchByQuery( index, docType, qb, null );
        //List<Map<String, Object>> list = client.searchByFilter( index, docType, fb );
        System.out.println(JSON.toJSONString(list));
    }

    protected static QueryBuilder geoDistanceFilter(Double x,Double y,Double distance) {

        QueryBuilder filter = QueryBuilders.geoDistanceQuery("name")
                .point(40, -70)
                .distance(200, DistanceUnit.KILOMETERS)
                .optimizeBbox("memory")
                .geoDistance(GeoDistance.ARC);
        return filter;
        /*return FilterBuilders.geoDistanceFilter("the_geom")
                .point(x, y)
                .distance(distance, DistanceUnit.KILOMETERS)
                .optimizeBbox("memory")                   // Can be also "indexed" or "none"
                .geoDistance(GeoDistance.ARC);            // Or GeoDistance.PLANE*/
    }

    @Test
    public void test123(){
        SearchRequestBuilder searchRequestBuilder =client.getClient().prepareSearch( index ).setTypes( docType );
        QueryBuilder distanceFilter=this.geoDistanceFilter(1.0,1.0,1.0);
        searchRequestBuilder.setPostFilter(distanceFilter);
        SearchResponse sResponse=  searchRequestBuilder.setExplain(true).setFrom(0).setSize( 10 )
                .execute()
                .actionGet();
    }

    @Test
    public void testReg() throws Exception {
        BoolQueryBuilder qb = QueryBuilders.boolQuery();
//        qb.must( QueryBuilders.termQuery( CloudFile.DELFLAG, false ) );
//        qb.must( QueryBuilders.regexpQuery( CloudFile.PATH, "/dp/sourcedata/005221-201504220155060370-201504220333090360/image/1/([^/]+)" ) );
        //RegexpQueryBuilder qb = QueryBuilders.regexpQuery(CloudFile.PATH, "/dp/sourcedata/005221-201504220155060370-201504220333090360/image/6.+");
        List<Map<String, Object>> list = client.searchByQuery( index, docType, qb );
        System.out.println( list.size() );
        /*System.out.println( client.countByQuery(index, docType, qb) );*/
       /* list = client.searchByQuery(index, docType, QueryBuilders.regexpQuery("path", "/test/dp/([^/]+)/.+") );
        System.out.println( list.size() );
        list = client.searchByQuery(index, docType, QueryBuilders.regexpQuery("path", "/test/dp/([^/]+)/.+") );
        System.out.println( list.size() );
        list = client.searchByQuery(index, docType, QueryBuilders.regexpQuery("path", "/test/dp/([^/]+)/.+") );
        System.out.println( list.size() );*/
    }

    @Test
    public void testImport() throws Exception {
        client.importData("fs","bigfile","D:/fs_bigfile.json");
    }



    @Test
    public void testRM() throws Exception {
        client.deleteDocByQuery( "yl_bf_dir",
                                 "yl_bf_dir",
                                 QueryBuilders.regexpQuery( "path", "/yl_bf_dir/st.*" ) );
    }

    @Test
    public void testR(){
        for ( int i = 0; i < 10 ; i++ ){
            test();
        }
    }

    private void test(){
        Pattern pattern = Pattern.compile( "/test/dp/([^/]+)/.*" );
        List list = new ArrayList();

        SearchResponse scrollResp = (SearchResponse)this.client.getClient().prepareSearch(index).setSearchType(SearchType.DEFAULT)
                .setScroll(new TimeValue(600000L))
                .setQuery(QueryBuilders.regexpQuery("path", "/test/dp/([^/]+)/.*"))
                .setSize(1000).execute().actionGet();
        boolean flag = true;
        while (flag) {
            scrollResp = (SearchResponse) this.client.getClient().prepareSearchScroll(scrollResp.getScrollId())
                    .setScroll(new TimeValue(600000L))
                    .execute().actionGet();
            SearchHit[] searchHits = scrollResp.getHits().hits();
            long len = searchHits.length;
            if (len == 0L) {
                flag = false;
            }
            for (SearchHit sh : searchHits) {
                String value = (String) ((SearchHitField) sh.getFields().get("path")).getValue();
                if (value != null) {
                    Matcher m = pattern.matcher(value);
                    if (m.find()) {
                        String p = m.group(1);
                        if (!list.contains(p)) {
                            list.add(p);
                        }
                    }
                }
            }
        }
        System.out.println( list.size() );
    }
}
