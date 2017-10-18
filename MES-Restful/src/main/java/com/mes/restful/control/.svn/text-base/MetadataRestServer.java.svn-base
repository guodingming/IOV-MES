package com.mes.restful.control;

import com.alibaba.fastjson.JSON;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IMetadataProvider;
import com.mes.entity.control.ExpandTableConfig;
import com.mes.entity.control.Metadata;
import com.mes.entity.control.MetadataSave;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by dengyun.le on 2017/7/25.
 */
@Api(value = "开发平台-字段信息保存", description = "开发平台-字段信息保存")
@Path(RestConstants.RestPathPrefix.METADATA)
public class MetadataRestServer extends BaseRestServerInterfaceImpl<Metadata> {
    public IMetadataProvider getDubboBaseInterface(){return ControlConsumer.getMetadataProvider();}

    @POST
    @Path("saveFieldList")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "字段信息保存", notes = "字段信息保存", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject saveFieldList(@ApiParam(value = "字段信息")MetadataSave metadataSave){
        String tableId = metadataSave.getTableId();
        List<Metadata> list = metadataSave.getColumnList();
        try {
            String id = this.getDubboBaseInterface().saveFieldList(tableId,list);
            jsonView.successPack(id,"保存成功!");
        } catch (DubboProviderException e) {
            jsonView.failPack(e);
            this.addOperationLog("保存失败", "", false);
            log.error("MetadataRestServer saveFieldList is error", e);
        }

        return jsonView;

    }

    @GET
    @Path("findByTableId")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "查询字段信息", notes = "查询字段信息", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject findByTableId(@ApiParam(value = "主表Id")@QueryParam("tableId")String tableId,@ApiParam(value = "是否是扩展表")@QueryParam("isExpand")String isExpand ){
            try {
                List<Metadata> list =this.getDubboBaseInterface().findByTableId(tableId,isExpand);
                jsonView.successPack(list,"查询成功!");
            } catch (DubboProviderException e) {
                jsonView.failPack(e);
                this.addOperationLog("查询失败", "", false);
                log.error("MetadataRestServer findByTableId is error", e);
            }

    return jsonView;
    }

}
