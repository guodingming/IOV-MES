package com.mes.restful.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.utils.StringUtils;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpRepairStationBadInfoProvider;
import com.mes.entity.control.DpRepairStationBadInfo;
import com.mes.entity.control.User;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * 开发平台-产品维修站-不良信息
 * Created by xiuyou.xu on 2017/08/25.
 */
@Api(value = "开发平台-产品维修站-不良信息", description = "开发平台-产品维修站-不良信息"/*, authorizations = {@Authorization(value = "mesoauth", scopes = {@AuthorizationScope(scope = "dprepairstationbadinfo", description = "开发平台-产品维修站-不良信息")})}*/)
@Path(RestConstants.RestPathPrefix.DPREPAIRSTATIONBADINFO)
public class DpRepairStationBadInfoRestServer extends BaseRestServerInterfaceImpl<DpRepairStationBadInfo> {
    @Override
    public IDpRepairStationBadInfoProvider getDubboBaseInterface() {
        return ControlConsumer.getDpRepairStationBadInfoProvider();
    }

    /**
     * 根据产品条码获取产品不良信息
     *
     * @param number
     * @return
     */
    @GET
    @Path("/getBadInfoByNumber")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据产品条码获取产品不良信息", notes = "根据产品条码获取产品不良信息", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getBadInfoByNumber(@ApiParam(value = "产品条码") @QueryParam("number") String number) {
        try {
            if (StringUtils.isNotBlank(number)) {
                jsonView = this.getDubboBaseInterface().getBadInfoByNumber(number);
            } else {
                jsonView.failPack(false, "请传入指定参数");
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(e);
            this.addOperationLog("根据产品条码获取产品不良信息", "根据产品条码获取产品不良信息失败", false);
            log.error("DpRepairStationBadInfoRestServer getBadInfoByNumber is error", e);
        }
        return jsonView;
    }


    /**
     * 维修不良并录入维修信息
     *
     * @param dpRepairStationBadInfo
     * @return
     */
    @POST
    @Path("repair")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "维修不良并录入维修信息", notes = "维修不良并录入维修信息", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject repair(@ApiParam(value = "维修信息对象") DpRepairStationBadInfo dpRepairStationBadInfo){
        try {
            Object o = request.getSession().getAttribute("station");
            if (null != o) {
                Map<String, Object> session = (Map<String, Object>) o;
                User user = (User) session.get("userInfo");
                if (dpRepairStationBadInfo != null) {
                    dpRepairStationBadInfo.setRepairUserName(user.getName());
                    dpRepairStationBadInfo.setRepairUserId(user.getId());
                    dpRepairStationBadInfo.setIsRework("1");
                    boolean flag = this.getDubboBaseInterface().update(dpRepairStationBadInfo);
                    if (flag) {
                        jsonView.successPack(true, "维修不良并录入维修信息成功");
                    } else {
                        jsonView.failPack(false, "维修不良并录入维修信息失败");
                    }
                } else {
                    jsonView.failPack(false, "请传入指定参数");
                }
            } else {
                jsonView.failPack("请确认登录信息");
            }
        } catch (DubboProviderException e) {
            jsonView.failPack(e);
            this.addOperationLog("维修不良并录入维修信息", "维修不良并录入维修信息失败", false);
            log.error("DpRepairStationBadInfoRestServer repair is error", e);
        }
        return jsonView;
    }



}
