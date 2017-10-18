package com.mes.control.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * 芯片操作字典工具类
 * <p>
 * Created by xiuyou.xu on 2017/8/21.
 */
public class ChipOpDictionaryUtil {
    private static Logger logger = LoggerFactory.getLogger(ChipOpDictionaryUtil.class);

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

            Dic dic = (Dic) unmarshaller.unmarshal(ChipOpDictionaryUtil.class.getClassLoader().getResourceAsStream("configs/chip-op-dic.xml"));
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
}
