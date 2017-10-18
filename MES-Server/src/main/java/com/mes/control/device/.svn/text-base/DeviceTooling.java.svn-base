package com.mes.control.device;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * 工装信息XML
 * <p>
 * Created by xiuyou.xu on 2017/8/29.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "NewDataSet")
public class DeviceTooling {
    @XmlElement(name = "pre_machine_tb")
    private List<PreMachineTb> preMachineTbs;

    public List<PreMachineTb> getPreMachineTbs() {
        return preMachineTbs;
    }

    public void setPreMachineTbs(List<PreMachineTb> preMachineTbs) {
        this.preMachineTbs = preMachineTbs;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "pre_machine_tb")
    public static class PreMachineTb {
        @XmlElement(name = "machine_id")
        private String machineId;
        @XmlElement(name = "machine_name")
        private String machineName;
        @XmlElement(name = "channel_number")
        private String channelNumber;
        @XmlElement(name = "temperature_sensor")
        private String temperatureSensor;
        @XmlElement(name = "realize_type")
        private String realizeType;

        public String getMachineId() {
            return machineId;
        }

        public void setMachineId(String machineId) {
            this.machineId = machineId;
        }

        public String getMachineName() {
            return machineName;
        }

        public void setMachineName(String machineName) {
            this.machineName = machineName;
        }

        public String getChannelNumber() {
            return channelNumber;
        }

        public void setChannelNumber(String channelNumber) {
            this.channelNumber = channelNumber;
        }

        public String getTemperatureSensor() {
            return temperatureSensor;
        }

        public void setTemperatureSensor(String temperatureSensor) {
            this.temperatureSensor = temperatureSensor;
        }

        public String getRealizeType() {
            return realizeType;
        }

        public void setRealizeType(String realizeType) {
            this.realizeType = realizeType;
        }
    }
}
