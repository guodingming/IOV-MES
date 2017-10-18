package com.mes.restful.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IExpandTableConfigProvider;
import com.mes.entity.control.ExpandFieldSave;
import com.mes.entity.control.ExpandTableConfig;
import com.mes.entity.control.Metadata;
import com.mes.entity.control.MetadataSave;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by dengyun.le on 2017/7/26.
 */
@Api(value = "开发平台-扩展表", description = "开发平台-扩展表")
@Path(RestConstants.RestPathPrefix.EXPANDTABLECONFIG)
public class ExpandTableConfigRestServer extends BaseRestServerInterfaceImpl<ExpandTableConfig> {
    @Override
    public IExpandTableConfigProvider getDubboBaseInterface(){return ControlConsumer.getExpandTableConfigProvider();}

    /**
     * 添加扩展对象
     * @param expandFieldSave
     * @return
     */
    @POST
    @Path("saveExpandField")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "扩展字段保存", notes = "字段信息保存", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject saveExpandField(@ApiParam(value = "字段信息")ExpandFieldSave expandFieldSave){
        String tableId = expandFieldSave.getTableId();
        List<Metadata> list = expandFieldSave.getColumnList();
        try {
            String id = this.getDubboBaseInterface().saveExpandField(tableId,list);
            jsonView.successPack(id,"保存成功!");
        } catch (DubboProviderException e) {
            jsonView.failPack(e);
            this.addOperationLog("保存失败", "", false);
            log.error("MetadataRestServer saveFieldList is error", e);
        }

        return jsonView;

    }

}
