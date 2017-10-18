package com.mes.common.framework.mapper;

/**
 * Created by wanshan.hu on 2017/6/21.
 */

import com.google.common.collect.Lists;
import org.dozer.DozerBeanMapper;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类描述： bean map 转换类
 */
public class BeanMapper {

    private static DozerBeanMapper dozer = new DozerBeanMapper();

//    /**
//     * 方法描述：map 转 bean
//     *
//     * @param <T>
//     * @param map
//     * @param destinationClass
//     * @return
//     */
//    public static <T> T mapToBean(Map<String, ?> map, Class<T> destinationClass) {
//        return dozer.map(map, destinationClass);
//    }

    /**
     * 方法描述：bean 转map
     *
     * @param source
     * @return
     */
    public static Map<String, Object> beanToMap(Object source) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        dozer.map(source, map);
        return map;
    }

    public static List<Map<String,Object>> beanToMapList(List<Object> list) {
        List<Map<String,Object>> listMap = Lists.newArrayList();
        for (Object one:list){
            HashMap<String, Object> map = new HashMap<String, Object>();
            dozer.map(one, map);
            listMap.add(map);
        }
        return listMap;
    }

    public static <T> List<T> mapList(Collection sourceList, Class<T> destinationClass) {
        List<T> destinationList = Lists.newArrayList();
        for (Object sourceObject : sourceList) {
            T destinationObject = dozer.map(sourceObject, destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }

}