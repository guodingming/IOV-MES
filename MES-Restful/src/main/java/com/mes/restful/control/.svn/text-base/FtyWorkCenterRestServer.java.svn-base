package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.framework.rest.view.Node;
import com.mes.common.utils.StringUtils;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IFtyWorkCenterProvider;
import com.mes.entity.control.FtyWorkCenter;
import com.mes.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Api(value = "工作中心管理-（Work center）", description = "工作中心管理-（Work center）")
@Path(RestConstants.RestPathPrefix.FTYWORKCENTER)
public class FtyWorkCenterRestServer extends BaseRestServerInterfaceImpl<FtyWorkCenter> {
	@Override
	public IFtyWorkCenterProvider getDubboBaseInterface() {
		return ControlConsumer.getFtyWorkCenterProvider();
	}

	/**
	 * @Author jinlong.zhu
	 * @Date 2017/7/19 16:36
	 *根据车间查询产线及其下属工作中心树形结构
	 */
	@GET
	@Path("getAreaProductionLine")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "根据车间查询产线及其下属工作中心树形结构数据",notes ="根据车间查询产线及其下属工作中心树形结构数据",response = JsonViewObject.class,
	produces = MediaType.APPLICATION_JSON)
	public JsonViewObject getAreaProductionLineTree(@QueryParam("areaId") String areaId){
		try{
			List<Node> resultTree = this.getDubboBaseInterface().getAreaProductionLineTree(areaId);
			this.addOperationLog("根据车间查询加工中心列表","",true);
			jsonView.successPack(resultTree);
		}catch (Exception e){
			jsonView.failPack(e);
			this.addOperationLog("根据车间查询加工中心列表", "", false);
			log.error("FtyWorkCenterRestServer getPageByAreaId is error", e);
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
				jsonView.failPack("false", "删除数据失败，该工作中心下有数据");
				this.addOperationLog("删除数据", "ids=" + ids, false);
			}
		} catch (Exception e) {
			jsonView.failPack("false", "删除数据失败!" + e.getMessage());
			this.addOperationLog("删除数据", "id=" + ids, false);
			log.error("FtyWorkCenterRestServer deleteByIds is error,{Id:" + ids + "}", e);
		}
		return jsonView;
	}

}
