package com.mes.control.device;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * 测试结果
 *
 * Created by xiuyou.xu on 2017/8/29.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "test_result_info")
public class TestResultInfo {
    @XmlAttribute(name = "mems")
    private String mems;
    @XmlElement(name = "channel")
    private Channel channel;
    @XmlElement(name = "result")
    private Result result;
    @XmlElement(name = "product_result_item")
    private List<ProductResultItem> productResultItems;

    public String getMems() {
        return mems;
    }

    public void setMems(String mems) {
        this.mems = mems;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public List<ProductResultItem> getProductResultItems() {
        return productResultItems;
    }

    public void setProductResultItems(List<ProductResultItem> productResultItems) {
        this.productResultItems = productResultItems;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "channel")
    public static class Channel {
        @XmlAttribute(name = "type")
        private String type;
        @XmlValue
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "result")
    public static class Result {
        @XmlAttribute(name = "type")
        private String type;
        @XmlValue
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "product_result_item")
    public static class ProductResultItem {
        @XmlAttribute(name = "dim")
        private String dim;
        @XmlAttribute(name = "type")
        private String type;
        @XmlElement(name = "test_result")
        private List<TestResult> testResults;

        public String getDim() {
            return dim;
        }

        public void setDim(String dim) {
            this.dim = dim;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<TestResult> getTestResults() {
            return testResults;
        }

        public void setTestResults(List<TestResult> testResults) {
            this.testResults = testResults;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "test_result")
    public static class TestResult {
        @XmlAttribute(name = "mems")
        private String mems;
        @XmlElement(name = "result")
        private TestResultResult result;
        @XmlElement(name = "test_device_results")
        private TestDeviceResults testDeviceResults;

        public String getMems() {
            return mems;
        }

        public void setMems(String mems) {
            this.mems = mems;
        }

        public TestResultResult getResult() {
            return result;
        }

        public void setResult(TestResultResult result) {
            this.result = result;
        }

        public TestDeviceResults getTestDeviceResults() {
            return testDeviceResults;
        }

        public void setTestDeviceResults(TestDeviceResults testDeviceResults) {
            this.testDeviceResults = testDeviceResults;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "result")
    public static class TestResultResult {
        @XmlAttribute(name = "mems")
        private String mems;
        @XmlElement(name = "ti_id")
        private TiId tiId;
        @XmlElement(name = "pri_data")
        private PriData priData;
        @XmlElement(name = "pri_result")
        private PriResult priResult;

        public String getMems() {
            return mems;
        }

        public void setMems(String mems) {
            this.mems = mems;
        }

        public TiId getTiId() {
            return tiId;
        }

        public void setTiId(TiId tiId) {
            this.tiId = tiId;
        }

        public PriData getPriData() {
            return priData;
        }

        public void setPriData(PriData priData) {
            this.priData = priData;
        }

        public PriResult getPriResult() {
            return priResult;
        }

        public void setPriResult(PriResult priResult) {
            this.priResult = priResult;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "ti_id")
    public static class TiId {
        @XmlAttribute(name = "type")
        private String type;
        @XmlValue
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "pri_data")
    public static class PriData {
        @XmlAttribute(name = "type")
        private String type;
        @XmlValue
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "pri_result")
    public static class PriResult {
        @XmlAttribute(name = "type")
        private String type;
        @XmlValue
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "test_device_results")
    public static class TestDeviceResults {
        @XmlAttribute(name = "dim")
        private String dim;
        @XmlAttribute(name = "type")
        private String type;
        @XmlElement(name = "test_device_result")
        private List<TestDeviceResult> testDeviceResults;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDim() {
            return dim;
        }

        public void setDim(String dim) {
            this.dim = dim;
        }

        public List<TestDeviceResult> getTestDeviceResults() {
            return testDeviceResults;
        }

        public void setTestDeviceResults(List<TestDeviceResult> testDeviceResults) {
            this.testDeviceResults = testDeviceResults;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "test_device_result")
    public static class TestDeviceResult {
        @XmlAttribute(name = "mems")
        private String mems;
        @XmlElement(name = "tdp_id")
        private TdpId tdpId;
        @XmlElement(name = "tdr_data")
        private TdrData tdrData;
        @XmlElement(name = "tdr_result")
        private TdrResult tdrResult;

        public String getMems() {
            return mems;
        }

        public void setMems(String mems) {
            this.mems = mems;
        }

        public TdpId getTdpId() {
            return tdpId;
        }

        public void setTdpId(TdpId tdpId) {
            this.tdpId = tdpId;
        }

        public TdrData getTdrData() {
            return tdrData;
        }

        public void setTdrData(TdrData tdrData) {
            this.tdrData = tdrData;
        }

        public TdrResult getTdrResult() {
            return tdrResult;
        }

        public void setTdrResult(TdrResult tdrResult) {
            this.tdrResult = tdrResult;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "tdp_id")
    public static class TdpId {
        @XmlAttribute(name = "type")
        private String type;
        @XmlValue
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "tdr_data")
    public static class TdrData {
        @XmlAttribute(name = "type")
        private String type;
        @XmlValue
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "tdr_result")
    public static class TdrResult {
        @XmlAttribute(name = "type")
        private String type;
        @XmlValue
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
