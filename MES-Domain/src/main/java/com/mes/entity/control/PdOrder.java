package com.mes.entity.control;

import com.mes.common.framework.domain.BeanValidationGroups;
import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 产品管理-产品订单管理
*/
@ApiModel(value = "PdOrder", description = "产品管理-产品订单管理")
public class PdOrder extends TrackableEntity {
	@ApiModelProperty(value = "订单号")
	@NotNull(message = "订单号",groups = {BeanValidationGroups.CreateGroup.class})
	private String orderNum;
	@ApiModelProperty(value = "产品数据量")
	@NotNull(message = "订单号",groups = {BeanValidationGroups.CreateGroup.class})
	private String pdNum;
	@ApiModelProperty(value = "客户")
	@NotNull(message = "订单号",groups = {BeanValidationGroups.CreateGroup.class})
	private String customer;
	@ApiModelProperty(value = "仓储")
	private String warehouse;
	@ApiModelProperty(value = "交货时间")
	private Date deliveryTime;
	@ApiModelProperty(value = "状态（未开始，生产中、完成）")
	private String status;
	@ApiModelProperty(value = "下单时间")
	private Date orderTime;
	@ApiModelProperty(value = "生产计划开始时间")
	private Date startTime;
	@ApiModelProperty(value = "生产计划完工时间")
	private Date endTime;
	@ApiModelProperty(value = "产品ID")
	@NotNull(message = "订单号",groups = {BeanValidationGroups.CreateGroup.class})
	private String pdId;

	@ApiModelProperty(value = "订单名称")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getPdNum() {
		return pdNum;
	}
	public void setPdNum(String pdNum) {
		this.pdNum = pdNum;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}
	public Date getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getPdId() {
		return pdId;
	}
	public void setPdId(String pdId) {
		this.pdId = pdId;
	}
}
