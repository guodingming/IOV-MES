package com.mes.dubbo.consumer;


import com.mes.common.framework.spring.ServiceBeanContext;
import com.mes.dubbo.interprovider.control.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ControlConsumer {

    private static final Logger log = LoggerFactory.getLogger(ControlConsumer.class);

    /**
     * 文件传输接口
     */
    public static IFileTransferProvider getFileTransferProvider() {
        IFileTransferProvider fileTransferProvider = null;
        try {
            fileTransferProvider = (IFileTransferProvider) ServiceBeanContext.getInstance().getBean("fileTransferProvider");
        } catch (Exception e) {
            log.error("获取 getFileTransferProvider ServiceBean 失败！  ", e);
        }
        return fileTransferProvider;
    }

    /**
     * 平台管理-工作站Agent管理
     */
    public static IAgentProvider getAgentProvider() {
        IAgentProvider agentProvider = null;
        try {
            agentProvider = (IAgentProvider) ServiceBeanContext.getInstance().getBean("agentProvider");
        } catch (Exception e) {
            log.error("获取 getAgentProvider ServiceBean 失败！  ", e);
        }
        return agentProvider;
    }

    /**
     * 用户管理
     */
    public static IUserProvider getUserProvider() {
        IUserProvider userProvider = null;
        try {
            userProvider = (IUserProvider) ServiceBeanContext.getInstance().getBean("userProvider");
        } catch (Exception e) {
            log.error("获取 getUserProvider ServiceBean 失败！  ", e);
        }
        return userProvider;
    }

    /**
     * 用户管理-人员技能
     */
    public static IUserProcessProvider getUserProcessProvider() {
        IUserProcessProvider userProcessProvider = null;
        try {
            userProcessProvider = (IUserProcessProvider) ServiceBeanContext.getInstance().getBean("userProcessProvider");
        } catch (Exception e) {
            log.error("获取 getUserProcessProvider ServiceBean 失败！  ", e);
        }
        return userProcessProvider;
    }

    /**
     * 角色管理
     */
    public static IRoleProvider getRoleProvider() {
        IRoleProvider roleProvider = null;
        try {
            roleProvider = (IRoleProvider) ServiceBeanContext.getInstance().getBean("roleProvider");
        } catch (Exception e) {
            log.error("获取 getRoleProvider ServiceBean 失败！  ", e);
        }
        return roleProvider;
    }

    /**
     * 用户组管理
     */
    public static IUserGroupProvider getUserGroupProvider() {
        IUserGroupProvider userGroupProvider = null;
        try {
            userGroupProvider = (IUserGroupProvider) ServiceBeanContext.getInstance().getBean("userGroupProvider");
        } catch (Exception e) {
            log.error("获取 getUserGroupProvider ServiceBean 失败！  ", e);
        }
        return userGroupProvider;
    }

    /**
     * 部门管理
     */
    public static IDeptProvider getDeptProvider() {
        IDeptProvider deptProvider = null;
        try {
            deptProvider = (IDeptProvider) ServiceBeanContext.getInstance().getBean("deptProvider");
        } catch (Exception e) {
            log.error("获取 getDeptProvider ServiceBean 失败！  ", e);
        }
        return deptProvider;
    }

    /**
     * 工厂管理-企业登记
     */
    public static IFtyEnterpriseProvider getFtyEnterpriseProvider() {
        IFtyEnterpriseProvider ftyEnterpriseProvider = null;
        try {
            ftyEnterpriseProvider = (IFtyEnterpriseProvider) ServiceBeanContext.getInstance().getBean("ftyEnterpriseProvider");
        } catch (Exception e) {
            log.error("获取 getFtyEnterpriseProvider ServiceBean 失败！  ", e);
        }
        return ftyEnterpriseProvider;
    }

    /**
     * 工厂管理-工厂信息
     */
    public static IFtySiteInfoProvider getFtySiteInfoProvider() {
        IFtySiteInfoProvider ftySiteInfoProvider = null;
        try {
            ftySiteInfoProvider = (IFtySiteInfoProvider) ServiceBeanContext.getInstance().getBean("ftySiteInfoProvider");
        } catch (Exception e) {
            log.error("获取 getFtySiteInfoProvider ServiceBean 失败！  ", e);
        }
        return ftySiteInfoProvider;
    }

    /**
     * 工厂管理-车间管理
     */
    public static IFtyAreaProvider getFtyAreaProvider() {
        IFtyAreaProvider ftyAreaProvider = null;
        try {
            ftyAreaProvider = (IFtyAreaProvider) ServiceBeanContext.getInstance().getBean("ftyAreaProvider");
        } catch (Exception e) {
            log.error("获取 getFtyAreaProvider ServiceBean 失败！  ", e);
        }
        return ftyAreaProvider;
    }

    /**
     * 工作中心管理-（Work center）
     */
    public static IFtyWorkCenterProvider getFtyWorkCenterProvider() {
        IFtyWorkCenterProvider ftyWorkCenterProvider = null;
        try {
            ftyWorkCenterProvider = (IFtyWorkCenterProvider) ServiceBeanContext.getInstance().getBean("ftyWorkCenterProvider");
        } catch (Exception e) {
            log.error("获取 getFtyWorkCenterProvider ServiceBean 失败！  ", e);
        }
        return ftyWorkCenterProvider;
    }

    /**
     * 工厂管理-设备管理
     */
    public static IFtyDeviceProvider getFtyDeviceProvider() {
        IFtyDeviceProvider ftyDeviceProvider = null;
        try {
            ftyDeviceProvider = (IFtyDeviceProvider) ServiceBeanContext.getInstance().getBean("ftyDeviceProvider");
        } catch (Exception e) {
            log.error("获取 getFtyDeviceProvider ServiceBean 失败！  ", e);
        }
        return ftyDeviceProvider;
    }

    /**
     * 生产线管理-Production Line
     */
    public static IFtyProductionLineProvider getFtyProductionLineProvider() {
        IFtyProductionLineProvider ftyProductionLineProvider = null;
        try {
            ftyProductionLineProvider = (IFtyProductionLineProvider) ServiceBeanContext.getInstance().getBean("ftyProductionLineProvider");
        } catch (Exception e) {
            log.error("获取 getFtyProductionLineProvider ServiceBean 失败！  ", e);
        }
        return ftyProductionLineProvider;
    }

    public static IPdProductionLineInfoProvider getPdProductionLineInfoProvider() {
        IPdProductionLineInfoProvider pdProductionLineInfoProvider = null;
        try {
            pdProductionLineInfoProvider = (IPdProductionLineInfoProvider) ServiceBeanContext.getInstance().getBean("pdProductionLineInfoProvider");
        } catch (Exception e) {
            log.error("获取 getPdProductionLineInfoProvider ServiceBean 失败！  ", e);
        }
        return pdProductionLineInfoProvider;
    }


    /**
     * 产品管理-产品
     */
    public static IPdProvider getPdProvider() {
        IPdProvider pdProvider = null;
        try {
            pdProvider = (IPdProvider) ServiceBeanContext.getInstance().getBean("pdProvider");
        } catch (Exception e) {
            log.error("获取 getPdProvider ServiceBean 失败！  ", e);
        }
        return pdProvider;
    }

    /**
     * 开发平台-产品明细（按工单移）
     */
    public static IPdProductInfoProvider getPdProductInfoProvider() {
        IPdProductInfoProvider pdProductInfoProvider = null;
        try {
            pdProductInfoProvider = (IPdProductInfoProvider) ServiceBeanContext.getInstance().getBean("pdProductInfoProvider");
        } catch (Exception e) {
            log.error("获取 getPdProductInfoProvider ServiceBean 失败！  ", e);
        }
        return pdProductInfoProvider;
    }

    /**
     * 开发平台-表单类型管理
     */
    public static IDpFormTypeProvider getDpFormTypeProvider() {
        IDpFormTypeProvider dpFormTypeProvider = null;
        try {
            dpFormTypeProvider = (IDpFormTypeProvider) ServiceBeanContext.getInstance().getBean("dpFormTypeProvider");
        } catch (Exception e) {
            log.error("获取 getDpFormTypeProvider ServiceBean 失败！  ", e);
        }
        return dpFormTypeProvider;
    }

    /**
     * 元数据
     */
    public static IMetadataProvider getMetadataProvider() {
        IMetadataProvider metadataProvider = null;
        try {
            metadataProvider = (IMetadataProvider) ServiceBeanContext.getInstance().getBean("metadataProvider");
        } catch (Exception e) {
            log.error("获取 getMetadataProvider ServiceBean 失败！  ", e);
        }
        return metadataProvider;
    }

    /**
     * 开发平台-服务管理
     */
    public static IDpServiceProvider getDpServiceProvider() {
        IDpServiceProvider dpServiceProvider = null;
        try {
            dpServiceProvider = (IDpServiceProvider) ServiceBeanContext.getInstance().getBean("dpServiceProvider");
        } catch (Exception e) {
            log.error("获取 getDpServiceProvider ServiceBean 失败！  ", e);
        }
        return dpServiceProvider;
    }

    /**
     * 开发平台-条码规则分类
     */
    public static IPdBarcodeRuleTypeProvider getPdBarcodeRuleTypeProvider() {
        IPdBarcodeRuleTypeProvider pdBarcodeRuleTypeProvider = null;
        try {
            pdBarcodeRuleTypeProvider = (IPdBarcodeRuleTypeProvider) ServiceBeanContext.getInstance().getBean("pdBarcodeRuleTypeProvider");
        } catch (Exception e) {
            log.error("获取 getPdBarcodeRuleTypeProvider ServiceBean 失败！  ", e);
        }
        return pdBarcodeRuleTypeProvider;
    }

    /**
     * 产品管理-条码规则设置
     */
    public static IPdBarcodeRuleProvider getPdBarcodeRuleProvider() {
        IPdBarcodeRuleProvider pdBarcodeRuleProvider = null;
        try {
            pdBarcodeRuleProvider = (IPdBarcodeRuleProvider) ServiceBeanContext.getInstance().getBean("pdBarcodeRuleProvider");
        } catch (Exception e) {
            log.error("获取 getPdBarcodeRuleProvider ServiceBean 失败！  ", e);
        }
        return pdBarcodeRuleProvider;
    }

    /**
     * 工作站管理-（workstation ）
     */
    public static IFtyWorkstationProvider getFtyWorkstationProvider() {
        IFtyWorkstationProvider ftyWorkstationProvider = null;
        try {
            ftyWorkstationProvider = (IFtyWorkstationProvider) ServiceBeanContext.getInstance().getBean("ftyWorkstationProvider");
        } catch (Exception e) {
            log.error("获取 getFtyWorkstationProvider ServiceBean 失败！  ", e);
        }
        return ftyWorkstationProvider;
    }

    /**
     * 工厂管理-设备附件
     */
    public static IFtyDeviceAnnexProvider getFtyDeviceAnnexProvider() {
        IFtyDeviceAnnexProvider ftyDeviceAnnexProvider = null;
        try {
            ftyDeviceAnnexProvider = (IFtyDeviceAnnexProvider) ServiceBeanContext.getInstance().getBean("ftyDeviceAnnexProvider");
        } catch (Exception e) {
            log.error("获取 getFtyDeviceAnnexProvider ServiceBean 失败！  ", e);
        }
        return ftyDeviceAnnexProvider;
    }

    /**
     * 工厂管理-（治具/工装/其他）
     */
    public static IFtyDeviceAnnexInfoProvider getFtyDeviceAnnexInfoProvider() {
        IFtyDeviceAnnexInfoProvider ftyDeviceAnnexInfoProvider = null;
        try {
            ftyDeviceAnnexInfoProvider = (IFtyDeviceAnnexInfoProvider) ServiceBeanContext.getInstance().getBean("ftyDeviceAnnexInfoProvider");
        } catch (Exception e) {
            log.error("获取 getFtyDeviceAnnexInfoProvider ServiceBean 失败！  ", e);
        }
        return ftyDeviceAnnexInfoProvider;
    }

    /**
     * 工厂管理-设备耗品
     */
    public static IFtyDeviceConsumablesProvider getFtyDeviceConsumablesProvider() {
        IFtyDeviceConsumablesProvider ftyDeviceConsumablesProvider = null;
        try {
            ftyDeviceConsumablesProvider = (IFtyDeviceConsumablesProvider) ServiceBeanContext.getInstance().getBean("ftyDeviceConsumablesProvider");
        } catch (Exception e) {
            log.error("获取 getFtyDeviceConsumablesProvider ServiceBean 失败！  ", e);
        }
        return ftyDeviceConsumablesProvider;
    }

    /**
     * 工厂管理-工序-设备
     */
    public static IFtyDeviceProcessProvider getFtyDeviceProcessProvider() {
        IFtyDeviceProcessProvider ftyDeviceProcessProvider = null;
        try {
            ftyDeviceProcessProvider = (IFtyDeviceProcessProvider) ServiceBeanContext.getInstance().getBean("ftyDeviceProcessProvider");
        } catch (Exception e) {
            log.error("获取 getFtyDeviceProcessProvider ServiceBean 失败！  ", e);
        }
        return ftyDeviceProcessProvider;
    }

    /**
     * 扩展表配置
     */
    public static IExpandTableConfigProvider getExpandTableConfigProvider() {
        IExpandTableConfigProvider expandTableConfigProvider = null;
        try {
            expandTableConfigProvider = (IExpandTableConfigProvider) ServiceBeanContext.getInstance().getBean("expandTableConfigProvider");
        } catch (Exception e) {
            log.error("获取 getExpandTableConfigProvider ServiceBean 失败！  ", e);
        }
        return expandTableConfigProvider;
    }

    /**
     * 主表
     */
    public static ITableProvider getTableProvider() {
        ITableProvider tableProvider = null;
        try {
            tableProvider = (ITableProvider) ServiceBeanContext.getInstance().getBean("tableProvider");
        } catch (Exception e) {
            log.error("获取 getTableProvider ServiceBean 失败！  ", e);
        }
        return tableProvider;
    }

    /**
     * 产品管理-产品线
     */
    public static IPdLineProvider getPdLineProvider() {
        IPdLineProvider pdLineProvider = null;
        try {
            pdLineProvider = (IPdLineProvider) ServiceBeanContext.getInstance().getBean("pdLineProvider");
        } catch (Exception e) {
            log.error("获取 getPdLineProvider ServiceBean 失败！  ", e);
        }
        return pdLineProvider;
    }

    /**
     * 产品管理-产品订单管理
     */
    public static IPdOrderProvider getPdOrderProvider() {
        IPdOrderProvider pdOrderProvider = null;
        try {
            pdOrderProvider = (IPdOrderProvider) ServiceBeanContext.getInstance().getBean("pdOrderProvider");
        } catch (Exception e) {
            log.error("获取 getPdOrderProvider ServiceBean 失败！  ", e);
        }
        return pdOrderProvider;
    }

    /**
     * 产品管理-班次类型
     */
    public static IPdSchedulingTypeProvider getPdSchedulingTypeProvider() {
        IPdSchedulingTypeProvider pdSchedulingTypeProvider = null;
        try {
            pdSchedulingTypeProvider = (IPdSchedulingTypeProvider) ServiceBeanContext.getInstance().getBean("pdSchedulingTypeProvider");
        } catch (Exception e) {
            log.error("获取 getPdSchedulingTypeProvider ServiceBean 失败！  ", e);
        }
        return pdSchedulingTypeProvider;
    }

    /**
     * 产品管理-排班-人员
     */
    public static IPdSchedulingProvider getPdSchedulingProvider() {
        IPdSchedulingProvider pdSchedulingProvider = null;
        try {
            pdSchedulingProvider = (IPdSchedulingProvider) ServiceBeanContext.getInstance().getBean("pdSchedulingProvider");
        } catch (Exception e) {
            log.error("获取 getPdSchedulingProvider ServiceBean 失败！  ", e);
        }
        return pdSchedulingProvider;
    }

    /**
     * 产品管理-工单管理
     */
    public static IPdWorkOrderProvider getPdWorkOrderProvider() {
        IPdWorkOrderProvider pdWorkOrderProvider = null;
        try {
            pdWorkOrderProvider = (IPdWorkOrderProvider) ServiceBeanContext.getInstance().getBean("pdWorkOrderProvider");
        } catch (Exception e) {
            log.error("获取 getPdWorkOrderProvider ServiceBean 失败！  ", e);
        }
        return pdWorkOrderProvider;
    }

    /**
     * 产品管理-工单BOM管理用量
     */
    public static IPdBomWorkAmountProvider getPdBomWorkAmountProvider() {
        IPdBomWorkAmountProvider pdBomWorkAmountProvider = null;
        try {
            pdBomWorkAmountProvider = (IPdBomWorkAmountProvider) ServiceBeanContext.getInstance().getBean("pdBomWorkAmountProvider");
        } catch (Exception e) {
            log.error("获取 getPdBomWorkAmountProvider ServiceBean 失败！  ", e);
        }
        return pdBomWorkAmountProvider;
    }

    /**
     * 产品管理-BOM替换料
     */
    public static IPdBomMaterialsReplaceProvider getPdBomMaterialsReplaceProvider() {
        IPdBomMaterialsReplaceProvider pdBomMaterialsReplaceProvider = null;
        try {
            pdBomMaterialsReplaceProvider = (IPdBomMaterialsReplaceProvider) ServiceBeanContext.getInstance().getBean("pdBomMaterialsReplaceProvider");
        } catch (Exception e) {
            log.error("获取 getPdBomMaterialsReplaceProvider ServiceBean 失败！  ", e);
        }
        return pdBomMaterialsReplaceProvider;
    }

    /**
     * 产品管理--产品生产工序
     */
    public static IDpProduceProcessProvider getDpProduceProcessProvider() {
        IDpProduceProcessProvider dpProduceProcessProvider = null;
        try {
            dpProduceProcessProvider = (IDpProduceProcessProvider) ServiceBeanContext.getInstance().getBean("dpProduceProcessProvider");
        } catch (Exception e) {
            log.error("获取 getDpProduceProcessProvider ServiceBean 失败！  ", e);
        }
        return dpProduceProcessProvider;
    }

    /**
     * 开发平台-工艺路径管理（Routes）
     */
    public static IDpRoutesProvider getDpRoutesProvider() {
        IDpRoutesProvider dpRoutesProvider = null;
        try {
            dpRoutesProvider = (IDpRoutesProvider) ServiceBeanContext.getInstance().getBean("dpRoutesProvider");
        } catch (Exception e) {
            log.error("获取 getDpRoutesProvider ServiceBean 失败！  ", e);
        }
        return dpRoutesProvider;
    }

    /**
     * 开发平台-表单
     */
    public static IDpFormProvider getDpFormProvider() {
        IDpFormProvider dpFormProvider = null;
        try {
            dpFormProvider = (IDpFormProvider) ServiceBeanContext.getInstance().getBean("dpFormProvider");
        } catch (Exception e) {
            log.error("获取 getDpFormProvider ServiceBean 失败！  ", e);
        }
        return dpFormProvider;
    }

    /**
     * 开发平台-生产工序配置属性
     */
    public static IDpProduceProcessConfigProvider getDpProduceProcessConfigProvider() {
        IDpProduceProcessConfigProvider dpProduceProcessConfigProvider = null;
        try {
            dpProduceProcessConfigProvider = (IDpProduceProcessConfigProvider) ServiceBeanContext.getInstance().getBean("dpProduceProcessConfigProvider");
        } catch (Exception e) {
            log.error("获取 getDpProduceProcessConfigProvider ServiceBean 失败！  ", e);
        }
        return dpProduceProcessConfigProvider;
    }

    /**
     * 开发平台-产品测试项
     */
    public static IDpProductTestLogProvider getDpProductTestLogProvider() {
        IDpProductTestLogProvider dpProductTestLogProvider = null;
        try {
            dpProductTestLogProvider = (IDpProductTestLogProvider) ServiceBeanContext.getInstance().getBean("dpProductTestLogProvider");
        } catch (Exception e) {
            log.error("获取 getDpProductTestLogProvider ServiceBean 失败！  ", e);
        }
        return dpProductTestLogProvider;
    }

    /**
     * 开发平台-产品生产工序记录
     */
    public static IDpProductInfoLogProvider getDpProductInfoLogProvider() {
        IDpProductInfoLogProvider dpProductInfoLogProvider = null;
        try {
            dpProductInfoLogProvider = (IDpProductInfoLogProvider) ServiceBeanContext.getInstance().getBean("dpProductInfoLogProvider");
        } catch (Exception e) {
            log.error("获取 getDpProductInfoLogProvider ServiceBean 失败！  ", e);
        }
        return dpProductInfoLogProvider;
    }

    /**
     * 开发平台-上料管理
     */
    public static IDpMaterialsInfoProvider getDpMaterialsInfoProvider() {
        IDpMaterialsInfoProvider dpMaterialsInfoProvider = null;
        try {
            dpMaterialsInfoProvider = (IDpMaterialsInfoProvider) ServiceBeanContext.getInstance().getBean("dpMaterialsInfoProvider");
        } catch (Exception e) {
            log.error("获取 getDpMaterialsInfoProvider ServiceBean 失败！  ", e);
        }
        return dpMaterialsInfoProvider;
    }

    /**
     * 产品管理-生产BOM管理用量
     */
    public static IPdBomProduceAmountProvider getPdBomProduceAmountProvider() {
        IPdBomProduceAmountProvider pdBomProduceAmountProvider = null;
        try {
            pdBomProduceAmountProvider = (IPdBomProduceAmountProvider) ServiceBeanContext.getInstance().getBean("pdBomProduceAmountProvider");
        } catch (Exception e) {
            log.error("获取 getPdBomProduceAmountProvider ServiceBean 失败！  ", e);
        }
        return pdBomProduceAmountProvider;
    }

    /**
     * 排班管理-班次人员
     */
    public static IPdSchedulingPersonnelProvider getPdSchedulingPersonnelProvider() {
        IPdSchedulingPersonnelProvider pdSchedulingPersonnelProvider = null;
        try {
            pdSchedulingPersonnelProvider = (IPdSchedulingPersonnelProvider) ServiceBeanContext.getInstance().getBean("pdSchedulingPersonnelProvider");
        } catch (Exception e) {
            log.error("获取 getPdSchedulingPersonnelProvider ServiceBean 失败！  ", e);
        }
        return pdSchedulingPersonnelProvider;
    }

    /**
     * 文件分类管理
     */
    public static IPdFileTypeProvider getPdFileTypeProvider() {
        IPdFileTypeProvider pdFileTypeProvider = null;
        try {
            pdFileTypeProvider = (IPdFileTypeProvider) ServiceBeanContext.getInstance().getBean("pdFileTypeProvider");
        } catch (Exception e) {
            log.error("获取 getPdFileTypeProvider ServiceBean 失败！  ", e);
        }
        return pdFileTypeProvider;
    }

    /**
     * 资源文件管理
     */
    public static IPdFileResourcesProvider getPdFileResourcesProvider() {
        IPdFileResourcesProvider pdFileResourcesProvider = null;
        try {
            pdFileResourcesProvider = (IPdFileResourcesProvider) ServiceBeanContext.getInstance().getBean("pdFileResourcesProvider");
        } catch (Exception e) {
            log.error("获取 getPdFileResourcesProvider ServiceBean 失败！  ", e);
        }
        return pdFileResourcesProvider;
    }

    /**
     * 工厂管理-工序
     */
    public static IFtyProcessProvider getFtyProcessProvider() {
        IFtyProcessProvider ftyProcessProvider = null;
        try {
            ftyProcessProvider = (IFtyProcessProvider) ServiceBeanContext.getInstance().getBean("ftyProcessProvider");
        } catch (Exception e) {
            log.error("获取 getFtyProcessProvider ServiceBean 失败！  ", e);
        }
        return ftyProcessProvider;
    }

    /**
     * 工厂管理-工序-设备-附件
     */
    public static IFtyDeviceProcessAnnexProvider getFtyDeviceProcessAnnexProvider() {
        IFtyDeviceProcessAnnexProvider ftyDeviceProcessAnnexProvider = null;
        try {
            ftyDeviceProcessAnnexProvider = (IFtyDeviceProcessAnnexProvider) ServiceBeanContext.getInstance().getBean("ftyDeviceProcessAnnexProvider");
        } catch (Exception e) {
            log.error("获取 getFtyDeviceProcessAnnexProvider ServiceBean 失败！  ", e);
        }
        return ftyDeviceProcessAnnexProvider;
    }

    /**
     * 设备管理-设备-工序-附件
     */
    public static IFtyDeviceProcessAnnexAssociationProvider getFtyDeviceProcessAnnexAssociationProvider() {
        IFtyDeviceProcessAnnexAssociationProvider ftyDeviceProcessAnnexAssociationProvider = null;
        try {
            ftyDeviceProcessAnnexAssociationProvider = (IFtyDeviceProcessAnnexAssociationProvider) ServiceBeanContext.getInstance().getBean("ftyDeviceProcessAnnexAssociationProvider");
        } catch (Exception e) {
            log.error("获取 getFtyDeviceProcessAnnexAssociationProvider ServiceBean 失败！  ", e);
        }
        return ftyDeviceProcessAnnexAssociationProvider;
    }

    /**
     * 工厂管理-设备配置-字典分类
     */
    public static IFtyDeviceConfigTypeProvider getFtyDeviceConfigTypeProvider() {
        IFtyDeviceConfigTypeProvider ftyDeviceConfigTypeProvider = null;
        try {
            ftyDeviceConfigTypeProvider = (IFtyDeviceConfigTypeProvider) ServiceBeanContext.getInstance().getBean("ftyDeviceConfigTypeProvider");
        } catch (Exception e) {
            log.error("获取 getFtyDeviceConfigTypeProvider ServiceBean 失败！  ", e);
        }
        return ftyDeviceConfigTypeProvider;
    }

    /**
     * 工厂管理-设备配置信息详情
     */
    public static IFtyDeviceConfigInfoProvider getFtyDeviceConfigInfoProvider() {
        IFtyDeviceConfigInfoProvider ftyDeviceConfigInfoProvider = null;
        try {
            ftyDeviceConfigInfoProvider = (IFtyDeviceConfigInfoProvider) ServiceBeanContext.getInstance().getBean("ftyDeviceConfigInfoProvider");
        } catch (Exception e) {
            log.error("获取 getFtyDeviceConfigInfoProvider ServiceBean 失败！  ", e);
        }
        return ftyDeviceConfigInfoProvider;
    }

    /**
     * 工厂管理-设备配置设置
     */
    public static IFtyDeviceConfigProvider getFtyDeviceConfigProvider() {
        IFtyDeviceConfigProvider ftyDeviceConfigProvider = null;
        try {
            ftyDeviceConfigProvider = (IFtyDeviceConfigProvider) ServiceBeanContext.getInstance().getBean("ftyDeviceConfigProvider");
        } catch (Exception e) {
            log.error("获取 getFtyDeviceConfigProvider ServiceBean 失败！  ", e);
        }
        return ftyDeviceConfigProvider;
    }

    /**
     * 工厂管理-设备异常管理
     */
    public static IFtyDeviceFaultProvider getFtyDeviceFaultProvider() {
        IFtyDeviceFaultProvider ftyDeviceFaultProvider = null;
        try {
            ftyDeviceFaultProvider = (IFtyDeviceFaultProvider) ServiceBeanContext.getInstance().getBean("ftyDeviceFaultProvider");
        } catch (Exception e) {
            log.error("获取 getFtyDeviceFaultProvider ServiceBean 失败！  ", e);
        }
        return ftyDeviceFaultProvider;
    }

    /**
     * 工厂管理-设备异常管理-故障字典
     */
    public static IFtyDeviceFaultInfoProvider getFtyDeviceFaultInfoProvider() {
        IFtyDeviceFaultInfoProvider ftyDeviceFaultInfoProvider = null;
        try {
            ftyDeviceFaultInfoProvider = (IFtyDeviceFaultInfoProvider) ServiceBeanContext.getInstance().getBean("ftyDeviceFaultInfoProvider");
        } catch (Exception e) {
            log.error("获取 getFtyDeviceFaultInfoProvider ServiceBean 失败！  ", e);
        }
        return ftyDeviceFaultInfoProvider;
    }

    /**
     * 工厂管理-故障影响-工序
     */
    public static IFtyDeviceFaultProcessProvider getFtyDeviceFaultProcessProvider() {
        IFtyDeviceFaultProcessProvider ftyDeviceFaultProcessProvider = null;
        try {
            ftyDeviceFaultProcessProvider = (IFtyDeviceFaultProcessProvider) ServiceBeanContext.getInstance().getBean("ftyDeviceFaultProcessProvider");
        } catch (Exception e) {
            log.error("获取 getFtyDeviceFaultProcessProvider ServiceBean 失败！  ", e);
        }
        return ftyDeviceFaultProcessProvider;
    }

    /**
     * 开发平台-工序基础配置
     */
    public static IDpProcessBaseConfigProvider getDpProcessBaseConfigProvider() {
        IDpProcessBaseConfigProvider dpProcessBaseConfigProvider = null;
        try {
            dpProcessBaseConfigProvider = (IDpProcessBaseConfigProvider) ServiceBeanContext.getInstance().getBean("dpProcessBaseConfigProvider");
        } catch (Exception e) {
            log.error("获取 getDpProcessBaseConfigProvider ServiceBean 失败！  ", e);
        }
        return dpProcessBaseConfigProvider;
    }

    /**
     * 开发平台-设备配置-工序-设备附件
     */
    public static IDpProduceProcessDeviceAnnexProvider getDpProduceProcessDeviceAnnexProvider() {
        IDpProduceProcessDeviceAnnexProvider dpProduceProcessDeviceAnnexProvider = null;
        try {
            dpProduceProcessDeviceAnnexProvider = (IDpProduceProcessDeviceAnnexProvider) ServiceBeanContext.getInstance().getBean("dpProduceProcessDeviceAnnexProvider");
        } catch (Exception e) {
            log.error("获取 getDpProduceProcessDeviceAnnexProvider ServiceBean 失败！  ", e);
        }
        return dpProduceProcessDeviceAnnexProvider;
    }

    /**
     * 开发平台-设备配置信息
     */
    public static IDpProduceProcessDeviceConfigProvider getDpProduceProcessDeviceConfigProvider() {
        IDpProduceProcessDeviceConfigProvider dpProduceProcessDeviceConfigProvider = null;
        try {
            dpProduceProcessDeviceConfigProvider = (IDpProduceProcessDeviceConfigProvider) ServiceBeanContext.getInstance().getBean("dpProduceProcessDeviceConfigProvider");
        } catch (Exception e) {
            log.error("获取 getDpProduceProcessDeviceConfigProvider ServiceBean 失败！  ", e);
        }
        return dpProduceProcessDeviceConfigProvider;
    }

    /**
     * 开发平台-设备配置信息-工单
     */
    public static IDpProduceProcessConfigWorkorderProvider getDpProduceProcessConfigWorkorderProvider() {
        IDpProduceProcessConfigWorkorderProvider dpProduceProcessConfigWorkorderProvider = null;
        try {
            dpProduceProcessConfigWorkorderProvider = (IDpProduceProcessConfigWorkorderProvider) ServiceBeanContext.getInstance().getBean("dpProduceProcessConfigWorkorderProvider");
        } catch (Exception e) {
            log.error("获取 getDpProduceProcessConfigWorkorderProvider ServiceBean 失败！  ", e);
        }
        return dpProduceProcessConfigWorkorderProvider;
    }

    /**
     * 开发平台-服务分类
     */
    public static IDpServiceTypeProvider getDpServiceTypeProvider() {
        IDpServiceTypeProvider dpServiceTypeProvider = null;
        try {
            dpServiceTypeProvider = (IDpServiceTypeProvider) ServiceBeanContext.getInstance().getBean("dpServiceTypeProvider");
        } catch (Exception e) {
            log.error("获取 getDpServiceTypeProvider ServiceBean 失败！  ", e);
        }
        return dpServiceTypeProvider;
    }

    /**
     * 开发平台-服务日志
     */
    public static IDpServiceLogProvider getDpServiceLogProvider() {
        IDpServiceLogProvider dpServiceLogProvider = null;
        try {
            dpServiceLogProvider = (IDpServiceLogProvider) ServiceBeanContext.getInstance().getBean("dpServiceLogProvider");
        } catch (Exception e) {
            log.error("获取 getDpServiceLogProvider ServiceBean 失败！  ", e);
        }
        return dpServiceLogProvider;
    }

    /**
     * 开发平台-函数分类
     */
    public static IDpFunctionTypeProvider getDpFunctionTypeProvider() {
        IDpFunctionTypeProvider dpFunctionTypeProvider = null;
        try {
            dpFunctionTypeProvider = (IDpFunctionTypeProvider) ServiceBeanContext.getInstance().getBean("dpFunctionTypeProvider");
        } catch (Exception e) {
            log.error("获取 getDpFunctionTypeProvider ServiceBean 失败！  ", e);
        }
        return dpFunctionTypeProvider;
    }

    /**
     * 开发平台-脚本
     */
    public static IDpFunctionProvider getDpFunctionProvider() {
        IDpFunctionProvider dpFunctionProvider = null;
        try {
            dpFunctionProvider = (IDpFunctionProvider) ServiceBeanContext.getInstance().getBean("dpFunctionProvider");
        } catch (Exception e) {
            log.error("获取 getDpFunctionProvider ServiceBean 失败！  ", e);
        }
        return dpFunctionProvider;
    }

    /**
     * 工厂管理-设备-工作站
     */
    public static IFtyWorkstationDeviceProvider getFtyWorkstationDeviceProvider() {
        IFtyWorkstationDeviceProvider ftyWorkstationDeviceProvider = null;
        try {
            ftyWorkstationDeviceProvider = (IFtyWorkstationDeviceProvider) ServiceBeanContext.getInstance().getBean("ftyWorkstationDeviceProvider");
        } catch (Exception e) {
            log.error("获取 getFtyWorkstationDeviceProvider ServiceBean 失败！  ", e);
        }
        return ftyWorkstationDeviceProvider;
    }

    /**
     * 产品管理-物料清单
     */
    public static IPdBomMaterialsProvider getPdBomMaterialsProvider() {
        IPdBomMaterialsProvider pdBomMaterialsProvider = null;
        try {
            pdBomMaterialsProvider = (IPdBomMaterialsProvider) ServiceBeanContext.getInstance().getBean("pdBomMaterialsProvider");
        } catch (Exception e) {
            log.error("获取 getPdBomMaterialsProvider ServiceBean 失败！  ", e);
        }
        return pdBomMaterialsProvider;
    }

    /**
     * 工厂管理-设备分类
     */
    public static IFtyDeviceTypeProvider getFtyDeviceTypeProvider() {
        IFtyDeviceTypeProvider ftyDeviceTypeProvider = null;
        try {
            ftyDeviceTypeProvider = (IFtyDeviceTypeProvider) ServiceBeanContext.getInstance().getBean("ftyDeviceTypeProvider");
        } catch (Exception e) {
            log.error("获取 getFtyDeviceTypeProvider ServiceBean 失败！  ", e);
        }
        return ftyDeviceTypeProvider;
    }

    /**
     * 产品管理-BOM-附属信息
     */
    public static IPdBomAffiliatedProvider getPdBomAffiliatedProvider() {
        IPdBomAffiliatedProvider pdBomAffiliatedProvider = null;
        try {
            pdBomAffiliatedProvider = (IPdBomAffiliatedProvider) ServiceBeanContext.getInstance().getBean("pdBomAffiliatedProvider");
        } catch (Exception e) {
            log.error("获取 getPdBomAffiliatedProvider ServiceBean 失败！  ", e);
        }
        return pdBomAffiliatedProvider;
    }

    /**
     * 产品管理-生产BOM管理
     */
    public static IPdBomProduceProvider getPdBomProduceProvider() {
        IPdBomProduceProvider pdBomProduceProvider = null;
        try {
            pdBomProduceProvider = (IPdBomProduceProvider) ServiceBeanContext.getInstance().getBean("pdBomProduceProvider");
        } catch (Exception e) {
            log.error("获取 getPdBomProduceProvider ServiceBean 失败！  ", e);
        }
        return pdBomProduceProvider;
    }

    /**
     * 产品管理-工单BOM管理
     */
    public static IPdBomWorkProvider getPdBomWorkProvider() {
        IPdBomWorkProvider pdBomWorkProvider = null;
        try {
            pdBomWorkProvider = (IPdBomWorkProvider) ServiceBeanContext.getInstance().getBean("pdBomWorkProvider");
        } catch (Exception e) {
            log.error("获取 getPdBomWorkProvider ServiceBean 失败！  ", e);
        }
        return pdBomWorkProvider;
    }

    /**
     * 产品管理-工单批次
     */
    public static IPdWorkOrderBatchProvider getPdWorkOrderBatchProvider() {
        IPdWorkOrderBatchProvider pdWorkOrderBatchProvider = null;
        try {
            pdWorkOrderBatchProvider = (IPdWorkOrderBatchProvider) ServiceBeanContext.getInstance().getBean("pdWorkOrderBatchProvider");
        } catch (Exception e) {
            log.error("获取 getPdWorkOrderBatchProvider ServiceBean 失败！  ", e);
        }
        return pdWorkOrderBatchProvider;
    }

    /**
     * 产品管理--排班-设备
     */
    public static IPdSchedulingDeviceProvider getPdSchedulingDeviceProvider() {
        IPdSchedulingDeviceProvider pdSchedulingDeviceProvider = null;
        try {
            pdSchedulingDeviceProvider = (IPdSchedulingDeviceProvider) ServiceBeanContext.getInstance().getBean("pdSchedulingDeviceProvider");
        } catch (Exception e) {
            log.error("获取 getPdSchedulingDeviceProvider ServiceBean 失败！  ", e);
        }
        return pdSchedulingDeviceProvider;
    }

    /**
     * 开发平台--开发工程
     */
    public static IDpProjectProvider getDpProjectProvider() {
        IDpProjectProvider dpProjectProvider = null;
        try {
            dpProjectProvider = (IDpProjectProvider) ServiceBeanContext.getInstance().getBean("dpProjectProvider");
        } catch (Exception e) {
            log.error("获取 getDpProjectProvider ServiceBean 失败！  ", e);
        }
        return dpProjectProvider;
    }

    /**
     * 生产工序-设备
     */
    public static IDpProduceProcessDeviceProvider getDpProduceProcessDeviceProvider() {
        IDpProduceProcessDeviceProvider dpProduceProcessDeviceProvider = null;
        try {
            dpProduceProcessDeviceProvider = (IDpProduceProcessDeviceProvider) ServiceBeanContext.getInstance().getBean("dpProduceProcessDeviceProvider");
        } catch (Exception e) {
            log.error("获取 getDpProduceProcessDeviceProvider ServiceBean 失败！  ", e);
        }
        return dpProduceProcessDeviceProvider;
    }

    /**
     * 开发平台--工序基础配置属性
     */
    public static IDpProcessConfigProvider getDpProcessConfigProvider() {
        IDpProcessConfigProvider dpProcessConfigProvider = null;
        try {
            dpProcessConfigProvider = (IDpProcessConfigProvider) ServiceBeanContext.getInstance().getBean("dpProcessConfigProvider");
        } catch (Exception e) {
            log.error("获取 getDpProcessConfigProvider ServiceBean 失败！  ", e);
        }
        return dpProcessConfigProvider;
    }

    /**
     * 开发平台-数据字典类型
     */
    public static IDpDataDictionaryTypeProvider getDpDataDictionaryTypeProvider() {
        IDpDataDictionaryTypeProvider dpDataDictionaryTypeProvider = null;
        try {
            dpDataDictionaryTypeProvider = (IDpDataDictionaryTypeProvider) ServiceBeanContext.getInstance().getBean("dpDataDictionaryTypeProvider");
        } catch (Exception e) {
            log.error("获取 getDpDataDictionaryTypeProvider ServiceBean 失败！  ", e);
        }
        return dpDataDictionaryTypeProvider;
    }

    /**
     * 开发平台-数据字典表
     */
    public static IDpDataDictionaryProvider getDpDataDictionaryProvider() {
        IDpDataDictionaryProvider dpDataDictionaryProvider = null;
        try {
            dpDataDictionaryProvider = (IDpDataDictionaryProvider) ServiceBeanContext.getInstance().getBean("dpDataDictionaryProvider");
        } catch (Exception e) {
            log.error("获取 getDpDataDictionaryProvider ServiceBean 失败！  ", e);
        }
        return dpDataDictionaryProvider;
    }

    /**
     * 开发平台-产品生产工序记录--历史表
     */
    public static IDpProductInfoLogHistoryProvider getDpProductInfoLogHistoryProvider() {
        IDpProductInfoLogHistoryProvider dpProductInfoLogHistoryProvider = null;
        try {
            dpProductInfoLogHistoryProvider = (IDpProductInfoLogHistoryProvider) ServiceBeanContext.getInstance().getBean("dpProductInfoLogHistoryProvider");
        } catch (Exception e) {
            log.error("获取 getDpProductInfoLogHistoryProvider ServiceBean 失败！  ", e);
        }
        return dpProductInfoLogHistoryProvider;
    }

    /**
     * 开发平台-产品明细（按工单移）历史表
     */
    public static IPdProductInfoHistoryProvider getPdProductInfoHistoryProvider() {
        IPdProductInfoHistoryProvider pdProductInfoHistoryProvider = null;
        try {
            pdProductInfoHistoryProvider = (IPdProductInfoHistoryProvider) ServiceBeanContext.getInstance().getBean("pdProductInfoHistoryProvider");
        } catch (Exception e) {
            log.error("获取 getPdProductInfoHistoryProvider ServiceBean 失败！  ", e);
        }
        return pdProductInfoHistoryProvider;
    }

    /**
     * 开发平台-产品测试项-历史表
     */
    public static IDpProductTestLogHistoryProvider getDpProductTestLogHistoryProvider() {
        IDpProductTestLogHistoryProvider dpProductTestLogHistoryProvider = null;
        try {
            dpProductTestLogHistoryProvider = (IDpProductTestLogHistoryProvider) ServiceBeanContext.getInstance().getBean("dpProductTestLogHistoryProvider");
        } catch (Exception e) {
            log.error("获取 getDpProductTestLogHistoryProvider ServiceBean 失败！  ", e);
        }
        return dpProductTestLogHistoryProvider;
    }

    /**
     * 开发平台-上料管理-历史包
     */
    public static IDpMaterialsInfoHistoryProvider getDpMaterialsInfoHistoryProvider() {
        IDpMaterialsInfoHistoryProvider dpMaterialsInfoHistoryProvider = null;
        try {
            dpMaterialsInfoHistoryProvider = (IDpMaterialsInfoHistoryProvider) ServiceBeanContext.getInstance().getBean("dpMaterialsInfoHistoryProvider");
        } catch (Exception e) {
            log.error("获取 getDpMaterialsInfoHistoryProvider ServiceBean 失败！  ", e);
        }
        return dpMaterialsInfoHistoryProvider;
    }

    public static IMenuProvider getMenuProvider() {
        IMenuProvider menuProvider = null;
        try {
            menuProvider = (IMenuProvider) ServiceBeanContext.getInstance().getBean("menuProvider");
        } catch (Exception e) {
            log.error("获取 getMenuProvider ServiceBean 失败！  ", e);
        }
        return menuProvider;
    }


    /**
     * 菜单rest接口
     */
    public static IMenuRestApiProvider getMenuRestApiProvider() {
        IMenuRestApiProvider menuRestApiProvider = null;
        try {
            menuRestApiProvider = (IMenuRestApiProvider) ServiceBeanContext.getInstance().getBean("menuRestApiProvider");
        } catch (Exception e) {
            log.error("获取 getMenuRestApiProvider ServiceBean 失败！  ", e);
        }
        return menuRestApiProvider;
    }

    /**
     * 产品管理-工单班次
     */
    public static IPdSchedulingWorkOrderProvider getPdSchedulingWorkOrderProvider() {
        IPdSchedulingWorkOrderProvider pdSchedulingWorkOrderProvider = null;
        try {
            pdSchedulingWorkOrderProvider = (IPdSchedulingWorkOrderProvider) ServiceBeanContext.getInstance().getBean("pdSchedulingWorkOrderProvider");
        } catch (Exception e) {
            log.error("获取 getPdSchedulingWorkOrderProvider ServiceBean 失败！  ", e);
        }
        return pdSchedulingWorkOrderProvider;
    }

    /**
     * 开发平台-对象分类
     */
    public static ITableTypeProvider getTableTypeProvider() {
        ITableTypeProvider tableTypeProvider = null;
        try {
            tableTypeProvider = (ITableTypeProvider) ServiceBeanContext.getInstance().getBean("tableTypeProvider");
        } catch (Exception e) {
            log.error("获取 getTableTypeProvider ServiceBean 失败！  ", e);
        }
        return tableTypeProvider;
    }

    /**
     * 产品管理-生产BOM校验规则
     */
    public static IPdBomProduceRulesProvider getPdBomProduceRulesProvider() {
        IPdBomProduceRulesProvider pdBomProduceRulesProvider = null;
        try {
            pdBomProduceRulesProvider = (IPdBomProduceRulesProvider) ServiceBeanContext.getInstance().getBean("pdBomProduceRulesProvider");
        } catch (Exception e) {
            log.error("获取 getPdBomProduceRulesProvider ServiceBean 失败！  ", e);
        }
        return pdBomProduceRulesProvider;
    }

    /**
     * 开发平台-条码
     */
    public static IDpBarcodeProvider getDpBarcodeProvider() {
        IDpBarcodeProvider dpBarcodeProvider = null;
        try {
            dpBarcodeProvider = (IDpBarcodeProvider) ServiceBeanContext.getInstance().getBean("dpBarcodeProvider");
        } catch (Exception e) {
            log.error("获取 getDpBarcodeProvider ServiceBean 失败！  ", e);
        }
        return dpBarcodeProvider;
    }

    /**
     * 开发平台-条码类别
     */
    public static IDpBarcodeTypeProvider getDpBarcodeTypeProvider() {
        IDpBarcodeTypeProvider dpBarcodeTypeProvider = null;
        try {
            dpBarcodeTypeProvider = (IDpBarcodeTypeProvider) ServiceBeanContext.getInstance().getBean("dpBarcodeTypeProvider");
        } catch (Exception e) {
            log.error("获取 getDpBarcodeTypeProvider ServiceBean 失败！  ", e);
        }
        return dpBarcodeTypeProvider;
    }

    /**
     * 开发平台-标签管理
     */
    public static IDpLabelProvider getDpLabelProvider() {
        IDpLabelProvider dpLabelProvider = null;
        try {
            dpLabelProvider = (IDpLabelProvider) ServiceBeanContext.getInstance().getBean("dpLabelProvider");
        } catch (Exception e) {
            log.error("获取 getDpLabelProvider ServiceBean 失败！  ", e);
        }
        return dpLabelProvider;
    }

    /**
     * 开发平台-标签类别
     */
    public static IDpLabelTypeProvider getDpLabelTypeProvider() {
        IDpLabelTypeProvider dpLabelTypeProvider = null;
        try {
            dpLabelTypeProvider = (IDpLabelTypeProvider) ServiceBeanContext.getInstance().getBean("dpLabelTypeProvider");
        } catch (Exception e) {
            log.error("获取 getDpLabelTypeProvider ServiceBean 失败！  ", e);
        }
        return dpLabelTypeProvider;
    }

    /**
     * 用户操作日志
     */
    public static IUserOpLogProvider getUserOpLogProvider() {
        IUserOpLogProvider userOpLogProvider = null;
        try {
            userOpLogProvider = (IUserOpLogProvider) ServiceBeanContext.getInstance().getBean("userOpLogProvider");
        } catch (Exception e) {
            log.error("获取 getUserOpLogProvider ServiceBean 失败！  ", e);
        }
        return userOpLogProvider;
    }

    /**
     * 开发平台-素材管理
     */
    public static IDpMaterialProvider getDpMaterialProvider() {
        IDpMaterialProvider dpMaterialProvider = null;
        try {
            dpMaterialProvider = (IDpMaterialProvider) ServiceBeanContext.getInstance().getBean("dpMaterialProvider");
        } catch (Exception e) {
            log.error("获取 getDpMaterialProvider ServiceBean 失败！  ", e);
        }
        return dpMaterialProvider;
    }

    /**
     * 开发平台-组件管理
     */
    public static IDpSubassemblyProvider getDpSubassemblyProvider() {
        IDpSubassemblyProvider dpSubassemblyProvider = null;
        try {
            dpSubassemblyProvider = (IDpSubassemblyProvider) ServiceBeanContext.getInstance().getBean("dpSubassemblyProvider");
        } catch (Exception e) {
            log.error("获取 getDpSubassemblyProvider ServiceBean 失败！  ", e);
        }
        return dpSubassemblyProvider;
    }

    /**
     * 开发平台-模板管理
     */
    public static IDpTemplateProvider getDpTemplateProvider() {
        IDpTemplateProvider dpTemplateProvider = null;
        try {
            dpTemplateProvider = (IDpTemplateProvider) ServiceBeanContext.getInstance().getBean("dpTemplateProvider");
        } catch (Exception e) {
            log.error("获取 getDpTemplateProvider ServiceBean 失败！  ", e);
        }
        return dpTemplateProvider;
    }

    /**
     * 开发平台-组件分类
     */
    public static IDpSubassemblyTypeProvider getDpSubassemblyTypeProvider() {
        IDpSubassemblyTypeProvider dpSubassemblyTypeProvider = null;
        try {
            dpSubassemblyTypeProvider = (IDpSubassemblyTypeProvider) ServiceBeanContext.getInstance().getBean("dpSubassemblyTypeProvider");
        } catch (Exception e) {
            log.error("获取 getDpSubassemblyTypeProvider ServiceBean 失败！  ", e);
        }
        return dpSubassemblyTypeProvider;
    }

    /**
     * 开发平台-模板分类
     */
    public static IDpTemplateTypeProvider getDpTemplateTypeProvider() {
        IDpTemplateTypeProvider dpTemplateTypeProvider = null;
        try {
            dpTemplateTypeProvider = (IDpTemplateTypeProvider) ServiceBeanContext.getInstance().getBean("dpTemplateTypeProvider");
        } catch (Exception e) {
            log.error("获取 getDpTemplateTypeProvider ServiceBean 失败！  ", e);
        }
        return dpTemplateTypeProvider;
    }

    /**
     * 开发平台-素材分类
     */
    public static IDpMaterialTypeProvider getDpMaterialTypeProvider() {
        IDpMaterialTypeProvider dpMaterialTypeProvider = null;
        try {
            dpMaterialTypeProvider = (IDpMaterialTypeProvider) ServiceBeanContext.getInstance().getBean("dpMaterialTypeProvider");
        } catch (Exception e) {
            log.error("获取 getDpMaterialTypeProvider ServiceBean 失败！  ", e);
        }
        return dpMaterialTypeProvider;
    }

    /**
     * 开发平台-产品明细-产品编码
     */
    public static IPdProductInfoNumberProvider getPdProductInfoNumberProvider() {
        IPdProductInfoNumberProvider pdProductInfoNumberProvider = null;
        try {
            pdProductInfoNumberProvider = (IPdProductInfoNumberProvider) ServiceBeanContext.getInstance().getBean("pdProductInfoNumberProvider");
        } catch (Exception e) {
            log.error("获取 getPdProductInfoNumberProvider ServiceBean 失败！  ", e);
        }
        return pdProductInfoNumberProvider;
    }

    /**
     * 开发平台-产品明细-产品编码(历史)
     */
    public static IPdProductInfoNumberHistoryProvider getPdProductInfoNumberHistoryProvider() {
        IPdProductInfoNumberHistoryProvider pdProductInfoNumberHistoryProvider = null;
        try {
            pdProductInfoNumberHistoryProvider = (IPdProductInfoNumberHistoryProvider) ServiceBeanContext.getInstance().getBean("pdProductInfoNumberHistoryProvider");
        } catch (Exception e) {
            log.error("获取 getPdProductInfoNumberHistoryProvider ServiceBean 失败！  ", e);
        }
        return pdProductInfoNumberHistoryProvider;
    }

    /**
     * 开发平台-产品明细-物料
     */
    public static IPdProductInfoMaterialsProvider getPdProductInfoMaterialsProvider() {
        IPdProductInfoMaterialsProvider pdProductInfoMaterialsProvider = null;
        try {
            pdProductInfoMaterialsProvider = (IPdProductInfoMaterialsProvider) ServiceBeanContext.getInstance().getBean("pdProductInfoMaterialsProvider");
        } catch (Exception e) {
            log.error("获取 getPdProductInfoMaterialsProvider ServiceBean 失败！  ", e);
        }
        return pdProductInfoMaterialsProvider;
    }

    /**
     * 开发平台-产品明细-物料-历史
     */
    public static IPdProductInfoMaterialsHistoryProvider getPdProductInfoMaterialsHistoryProvider() {
        IPdProductInfoMaterialsHistoryProvider pdProductInfoMaterialsHistoryProvider = null;
        try {
            pdProductInfoMaterialsHistoryProvider = (IPdProductInfoMaterialsHistoryProvider) ServiceBeanContext.getInstance().getBean("pdProductInfoMaterialsHistoryProvider");
        } catch (Exception e) {
            log.error("获取 getPdProductInfoMaterialsHistoryProvider ServiceBean 失败！  ", e);
        }
        return pdProductInfoMaterialsHistoryProvider;
    }

    /**
     * 产品管理-产品属性管理
     */
    public static IPdAttributeProvider getPdAttributeProvider() {
        IPdAttributeProvider pdAttributeProvider = null;
        try {
            pdAttributeProvider = (IPdAttributeProvider) ServiceBeanContext.getInstance().getBean("pdAttributeProvider");
        } catch (Exception e) {
            log.error("获取 getPdAttributeProvider ServiceBean 失败！  ", e);
        }
        return pdAttributeProvider;
    }

    /**
     * 服务调用监控
     */
    public static IDpServiceMonitorProvider getDpServiceMonitorProvider() {
        IDpServiceMonitorProvider dpServiceMonitorProvider = null;
        try {
            dpServiceMonitorProvider = (IDpServiceMonitorProvider) ServiceBeanContext.getInstance().getBean("dpServiceMonitorProvider");
        } catch (Exception e) {
            log.error("获取 getDpServiceMonitorProvider ServiceBean 失败！  ", e);
        }
        return dpServiceMonitorProvider;
    }

    /**
     * 开发平台-产品测试标准
     */
    public static IDpProduceStandardTestProvider getDpProduceStandardTestProvider() {
        IDpProduceStandardTestProvider dpProduceStandardTestProvider = null;
        try {
            dpProduceStandardTestProvider = (IDpProduceStandardTestProvider) ServiceBeanContext.getInstance().getBean("dpProduceStandardTestProvider");
        } catch (Exception e) {
            log.error("获取 getDpProduceStandardTestProvider ServiceBean 失败！  ", e);
        }
        return dpProduceStandardTestProvider;
    }

    /**
     * 开发平台-产品测试标准-测试顺序
     */
    public static IDpProduceStandardTestOrderProvider getDpProduceStandardTestOrderProvider() {
        IDpProduceStandardTestOrderProvider dpProduceStandardTestOrderProvider = null;
        try {
            dpProduceStandardTestOrderProvider = (IDpProduceStandardTestOrderProvider) ServiceBeanContext.getInstance().getBean("dpProduceStandardTestOrderProvider");
        } catch (Exception e) {
            log.error("获取 getDpProduceStandardTestOrderProvider ServiceBean 失败！  ", e);
        }
        return dpProduceStandardTestOrderProvider;
    }

    /**
     * 开发平台-产品芯片
     */
    public static IDpProduceChipProvider getDpProduceChipProvider() {
        IDpProduceChipProvider dpProduceChipProvider = null;
        try {
            dpProduceChipProvider = (IDpProduceChipProvider) ServiceBeanContext.getInstance().getBean("dpProduceChipProvider");
        } catch (Exception e) {
            log.error("获取 getDpProduceChipProvider ServiceBean 失败！  ", e);
        }
        return dpProduceChipProvider;
    }

    /**
     * 工厂管理-工序配置类型
     */
    public static IFtyProcessConfigTypeProvider getFtyProcessConfigTypeProvider() {
        IFtyProcessConfigTypeProvider ftyProcessConfigTypeProvider = null;
        try {
            ftyProcessConfigTypeProvider = (IFtyProcessConfigTypeProvider) ServiceBeanContext.getInstance().getBean("ftyProcessConfigTypeProvider");
        } catch (Exception e) {
            log.error("获取 getFtyProcessConfigTypeProvider ServiceBean 失败！  ", e);
        }
        return ftyProcessConfigTypeProvider;
    }

    /**
     * 工厂管理-工序配置类型字典
     */
    public static IFtyProcessConfigTypeDictProvider getFtyProcessConfigTypeDictProvider() {
        IFtyProcessConfigTypeDictProvider ftyProcessConfigTypeDictProvider = null;
        try {
            ftyProcessConfigTypeDictProvider = (IFtyProcessConfigTypeDictProvider) ServiceBeanContext.getInstance().getBean("ftyProcessConfigTypeDictProvider");
        } catch (Exception e) {
            log.error("获取 getFtyProcessConfigTypeDictProvider ServiceBean 失败！  ", e);
        }
        return ftyProcessConfigTypeDictProvider;
    }

    /**
     * 开发平台-栈板管理
     */
    public static IDpBoxPalletProvider getDpBoxPalletProvider() {
        IDpBoxPalletProvider dpBoxPalletProvider = null;
        try {
            dpBoxPalletProvider = (IDpBoxPalletProvider) ServiceBeanContext.getInstance().getBean("dpBoxPalletProvider");
        } catch (Exception e) {
            log.error("获取 getDpBoxPalletProvider ServiceBean 失败！  ", e);
        }
        return dpBoxPalletProvider;
    }

    /**
     * 开发平台-包装箱管理
     */
    public static IDpBoxProvider getDpBoxProvider() {
        IDpBoxProvider dpBoxProvider = null;
        try {
            dpBoxProvider = (IDpBoxProvider) ServiceBeanContext.getInstance().getBean("dpBoxProvider");
        } catch (Exception e) {
            log.error("获取 getDpBoxProvider ServiceBean 失败！  ", e);
        }
        return dpBoxProvider;
    }

    /**
     * 开发平台-包装箱管理--包装箱生成规则配置
     */
    public static IDpBoxRuleProvider getDpBoxRuleProvider() {
        IDpBoxRuleProvider dpBoxRuleProvider = null;
        try {
            dpBoxRuleProvider = (IDpBoxRuleProvider) ServiceBeanContext.getInstance().getBean("dpBoxRuleProvider");
        } catch (Exception e) {
            log.error("获取 getDpBoxRuleProvider ServiceBean 失败！  ", e);
        }
        return dpBoxRuleProvider;
    }


    /**
     * 开发平台-包装箱-产品
     */
    public static IDpBoxProductInfoProvider getDpBoxProductInfoProvider() {
        IDpBoxProductInfoProvider dpBoxProductInfoProvider = null;
        try {
            dpBoxProductInfoProvider = (IDpBoxProductInfoProvider) ServiceBeanContext.getInstance().getBean("dpBoxProductInfoProvider");
        } catch (Exception e) {
            log.error("获取 getDpBoxProductInfoProvider ServiceBean 失败！  ", e);
        }
        return dpBoxProductInfoProvider;
    }

    /**
     * 开发平台-栈板管理-包装箱
     */
    public static IDpBoxPalletInfoProvider getDpBoxPalletInfoProvider() {
        IDpBoxPalletInfoProvider dpBoxPalletInfoProvider = null;
        try {
            dpBoxPalletInfoProvider = (IDpBoxPalletInfoProvider) ServiceBeanContext.getInstance().getBean("dpBoxPalletInfoProvider");
        } catch (Exception e) {
            log.error("获取 getDpBoxPalletInfoProvider ServiceBean 失败！  ", e);
        }
        return dpBoxPalletInfoProvider;
    }

    /**
     * 开发平台-产品维修站
     */
    public static IDpRepairStationProvider getDpRepairStationProvider() {
        IDpRepairStationProvider dpRepairStationProvider = null;
        try {
            dpRepairStationProvider = (IDpRepairStationProvider) ServiceBeanContext.getInstance().getBean("dpRepairStationProvider");
        } catch (Exception e) {
            log.error("获取 getDpRepairStationProvider ServiceBean 失败！  ", e);
        }
        return dpRepairStationProvider;
    }

    /**
     * 开发平台-产品维修站-不良信息
     */
    public static IDpRepairStationBadInfoProvider getDpRepairStationBadInfoProvider() {
        IDpRepairStationBadInfoProvider dpRepairStationBadInfoProvider = null;
        try {
            dpRepairStationBadInfoProvider = (IDpRepairStationBadInfoProvider) ServiceBeanContext.getInstance().getBean("dpRepairStationBadInfoProvider");
        } catch (Exception e) {
            log.error("获取 getDpRepairStationBadInfoProvider ServiceBean 失败！  ", e);
        }
        return dpRepairStationBadInfoProvider;
    }

    /**
     * 开发平台-生产工序配置-工序执行时间
     */
    public static IDpProduceProcessDateProvider getDpProduceProcessDateProvider() {
        IDpProduceProcessDateProvider dpProduceProcessDateProvider = null;
        try {
            dpProduceProcessDateProvider = (IDpProduceProcessDateProvider) ServiceBeanContext.getInstance().getBean("dpProduceProcessDateProvider");
        } catch (Exception e) {
            log.error("获取 getDpProduceProcessDateProvider ServiceBean 失败！  ", e);
        }
        return dpProduceProcessDateProvider;
    }

    /**
     * 开发平台-产品标定
     */
    public static IDpProduceDemarcateProvider getDpProduceDemarcateProvider() {
        IDpProduceDemarcateProvider dpProduceDemarcateProvider = null;
        try {
            dpProduceDemarcateProvider = (IDpProduceDemarcateProvider) ServiceBeanContext.getInstance().getBean("dpProduceDemarcateProvider");
        } catch (Exception e) {
            log.error("获取 getDpProduceDemarcateProvider ServiceBean 失败！  ", e);
        }
        return dpProduceDemarcateProvider;
    }

    /**
     * 软件注入结果记录
     */
    public static IPdExecSoftinjectTbProvider getPdExecSoftinjectTbProvider() {
        IPdExecSoftinjectTbProvider pdExecSoftinjectTbProvider = null;
        try {
            pdExecSoftinjectTbProvider = (IPdExecSoftinjectTbProvider) ServiceBeanContext.getInstance().getBean("pdExecSoftinjectTbProvider");
        } catch (Exception e) {
            log.error("获取 getPdExecSoftinjectTbProvider ServiceBean 失败！  ", e);
        }
        return pdExecSoftinjectTbProvider;
    }

    /**
     * 终端测试项结果
     */
    public static IPdWorkTestDetailTbProvider getPdWorkTestDetailTbProvider() {
        IPdWorkTestDetailTbProvider pdWorkTestDetailTbProvider = null;
        try {
            pdWorkTestDetailTbProvider = (IPdWorkTestDetailTbProvider) ServiceBeanContext.getInstance().getBean("pdWorkTestDetailTbProvider");
        } catch (Exception e) {
            log.error("获取 getPdWorkTestDetailTbProvider ServiceBean 失败！  ", e);
        }
        return pdWorkTestDetailTbProvider;
    }

    /**
     * 终端测试项设备状态
     */
    public static IPdWorkTestDeviceTbProvider getPdWorkTestDeviceTbProvider() {
        IPdWorkTestDeviceTbProvider pdWorkTestDeviceTbProvider = null;
        try {
            pdWorkTestDeviceTbProvider = (IPdWorkTestDeviceTbProvider) ServiceBeanContext.getInstance().getBean("pdWorkTestDeviceTbProvider");
        } catch (Exception e) {
            log.error("获取 getPdWorkTestDeviceTbProvider ServiceBean 失败！  ", e);
        }
        return pdWorkTestDeviceTbProvider;
    }

    /**
     * 终端测试结果
     */
    public static IPdWorkTestMainTbProvider getPdWorkTestMainTbProvider() {
        IPdWorkTestMainTbProvider pdWorkTestMainTbProvider = null;
        try {
            pdWorkTestMainTbProvider = (IPdWorkTestMainTbProvider) ServiceBeanContext.getInstance().getBean("pdWorkTestMainTbProvider");
        } catch (Exception e) {
            log.error("获取 getPdWorkTestMainTbProvider ServiceBean 失败！  ", e);
        }
        return pdWorkTestMainTbProvider;
    }

    /**
     * $table.description
     */
    public static IPdExecSystemModuleCopyProvider getPdExecSystemModuleCopyProvider() {
        IPdExecSystemModuleCopyProvider pdExecSystemModuleCopyProvider = null;
        try {
            pdExecSystemModuleCopyProvider = (IPdExecSystemModuleCopyProvider) ServiceBeanContext.getInstance().getBean("pdExecSystemModuleCopyProvider");
        } catch (Exception e) {
            log.error("获取 getPdExecSystemModuleCopyProvider ServiceBean 失败！  ", e);
        }
        return pdExecSystemModuleCopyProvider;
    }

    /**
     * $table.description
     */
    public static IPdExecTransmitSetTbProvider getPdExecTransmitSetTbProvider() {
        IPdExecTransmitSetTbProvider pdExecTransmitSetTbProvider = null;
        try {
            pdExecTransmitSetTbProvider = (IPdExecTransmitSetTbProvider) ServiceBeanContext.getInstance().getBean("pdExecTransmitSetTbProvider");
        } catch (Exception e) {
            log.error("获取 getPdExecTransmitSetTbProvider ServiceBean 失败！  ", e);
        }
        return pdExecTransmitSetTbProvider;
    }

    /**
     * 产品管理-抽检管理
     */
    public static IDpSampleInspectionProvider getDpSampleInspectionProvider() {
        IDpSampleInspectionProvider dpSampleInspectionProvider = null;
        try {
            dpSampleInspectionProvider = (IDpSampleInspectionProvider) ServiceBeanContext.getInstance().getBean("dpSampleInspectionProvider");
        } catch (Exception e) {
            log.error("获取 getDpSampleInspectionProvider ServiceBean 失败！  ", e);
        }
        return dpSampleInspectionProvider;
    }

    /**
     * 产品管理-抽检管理-抽检详细
     */
    public static IDpSampleInspectionDetailProvider getDpSampleInspectionDetailProvider() {
        IDpSampleInspectionDetailProvider dpSampleInspectionDetailProvider = null;
        try {
            dpSampleInspectionDetailProvider = (IDpSampleInspectionDetailProvider) ServiceBeanContext.getInstance().getBean("dpSampleInspectionDetailProvider");
        } catch (Exception e) {
            log.error("获取 getDpSampleInspectionDetailProvider ServiceBean 失败！  ", e);
        }
        return dpSampleInspectionDetailProvider;
    }

    /**
     * 开发平台-上料管理-组装
     */
    public static IDpMaterialsAssembleProvider getDpMaterialsAssembleProvider() {
        IDpMaterialsAssembleProvider dpMaterialsAssembleProvider = null;
        try {
            dpMaterialsAssembleProvider = (IDpMaterialsAssembleProvider) ServiceBeanContext.getInstance().getBean("dpMaterialsAssembleProvider");
        } catch (Exception e) {
            log.error("获取 getDpMaterialsAssembleProvider ServiceBean 失败！  ", e);
        }
        return dpMaterialsAssembleProvider;
    }

    /**
     * 开发平台-上料管理-上料
     */
    public static IDpMaterialsLoadProvider getDpMaterialsLoadProvider() {
        IDpMaterialsLoadProvider dpMaterialsLoadProvider = null;
        try {
            dpMaterialsLoadProvider = (IDpMaterialsLoadProvider) ServiceBeanContext.getInstance().getBean("dpMaterialsLoadProvider");
        } catch (Exception e) {
            log.error("获取 getDpMaterialsLoadProvider ServiceBean 失败！  ", e);
        }
        return dpMaterialsLoadProvider;
    }

    /**
     * 开发平台-生产工序-工装配置信息
     */
    public static IDpProduceProcessAnnexProvider getDpProduceProcesAnnexProvider() {
        IDpProduceProcessAnnexProvider dpProduceProcesAnnexProvider = null;
        try {
            dpProduceProcesAnnexProvider = (IDpProduceProcessAnnexProvider) ServiceBeanContext.getInstance().getBean("dpProduceProcessAnnexProvider");
        } catch (Exception e) {
            log.error("获取 getDpProduceProcesAnnexProvider ServiceBean 失败！  ", e);
        }
        return dpProduceProcesAnnexProvider;
    }

    /**
     * 开发平台-产品明细-产品标签
     */
    public static IPdProductPdLableProvider getPdProductPdLableProvider() {
        IPdProductPdLableProvider pdProductPdLableProvider = null;
        try {
            pdProductPdLableProvider = (IPdProductPdLableProvider) ServiceBeanContext.getInstance().getBean("pdProductPdLableProvider");
        } catch (Exception e) {
            log.error("获取 getPdProductPdLableProvider ServiceBean 失败！  ", e);
        }
        return pdProductPdLableProvider;
    }

    /**
     * 产品管理-产品条码
     */
    public static IPdProductBarCodeProvider getPdProductBarCodeProvider() {
        IPdProductBarCodeProvider pdProductBarCodeProvider = null;
        try {
            pdProductBarCodeProvider = (IPdProductBarCodeProvider) ServiceBeanContext.getInstance().getBean("pdProductBarCodeProvider");
        } catch (Exception e) {
            log.error("获取 getPdProductBarCodeProvider ServiceBean 失败！  ", e);
        }
        return pdProductBarCodeProvider;
    }

    /**
     * 产品管理-产品标签
     */
    public static IPdProductLabelProvider getPdProductLabelProvider() {
        IPdProductLabelProvider pdProductLabelProvider = null;
        try {
            pdProductLabelProvider = (IPdProductLabelProvider) ServiceBeanContext.getInstance().getBean("pdProductLabelProvider");
        } catch (Exception e) {
            log.error("获取 getPdProductLabelProvider ServiceBean 失败！  ", e);
        }
        return pdProductLabelProvider;
    }

    /**
     * 产品管理-条码通配符列表
     */
    public static IPdBarcodeWildcardProvider getPdBarcodeWildcardProvider() {
        IPdBarcodeWildcardProvider pdBarcodeWildcardProvider = null;
        try {
            pdBarcodeWildcardProvider = (IPdBarcodeWildcardProvider) ServiceBeanContext.getInstance().getBean("pdBarcodeWildcardProvider");
        } catch (Exception e) {
            log.error("获取 getPdBarcodeWildcardProvider ServiceBean 失败！  ", e);
        }
        return pdBarcodeWildcardProvider;
    }

    /**
     * 产品管理-条码通配符日期替换
     */
    public static IPdBaseReplaceTbProvider getPdBaseReplaceTbProvider() {
        IPdBaseReplaceTbProvider pdBaseReplaceTbProvider = null;
        try {
            pdBaseReplaceTbProvider = (IPdBaseReplaceTbProvider) ServiceBeanContext.getInstance().getBean("pdBaseReplaceTbProvider");
        } catch (Exception e) {
            log.error("获取 getPdBaseReplaceTbProvider ServiceBean 失败！  ", e);
        }
        return pdBaseReplaceTbProvider;
    }

    /**
     * 产品管理-条码扩展通配符
     */
    public static IPdPreCodeWildcardTbProvider getPdPreCodeWildcardTbProvider() {
        IPdPreCodeWildcardTbProvider pdPreCodeWildcardTbProvider = null;
        try {
            pdPreCodeWildcardTbProvider = (IPdPreCodeWildcardTbProvider) ServiceBeanContext.getInstance().getBean("pdPreCodeWildcardTbProvider");
        } catch (Exception e) {
            log.error("获取 getPdPreCodeWildcardTbProvider ServiceBean 失败！  ", e);
        }
        return pdPreCodeWildcardTbProvider;
    }

    /**
     * 开发平台-流水规则-规则
     */
    public static ISerialRuleProvider getSerialRuleProvider() {
        ISerialRuleProvider serialRuleProvider = null;
        try {
            serialRuleProvider = (ISerialRuleProvider) ServiceBeanContext.getInstance().getBean("serialRuleProvider");
        } catch (Exception e) {
            log.error("获取 getSerialRuleProvider ServiceBean 失败！  ", e);
        }
        return serialRuleProvider;
    }

    /**
     * 开发平台-流水规则-规则工单关联
     */
    public static ISerialRuleWorkOrderAssociationProvider getSerialRuleWorkOrderAssociationProvider() {
        ISerialRuleWorkOrderAssociationProvider serialRuleWorkOrderAssociationProvider = null;
        try {
            serialRuleWorkOrderAssociationProvider = (ISerialRuleWorkOrderAssociationProvider) ServiceBeanContext.getInstance().getBean("serialRuleWorkOrderAssociationProvider");
        } catch (Exception e) {
            log.error("获取 getSerialRuleWorkOrderAssociationProvider ServiceBean 失败！  ", e);
        }
        return serialRuleWorkOrderAssociationProvider;
    }

    /**
     * 开发平台-流水规则-明细
     */
    public static ISerialRuleDetailProvider getSerialRuleDetailProvider() {
        ISerialRuleDetailProvider serialRuleDetailProvider = null;
        try {
            serialRuleDetailProvider = (ISerialRuleDetailProvider) ServiceBeanContext.getInstance().getBean("serialRuleDetailProvider");
        } catch (Exception e) {
            log.error("获取 getSerialRuleDetailProvider ServiceBean 失败！  ", e);
        }
        return serialRuleDetailProvider;
    }
}
