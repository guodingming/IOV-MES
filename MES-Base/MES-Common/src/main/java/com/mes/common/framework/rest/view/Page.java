package com.mes.common.framework.rest.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

/**
 * {'total':64,'pageNum':1,'maxSize':10,'pageSize':10,'condition':''};
 */
@ApiModel(value = "Page")
public class Page implements Serializable{
	@ApiModelProperty(value = "每页数据条数")
	@Min(value = 0, message = "每页数据条数不能为负数")
	private int pageSize = 10;     //每页数据条数
	@ApiModelProperty(value = "页码")
	@Min(value = 0, message = "页码不能为负数")
	private int pageNum = 1;       //页码
	@ApiModelProperty(value = "总的数据数")
	private int total = 0;         //总的数据数
	private int totalPageNum = 0;  //总页数
	@ApiModelProperty(value = "数据开始行号")
	private int startRowNum = 0;   //
	private int pageNumber = 1;
	@ApiModelProperty(value = "数据结束行号")
	private int endRowNum = 0;
	private	String orderBy = "";
	private String desc = "";
	@ApiModelProperty(value = "查询条件对象")
	private Object condition;
	@SuppressWarnings("rawtypes")
	@ApiModelProperty(value = "分页数据列表")
	private List rows;

    public Page() {
    }

    public Page(int pageSize, int total) {
        this.pageSize = pageSize;
        this.total = total;
        int mod = total % pageSize;
        totalPageNum = mod == 0 ? (total / pageSize) : (total / pageSize) + 1;
        if (startRowNum<=0) {
        	startRowNum = 0;
            endRowNum = pageSize;
		}
    }

	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNumber) {
		this.pageNum = pageNumber;
		int startTemp=pageSize*(pageNumber-1);
		if (startTemp > total) {
			this.startRowNum=total-pageSize;
		}else{
			this.startRowNum=startTemp;
		}
//		this.startRowNum=startTemp;
		int temp=pageSize*pageNum;
		if (temp>total){
			this.endRowNum=total;
		}else {
			this.endRowNum = temp;
		}

	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
        int mod = total % pageSize;
        totalPageNum = mod == 0 ? (total / pageSize) : (total / pageSize) + 1;
        if (startRowNum<=0) {
        	startRowNum = 0;
            endRowNum = pageSize;
		}
		this.startRowNum = (pageSize*(pageNum-1));
		int temp=pageSize*pageNum;
		if (temp>total){
			this.endRowNum=total;
		}else {
			this.endRowNum = temp;
		}
	}
	public int getTotalPageNum() {
		return totalPageNum;
	}
	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}
	public int getStartRowNum() {
		return startRowNum;
	}
	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
//		this.startRowNum = (pageSize*(pageNum-1));
	}
	public int getEndRowNum() {
		int temp=pageSize*pageNum;
		if (temp>total){
			this.endRowNum=total;
		}else {
			this.endRowNum = (pageSize * pageNum);
		}
		return endRowNum;
	}
	public void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
	}

	public Object getCondition() {
		return condition;
	}

	public void setCondition(Object condition) {
		this.condition = condition;
	}

	@SuppressWarnings("rawtypes")
	public void setRows(List rows) {
		this.rows = rows;
	}
	@SuppressWarnings("rawtypes")
	public List getRows() {
		return rows;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getPageNumber() {
		return this.pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
		this.startRowNum = this.pageSize * (pageNumber - 1);
		this.endRowNum = this.pageSize * pageNumber;
	}
}
