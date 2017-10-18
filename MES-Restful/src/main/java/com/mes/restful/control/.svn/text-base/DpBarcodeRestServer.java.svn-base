package com.mes.restful.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.utils.StringUtils;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IDpBarcodeProvider;
import com.mes.dubbo.interprovider.control.IDpDataDictionaryProvider;
import com.mes.entity.control.DpBarcode;
import com.mes.entity.control.DpDataDictionary;
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
 * 开发平台-条码
*/
@Api(value = "开发平台-条码", description = "开发平台-条码")
@Path(RestConstants.RestPathPrefix.DPBARCODE)
public class DpBarcodeRestServer extends BaseRestServerInterfaceImpl<DpBarcode> {

	private IDpDataDictionaryProvider dpDataDictionaryProvider = ControlConsumer.getDpDataDictionaryProvider();

	@Override
	public IDpBarcodeProvider getDubboBaseInterface() {
		return ControlConsumer.getDpBarcodeProvider();
	}

	/**
	 * 根据条码分类Id查询标签
	 * @param typeId
	 * @return
	 */
	@GET
	@Path("/findByTypeId")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "根据条码分类Id查询", notes = "根据条码分类Id查询", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
	public JsonViewObject findByTypeId(@ApiParam(value = "条码分类Id") @QueryParam("typeId") String typeId){
		List<DpBarcode> labels = null;
		try {
			labels = this.getDubboBaseInterface().findByTypeId(typeId);
			this.addOperationLog("条码数据数据查询成功", "", true);
			jsonView.successPack(labels);
		} catch (DubboProviderException e) {
			jsonView.failPack(e);
			this.addOperationLog("条码数据数据查询失败", "", false);
			log.error("DpBarcodeRestServer findByTypeId is error", e);
		}
		return jsonView;
	}

    /**
     * 获取产品条码分类字典
     *
     * @return
     */
    @GET
    @Path("/getBarCodeTypes")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "获取产品条码分类字典", notes = "获取产品条码分类字典", response = JsonViewObject.class, produces = MediaType.APPLICATION_JSON)
    public JsonViewObject getBarCodeTypes() {
        try {
			String typeKey = ConfigHelper.getValue("barCode.dic.type");
			if (StringUtils.isNotBlank(typeKey)) {
				List<DpDataDictionary> dpDataDictionaryList = this.dpDataDictionaryProvider.findDictionaryByTypeKey(typeKey);
				jsonView.successPack(dpDataDictionaryList, "获取产品条码分类字典成功");
			} else {
				jsonView.failPack("获取产品条码分类字典失败,请确认字典项配置");
			}
		} catch (DubboProviderException e) {
            jsonView.failPack(false, "获取产品条码分类字典失败");
            log.error("获取产品条码分类字典失败");
        }
        return jsonView;
    }

}
