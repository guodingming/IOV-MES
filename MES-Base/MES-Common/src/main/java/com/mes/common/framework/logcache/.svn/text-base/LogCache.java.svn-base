package com.mes.common.framework.logcache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.mes.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class LogCache {
    protected Logger log = LoggerFactory.getLogger(getClass());

    //工作流用到的缓存
    private static LoadingCache<String, String> logCache = null;
    private  static LogCache localCacheTool = null;

    private LogCache (){}

    public synchronized static LogCache init(){
        if(localCacheTool == null){
            localCacheTool = new LogCache();
        }
        if (logCache == null) {
            initLogCache();
        }
        return localCacheTool;
    }

    /**
     * 工作流程缓存初始化
     * @return
     */
    private static LoadingCache<String, String> initLogCache() {
        if (logCache == null) {
            logCache = CacheBuilder.newBuilder()
                    .concurrencyLevel(8)
                    .initialCapacity(10)
                    .maximumSize(100000)
                    .build(
                            new CacheLoader<String, String>() {
                                public String load(String key) throws Exception {
                                    String  str = new String();
                                    return str;
                                }
                            });
        }
        return logCache;
    }

    /**
     * 获取缓存数据
     * @param key
     * @return
     */
    public String getValue(String key) {
        String msg = null;
        try {
            msg = logCache.get(key);
        } catch (ExecutionException e) {
            log.error("获取缓存数据失败！",e);
        }
        return msg;
    }

    /***
     *向缓存中添加数据
     * @param key
     * @param message
     */
    public void  putValue(String key,String message){
        try {
            Object object = logCache.get(key);
            if(object == null){
                logCache.put(key,message);
            }else{
                logCache.invalidate(key);
                logCache.put(key,message);
            }
        } catch (ExecutionException e) {
            log.error("获取缓存数据失败！",e);
        }
    }

    /**
     * 将缓存中的时间移除
     * @param key
     */
    public void delValue(Object key){
        logCache.invalidate(key);
    }


    public static void main(String[] org){
        String jStr = "{\"objCondition\":{\"name\":\"\",\"type\":\"\",\"orgId\":\"1\"},\"pageNumber\":1,\"pageSize\":10}";
        jStr = jStr.replaceAll("\"","'");
        System.out.print(jStr);
    }

    /**
     * 获取指定条件的数据列表
     * @param pattern 条件，like 'DataGather.node.*'
     * @return List
     */
    public List<String> getList(String pattern) {
        List<String> list = new ArrayList<String>();
        if (StringUtils.isBlank(pattern)) {
            return list;
        }

        Map<String,String> keys = logCache.asMap();
        if (keys == null || keys.isEmpty()) {
            return list;
        }

        for (String key : keys.keySet()) {
            if (key.contains(pattern)) {
                list.add(getValue(key)+"|"+key);
            }
        }
        return list;
    }

}
