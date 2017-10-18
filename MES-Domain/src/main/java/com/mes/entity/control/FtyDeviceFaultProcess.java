package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "FtyDeviceFaultProcess", description = "工厂管理-故障影响-工序")
public class FtyDeviceFaultProcess extends TrackableEntity {
	@ApiModelProperty(value = "故障ID")
	private String deviceFaultInfoId;
	@ApiModelProperty(value = "责任方")
	private String responsiblePersion;
	@ApiModelProperty(value = "异常问题")
	private String abnormalProblems;
	@ApiModelProperty(value = "异常编码")
	private String abnormalCode;

	public String getDeviceFaultInfoId() {
		return deviceFaultInfoId;
	}

	public void setDeviceFaultInfoId(String deviceFaultInfoId) {
		this.deviceFaultInfoId = deviceFaultInfoId;
	}

	public String getResponsiblePersion() {
		return responsiblePersion;
	}

	public void setResponsiblePersion(String responsiblePersion) {
		this.responsiblePersion = responsiblePersion;
	}

	public String getAbnormalProblems() {
		return abnormalProblems;
	}

	public void setAbnormalProblems(String abnormalProblems) {
		this.abnormalProblems = abnormalProblems;
	}

	public String getAbnormalCode() {
		return abnormalCode;
	}

	public void setAbnormalCode(String abnormalCode) {
		this.abnormalCode = abnormalCode;
	}
}
