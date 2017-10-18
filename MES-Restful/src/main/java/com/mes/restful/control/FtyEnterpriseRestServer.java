package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.framework.rest.view.Node;
import com.mes.common.utils.StringUtils;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IFtyEnterpriseProvider;
import com.mes.entity.control.FtyEnterprise;
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

@Api(value = "工厂管理-企业登记", description = "工厂管理-企业登记")
@Path(RestConstants.RestPathPrefix.FTYENTERPRISE)
public class FtyEnterpriseRestServer extends BaseRestServerInterfaceImpl<FtyEnterprise> {
	@Override
	public IFtyEnterpriseProvider getDubboBaseInterface() {
		return ControlConsumer.getFtyEnterpriseProvider();
	}

	/**
	 *
	 *查询树数据
	 * 2017/07/31--ledengyun
	 */
	@GET
	@Path("getTree")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "查询树数据", notes = "查询树数据", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
	public JsonViewObject getTree() {
		try {
			List<Node> nodes = this.getDubboBaseInterface().getTree();
			this.addOperationLog("企业-工厂-车间，树数据查询成功", "", true);
			jsonView.successPack(nodes);
		} catch (Exception e) {
			jsonView.failPack(e);
			this.addOperationLog("企业-工厂-车间，树数据查询成功", "", false);
			log.error("FtyEnterpriseRestServer getTree is error", e);
		}
		return jsonView;
	}

	/**
	 * 查询仪表盘树
	 *
	 * @return
	 */
	@GET
	@Path("getDashboardTree")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "查询仪表盘树", notes = "查询仪表盘树", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
	public JsonViewObject getDashboardTree() {
		try {
			List<Node> nodes = this.getDubboBaseInterface().getDashboardTree();
			this.addOperationLog("查询仪表盘树成功！", "", true);
			jsonView.successPack(nodes);
		} catch (Exception e) {
			jsonView.failPack(e);
			this.addOperationLog("查询仪表盘树失败！", "", false);
			log.error("FtyProductionLineRestServer getDashboardTree", e);
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
				jsonView.failPack("false", "删除数据失败，该分类下有数据");
				this.addOperationLog("删除数据", "ids=" + ids, false);
			}
		} catch (Exception e) {
			jsonView.failPack("false", "删除数据失败!" + e.getMessage());
			this.addOperationLog("删除数据", "id=" + ids, false);
			log.error("FtyEnterpriseRestServer deleteByIds is error,{Id:" + ids + "}", e);
		}
		return jsonView;
	}

}
