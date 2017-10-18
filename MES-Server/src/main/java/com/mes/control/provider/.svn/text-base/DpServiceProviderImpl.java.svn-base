package com.mes.control.provider;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.groovy.GroovyUtil;
import com.mes.common.function.FunctionConstants;
import com.mes.common.function.FunctionParameter;
import com.mes.control.mapper.DpFunctionMapper;
import com.mes.control.mapper.DpServiceMapper;
import com.mes.control.utils.Dictionaries;
import com.mes.control.workflow.FunctionRoute;
import com.mes.dubbo.interprovider.control.IDpServiceProvider;
import com.mes.entity.control.DpFunction;
import com.mes.entity.control.DpService;
import com.mes.entity.control.DpServiceInvocation;
import com.mes.entity.control.DpServiceRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import java.util.Map;

/**
 * 开发平台-服务管理
 */
public class DpServiceProviderImpl extends BaseProviderImpl<DpService> implements IDpServiceProvider {
    private static Logger logger = LoggerFactory.getLogger(DpServiceProviderImpl.class);

    @Autowired
    @Qualifier("dpServiceMapper")
    private DpServiceMapper dpServiceMapper;

    @Autowired
    @Qualifier("dpFunctionMapper")
    private DpFunctionMapper dpFunctionMapper;

//    @Autowired
//    @Qualifier("tableMapper")
//    private TableMapper tableMapper;

    @Override
    public DpServiceMapper getBaseInterfaceMapper() {
        return dpServiceMapper;
    }

    @Override
    public Object saveInvocation(DpServiceRequest request) throws DubboProviderException {
        try {
            String code = request.getCode();
            Map<String, Object> params = request.getParams();
            Map<String, Object> map = Maps.newHashMap();
            map.put("code", code);
            List<DpService> services = dpServiceMapper.findByMap(map);
            if (services != null && !services.isEmpty()) {
                DpService service = services.get(0);
                // sql type
//            if ("sql".equalsIgnoreCase(service.getType())) {
//                Iterator<String> keys = params.keySet().iterator();
                // 硬编码sql暂不支持传入参数
//                String sql = service.getSql();
//                Table table = tableMapper.findById(service.getTableId());
//                if ("select".equalsIgnoreCase(service.getSqlType())) {
//                    if (sql == null) {
//                        sql = ExpandTableUtil.getSelectSql(table.getName(), params);
//                    }
//                    return findToSql(sql);
//                } else if ("update".equalsIgnoreCase(service.getSqlType())) {
//                    if (sql == null) {
//                        sql = ExpandTableUtil.getUpdateSql(table.getName(), params);
//                    }
//                    try {
//                        updateToSql(sql);
//                        return true;
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    return false;
//                }
//            } else if ("script".equalsIgnoreCase(service.getType())) {
                DpFunction fn = dpFunctionMapper.findById(service.getFnId());
                if (Dictionaries.DpFunctionTypes.TYPE_GROOVY.equals(fn.getType())) {
                    FunctionParameter parameter = new FunctionParameter();
                    parameter.setRequestMap(params);
                    return GroovyUtil.evalScript(fn.getScript(), parameter);
                }
                if (Dictionaries.DpFunctionTypes.TYPE_JAVA.equals(fn.getType())) {
                    String clazz = fn.getClazz();
                    params.put(FunctionConstants.parameter.CLASS, clazz);
                    FunctionParameter parameter = new FunctionParameter();
                    parameter.setRequestMap(params);
                    try {
                        URL[] urls = new URL[1];
                        urls[0] = new File(ConfigHelper.getValue("shared.fs.dir") + fn.getFilePath()).toURI().toURL();
                        ClassLoader classLoader = new URLClassLoader(urls);
                        parameter = FunctionRoute.onReceive(parameter, classLoader);
                        return parameter.getResponseMap();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
//            }
            }
            return null;
        } catch (Exception e) {
            throw new DubboProviderException(e);
        }
    }

    @Override
    public void logInvocation(DpServiceInvocation invocation) throws DubboProviderException {
        logger.info(JSON.toJSONString(invocation));
    }

    @Override
    public String save(DpService dpService) throws DubboProviderException {
        dpService.setUrl("dpservice/invoke/" + dpService.getMethodName());
        dpService.setMethod("POST");
        dpService.setStatus("0");
        return super.save(dpService);
    }
}
