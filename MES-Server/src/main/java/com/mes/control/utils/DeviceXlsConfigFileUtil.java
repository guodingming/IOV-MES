package com.mes.control.utils;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.spring.ServiceBeanContext;
import com.mes.common.utils.FileUtils;
import com.mes.dubbo.interprovider.control.IDpFunctionProvider;
import com.mes.dubbo.interprovider.control.IDpFunctionTypeProvider;
import com.mes.entity.control.DpFunction;
import com.mes.entity.control.DpFunctionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.util.List;

/**
 * 设备配置xls文件转换为xml内容工具类
 * Created by xiuyou.xu on 2017/10/12.
 */
public class DeviceXlsConfigFileUtil {
    private static Logger logger = LoggerFactory.getLogger(DeviceXlsConfigFileUtil.class);

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "fns")
    public static class Fns {
        @XmlAttribute(name = "fn-type-id")
        private String fnTypeId;
        @XmlAttribute(name = "persisted")
        private boolean persisted;
        @XmlElement(name = "fn")
        private List<Fn> fns;

        public String getFnTypeId() {
            return fnTypeId;
        }

        public void setFnTypeId(String fnTypeId) {
            this.fnTypeId = fnTypeId;
        }

        public boolean isPersisted() {
            return persisted;
        }

        public void setPersisted(boolean persisted) {
            this.persisted = persisted;
        }

        public List<Fn> getFns() {
            return fns;
        }

        public void setFns(List<Fn> fns) {
            this.fns = fns;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "fn")
    public static class Fn {
        @XmlAttribute(name = "name")
        private String name;
        @XmlAttribute(name = "script-path")
        private String scriptPath;
        @XmlAttribute(name = "description")
        private String description;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getScriptPath() {
            return scriptPath;
        }

        public void setScriptPath(String scriptPath) {
            this.scriptPath = scriptPath;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    public static void persist() {
        try {
            JAXBContext context = JAXBContext.newInstance(Fns.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            Fns fns = (Fns) unmarshaller.unmarshal(ComInterfacesUtil.class.getClassLoader().getResourceAsStream("configs/device-config-xls-files.xml"));
            // 如果未导入则执行导入
            if (fns != null && !fns.isPersisted()) {
                logger.debug("开始导入设备配置xls文件转换为xml内容函数：configs/device-config-xls-files.xml");

                IDpFunctionTypeProvider dpFunctionTypeProvider = (IDpFunctionTypeProvider) ServiceBeanContext.getInstance().getBean("dpFunctionTypeProvider");
                DpFunctionType dpFunctionType = new DpFunctionType();
                dpFunctionType.setType("1");
                dpFunctionType.setName("设备配置xls文件转换xml函数");
                dpFunctionType.setParentId("0");
                dpFunctionTypeProvider.save(dpFunctionType);
                String fnTypeId = dpFunctionType.getId();

                IDpFunctionProvider dpFunctionProvider = (IDpFunctionProvider) ServiceBeanContext.getInstance().getBean("dpFunctionProvider");
                fns.getFns().forEach(fn -> {
                    DpFunction f = new DpFunction();
                    f.setName(fn.getName());
                    f.setFunctionTypeId(fnTypeId);
                    f.setDescription(fn.getDescription());
                    f.setType("1");
                    f.setScript(FileUtils.readToString(new File(DeviceXlsConfigFileUtil.class.getClassLoader().getResource(fn.getScriptPath()).getFile())));

                    try {
                        dpFunctionProvider.save(f);
                    } catch (DubboProviderException e) {
                        e.printStackTrace();
                    }
                });

                // 写入xml文件，更新是否已persisted
                fns.setPersisted(true);
                try {
                    Marshaller marshaller = context.createMarshaller();
                    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                    File oldFile = new File(DeviceXlsConfigFileUtil.class.getClassLoader().getResource("configs/device-config-xls-files.xml").getPath());
                    File newFile = new File(oldFile.getParent(), "device-config-xls-files-new.xml");
                    marshaller.marshal(fns, newFile);
                    if (oldFile.delete()) {
                        newFile.renameTo(oldFile);
                    }
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (DubboProviderException e) {
            e.printStackTrace();
        }
    }
}
