package com.mes.restful.control;

import com.alibaba.fastjson.JSON;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.utils.StringUtils;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IPdFileTypeProvider;
import com.mes.entity.control.PdFileType;
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
 * 文件分类管理
*/
@Api(value = "文件分类管理", description = "文件分类管理")
@Path(RestConstants.RestPathPrefix.PDFILETYPE)
public class PdFileTypeRestServer extends BaseRestServerInterfaceImpl<PdFileType> {
	@Override
	public IPdFileTypeProvider getDubboBaseInterface() {
		return ControlConsumer.getPdFileTypeProvider();
	}

	/**
	 * 查询文件类别树
	 * @param type
	 * @return
	 */
	@GET
	@Path("findByType")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "查询文件类别树", notes = "查询文件类别树", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
	public JsonViewObject findByType(@ApiParam(value = "文件类型",example = "1:资源文件 2:工艺文件")@QueryParam("type")String type){
		JSON result;
		List<PdFileType> list = null;
		try {
			list = this.getDubboBaseInterface().findByType(type);
			result = (JSON) JSON.toJSON(list);
			this.addOperationLog("查询资源文件类别树", "", true);
			jsonView.successPack(result);
		} catch (DubboProviderException e) {
			jsonView.failPack(e);
			this.addOperationLog("查询资源文件类别树", "", false);
			log.error("PdFileResourcesRestServer findByType is error", e);
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
			log.error("PdFileTypeRestServer deleteByIds is error,{Id:" + ids + "}", e);
		}
		return jsonView;
	}



}
