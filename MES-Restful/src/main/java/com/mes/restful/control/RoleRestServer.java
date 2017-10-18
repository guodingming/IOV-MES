package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.utils.StringUtils;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IRoleProvider;
import com.mes.entity.control.Menu;
import com.mes.entity.control.Role;
import com.mes.entity.control.RoleMenus;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * 角色管理
 * Created by xiuyou.xu on 2017/7/4.
 */
@Api(value = "系统管理-角色管理", description = "系统管理-角色管理"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "role", description = "角色管理")})}*/)
@Path(RestConstants.RestPathPrefix.ROLE)
public class RoleRestServer extends BaseRestServerInterfaceImpl<Role> {
    @Override
    public IRoleProvider getDubboBaseInterface() {
        return ControlConsumer.getRoleProvider();
    }

    @POST
    @Path("saveMenuAuth")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "新增角色菜单权限", notes = "新增角色菜单权限", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject saveMenuAuth(@ApiParam(value = "角色及其已授权菜单项", defaultValue = "", example = "{\"roleId\":\"1\", \"menuIds\":[\"1100\",\"1200\"]}") RoleMenus roleMenus) {
        try {
            this.getDubboBaseInterface().saveMenuAuth(roleMenus.getRoleId(), roleMenus.getMenuIds());
            this.addOperationLog("新增角色菜单权限", roleMenus.getRoleId() + "," + roleMenus.getMenuIds(), true);
            jsonView.successPack("新增成功");
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("新增角色菜单权限", roleMenus.getRoleId() + "," + roleMenus.getMenuIds(), false);
            log.error("RoleRestServer saveMenuAuth is error", e);
        }
        return jsonView;
    }

    @GET
    @Path("getMenuAuth/{roleId}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "查询角色菜单权限", notes = "查询角色菜单权限", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getMenuAuth(@ApiParam(value = "角色id", required = true, defaultValue = "", example = "\"1\"") @NotNull @PathParam("roleId") String roleId) {
        try {
            List<Menu> menus = this.getDubboBaseInterface().getMenuAuth(roleId);
            this.addOperationLog("查询角色菜单权限", roleId, true);
            jsonView.successPack(menus);
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("查询角色菜单权限", roleId, false);
            log.error("RoleRestServer getMenuAuth is error", e);
        }
        return jsonView;
    }

    /**
     * 部门删除添加验证是否有数据，是否允许删除
     * @param ids
     * @return
     * lednegyun--2017/10/14
     */
    @GET
    @Path("/deleting")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "根据多个id删除记录", notes = "根据多个id删除记录", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject deleteByIds(@ApiParam(value = "多个记录id，用逗号分隔", required = true, defaultValue = "", example = "1,2") @QueryParam("ids") String ids){
        boolean flag = true;
        boolean ff = false;
        int count = 0;
        try {
            if (!StringUtils.isBlank(ids)) {
                String[] idArray = ids.split(",");
                for (String id : idArray) {
                    //验证分类下是否有数据，是否可以删除
                    ff = this.getDubboBaseInterface().check(id);
                    if (ff) {
                        flag = this.getDubboBaseInterface().deleteById(id);
                        if (!flag) {
                            continue;
                        } else {
                            count++;
                        }
                    }else {
                        count =0;
                    }
                }
            }
            if (count > 0) {
                jsonView.successPack("true", "删除数据成功!");
                this.addOperationLog("删除数据", "ids=" + ids, false);
            } else {
                jsonView.failPack("false", "删除数据失败，该分类下有数据");
                this.addOperationLog("删除数据", "ids=" + ids, false);
            }
        } catch (Exception e) {
            jsonView.failPack("false", "删除数据失败!" + e.getMessage());
            this.addOperationLog("删除数据", "id=" + ids, false);
            log.error("DpDataDictionaryTypeRestServer deleteByIds is error,{Id:" + ids + "}", e);
        }
        return jsonView;
    }
}
