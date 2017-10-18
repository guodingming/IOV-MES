package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.framework.rest.view.Node;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdBomWorkProvider;
import com.mes.entity.control.PdBomWork;
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
 * 产品管理-工单BOM管理
*/
@Api(value = "产品管理-工单BOM管理", description = "产品管理-工单BOM管理")
@Path(RestConstants.RestPathPrefix.PDBOMWORK)
public class PdBomWorkRestServer extends BaseRestServerInterfaceImpl<PdBomWork> {
	@Override
	public IPdBomWorkProvider getDubboBaseInterface() {
		return ControlConsumer.getPdBomWorkProvider();
	}

	/**
	 * 根据bom id查询bom物料清单树
	 *
	 * @param bomId
	 * @return
	 */
	@GET
	@Path("getMaterialTree")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "根据bom id查询bom物料清单树", notes = "根据bom id查询bom物料清单树", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
	public JsonViewObject getMaterialTree(@ApiParam(value = "BOM id", required = true, defaultValue = "", example = "1") @QueryParam("bomId") String bomId) {
		try {
			List<Node> nodes = this.getDubboBaseInterface().getMaterialTree(bomId);
			this.addOperationLog("根据bom id查询bom物料清单树成功", "", true);
			jsonView.successPack(nodes);
		} catch (Exception e) {
			jsonView.failPack(e);
			this.addOperationLog("根据bom id查询bom物料清单树失败", "", false);
			log.error("PdBomWorkRestServer getMaterialTree is error", e);
		}
		return jsonView;
	}

	/**
	 * 查询bom下物料不同版本数量相关信息列表
	 *
	 * @param bomId
	 * @param code
	 * @return
	 */
	@GET
	@Path("getMaterialAmount")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "查询bom下物料不同版本数量相关信息列表", notes = "查询bom下物料不同版本数量相关信息列表", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
	public JsonViewObject getMaterialAmount(@ApiParam(value = "BOM id", required = true, defaultValue = "", example = "1") @QueryParam("bomId") String bomId,
											@ApiParam(value = "物料编码", required = true, defaultValue = "", example = "1") @QueryParam("code") String code) {
		try {
			List<Map<String, Object>> nodes = this.getDubboBaseInterface().getMaterialAmount(bomId, code);
			this.addOperationLog("查询bom下物料不同版本数量相关信息列表成功", "", true);
			jsonView.successPack(nodes, "查询bom下物料不同版本数量相关信息列表成功");
		} catch (Exception e) {
			jsonView.failPack(e);
			this.addOperationLog("查询bom下物料不同版本数量相关信息列表失败", "", false);
			log.error("PdBomWorkRestServer getMaterialAmount is error", e);
		}
		return jsonView;
	}
}
