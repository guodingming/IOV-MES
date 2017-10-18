package com.mes.restful.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.framework.rest.view.Page;
import com.mes.common.utils.StringUtils;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IUserProvider;
import com.mes.entity.control.*;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 用户管理
 * Created by xiuyou.xu on 2017/7/4.
 */
@Api(value = "系统管理-用户管理", description = "系统管理-用户管理"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "user", description = "用户管理")})}*/)
@Path(RestConstants.RestPathPrefix.USER)
public class UserRestServer extends BaseRestServerInterfaceImpl<User> {

    @Override
    public IUserProvider getDubboBaseInterface() {
        return ControlConsumer.getUserProvider();
    }

    /**
     * 用户登录
     *
     * @param userLogin
     * @return
     */
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "用户登录", notes = "用户登录", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject login(UserLogin userLogin) {
        try {
            Map<String, Object> ret = this.getDubboBaseInterface().login(userLogin);
            if (ret != null) {
                request.getSession().setAttribute("user", ret);
                request.getSession().setAttribute("userInfo", userLogin);
                this.addOperationLog("用户登录成功", "", true);
                jsonView.successPack(ret, "用户登录成功!");
            } else {
                this.addOperationLog("用户名或密码错误", "", true);
                jsonView.failPack("用户名或密码错误!");
            }
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("用户登录失败", "", false);
            log.error("UserRestServer login is error", e);
        }
        return jsonView;
    }

    @GET
    @Path("/logout")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "用户登出", notes = "用户登出", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject logout() {
        try {
            Object ret = request.getSession().getAttribute("user");
            Object userInfo = request.getSession().getAttribute("userInfo");
            if (ret != null) {
                request.getSession().removeAttribute("user");
                request.getSession().invalidate();
            }
            if (userInfo != null) {
                request.getSession().removeAttribute("userInfo");
                request.getSession().invalidate();
            }
            this.addOperationLog("用户登出成功", "", true);
            jsonView.successPack(true, "用户登出成功!");
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("用户Session验证失败", "", false);
            log.error("UserRestServer login is error", e);
        }
        return jsonView;
    }

    /**
     * 用户信息校验
     *
     * @return
     */
    @GET
    @Path("/validate")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "用户Session验证", notes = "用户Session验证", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public Response validate() {
        try {
            Object ret = request.getSession().getAttribute("userInfo");
            if (ret != null) {
                UserLogin userLogin = (UserLogin) ret;
                Map<String, Object> result= this.getDubboBaseInterface().validate(userLogin);
                if (result == null) {
                    jsonView.failPack("用户信息校验失败");
                    return Response.status(Response.Status.UNAUTHORIZED).entity(jsonView).build();
                } else {
                    this.addOperationLog("用户Session验证成功", "", true);
                    jsonView.successPack(result,"用户Session验证成功");
                }
            } else {
                jsonView.failPack("用户未登录");
                return Response.status(Response.Status.UNAUTHORIZED).entity(jsonView).build();
            }
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("用户Session验证失败", "", false);
            log.error("UserRestServer validate is error", e);
        }
        return Response.ok(jsonView).build();
    }

    /**
     * 根据部门分页查询用户列表
     *
     * @param page
     * @return
     */
    @POST
    @Path("/byPage/dept")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据部门分页查询用户列表", notes = "根据部门分页查询用户列表", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getPageByDeptId(Page page) {
        try {
            page = this.getDubboBaseInterface().getPageByDeptId(page);
            this.addOperationLog("根据部门分页查询用户列表", "", true);
            jsonView.successPack(page);
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("根据部门分页查询用户列表", "", false);
            log.error("UserRestServer getPageByDeptId is error", e);
        }
        return jsonView;
    }

    /**
     * 根据用户组分页查询用户列表
     *
     * @param page
     * @return
     */
    @POST
    @Path("/byPage/userGroup")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据用户组分页查询用户列表", notes = "根据用户组分页查询用户列表", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getPageByUserGroupId(Page page) {
        try {
            page = this.getDubboBaseInterface().getPageByUserGroupId(page);
            this.addOperationLog("根据用户组分页查询用户列表", "", true);
            jsonView.successPack(page);
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("根据用户组分页查询用户列表", "", false);
            log.error("UserRestServer getPageByUserGroupId is error", e);
        }
        return jsonView;
    }

    /**
     * 查询指定部门下不属于指定用户组的所有用户
     *
     * @param user
     * @return
     */
    @POST
    @Path("/getAssignableUsers")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "查询指定部门下不属于指定用户组的所有用户", notes = "查询指定部门下不属于指定用户组的所有用户", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getAssignableUsers(User user) {
        try {
            List<User> users = this.getDubboBaseInterface().getAssignableUsers(user);
            this.addOperationLog("查询指定部门下不属于指定用户组的所有用户", "", true);
            jsonView.successPack(users);
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("查询指定部门下不属于指定用户组的所有用户", "", false);
            log.error("UserRestServer getAssignableUsers is error", e);
        }
        return jsonView;
    }

    /**
     * 用户组批量添加用户
     *
     * @param userGroupAuth
     * @return
     */
    @POST
    @Path("saveGroupAuthBatch")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "用户组批量添加用户", notes = "用户组批量添加用户", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject saveGroupAuthBatch(@ApiParam(value = "用户组及其用户", required = true, defaultValue = "", example = "{\"groupId\":\"2\",\"userIds\":\"2,3,4\"}") UserGroupAuth userGroupAuth) {


        try {
            this.getDubboBaseInterface().saveGroupAuthBatch(userGroupAuth.getGroupId(), userGroupAuth.getUserIds());
            this.addOperationLog("新增用户", userGroupAuth.getGroupId() + "," + userGroupAuth.getUserIds(), true);
            jsonView.successPack("新增成功");
        } catch (DubboProviderException e) {
            jsonView.failPack(e);
            this.addOperationLog("新增用户", userGroupAuth.getGroupId() + "," + userGroupAuth.getUserIds(), false);
            log.error("UserRestServer saveGroupAuthBatch is error", e);
        }
        return jsonView;
    }

    /**
     * 批量删除指定用户组的用户
     *
     * @param groupId
     * @param userIds
     * @return
     */
    @GET
    @Path("deleteByGroupIdAndUserIds")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "批量删除指定用户组的用户", notes = "批量删除指定用户组的用户", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)

    public JsonViewObject deleteByGroupIdAndUserIds(@ApiParam(value = "用户组Id") @QueryParam("groupId") String groupId, @ApiParam(value = "用户Id，多个用“，”号隔开", example = "1,2,3") @QueryParam("userIds") String userIds) {
        boolean flag = false;
        if (StringUtils.isNotBlank(groupId) && StringUtils.isNotBlank(userIds)) {
            List list = new ArrayList();
            String[] uuserIds = userIds.split(",");
            for (int i = 0; i < uuserIds.length; i++) {
                list.add(uuserIds[i]);
            }
            try {
                this.getDubboBaseInterface().deleteByGroupIdAndUserIds(groupId, list);
                flag = true;
                this.addOperationLog("删除用户", groupId + "," + userIds, true);
                jsonView.successPack(flag);
            } catch (DubboProviderException e) {

                jsonView.failPack(e);
                this.addOperationLog("删除用户", groupId + "," + userIds, false);
                log.error("UserRestServer deleteByGroupIdAndUserIds is error", e);
            }

        }
        return jsonView;
    }
    @GET
    @Path("/updateDelete")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "取消用户注销", notes = "取消用户注销", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)

    public JsonViewObject updateDelete(@ApiParam(value = "用户Id，多个用“，”号隔开", example = "1,2,3") @QueryParam("ids") String ids,@ApiParam(value = "isDelete")@QueryParam("isDelete")String isDelete) {
        boolean flag = false;
        int count = 0;
        if (StringUtils.isNotBlank(ids) && StringUtils.isNotBlank(isDelete)) {
            String[] idArray = ids.split(",");
            for (String id : idArray) {
                try {
                    flag = this.getDubboBaseInterface().updateDelete(id,isDelete);
                } catch (DubboProviderException e) {
                    jsonView.failPack("false","用户数据取消注销失败  "+e.getMessage());
                    this.addOperationLog("用户数据取消注销失败","flag=" +flag,false);
                }
                if (!flag) {
                    continue;
                } else {
                    count++;
                }
            }
            if(count == idArray.length){
                jsonView.successPack("true", "用户数据全部更新成功!");
                this.addOperationLog("用户数据全部更新成功", "count=" + count, true);
            }else if(count !=0 && count<idArray.length){
                jsonView.successPack("true", "用户部分数据更新成功!");
                this.addOperationLog("用户部分数据更新成功", "count=" + count, true);
            }else {
                jsonView.failPack("false","用户数据取消注销失败");
                this.addOperationLog("用户数据取消注销失败","count=" +count,false);
            }

        }

        return jsonView;
    }

}
