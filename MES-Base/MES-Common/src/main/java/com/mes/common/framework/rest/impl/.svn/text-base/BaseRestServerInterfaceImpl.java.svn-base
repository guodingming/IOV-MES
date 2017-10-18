package com.mes.common.framework.rest.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.mes.common.framework.domain.BeanValidationGroups;
import com.mes.common.framework.domain.TrackableEntity;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.common.framework.logcache.LogCache;
import com.mes.common.framework.rest.BaseRestServerInterface;
import com.mes.common.framework.rest.MyValidator;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.framework.rest.view.Page;
import com.mes.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.lang.reflect.ParameterizedType;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by hudaowan
 */
public abstract class BaseRestServerInterfaceImpl<Entity extends TrackableEntity> implements BaseRestServerInterface<Entity> {
    protected Logger log = LoggerFactory.getLogger(getClass());
    protected JsonViewObject jsonView = new JsonViewObject();
    @Context
    protected HttpServletResponse response;
    @Context
    protected HttpServletRequest request;
    protected String modelName;
    protected String systemName;
    protected String userName;

    {
        getDubboBaseInterface();
    }


    /**
     * {
     * "content": "{"endRowNum":10,"objCondition":null,"pageNumber":1,"pageSize":10,"startRowNum":0,"total":2,"totalPageNum":1,
     * "rows":[
     * {"createDate":"2015-09-29 15:30:42","groupName":"test1","id":"C8879FFFB2064E66BB7A7D4ED052C9DE","userName":null,"webPort":"5052"},
     * {"createDate":"2015-09-29 14:51:46","groupName":"test2","id":"122830C1DC334517BC7BCE79F62D4FD5","userName":null,"webPort":"5052"}
     * ]}",
     * "message": "",
     * "status": "success"
     * }
     *
     * @param page
     * @return
     */
    @Override
    public JsonViewObject getPage(Page page) {
        JSON result;
        String jsonStr = JSON.toJSONString(page);
        try {
            Map<String, Object> mapBean = Maps.newHashMap();
            if (page != null) {
                if (page.getCondition() != null && Map.class.isInstance(page.getCondition())) {
                    mapBean = (Map) page.getCondition();
                }
//                Entity entity = null;
//                if (page.getCondition() != null) {
//                    String objCondition = page.getCondition().toString();
//                    if (StringUtils.isNotBlank(objCondition) && !"{}".equalsIgnoreCase(objCondition)) {
//                        entity = JSON.parseObject(objCondition, this.getEntityClass());
//                    }
//                }
//                mapBean = BeanObjectToMap.convertBean(entity);
            }
            page = this.getDubboBaseInterface().findByPage(page, mapBean);
            result = (JSON) JSON.toJSON(page);
            jsonView.successPack(result);
            this.addOperationLog("分页查询", jsonStr, true);
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("分页查询", jsonStr, false);
            log.error("BaseRestServerInterfaceImpl getPage is error,{jsonStr:" + jsonStr + "}", e);
        }
        return jsonView;
    }

    /**
     * {
     * "content": "[
     * {"createDate":"2015-09-29 15:30:42","id":"C8879FFFB2064E66BB7A7D4ED052C9DE","name":"test1","status":"0"},
     * {"createDate":"2015-09-29 14:51:46","id":"122830C1DC334517BC7BCE79F62D4FD5","name":"test2","status":"0"}
     * ]",
     * "message": "",
     * "status": "success"
     * }
     *
     * @return
     */
    @Override
    public JsonViewObject getAll() {
        JSON result;
        try {
            List<Entity> list = this.getDubboBaseInterface().findAll();
            result = (JSON) JSON.toJSON(list);
            this.addOperationLog("查询所有数据", "", true);
            jsonView.successPack(result);
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("查询所有数据", "", false);
            log.error("BaseRestServerInterfaceImpl getAll is error", e);
        }
        return jsonView;
    }

    /**
     * {
     * "content": "[
     * {"createDate":"2015-09-29 15:30:42","id":"C8879FFFB2064E66BB7A7D4ED052C9DE","name":"test1","status":"0"},
     * {"createDate":"2015-09-29 14:51:46","id":"122830C1DC334517BC7BCE79F62D4FD5","name":"test2","status":"0"}
     * ]",
     * "message": "",
     * "status": "success"
     * }
     *
     * @param params
     * @return
     */
    @Override
    public JsonViewObject getByWhere(Map<String, Object> params) {
        JSON result;
        String jsonStr = JSON.toJSONString(params);
        try {
            List<Entity> list = this.getDubboBaseInterface().findByMap(params);
            if (list != null) {
                result = (JSON) JSON.toJSON(list);
                this.addOperationLog("条件查询", jsonStr, true);
            } else {
                result = new JSONArray();
            }
            jsonView.successPack(result);
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("条件查询", jsonStr, false);
            log.error("BaseRestServerInterfaceImpl getByWhere is error，{jsonStr:" + jsonStr + "}", e);
        }
        return jsonView;
    }

    @Override
    public JsonViewObject countByCondition(Map<String, Object> params) {
        String jsonStr = JSON.toJSONString(params);
        try {
                int count = this.getDubboBaseInterface().countByCondition(params);
                this.addOperationLog("条件查询", jsonStr, true);
            jsonView.successPack(count);
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("条件查询", jsonStr, false);
            log.error("BaseRestServerInterfaceImpl countByCondition is error，{jsonStr:" + jsonStr + "}", e);
        }
        return jsonView;
    }

    /**
     * {
     * "content": "{"groupId":"D54FAB067D6F47A99136210ED640368E","id":"C8879FFFB2064E66BB7A7D4ED052C9DE","status":"0","webPort":"5052"}",
     * "message": "",
     * "status": "success"
     * }
     *
     * @param id
     * @return
     */
    @Override
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public JsonViewObject getById(@PathParam("id") String id) {
        JSON result;
        try {
            if (id != null) {
                Entity entity = this.getDubboBaseInterface().findById(id);
                if (entity != null) {
                    result = (JSON) JSON.toJSON(entity);
                    this.addOperationLog("条件查询", "id=" + id, true);
                } else {
                    result = new JSONObject();
                }
                jsonView.successPack(result);
            }
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("条件查询", "id=" + id, false);
            log.error("BaseRestServerInterfaceImpl getById is error,{id:" + id + "}", e);
        }
        return jsonView;
    }

    @Override
    public JsonViewObject deleteByIds(String ids) {
        boolean flag = true;
        int count = 0;
        try {
            if (!StringUtils.isBlank(ids)) {
                String[] idArray = ids.split(",");
                for (String id : idArray) {
                    flag = this.getDubboBaseInterface().deleteById(id);
                    if (!flag) {
                        continue;
                    } else {
                        count++;
                    }
                }
            }
            if (count > 0) {
                jsonView.successPack("true", "删除数据成功!");
                this.addOperationLog("删除数据", "ids=" + ids, false);
            } else {
                jsonView.successPack("false", "删除数据");
                this.addOperationLog("删除数据", "ids=" + ids, false);
            }
        } catch (Exception e) {
            jsonView.failPack("false", "删除数据失败!" + e.getMessage());
            this.addOperationLog("删除数据", "id=" + ids, false);
            log.error("BaseRestServerInterfaceImpl deleteByIds is error,{Id:" + ids + "}", e);
        }
        return jsonView;
    }

    @Override
    public JsonViewObject save(Entity entity) {
        Set<ConstraintViolation<Entity>> violations = MyValidator.validate(entity, BeanValidationGroups.CreateGroup.class);
        if (violations != null && !violations.isEmpty()) {
            String msg = MyValidator.buildConstraintViolationMessage(violations);
            jsonView.failPack(msg);
            log.error("failed to validate request entity while creating: class=" + entity.getCreateDate() + ", " + msg);
            return jsonView;
        }

        String result = "";
        String jsonStr = JSON.toJSONString(entity);
        try {
            if (entity != null) {
                result = this.getDubboBaseInterface().save(entity);
                if ("exists".equals(result)) {
                    jsonView.setMessage("exists");
                } else {
                    jsonView.successPack(result);
                    this.addOperationLog("保存数据", "jsonStr=" + jsonStr, true);
                }
            }
        } catch (Exception e) {
            jsonView.failPack("false", "保存数据失败！" + e.getMessage());
            this.addOperationLog("保存数据", "jsonStr=" + jsonStr, false);
            log.error("BaseRestServerInterfaceImpl save is error,{jsonStr:" + jsonStr + "}," + e.getMessage(), e);
        }
        return jsonView;
    }

    @Override
    public JsonViewObject update(Entity entity) {
        Set<ConstraintViolation<Entity>> violations = MyValidator.validate(entity, BeanValidationGroups.UpdateGroup.class);
        if (violations != null && !violations.isEmpty()) {
            String msg = MyValidator.buildConstraintViolationMessage(violations);
            jsonView.failPack(msg);
            log.error("failed to validate request entity while updating: class=" + entity.getCreateDate() + ", " + msg);
            return jsonView;
        }

        String result = "";
        String jsonStr = JSON.toJSONString(entity);
        try {
            if (entity != null) {
                result = String.valueOf(this.getDubboBaseInterface().update(entity));
                jsonView.successPack(result);
                this.addOperationLog("更新数据", "jsonStr=" + jsonStr, true);
            }
        } catch (Exception e) {
            jsonView.failPack("false", "更新数据失败！" + e.getMessage());
            this.addOperationLog("更新数据", "jsonStr=" + jsonStr, false);
            log.error("BaseRestServerInterfaceImpl update is error,{jsonStr:" + jsonStr + "}," + e.getMessage(), e);
        }
        return jsonView;
    }


    /**
     * 添加系统操作日志
     */
    protected void addOperationLog(String operation, String paramJson, boolean status, String msg) {
        //从session取数据用户数据
//        String userName = (User)getRequest().getSession().getAttribute(Constants.user.COOKIE_USER);
        String name = modelName;
        String sysName = systemName;
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
        //构建参数JSON
        JSONObject data = new JSONObject();
        data.put("name", this.modelName);//模块名称
        data.put("description", optCotent);//操作内容
        data.put("status", status);//操作状态
        data.put("operator", StringUtils.isBlank(userName) ? "admin" : userName);//操作人
        data.put("createDate", new Date());
        data.put("param", param);
        LogCache cache = LogCache.init();
        UUID uid = UUID.randomUUID();
        String logKey = systemName + ".sysLog" + uid.toString();
        cache.putValue(logKey, data.toJSONString()); //写入缓存
    }

    /**
     * 得到当前的对象class
     *
     * @return
     */
    public Class<Entity> getEntityClass() {
        return (Class<Entity>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * 抽象方法需要实现，  得到基础服务接口
     *
     * @return
     */
    public abstract DubboBaseInterface<Entity> getDubboBaseInterface();

}
