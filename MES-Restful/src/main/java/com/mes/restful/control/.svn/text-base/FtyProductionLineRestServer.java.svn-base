package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.framework.rest.view.Page;
import com.mes.common.utils.StringUtils;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IFtyProductionLineProvider;
import com.mes.entity.control.FtyProductionLine;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Api(value = "生产线管理-Production Line", description = "生产线管理-Production Line")
@Path(RestConstants.RestPathPrefix.FTYPRODUCTIONLINE)
public class FtyProductionLineRestServer extends BaseRestServerInterfaceImpl<FtyProductionLine> {
	@Override
	public IFtyProductionLineProvider getDubboBaseInterface() {
		return ControlConsumer.getFtyProductionLineProvider();
	}

	@POST
	@Path("byPage/area")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "根据车间分页查询生产线列表",notes = "根据车间分页查询生产线列表",response = JsonViewObject.class,produces = MediaType.APPLICATION_JSON)
	public JsonViewObject getPageByAreaId(Page page){
		try{
			page = this.getDubboBaseInterface().getPageByAreaId(page);
			this.addOperationLog("根据车间分页查询生产线列表","",true);
			jsonView.successPack(page);
		}catch (Exception e){
			jsonView.failPack(e);
			this.addOperationLog("根据车间分页查询生产线列表","",false);
			log.error("FtyProductionLineRestServer getPageByAreaId",e);
		}
		return jsonView;
	}


	/**
	 * 生产线删除添加验证是否有数据，是否允许删除
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
				jsonView.successPack("true", "生产线删除数据成功!");
				this.addOperationLog("生产线删除数据", "ids=" + ids, false);
			} else {
				jsonView.failPack("false", "生产线删除数据失败，该生产线下有工作中心");
				this.addOperationLog("删除数据", "ids=" + ids, false);
			}
		} catch (Exception e) {
			jsonView.failPack("false", "生产线删除数据失败!" + e.getMessage());
			this.addOperationLog("生产线删除数据", "id=" + ids, false);
			log.error("FtyProductionLineRestServer deleteByIds is error,{Id:" + ids + "}", e);
		}
		return jsonView;
	}
}
