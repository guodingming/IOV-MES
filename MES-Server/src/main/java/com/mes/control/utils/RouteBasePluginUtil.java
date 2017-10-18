package com.mes.control.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * 工艺路径基础插件配置工具类
 * <p>
 * Created by xiuyou.xu on 2017/8/21.
 */
public class RouteBasePluginUtil {
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "nodes")
    public static class BasePluginNodes {
        @XmlElement(name = "node")
        private List<BasePluginNode> nodes;

        public List<BasePluginNode> getNodes() {
            return nodes;
        }

        public void setNodes(List<BasePluginNode> nodes) {
            this.nodes = nodes;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "node")
    public static class BasePluginNode {
        @XmlAttribute(name = "show")
        private boolean show = true;
        @XmlAttribute(name = "id")
        private String id;
        @XmlAttribute(name = "name")
        private String name;
        @XmlAttribute(name = "icon")
        private String icon;

        public boolean isShow() {
            return show;
        }

        public void setShow(boolean show) {
            this.show = show;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }

    /**
     * 从xml文件中读取工艺路径基础插件列表
     *
     * @return
     */
    public static BasePluginNodes getBasePluginNodes() {
        try {
            JAXBContext context = JAXBContext.newInstance(BasePluginNodes.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            BasePluginNodes nodes = (BasePluginNodes) unmarshaller.unmarshal(RouteBasePluginUtil.class.getClassLoader().getResourceAsStream("configs/route-base-plugins.xml"));
            return nodes;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
