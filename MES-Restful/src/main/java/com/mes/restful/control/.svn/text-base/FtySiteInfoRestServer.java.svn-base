package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.framework.rest.view.Node;
import com.mes.common.framework.rest.view.Page;
import com.mes.common.utils.StringUtils;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IFtySiteInfoProvider;
import com.mes.entity.control.FtySiteInfo;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Api(value = "工厂管理-工厂信息", description = "工厂管理-工厂信息")
@Path(RestConstants.RestPathPrefix.FTYSITEINFO)
public class FtySiteInfoRestServer extends BaseRestServerInterfaceImpl<FtySiteInfo> {
    @Override
    public IFtySiteInfoProvider getDubboBaseInterface() {
        return ControlConsumer.getFtySiteInfoProvider();
    }

    /**
     * 根据企业分页查询工厂列表
     *
     * @param page
     * @return
     */
    @POST
    @Path("byPage/enterprise")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据企业分页查询工厂列表", notes = "根据企业分页查询工厂列表", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getPageByEnterpriseId(Page page) {
        try {
            page = this.getDubboBaseInterface().getPageByEnterpriseId(page);
            this.addOperationLog("根据企业分页查询工厂列表", "", true);
            jsonView.successPack(page);
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("根据企业分页查询工厂列表", "", false);
            log.error("FtySiteInfoRestServer getPageByEnterpriseId is error", e);
        }
        return jsonView;
    }

    /**
     * 根据企业查询工厂及其下属车间树形结构数据
     *
     * @param enterpriseId
     * @return
     */
    @GET
    @Path("getSiteAreaTree")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据企业查询工厂及其下属车间树形结构数据", notes = "根据企业查询工厂及其下属车间树形结构数据", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getSiteAreaTree(@ApiParam(value = "企业id", required = true, defaultValue = "", example = "1") @QueryParam("enterpriseId") String enterpriseId) {
        try {
            List<Node> tree = this.getDubboBaseInterface().getSiteAreaTree(enterpriseId);
            this.addOperationLog("根据企业分页查询工厂列表", "", true);
            jsonView.successPack(tree);
        } catch (Exception e) {
            jsonView.failPack(e);
            this.addOperationLog("根据企业分页查询工厂列表", "", false);
            log.error("FtySiteInfoRestServer getPageByEnterpriseId is error", e);
        }
        return jsonView;
    }

    /**
     * 分类删除添加验证是否有数据，是否允许删除
     * @param ids
     * @return
     * lednegyun--2017/10/10
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
                jsonView.failPack("false", "删除数据失败，该工厂下有数据");
                this.addOperationLog("删除数据", "ids=" + ids, false);
            }
        } catch (Exception e) {
            jsonView.failPack("false", "删除数据失败!" + e.getMessage());
            this.addOperationLog("删除数据", "id=" + ids, false);
            log.error("FtySiteInfoRestServer deleteByIds is error,{Id:" + ids + "}", e);
        }
        return jsonView;
    }

}
