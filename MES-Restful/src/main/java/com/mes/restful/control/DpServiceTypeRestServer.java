package com.mes.restful.control;

import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.framework.rest.view.Node;
import com.mes.common.utils.StringUtils;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpServiceTypeProvider;
import com.mes.entity.control.DpServiceType;
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

/**
 * 开发平台-服务分类
*/
@Api(value = "开发平台-服务分类", description = "开发平台-服务分类")
@Path(RestConstants.RestPathPrefix.DPSERVICETYPE)
public class DpServiceTypeRestServer extends BaseRestServerInterfaceImpl<DpServiceType> {

	private IDpServiceTypeProvider dpServiceTypeProvider =  ControlConsumer.getDpServiceTypeProvider();

	@Override
	public IDpServiceTypeProvider getDubboBaseInterface() {
		return dpServiceTypeProvider;
	}

	@GET
	@Path("getAllServiceByServiceType")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "根据接口服务类型查询接口服务",notes ="根据接口服务类型查询接口服务",response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
	public  JsonViewObject getAllServiceByServiceType(){
		try{
			List<Node> resultTree = this.dpServiceTypeProvider.findServiceTreeByServiceId();
			this.addOperationLog("根据接口服务类型查询接口服务","",true);
			jsonView.successPack(resultTree);
		}
		catch(Exception e)
		{
			jsonView.failPack(e);
			log.error("getAllServiceByServiceType",e);
			this.addOperationLog("getAllServiceByServiceType error","",false);
		}
		return jsonView;
	}

	/**
	 * 分类删除验证，若分类下下有数据则不允许删除
	 * @param ids
	 * @return
	 * ledengyun--2017/09/22
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
			log.error("DpServiceTypeRestServer deleteByIds is error,{Id:" + ids + "}", e);
		}
		return jsonView;
	}
}
