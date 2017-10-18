package com.mes.control.device;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * 芯片操作列表信息
 *
 * Created by xiuyou.xu on 2017/8/29.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "NewDataSet")
public class ChipOpListInfo {
    @XmlElement(name = "item")
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "item")
    private static class Item {
        @XmlElement(name = "addr")
        private String addr;
        @XmlElement(name = "byte_num")
        private String byteNum;
        @XmlElement(name = "content")
        private String content;
        @XmlElement(name = "opertate_code")
        private String operateCode;
        @XmlElement(name = "prog_type")
        private String progType;
        @XmlElement(name = "source_type")
        private String sourceType;
        @XmlElement(name = "source_describe")
        private String sourceDescribe;
        @XmlElement(name = "showcontent")
        private String showContent;
        @XmlElement(name = "delay_time")
        private String delayTime;
        @XmlElement(name = "store_type")
        private String storeType;
        @XmlElement(name = "model")
        private String model;
        @XmlElement(name = "procedure_id")
        private String procedureId;

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public String getByteNum() {
            return byteNum;
        }

        public void setByteNum(String byteNum) {
            this.byteNum = byteNum;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getOperateCode() {
            return operateCode;
        }

        public void setOperateCode(String operateCode) {
            this.operateCode = operateCode;
        }

        public String getProgType() {
            return progType;
        }

        public void setProgType(String progType) {
            this.progType = progType;
        }

        public String getSourceType() {
            return sourceType;
        }

        public void setSourceType(String sourceType) {
            this.sourceType = sourceType;
        }

        public String getSourceDescribe() {
            return sourceDescribe;
        }

        public void setSourceDescribe(String sourceDescribe) {
            this.sourceDescribe = sourceDescribe;
        }

        public String getShowContent() {
            return showContent;
        }

        public void setShowContent(String showContent) {
            this.showContent = showContent;
        }

        public String getDelayTime() {
            return delayTime;
        }

        public void setDelayTime(String delayTime) {
            this.delayTime = delayTime;
        }

        public String getStoreType() {
            return storeType;
        }

        public void setStoreType(String storeType) {
            this.storeType = storeType;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getProcedureId() {
            return procedureId;
        }

        public void setProcedureId(String procedureId) {
            this.procedureId = procedureId;
        }
    }
}
