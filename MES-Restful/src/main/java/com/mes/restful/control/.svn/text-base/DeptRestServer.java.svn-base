package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.utils.StringUtils;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDeptProvider;
import com.mes.entity.control.Dept;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * 部门管理
 * Created by xiuyou.xu on 2017/7/4.
 */
@Api(value = "系统管理-部门管理", description = "系统管理-部门管理"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "dept", description = "部门管理")})}*/)
@Path(RestConstants.RestPathPrefix.DEPT)
public class DeptRestServer extends BaseRestServerInterfaceImpl<Dept> {
    @Override
    public IDeptProvider getDubboBaseInterface() {
        return ControlConsumer.getDeptProvider();
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
