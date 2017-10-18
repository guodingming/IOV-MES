package com.mes.control.device;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 任务信息
 * <p>
 * Created by xiuyou.xu on 2017/8/29.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "NewDataSet")
public class TaskInfoItem {
    @XmlElement(name = "taskinfo")
    private TaskInfo taskInfo;

    public TaskInfo getTaskInfo() {
        return taskInfo;
    }

    public void setTaskInfo(TaskInfo taskInfo) {
        this.taskInfo = taskInfo;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "taskinfo")
    public static class TaskInfo {
        @XmlElement(name = "bill_no")
        private String billNo;
        @XmlElement(name = "procedure_name")
        private String procedureName;
        @XmlElement(name = "procedure_id")
        private String procedureId;
        @XmlElement(name = "batch")
        private String batch;
        @XmlElement(name = "product_id")
        private String productId;
        @XmlElement(name = "material_id")
        private String materialId;
        @XmlElement(name = "product_code")
        private String productCode;
        @XmlElement(name = "machine_id")
        private String machineId;
        @XmlElement(name = "task_mode")
        private String taskMode;
        @XmlElement(name = "procedure_type")
        private String procedureType;
        @XmlElement(name = "amount")
        private long amount;
        @XmlElement(name = "procedure_flag")
        private String procedureFlag;

        public String getBillNo() {
            return billNo;
        }

        public void setBillNo(String billNo) {
            this.billNo = billNo;
        }

        public String getProcedureName() {
            return procedureName;
        }

        public void setProcedureName(String procedureName) {
            this.procedureName = procedureName;
        }

        public String getProcedureId() {
            return procedureId;
        }

        public void setProcedureId(String procedureId) {
            this.procedureId = procedureId;
        }

        public String getBatch() {
            return batch;
        }

        public void setBatch(String batch) {
            this.batch = batch;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getMaterialId() {
            return materialId;
        }

        public void setMaterialId(String materialId) {
            this.materialId = materialId;
        }

        public String getProductCode() {
            return productCode;
        }

        public void setProductCode(String productCode) {
            this.productCode = productCode;
        }

        public String getMachineId() {
            return machineId;
        }

        public void setMachineId(String machineId) {
            this.machineId = machineId;
        }

        public String getTaskMode() {
            return taskMode;
        }

        public void setTaskMode(String taskMode) {
            this.taskMode = taskMode;
        }

        public String getProcedureType() {
            return procedureType;
        }

        public void setProcedureType(String procedureType) {
            this.procedureType = procedureType;
        }

        public long getAmount() {
            return amount;
        }

        public void setAmount(long amount) {
            this.amount = amount;
        }

        public String getProcedureFlag() {
            return procedureFlag;
        }

        public void setProcedureFlag(String procedureFlag) {
            this.procedureFlag = procedureFlag;
        }
    }
}
