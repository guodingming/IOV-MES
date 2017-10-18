package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.framework.rest.view.Page;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IUserOpLogProvider;
import com.mes.entity.control.UserOpLog;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by xiuyou.xu on 2017/8/2.
 */
@Api(value = "用户操作日志管理", description = "用户操作日志管理"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "dept", description = "用户操作日志管理")})}*/)
@Path(RestConstants.RestPathPrefix.USEROPLOG)
public class UserOpLogRestServer extends BaseRestServerInterfaceImpl<UserOpLog> {
    @Override
    public IUserOpLogProvider getDubboBaseInterface() {
        return ControlConsumer.getUserOpLogProvider();
    }

    /**
     * 分页查询用户操作日志
     *
     * @param page
     * @return
     */
    @POST
    @Path("query")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "分页查询用户操作日志", notes = "分页查询用户操作日志", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public JsonViewObject query(@ApiParam(value = "查询条件和分页参数", required = true, defaultValue = "", example = "{\"pageSize\": 10, \"pageNum\": 1}") Page page) {
        try {
            page = this.getDubboBaseInterface().query(page);
            this.addOperationLog("分页查询用户操作日志成功", "", true);
            jsonView.successPack(page, "分页查询用户操作日志成功!");
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("分页查询用户操作日志失败", "", false);
            log.error("UserOpLogRestServer query is error", e);
        }
        return jsonView;
    }
}
