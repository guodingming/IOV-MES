package com.mes.common.utils;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * Created by xiuyou.xu on 2017/8/29.
 */
public class ErrorCodes {
    @ErrorDef(message = "没有错误")
    public static final String NO_ERROR = "0";

    @ErrorDef(message = "后台发生异常")
    public static final String EXCEPTION_OCCURRED = "1";

    @ErrorDef(message = "设备不存在")
    public static final String DEVICE_NOT_EXISTS = "2";

    @ErrorDef(message = "关联表不存在")
    public static final String NO_RELATION_TABLES = "3";

    @ErrorDef(message = "未配置软件物料资源文件")
    public static final String NO_MATERIAL_RESOURCE_FILE = "4";

    @ErrorDef(message = "存在多个软件物料资源文件")
    public static final String MULTI_MATERIAL_RESOURCE_FILES = "5";

    @ErrorDef(message = "未找到指定ERP编码对应的物料")
    public static final String NO_MATERIAL = "6";

    @ErrorDef(message = "指定ERP编码对应多个物料")
    public static final String MULTI_MATERIALS = "7";

    @ErrorDef(message = "未找到指定工序对应的芯片操作列表")
    public static final String NO_CHIP_OPS = "8";

    @ErrorDef(message = "指定工序对应的芯片操作列表为空")
    public static final String EMPTY_CHIP_OPS = "9";

    @ErrorDef(message = "任务信息获取错误")
    public static final String TASK_INFO = "10";

    @ErrorDef(message = "指定BOM不存在任何对应的物料")
    public static final String NO_BOM_MATERIAL = "11";

    @ErrorDef(message = "未找到远程配置xml文件")
    public static final String NO_REMOTE_CONFIG_XML = "12";

    @ErrorDef(message = "未找到设备关联的工装")
    public static final String NO_DEVICE_ANNEX = "13";

    @ErrorDef(message = "未找到任务信息中的BOM记录")
    public static final String NO_WORK_BOM = "14";

    @ErrorDef(message = "未找到关联的测试标准")
    public static final String NO_TEST_STANDARDS = "15";

    @ErrorDef(message = "关联的测试标准列表为空")
    public static final String EMPTY_TEST_STANDARDS = "16";

    @ErrorDef(message = "未找到关联的测试顺序")
    public static final String NO_TEST_ORDERS = "17";

    @ErrorDef(message = "关联的测试顺序列表为空")
    public static final String EMPTY_TEST_ORDERS = "18";

    @ErrorDef(message = "未找到产品单项配置：实现方式")
    public static final String NO_IMPLEMENT_MODE = "19";

    @ErrorDef(message = "未找到工序单项配置：温度上限")
    public static final String NO_TEMPERATUE_TOP = "20";

    @ErrorDef(message = "未找到工序单项配置：温度下限")
    public static final String NO_TEMPERATUE_BOTTOM = "21";

    @ErrorDef(message = "未找到条码该条码对应的产品")
    public static final String NO_PRODUCT_NUMBERS = "22";

    @ErrorDef(message = "登录信息失败或用户不具有执行此工序的能力")
    public static final String SHOW_LOGIN = "23";

    @ErrorDef(message = "获取工序数据失败")
    public static final String COMPLETE_INFO = "24";

    @ErrorDef(message = "未找到该数据源类型对应的字节操作处理方法")
    public static final String NO_SOURCE_TYPE_HANDLER = "25";

    @ErrorDef(message = "设备配置文件类别未找到")
    public static final String DEVICE_FILE_TYPE_NOT_FOUND = "26";

    @ErrorDef(message = "芯片操作转换失败")
    public static final String TRANSFORM_FAILED = "27";

    @ErrorDef(message = "该条码不属于该工单")
    public static final String CHECK_CODE = "28";

    @ErrorDef(message = "未找到指定的生产工序")
    public static final String PRODUCE_PROCESS_NOT_FOUND = "29";

    @ErrorDef(message = "未找到产品单项配置：产品零件号")
    public static final String NO_CLIENT_NUMBER = "30";

    @ErrorDef(message = "产品过站失败")
    public static final String COMPLETE_TASK_FAILED = "31";

    @ErrorDef(message = "该产品不该执行此工序")
    public static final String CHECK_PROCESS_FAILED = "32";

    /**
     * 获取错误码对应的错误信息
     *
     * @param code
     * @return
     */
    public static String getMessage(String code) {
        Field[] fields = ErrorCodes.class.getFields();
        if (fields != null && fields.length > 0) {
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    if (code.equals(field.get(null))) {
                        ErrorDef def = field.getAnnotation(ErrorDef.class);
                        return def.message();
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Test
    public void test() {
        System.out.println(getMessage(ErrorCodes.DEVICE_NOT_EXISTS));
    }
}
