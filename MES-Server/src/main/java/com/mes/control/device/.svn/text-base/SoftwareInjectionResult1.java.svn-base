package com.mes.control.device;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * 一线软件注入结果
 * Created by xiuyou.xu on 2017/9/1.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "prod_infos_in")
public class SoftwareInjectionResult1 {
    @XmlElement(name = "ChipOperateData")
    private String chipOperateData;
    @XmlElement(name = "DownloadResult")
    private String downloadResult;
    @XmlElement(name = "Channel")
    private String channel;
    @XmlElement(name = "ChipOperateResult")
    private List<ChipOperateResult> chipOperateResults;

    public String getChipOperateData() {
        return chipOperateData;
    }

    public void setChipOperateData(String chipOperateData) {
        this.chipOperateData = chipOperateData;
    }

    public String getDownloadResult() {
        return downloadResult;
    }

    public void setDownloadResult(String downloadResult) {
        this.downloadResult = downloadResult;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public List<ChipOperateResult> getChipOperateResults() {
        return chipOperateResults;
    }

    public void setChipOperateResults(List<ChipOperateResult> chipOperateResults) {
        this.chipOperateResults = chipOperateResults;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "ChipOperateResult")
    public static class ChipOperateResult {
        @XmlElement(name = "ChipOperateUnit")
        private String chipOperateUnit;
        @XmlElement(name = "Address")
        private String address;
        @XmlElement(name = "Content")
        private String content;
        @XmlElement(name = "SaveType")
        private String saveType;
        @XmlElement(name = "OldContent")
        private String oldContent;

        public String getChipOperateUnit() {
            return chipOperateUnit;
        }

        public void setChipOperateUnit(String chipOperateUnit) {
            this.chipOperateUnit = chipOperateUnit;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getSaveType() {
            return saveType;
        }

        public void setSaveType(String saveType) {
            this.saveType = saveType;
        }

        public String getOldContent() {
            return oldContent;
        }

        public void setOldContent(String oldContent) {
            this.oldContent = oldContent;
        }
    }
}
