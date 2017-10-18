package com.mes.control.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.spring.ServiceBeanContext;
import com.mes.common.utils.IDGenerator;
import com.mes.control.mapper.DpDataDictionaryMapper;
import com.mes.control.mapper.DpDataDictionaryTypeMapper;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.entity.control.DpDataDictionary;
import com.mes.entity.control.DpDataDictionaryType;

import javax.security.auth.login.Configuration;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 芯片操作字典工具类
 * <p>
 * Created by dengyun.le on 2017/09/29.
 */
public class InitDataDictionaryUtil {
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "dic")
    public static class Dic {
        @XmlElement(name = "type")
        private List<Type> types;

        public List<Type> getTypes() {
            return types;
        }

        public void setTypes(List<Type> types) {
            this.types = types;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "type")
    public static class Type {
        @XmlAttribute(name = "name")
        private String name;
        @XmlAttribute(name = "key")
        private String key;
        @XmlElement(name = "item")
        private List<Item> items;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Item> getItems() {
            return items;
        }

        public void setItems(List<Item> items) {
            this.items = items;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "item")
    public static class Item {
        @XmlAttribute(name = "name")
        private String name;
        @XmlAttribute(name = "key")
        private String key;
        @XmlAttribute(name = "value")
        private String value;
        @XmlAttribute(name = "sort")
        private String sort;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }
    }

    /**
     * 从xml文件中读取工艺路径基础插件列表
     *
     * @return
     */
    public static Dic getChipOpDic() {
        try {
            JAXBContext context = JAXBContext.newInstance(Dic.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            Dic dic = (Dic) unmarshaller.unmarshal(InitDataDictionaryUtil.class.getClassLoader().getResourceAsStream("configs/init-data-dic.xml"));
            return dic;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 构造字典项中文名和key之间的反向映射关系
     *
     * @return
     */
    public static Map<String, Map<String, String>> reverseIndex() {
        Map<String, Map<String, String>> map = Maps.newHashMap();
        Dic dic = getChipOpDic();
        if (dic != null) {
            List<Type> types = dic.getTypes();
            if (types != null && !types.isEmpty()) {
                types.forEach(type -> {
                    Map<String, String> t = Maps.newHashMap();
                    map.put(type.getName(), t);
                    List<Item> items = type.getItems();
                    if (items != null && !items.isEmpty()) {
                        items.forEach(item -> {
                            t.put(item.getName(), item.getValue());
                        });
                    }
                });
            }
        }
        return map;
    }

    /**
     * 构造字典项key和中文名之间的正向映射关系
     *
     * @return
     */
    public static Map<String, Map<String, String>> index() {
        Map<String, Map<String, String>> map = Maps.newHashMap();
        Dic dic = getChipOpDic();
        if (dic != null) {
            List<Type> types = dic.getTypes();
            if (types != null && !types.isEmpty()) {
                types.forEach(type -> {
                    Map<String, String> t = Maps.newHashMap();
                    map.put(type.getName(), t);
                    List<Item> items = type.getItems();
                    if (items != null && !items.isEmpty()) {
                        items.forEach(item -> {
                            t.put(item.getValue(), item.getName());
                        });
                    }
                });
            }
        }
        return map;
    }

    /**
     * 获取字典数据
     *
     * @return
     */
    public static Map<String, List<Map<String, Object>>> getData() {
        Map<String, List<Map<String, Object>>> map = Maps.newHashMap();
        Dic dic = getChipOpDic();
        if (dic != null) {
            List<Type> types = dic.getTypes();
            if (types != null && !types.isEmpty()) {
                types.forEach(type -> {
                    List<Map<String, Object>> obj = Lists.newArrayList();
                    map.put(type.getName(), obj);
                    List<Item> items = type.getItems();
                    if (items != null && !items.isEmpty()) {
                        items.forEach(item -> {
                            Map<String, Object> t = Maps.newHashMap();
                            t.put("name", item.getName());
                            t.put("value", item.getValue());
                            obj.add(t);
                        });
                    }
                });
            }
        }
        return map;
    }

    public static void saveDiction() {
        String flag = null;
        flag = ConfigHelper.getValue("is_init_DictionData");
        if (flag.equals("y")) {
            Dic dic = InitDataDictionaryUtil.getChipOpDic();

            if (dic != null) {
                List<InitDataDictionaryUtil.Type> types = dic.getTypes();
                if (types != null && !types.isEmpty()) {
                    DpDataDictionaryTypeMapper dpDataDictionaryTypeMapper = (DpDataDictionaryTypeMapper) ServiceBeanContext.getInstance().getBean("dpDataDictionaryTypeMapper");
                    DpDataDictionaryMapper dpDataDictionaryMapper = (DpDataDictionaryMapper) ServiceBeanContext.getInstance().getBean("dpDataDictionaryMapper");
                    types.forEach(type -> {
                        DpDataDictionaryType dpDataDictionaryType = new DpDataDictionaryType();
                        String name = type.getName();
                        String key = type.getKey();
                        Map map = new HashMap();
                        map.put("key", key);
                        String id = null;

                        List<DpDataDictionaryType> list = dpDataDictionaryTypeMapper.findByMap(map);
                        if (list.size() <= 0) {
                            id = IDGenerator.getID();
                            dpDataDictionaryType.setId(id);
                            dpDataDictionaryType.setName(name);
                            dpDataDictionaryType.setKey(key);
                            dpDataDictionaryType.setCreateDate(new Date());
                            try {
                                dpDataDictionaryTypeMapper.save(dpDataDictionaryType);

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }else {
                            id = list.get(0).getId();
                            if(!list.get(0).getName().equals(name)){
                               dpDataDictionaryType.setId(id);
                               dpDataDictionaryType.setName(name);
                               dpDataDictionaryTypeMapper.update(dpDataDictionaryType);
                            }
                            if(!list.get(0).getKey().equals(key)){
                                dpDataDictionaryType.setId(id);
                                dpDataDictionaryType.setKey(key);
                                dpDataDictionaryTypeMapper.update(dpDataDictionaryType);
                            }
                        }
                            List<InitDataDictionaryUtil.Item> items = type.getItems();
                            if (items != null && !items.isEmpty()) {
                                String finalId = id;
                                items.forEach(item -> {
                                    String CnName = item.getName();
                                    String key_k = item.getKey();
                                    String value = item.getValue();
                                    String Idd = null;
                                    Map map1 = new HashMap();
                                    map1.put("keyk", key_k);
                                    List<DpDataDictionary> list1 = dpDataDictionaryMapper.findByMap(map1);
                                    DpDataDictionary dpDataDictionary = new DpDataDictionary();
                                    if (list1.size() <= 0) {
                                        Idd = IDGenerator.getID();
                                        dpDataDictionary.setId(Idd);
                                        dpDataDictionary.setCnName(CnName);
                                        dpDataDictionary.setKeyk(key_k);
                                        dpDataDictionary.setValuev(value);
                                        dpDataDictionary.setSort(item.getSort());
                                        dpDataDictionary.setMesDpDataDictionaryTypeId(finalId);
                                        dpDataDictionary.setCreateDate(new Date());

                                        try {
                                            dpDataDictionaryMapper.save(dpDataDictionary);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }

                                    }else {
                                       Idd = list1.get(0).getId();
                                        if(!list1.get(0).getCnName().equals(CnName)){
                                            dpDataDictionary.setId(Idd);
                                            dpDataDictionary.setCnName(CnName);
                                            dpDataDictionaryMapper.update(dpDataDictionary);
                                        }
                                        if(!list1.get(0).getKeyk().equals(key_k)){
                                            dpDataDictionary.setId(Idd);
                                            dpDataDictionary.setKeyk(key_k);
                                            dpDataDictionaryMapper.update(dpDataDictionary);
                                        }
                                        if(!list1.get(0).getValuev().equals(value)){
                                            dpDataDictionary.setId(Idd);
                                            dpDataDictionary.setValuev(value);
                                            dpDataDictionaryMapper.update(dpDataDictionary);
                                        }

                                    }
                                });
                            }


                    });


                }

            }
        }

    }

}
