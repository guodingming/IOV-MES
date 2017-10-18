package com.mes.restful.control.station;

import com.alibaba.fastjson.JSONObject;
import com.mes.common.framework.logcache.LogCache;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.utils.StringUtils;
import com.mes.entity.control.DpProduceProcess;
import com.mes.entity.control.PdWorkOrder;
import com.mes.entity.control.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * Created by hudaowan
 */
public abstract class StationBaseRestServer {
    protected Logger log = LoggerFactory.getLogger(getClass());
    protected JsonViewObject jsonView = new JsonViewObject();
    @Context
    protected HttpServletResponse response;
    @Context
    protected HttpServletRequest request;


    /**
     * 获取工作站request中的session
     * @return
     */
    protected Map<String, Object> getRequestSession() {
        Map<String, Object> session = null;
        Object o = request.getSession().getAttribute("station");
        if (null != o) {
            session = (Map<String, Object>) o;
        }
        return session;
    }

    /**
     * 获取session中的工单信息
     * @return
     */
    protected PdWorkOrder getSessionWorkOrder() {
        PdWorkOrder workOrder = null;
        Map<String, Object> session = this.getRequestSession();
        if (null != session) {
            workOrder = (PdWorkOrder) session.get("workOrder");
        }
        return workOrder;
    }

    /**
     * 获取session中的用户信息
     * @return
     */
    protected User getSessionUser() {
        User user = null;
        Map<String, Object> session = this.getRequestSession();
        if (null != session) {
            user = (User) session.get("userInfo");
        }
        return user;
    }

    /**
     * 获取session中的生产工序信息
     * @return
     */
    protected DpProduceProcess getSessionProduceProcess() {
        DpProduceProcess produceProcess = null;
        Map<String, Object> session = this.getRequestSession();
        if (null != session) {
            produceProcess = (DpProduceProcess) session.get("produceProcess");
        }
        return produceProcess;
    }

    /**
     * 添加系统操作日志
     */
    protected void addOperationLog(String operation, String paramJson, boolean status, String msg) {
        //从session取数据用户数据
//        String userName = (User)getRequest().getSession().getAttribute(Constants.user.COOKIE_USER);
        User user = this.getSessionUser();
        String userName = "admin";
        if (null != user) {
            userName = user.getName();
        }
        String name = "STATION";
        String sysName = "MES";
        String createDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        String jsonStr = "{'name':'" + name
                + "','status':'" + String.valueOf(status)
                + "','description':'" + operation + "===============" + msg
                + "','createDate':'" + createDate
                + "','operator':'" + (StringUtils.isBlank(userName) ? "admin" : userName)
                + "','param':'" + paramJson
                + "'}";
        LogCache cache = LogCache.init();
        //生成UUID
        UUID uid = UUID.randomUUID();
        String logKey = sysName + ".sysLog" + uid.toString();
        //写入缓存
        cache.putValue(logKey, jsonStr);
    }

    /**
     * 添加操作日志
     *
     * @param optCotent 操作内容
     * @param param     方法参数
     * @param status    结果状态
     */
    protected void addOperationLog(String optCotent, String param, boolean status) {
        User user = this.getSessionUser();
        String userName = "admin";
        if (null != user) {
            userName = user.getName();
        }
        String name = "STATION";
        String sysName = "MES";
        //构建参数JSON
        JSONObject data = new JSONObject();
        data.put("name", name);//模块名称
        data.put("description", optCotent);//操作内容
        data.put("status", status);//操作状态
        data.put("operator", StringUtils.isBlank(userName) ? "admin" : userName);//操作人
        data.put("createDate", new Date());
        data.put("param", param);
        LogCache cache = LogCache.init();
        UUID uid = UUID.randomUUID();
        String logKey = sysName + ".sysLog" + uid.toString();
        cache.putValue(logKey, data.toJSONString()); //写入缓存
    }
}
