package com.mes.control.device;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * 硬件子料信息XML
 *
 * Created by xiuyou.xu on 2017/8/29.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "MaterialInfo")
public class MaterialInfo {
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
        @XmlElement(name = "is_main")
        private String isMain;
        @XmlElement(name = "material_batch")
        private String materialBatch;
        @XmlElement(name = "material_code")
        private String materialCode;
        @XmlElement(name = "material_id")
        private String materialId;

        public String getIsMain() {
            return isMain;
        }

        public void setIsMain(String isMain) {
            this.isMain = isMain;
        }

        public String getMaterialBatch() {
            return materialBatch;
        }

        public void setMaterialBatch(String materialBatch) {
            this.materialBatch = materialBatch;
        }

        public String getMaterialCode() {
            return materialCode;
        }

        public void setMaterialCode(String materialCode) {
            this.materialCode = materialCode;
        }

        public String getMaterialId() {
            return materialId;
        }

        public void setMaterialId(String materialId) {
            this.materialId = materialId;
        }
    }
}
