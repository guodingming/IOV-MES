package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 设备管理-设备-工序-附件
*/
@ApiModel(value = "FtyDeviceProcessAnnexAssociation", description = "设备管理-设备-工序-附件")
public class FtyDeviceProcessAnnexAssociation extends TrackableEntity {
	@ApiModelProperty(value = "属所设备附件ID")
	private String deviceProcessAnnexId;
	@ApiModelProperty(value = "附件ID")
	private String deviceAnnexInfoId;


	public String getDeviceProcessAnnexId() {
		return deviceProcessAnnexId;
	}
	public void setDeviceProcessAnnexId(String deviceProcessAnnexId) {
		this.deviceProcessAnnexId = deviceProcessAnnexId;
	}
	public String getDeviceAnnexInfoId() {
		return deviceAnnexInfoId;
	}
	public void setDeviceAnnexInfoId(String deviceAnnexInfoId) {
		this.deviceAnnexInfoId = deviceAnnexInfoId;
	}
}
