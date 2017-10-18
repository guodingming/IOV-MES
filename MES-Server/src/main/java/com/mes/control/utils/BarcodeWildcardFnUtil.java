package com.mes.control.utils;

import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.spring.ServiceBeanContext;
import com.mes.common.utils.FileUtils;
import com.mes.dubbo.interprovider.control.IDpFunctionProvider;
import com.mes.dubbo.interprovider.control.IDpFunctionTypeProvider;
import com.mes.dubbo.interprovider.control.IPdBarcodeWildcardProvider;
import com.mes.entity.control.DpFunction;
import com.mes.entity.control.DpFunctionType;
import com.mes.entity.control.PdBarcodeWildcard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * 条码通配符替换脚本配置工具
 * Created by xiuyou.xu on 2017/10/12.
 */
public class BarcodeWildcardFnUtil {
    private static Logger logger = LoggerFactory.getLogger(BarcodeWildcardFnUtil.class);

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "wildcards")
    public static class Wildcards {
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
            JAXBContext context = JAXBContext.newInstance(Wildcards.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            Wildcards wildcards = (Wildcards) unmarshaller.unmarshal(ComInterfacesUtil.class.getClassLoader().getResourceAsStream("configs/barcode-wildcards.xml"));
            // 如果未导入则执行导入
            if (wildcards != null && !wildcards.isPersisted()) {
                logger.debug("开始导入条码通配符替换函数：configs/barcode-wildcards.xml");

                IDpFunctionProvider dpFunctionProvider = (IDpFunctionProvider) ServiceBeanContext.getInstance().getBean("dpFunctionProvider");
                IDpFunctionTypeProvider dpFunctionTypeProvider = (IDpFunctionTypeProvider) ServiceBeanContext.getInstance().getBean("dpFunctionTypeProvider");
                String name = "条码通配符替换函数";
                Map<String, Object> params = Maps.newHashMap();
                params.put("name", name);
                List<DpFunctionType> dpFunctionTypes = dpFunctionTypeProvider.findByMap(params);
                if (dpFunctionTypes != null || !dpFunctionTypes.isEmpty()) {
                    dpFunctionTypes.forEach(dpFunctionType -> {
                        String id = dpFunctionType.getId();
                        try {
                            params.clear();
                            params.put("functionTypeId", id);
                            List<DpFunction> dpFunctions = dpFunctionProvider.findByMap(params);
                            if (dpFunctions != null && !dpFunctions.isEmpty()) {
                                dpFunctions.forEach(dpFunction -> {
                                    try {
                                        dpFunctionProvider.deleteById(dpFunction.getId());
                                    } catch (DubboProviderException e) {
                                        e.printStackTrace();
                                    }
                                });
                            }
                            dpFunctionTypeProvider.deleteById(id);
                        } catch (DubboProviderException e) {
                            e.printStackTrace();
                        }
                    });
                }
                DpFunctionType dpFunctionType = new DpFunctionType();
                dpFunctionType.setType("1");
                dpFunctionType.setName(name);
                dpFunctionType.setParentId("0");
                dpFunctionTypeProvider.save(dpFunctionType);
                String fnTypeId = dpFunctionType.getId();
                IPdBarcodeWildcardProvider pdBarcodeWildcardProvider = (IPdBarcodeWildcardProvider) ServiceBeanContext.getInstance().getBean("pdBarcodeWildcardProvider");
                wildcards.getFns().forEach(fn -> {
                    DpFunction f = new DpFunction();
                    f.setName(fn.getName());
                    f.setFunctionTypeId(fnTypeId);
                    f.setDescription(fn.getDescription());
                    f.setType("1");
                    f.setScript(FileUtils.readToString(new File(BarcodeWildcardFnUtil.class.getClassLoader().getResource(fn.getScriptPath()).getFile())));

                    try {
                        dpFunctionProvider.save(f);

                        // 更新基础通配符对应的函数id
                        Map<String, Object> map = Maps.newHashMap();
                        map.put("wildcard", fn.getName());
                        List<PdBarcodeWildcard> pdBarcodeWildcards = pdBarcodeWildcardProvider.findByMap(map);
                        if (pdBarcodeWildcards != null && !pdBarcodeWildcards.isEmpty()) {
                            pdBarcodeWildcards.forEach(pdBarcodeWildcard -> {
                                PdBarcodeWildcard wildcard = new PdBarcodeWildcard();
                                wildcard.setId(pdBarcodeWildcard.getId());
                                wildcard.setFnId(f.getId());

                                try {
                                    pdBarcodeWildcardProvider.update(wildcard);
                                } catch (DubboProviderException e) {
                                    e.printStackTrace();
                                }
                            });
                        }
                    } catch (DubboProviderException e) {
                        e.printStackTrace();
                    }
                });

                // 写入xml文件，更新是否已persisted
                wildcards.setPersisted(true);
                try {
                    Marshaller marshaller = context.createMarshaller();
                    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                    File oldFile = new File(BarcodeWildcardFnUtil.class.getClassLoader().getResource("configs/barcode-wildcards.xml").getPath());
                    File newFile = new File(oldFile.getParent(), "barcode-wildcards-new.xml");
                    marshaller.marshal(wildcards, newFile);
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
