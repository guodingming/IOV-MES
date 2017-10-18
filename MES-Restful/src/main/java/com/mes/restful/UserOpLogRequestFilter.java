package com.mes.restful;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.entity.control.User;
import com.mes.entity.control.UserOpLog;
import io.swagger.jaxrs.Reader;
import io.swagger.jaxrs.config.DefaultJaxrsScanner;
import io.swagger.models.Swagger;
import io.swagger.util.Json;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xiuyou.xu on 2017/7/27.
 */
public class UserOpLogRequestFilter implements ContainerRequestFilter, ContainerResponseFilter {
    @Context
    private HttpServletRequest request;

    @Context
    private HttpServletResponse response;

    @Context
    private Application app;
    @Context
    private ServletConfig sc;

    /**
     * 保存日志任务执行线程池
     */
    private static ExecutorService pool = Executors.newFixedThreadPool(Integer.parseInt(ConfigHelper.getValue("user.op.log.threadpool.size")));

    /**
     * 不必登录即可访问的路径集合，可修改后通过配置文件进行配置
     */
    private static Set<String> paths = new HashSet<>();
    private static String contextPath = ConfigHelper.getJettyParameter("server.name");
    private static int pathPrefixLen = (contextPath + "/rest").length();

    static {
        paths.add(contextPath + "/rest/swagger.json");
        paths.add(contextPath + "/rest/user/login");//管理系统登录
        paths.add(contextPath + "/rest/user/stationLogin");//工作站登录
        paths.add(contextPath + "/rest/pdline/loginProcess");//工作站登录
        paths.add(contextPath + "/rest/pdline/loginPdInfo");//工作站登录页面获取信息
    }

    private Map<String, Map<String, Object>> pathSwaggerInfos = null;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        // 设置请求接入时间
        request.setAttribute("start", System.currentTimeMillis());
        String uri = request.getRequestURI();
        if (!paths.contains(uri)) {
            Object u = request.getSession().getAttribute("user");
            Object s = request.getSession().getAttribute("station");
//            if (u == null && s == null) {// 暂时放开未登录用户调用接口
//                JsonViewObject jsonView = new JsonViewObject();
//                jsonView.failPack("用户未登录");
//                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(jsonView).build());
//            }
        }
    }

    /**
     * 获取swagger.json内容，从中解析得到所有接口地址及其他相关信息
     */
    private void getPathSwaggerInfos() {
        Swagger swagger = new Swagger();
        DefaultJaxrsScanner scanner = new DefaultJaxrsScanner();
        Set<Class<?>> classes = scanner.classesFromContext(app, sc);
        new Reader(swagger).read(classes);
        try {
            String json = Json.mapper().writeValueAsString(swagger);
            Map<String, Object> map = JSON.parseObject(json, new TypeReference<Map<String, Object>>() {
            });
            pathSwaggerInfos = (Map<String, Map<String, Object>>) map.get("paths");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        Object startObj = request.getAttribute("start");
        if (startObj == null) {
            return;
        }
        long start = (Long) startObj;
        long time = System.currentTimeMillis() - start;

        String uri = request.getRequestURI();
        String method = request.getMethod().toLowerCase();
        if (!paths.contains(uri)) {
            if (pathSwaggerInfos == null) {
                getPathSwaggerInfos();
            }
            Map<String, Object> info = pathSwaggerInfos.get(uri.substring(pathPrefixLen));
            Object s = request.getSession().getAttribute("station");
            Object u = request.getSession().getAttribute("user");
            if (s != null || u != null) {
                Map<String, Object> ret = null;
                if (s != null) {
                    ret = (Map<String, Object>) s;
                }
                if (u != null) {
                    ret = (Map<String, Object>) u;
                }
                User user = (User) ret.get("userInfo");

//                System.out.println(request.getParameterMap());
                int status = response.getStatus();
                String res = "";
                // 只记录出错时的响应内容（对象深拷贝影响效率）
                if (status >= 300) {
                    res = JSON.toJSONString(responseContext.getEntity());
                }
                final String entity = res;
                // 异步提交日志到后台
                pool.submit(new Thread() {
                    public void run() {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                        Map<String, Object> methodMap = (Map<String, Object>) info.get(method);
                        UserOpLog userOpLog = new UserOpLog();
                        userOpLog.setUserId(user.getId());
                        userOpLog.setUserName(user.getName());
                        userOpLog.setPath(uri);
                        userOpLog.setDescription(methodMap.get("tags") + "-" + methodMap.get("description"));
                        userOpLog.setStartTime(sdf.format(new Date(start)));
                        userOpLog.setTookTime(time + "");
                        userOpLog.setStatus(status + "");
                        userOpLog.setResponse(entity);

                        try {
                            ControlConsumer.getUserOpLogProvider().save(userOpLog);
                        } catch (DubboProviderException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }
}
