package com.mes.es.cloudindex;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.search.SearchHit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 用来获取大批量数据的时候采用游标的方式来获取，使用next()来获取当前的数据，如果没有下个节点则返回为null
 *
 * Created by Administrator on 2016/2/23.
 */
public class ScrollResult {

    private Client elasticSearchClient;
    private SearchResponse scrollResp;
    private long timeout;

    public ScrollResult(Client elasticSearchClient, SearchResponse scrollResp, long timeout) {
        this.elasticSearchClient = elasticSearchClient;
        this.scrollResp = scrollResp;
        this.timeout = timeout;
    }

    /**
     * 取出下个结果集合
     * @return  查询的结果集合
     */
    public List<Map<String,Object>> next(){
        scrollResp = elasticSearchClient.prepareSearchScroll(scrollResp.getScrollId())
                .setScroll( new TimeValue( timeout ) ).execute().actionGet();
        SearchHit[] searchHits = scrollResp.getHits().hits();
        if ( searchHits.length > 0 ){
            List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
            for ( SearchHit sh : searchHits ){
                Map<String,Object> map = sh.getSource();
                map.put( CloudIndexClient.INDEX_ID, sh.getId() );
                list.add( map );
            }
            return list;
        }
        return null;
    }

}
