package com.mes.restful.control;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.framework.rest.view.Page;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IMenuProvider;
import com.mes.entity.control.Menu;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

/**
 * Created by xiuyou.xu on 2017/7/10.
 */
@Api(value = "系统管理-菜单管理", description = "系统管理-菜单管理"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "menu", description = "菜单管理")})}*/)
@Path(RestConstants.RestPathPrefix.MENU)
public class MenuRestServer extends BaseRestServerInterfaceImpl<Menu> {

    @Override
    public IMenuProvider getDubboBaseInterface() {
        return ControlConsumer.getMenuProvider();
    }

    @Path("getMenuJson")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "查询菜单数据，返回json数组格式内容", notes = "查询菜单数据，返回json数组格式内容")
    public JsonViewObject getMenuJson() {
        Map<String, Object> params = Maps.newHashMap();
        params.put("parentId", "0");
        try {
            List<Menu> menus = getDubboBaseInterface().getMenuJson(params);
            jsonView.successPack(menus);
            return jsonView;
        } catch (DubboProviderException e) {
            jsonView.failPack(e);
            this.addOperationLog("查询菜单数据，返回json数组格式内容", "", false);
            log.error("MenuRestServer getMenuJson is error", e);
        }
        return jsonView;
    }

    @Path("getRoleMenus/{roleId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据角色id查询菜单列表", notes = "根据角色id查询菜单列表")
    public JsonViewObject getRoleMenus(@ApiParam(value = "角色id", required = true, defaultValue = "", example = "1") @PathParam("roleId") String roleId) {
        try {
            List<Menu> menus = getDubboBaseInterface().getRoleMenus(roleId);
            jsonView.successPack(menus);
            return jsonView;
        } catch (DubboProviderException e) {
            jsonView.failPack(e);
            this.addOperationLog("根据角色id查询菜单列表", "", false);
            log.error("MenuRestServer getRoleMenus is error", e);
        }
        return jsonView;
    }

    /**
     * 修改分页查询实现，传入模糊查询关键词和上级菜单id，返回所有后代菜单节点的分页结果
     *
     * @param page
     * @return
     */
    @POST
    @Path("/byPage")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "分页查询菜单项", notes = "分页查询菜单项", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public JsonViewObject getPage(@ApiParam(value = "查询条件和分页参数", required = true, defaultValue = "", example = "{\"pageSize\": 10, \"pageNum\": 1}") Page page) {
        try {
            Map<String, Object> params = Maps.newHashMap();
            if (page != null && Map.class.isInstance(page.getCondition())) {
                params = (Map) page.getCondition();
            }
            String parentId = params.get("parentId") == null ? "" : params.get("parentId").toString();
            String search = params.get("search") == null ? "" : params.get("search").toString();
            if (parentId.isEmpty() && search.isEmpty()) {
                return super.getPage(page);
            }
            List<Menu> menus = Lists.newArrayList();
            buildMenus(menus, parentId, search);
            int start = (page.getPageNum() - 1) * page.getPageSize();
            int end = start + page.getPageSize();
            if (end > menus.size()) {
                end = menus.size();
            }
            List<Menu> ret = menus.subList(start, end);
            page.setRows(ret);
            page.setTotal(menus.size());
            jsonView.successPack(page);
        } catch (DubboProviderException e) {
            jsonView.failPack(e);
            this.addOperationLog("分页查询菜单项", "", false);
            log.error("MenuRestServer getPage is error", e);
        }
        return jsonView;
    }

    private void buildMenus(List<Menu> retMenus, String parentId, String search) throws DubboProviderException {
        Map<String, Object> params = Maps.newHashMap();
        params.put("parentId", parentId);
        params.put("search", search);
        try {
            List<Menu> menus = this.getDubboBaseInterface().findByMap(params);
            retMenus.addAll(menus);
            if (menus != null && !menus.isEmpty()) {
                menus.stream().forEach(menu -> {
                    try {
                        buildMenus(retMenus, menu.getId(), search);
                    } catch (DubboProviderException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (DubboProviderException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新菜单排序
     * @param menus
     * @return
     */
    @POST
    @Path("updateSort")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "更新菜单排序", notes = "更新菜单排序", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public JsonViewObject updateSort(@ApiParam(value = "需要更新排序的菜单集合", required = true, defaultValue = "", example = "[{\"id\": 10, \"itemOrder\": 1}]") List<Menu> menus) {
        try {
            boolean flag = this.getDubboBaseInterface().updateSort(menus);
            if (flag) {
                jsonView.successPack(flag, "更新菜单排序成功");
                this.addOperationLog("更新菜单排序",  "更新菜单排序成功", true);
            } else {
                jsonView.failPack(flag, "更新菜单排序失败");
                this.addOperationLog("更新菜单排序",  "更新菜单排序成功", true);
            }
        }catch (DubboProviderException e){
            jsonView.failPack("更新菜单排序失败", "更新菜单排序失败");
            this.addOperationLog("更新菜单排序",  "更新菜单排序失败", false);
            log.error("MenuRestServer updateSort is error,{:" + "" + "}", e);
        }
        return jsonView;
    }
}
