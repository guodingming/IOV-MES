package com.mes.control.utils;

import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.spring.ServiceBeanContext;
import com.mes.common.utils.FileUtils;
import com.mes.dubbo.interprovider.control.IDpFunctionProvider;
import com.mes.dubbo.interprovider.control.IDpFunctionTypeProvider;
import com.mes.dubbo.interprovider.control.IDpServiceProvider;
import com.mes.dubbo.interprovider.control.IDpServiceTypeProvider;
import com.mes.entity.control.DpFunction;
import com.mes.entity.control.DpFunctionType;
import com.mes.entity.control.DpService;
import com.mes.entity.control.DpServiceType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by xiuyou.xu on 2017/9/5.
 */
public class ComInterfacesUtil {
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "service-configs")
    public static class ServiceConfigs {
        @XmlAttribute(name = "persisted")
        private boolean persisted;
        @XmlElementWrapper(name = "services")
        @XmlElement(name = "service")
        private List<Service> services;
        @XmlElement(name = "source-types")
        private SourceTypes sourceTypes;

        public boolean isPersisted() {
            return persisted;
        }

        public void setPersisted(boolean persisted) {
            this.persisted = persisted;
        }

        public List<Service> getServices() {
            return services;
        }

        public void setServices(List<Service> services) {
            this.services = services;
        }

        public SourceTypes getSourceTypes() {
            return sourceTypes;
        }

        public void setSourceTypes(SourceTypes sourceTypes) {
            this.sourceTypes = sourceTypes;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "service")
    public static class Service {
        @XmlAttribute(name = "name")
        private String name;
        @XmlAttribute(name = "code")
        private String code;
        @XmlAttribute(name = "method-name")
        private String methodName;
        @XmlAttribute(name = "description")
        private String description;
        @XmlElement(name = "fn")
        private Fn fn;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMethodName() {
            return methodName;
        }

        public void setMethodName(String methodName) {
            this.methodName = methodName;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Fn getFn() {
            return fn;
        }

        public void setFn(Fn fn) {
            this.fn = fn;
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

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "source-types")
    public static class SourceTypes {
        @XmlElementWrapper(name = "fns")
        @XmlElement(name = "fn")
        private List<Fn> fns;
        @XmlElementWrapper(name = "types")
        @XmlElement(name = "type")
        private List<Type> types;

        public List<Fn> getFns() {
            return fns;
        }

        public void setFns(List<Fn> fns) {
            this.fns = fns;
        }

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
        @XmlAttribute(name = "handler")
        private String handler;
        @XmlAttribute(name = "handler-id")
        private String handlerId;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHandler() {
            return handler;
        }

        public void setHandler(String handler) {
            this.handler = handler;
        }

        public String getHandlerId() {
            return handlerId;
        }

        public void setHandlerId(String handlerId) {
            this.handlerId = handlerId;
        }
    }

    public static ServiceConfigs getServiceConfigs() {
        try {
            JAXBContext context = JAXBContext.newInstance(ServiceConfigs.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            ServiceConfigs serviceConfigs = (ServiceConfigs) unmarshaller.unmarshal(ComInterfacesUtil.class.getClassLoader().getResourceAsStream("configs/com-interfaces.xml"));
            return serviceConfigs;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void persist() {
        ServiceConfigs serviceConfigs = getServiceConfigs();
        if (serviceConfigs != null && !serviceConfigs.isPersisted()) {
            try {
                deleteLastInitData();
            } catch (DubboProviderException e) {
                e.printStackTrace();
            }
            List<Service> services = serviceConfigs.getServices();
            if (services != null && !services.isEmpty()) {
                IDpServiceTypeProvider dpServiceTypeProvider = (IDpServiceTypeProvider) ServiceBeanContext.getInstance().getBean("dpServiceTypeProvider");
                DpServiceType dpServiceType = new DpServiceType();
                dpServiceType.setName("COM组件调用接口");
                dpServiceType.setParentId("0");
                String serviceTypeId = null;
                try {
                    dpServiceTypeProvider.save(dpServiceType);
                    serviceTypeId = dpServiceType.getId();
                } catch (DubboProviderException e) {
                    e.printStackTrace();
                }
                final String typeId = serviceTypeId;

                IDpFunctionTypeProvider dpFunctionTypeProvider = (IDpFunctionTypeProvider) ServiceBeanContext.getInstance().getBean("dpFunctionTypeProvider");
                DpFunctionType dpFunctionType = new DpFunctionType();
                dpFunctionType.setName("COM组件调用接口");
                dpFunctionType.setParentId("0");
                dpFunctionType.setType("1");
                String functionTypeId = null;
                try {
                    dpFunctionTypeProvider.save(dpFunctionType);
                    functionTypeId = dpFunctionType.getId();
                } catch (DubboProviderException e) {
                    e.printStackTrace();
                }
                final String fnTypeId = functionTypeId;

                IDpFunctionProvider dpFunctionProvider = (IDpFunctionProvider) ServiceBeanContext.getInstance().getBean("dpFunctionProvider");
                IDpServiceProvider dpServiceProvider = (IDpServiceProvider) ServiceBeanContext.getInstance().getBean("dpServiceProvider");
                services.forEach(service -> {
                    Fn fn = service.getFn();
                    DpFunction f = new DpFunction();
                    f.setName(fn.getName());
                    f.setFunctionTypeId(fnTypeId);
                    f.setDescription(fn.getDescription());
                    f.setType("1");
                    f.setScript(readScript(fn.getScriptPath()));

                    try {
                        dpFunctionProvider.save(f);
                    } catch (DubboProviderException e) {
                        e.printStackTrace();
                    }

                    DpService s = new DpService();
                    s.setName(service.getName());
                    s.setCode(service.getCode());
                    s.setUrl("dpservice/invoke/" + service.getMethodName());
                    s.setDescription(service.getDescription());
                    s.setMethodName(service.getMethodName());
                    s.setMethod("POST");
                    s.setFnId(f.getId());
                    s.setServiceTypeId(typeId);
                    try {
                        dpServiceProvider.save(s);
                    } catch (DubboProviderException e) {
                        e.printStackTrace();
                    }
                });

                SourceTypes sourceTypes = serviceConfigs.getSourceTypes();
                if (sourceTypes != null) {
                    List<Fn> fns = sourceTypes.getFns();
                    List<Type> types = sourceTypes.getTypes();
                    Map<String, String> idMap = Maps.newHashMap();
                    if (fns != null && !fns.isEmpty()) {
                        fns.forEach(fn -> {
                            DpFunction f = new DpFunction();
                            f.setName(fn.getName());
                            f.setFunctionTypeId(fnTypeId);
                            f.setDescription(fn.getDescription());
                            f.setType("1");
                            f.setScript(readScript(fn.getScriptPath()));

                            try {
                                dpFunctionProvider.save(f);
                                idMap.put(fn.getName(), f.getId());
                            } catch (DubboProviderException e) {
                                e.printStackTrace();
                            }
                        });
                    }

                    if (types != null && !types.isEmpty()) {
                        types.forEach(type -> {
                            type.setHandlerId(idMap.get(type.getHandler()));
                        });
                    }
                }
            }


            // 写入xml文件，更新是否已persisted
            serviceConfigs.setPersisted(true);
            try {
                JAXBContext context = JAXBContext.newInstance(ServiceConfigs.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                File oldFile = new File(ComInterfacesUtil.class.getClassLoader().getResource("configs/com-interfaces.xml").getPath());
                File newFile = new File(oldFile.getParent(), "com-interfaces-new.xml");
                marshaller.marshal(serviceConfigs, newFile);
                if (oldFile.delete()) {
                    newFile.renameTo(oldFile);
                }
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 删除上次初始化数据
     *
     * @throws DubboProviderException
     */
    private static void deleteLastInitData() throws DubboProviderException {
        IDpServiceTypeProvider dpServiceTypeProvider = (IDpServiceTypeProvider) ServiceBeanContext.getInstance().getBean("dpServiceTypeProvider");
        IDpFunctionTypeProvider dpFunctionTypeProvider = (IDpFunctionTypeProvider) ServiceBeanContext.getInstance().getBean("dpFunctionTypeProvider");
        IDpFunctionProvider dpFunctionProvider = (IDpFunctionProvider) ServiceBeanContext.getInstance().getBean("dpFunctionProvider");
        IDpServiceProvider dpServiceProvider = (IDpServiceProvider) ServiceBeanContext.getInstance().getBean("dpServiceProvider");
        Map<String, Object> query = Maps.newHashMap();
        query.put("name", "COM组件调用接口");
        List<DpFunctionType> functionTypeList = dpFunctionTypeProvider.findByMap(query);
        List<DpServiceType> serviceTypeList = dpServiceTypeProvider.findByMap(query);
        query.clear();
        if (functionTypeList != null && !functionTypeList.isEmpty()) {
            for (DpFunctionType functionType : functionTypeList) {
                query.put("functionTypeId", functionType);
                List<DpFunction> functionList = dpFunctionProvider.findByMap(query);
                for (DpFunction function : functionList) {
                    dpFunctionProvider.deleteById(function.getId());
                }
                dpFunctionTypeProvider.deleteById(functionType.getId());
            }

        }
        query.clear();
        if(serviceTypeList != null && !serviceTypeList.isEmpty()) {
            for (DpServiceType dpServiceType : serviceTypeList) {
                query.put("serviceTypeId", dpServiceType.getId());
                List<DpService> serviceList = dpServiceProvider.findByMap(query);
                for (DpService dpService : serviceList) {
                    dpServiceProvider.deleteById(dpService.getId());
                }
                dpServiceTypeProvider.deleteById(dpServiceType.getId());
            }
        }
    }

    private static String readScript(String scriptPath) {
        return FileUtils.readToString(new File(ComInterfacesUtil.class.getClassLoader().getResource(scriptPath).getPath()));
    }

    public static void main(String[] args) {
//        ServiceConfigs configs = getServiceConfigs();
//        System.out.println(configs);
        System.out.println(readScript("configs/groovy/get-verify-code.groovy"));
    }
}
