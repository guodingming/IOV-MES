package com.mes.control.device;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * 待转换芯片操作信息
 * <p>
 * Created by xiuyou.xu on 2017/9/4.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "prod_infos_in")
public class ProdInfosIn {
    @XmlElement(name = "prod_info")
    private List<ProdInfo> prodInfos;

    public List<ProdInfo> getProdInfos() {
        return prodInfos;
    }

    public void setProdInfos(List<ProdInfo> prodInfos) {
        this.prodInfos = prodInfos;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "prod_info")
    public static class ProdInfo {
        @XmlElement(name = "serial_id")
        private String serialId;
        @XmlElement(name = "content")
        private String content;
        @XmlElement(name = "opertate_code")
        private String operateCode;
        @XmlElement(name = "prog_type")
        private String progType;
        @XmlElement(name = "source_type")
        private String sourceType;

        public String getSerialId() {
            return serialId;
        }

        public void setSerialId(String serialId) {
            this.serialId = serialId;
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
    }
}
