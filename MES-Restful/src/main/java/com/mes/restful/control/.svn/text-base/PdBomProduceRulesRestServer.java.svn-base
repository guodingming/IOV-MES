package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.framework.rest.view.Page;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdBomProduceRulesProvider;
import com.mes.entity.control.PdBomProduceRules;
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
 * 产品管理-生产BOM校验规则
 */
@Api(value = "产品管理-生产BOM校验规则", description = "产品管理-生产BOM校验规则")
@Path(RestConstants.RestPathPrefix.PDBOMPRODUCERULES)
public class PdBomProduceRulesRestServer extends BaseRestServerInterfaceImpl<PdBomProduceRules> {
    @Override
    public IPdBomProduceRulesProvider getDubboBaseInterface() {
        return ControlConsumer.getPdBomProduceRulesProvider();
    }

    /**
     * 根据产品分页查询bom校验规则列表
     *
     * @param page
     * @return
     */
    @POST
    @Path("byPage/pd")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据产品分页查询bom校验规则列表", notes = "根据产品分页查询bom校验规则列表", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getPageByPd(@ApiParam(value ="分页查询参数",required = true,defaultValue = "",example = "{\"pageSize\":10,\"pageNum\":1,\"condition\":{\"pdId\":\"1\",\"search\":\"test\"}}") Page page) {
        try {
            page = this.getDubboBaseInterface().getPageByPd(page);
            this.addOperationLog("根据产品分页查询bom校验规则列表成功", "", true);
            jsonView.successPack(page);
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("根据产品分页查询bom校验规则列表失败", "", false);
            log.error("PdBomProduceRulesRestServer getPageByPd is error", e);
        }
        return jsonView;
    }
}
