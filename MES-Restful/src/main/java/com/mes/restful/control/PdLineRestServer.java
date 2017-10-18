package com.mes.restful.control;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.framework.rest.view.Node;
import com.mes.common.utils.StringUtils;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdLineProvider;
import com.mes.entity.control.DpProduceProcess;
import com.mes.entity.control.Pd;
import com.mes.entity.control.PdLine;
import com.mes.entity.control.PdWorkOrder;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

/**
 * 产品管理-产品线
 */
@Api(value = "产品管理-产品线", description = "产品管理-产品线")
@Path(RestConstants.RestPathPrefix.PDLINE)
public class PdLineRestServer extends BaseRestServerInterfaceImpl<PdLine> {
    @Override
    public IPdLineProvider getDubboBaseInterface() {
        return ControlConsumer.getPdLineProvider();
    }

    /**
     * 查询产品线下所有的产品
     */
    @GET
    @Path("findByPdLineId")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "查询指定产品线下所有的产品", notes = "查询产品线下所有的产品", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject findByPdLineId(@ApiParam(value = "产品线ID") @QueryParam("pdLineId") String pdLineId) {
        JSON result;
        List<Pd> list = null;
        try {
            list = this.getDubboBaseInterface().findByPdLineId(pdLineId);
            result = (JSON) JSON.toJSON(list);
            this.addOperationLog("查询指定产品线下所有的产品", "", true);
            jsonView.successPack(result);
        } catch (DubboProviderException e) {
            jsonView.failPack(e);
            this.addOperationLog("查询所查询指定产品线下所有的产品", "", false);
            log.error("PdLineRestServer findByPdLineId is error", e);
        }

        return jsonView;
    }

    /**
     * 获取产品线及对应产品列表树形结构数据
     *
     * @return
     */
    @GET
    @Path("getPdLineTree")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "获取产品线及对应产品列表树形结构数据", notes = "获取产品线及对应产品列表树形结构数据", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getPdLineTree() {
        try {
            List<Node> nodes = this.getDubboBaseInterface().getPdLineTree();
            this.addOperationLog("获取产品线及对应产品列表树形结构数据成功！", "", true);
            jsonView.successPack(nodes, "获取产品线及对应产品列表树形结构数据成功！");
        } catch (DubboProviderException e) {
            jsonView.failPack(e);
            this.addOperationLog("获取产品线及对应产品列表树形结构数据失败！", "", false);
            log.error("PdLineRestServer getPdLineTree is error", e);
        }

        return jsonView;
    }


    /**
     * 工作站登录获取产品关联信息
     * @return
     */
    @GET
    @Path("/loginPdInfo")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "工作站登录获取产品关联信息", notes = "工作站登录获取产品关联信息", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject loginPdInfo(){
        try{
            List<Node> result = this.getDubboBaseInterface().loginPdInfo();
            this.addOperationLog("工作站登录获取产品关联信息","",true);
            jsonView.successPack(result, "工作站登录获取产品关联信息成功");
        }catch (Exception e){
            jsonView.failPack(e, "工作站登录获取产品关联信息失败");
            this.addOperationLog("工作站登录获取产品关联信息","",false);
            log.error("FtyProductionLineRestServer loginPdInfo",e);
        }
        return jsonView;
    }

    /**
     * 根据工单ID获取生产工序
     * @param workOrderId
     * @return
     */
    @GET
    @Path("/loginProcess")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "根据工单ID获取生产工序", notes = "根据工单ID获取生产工序", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject loginProcess(@ApiParam(value = "工程ID") @QueryParam("workOrderId") String workOrderId){
        try {
            if (StringUtils.isNotBlank(workOrderId)) {
                List<DpProduceProcess> result = this.getDubboBaseInterface().loginProcess(workOrderId);
                this.addOperationLog("根据工单ID获取生产工序","",true);
                jsonView.successPack(result, "根据工单ID获取生产工序成功");
            } else {
                this.addOperationLog("根据工单ID获取生产工序","",false);
                jsonView.failPack(false, "请传入指定参数");
            }
        } catch (Exception e) {
            jsonView.failPack(e, "根据工单ID获取生产工序失败");
            this.addOperationLog("根据工单ID获取生产工序失败", "" , false);
            log.error("FtyProductionLineRestServer loginProcess",e);
        }
        return jsonView;
    }
    /**
     * 分类删除添加验证是否有数据，是否允许删除
     * @param ids
     * @return
     * lednegyun--2017/09/22
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
            log.error("PdLineRestServer deleteByIds is error,{Id:" + ids + "}", e);
        }
        return jsonView;
    }


}
