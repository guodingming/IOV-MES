package com.mes.control.device;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * 软件注入结果保存
 * Created by xiuyou.xu on 2017/9/14.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ChipOperateData")
public class ChipOperateData {
    @XmlElement(name = "DownloadResult")
    private String downloadResult;
    @XmlElement(name = "Channel")
    private String channel;
    @XmlElementWrapper(name = "ChipOperateResult")
    @XmlElement(name = "ChipOperateUnit")
    private List<ChipOperateUnit> chipOperateUnits;

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

    public List<ChipOperateUnit> getChipOperateUnits() {
        return chipOperateUnits;
    }

    public void setChipOperateUnits(List<ChipOperateUnit> chipOperateUnits) {
        this.chipOperateUnits = chipOperateUnits;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "ChipOperateUnit")
    public static class ChipOperateUnit {
        @XmlElement(name = "Address")
        private String address;
        @XmlElement(name = "Content")
        private String content;
        @XmlElement(name = "SaveType")
        private String saveType;
        @XmlElement(name = "OldContent")
        private String oldContent;

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
