package configs.device_config_xls_files_transform

import com.mes.common.utils.ExcelHandler
import org.apache.poi.ss.usermodel.Sheet

/**
 * 硬件配置_终端
 * Created by xiuyou.xu on 2017/9/26.
 */

def handle(List<Sheet> sheets) {
    Sheet diChannel = null;
    Sheet doChannel = null;
    Sheet adChannel = null;
    Sheet canChannel = null;
    Sheet daChannel = null;
    Sheet programPower = null;
    Sheet dmmChannel = null;
    Sheet linChannel = null;
    Sheet rs232 = null;
    Sheet diProcess = null;
    Sheet doProcess = null;
    Sheet hardConfig = null;
    Sheet singalProcess = null;
    Sheet signalConfig = null;

    sheets.each { sheet ->
        if ("di_channel".equalsIgnoreCase(sheet.getSheetName())) {
            diChannel = sheet
        }
        if ("do_channel".equalsIgnoreCase(sheet.getSheetName())) {
            doChannel = sheet
        }
        if ("ad_channel".equalsIgnoreCase(sheet.getSheetName())) {
            adChannel = sheet
        }
        if ("can_channel".equalsIgnoreCase(sheet.getSheetName())) {
            canChannel = sheet
        }
        if ("da_channel".equalsIgnoreCase(sheet.getSheetName())) {
            daChannel = sheet
        }
        if ("ProgramPower".equalsIgnoreCase(sheet.getSheetName())) {
            programPower = sheet
        }
        if ("dmm_channel".equalsIgnoreCase(sheet.getSheetName())) {
            dmmChannel = sheet
        }
        if ("lin_channel".equalsIgnoreCase(sheet.getSheetName())) {
            linChannel = sheet
        }
        if ("rs232".equalsIgnoreCase(sheet.getSheetName())) {
            rs232 = sheet
        }
        if ("di_process".equalsIgnoreCase(sheet.getSheetName())) {
            diProcess = sheet
        }
        if ("do_process".equalsIgnoreCase(sheet.getSheetName())) {
            doProcess = sheet
        }
        if ("hard_config".equalsIgnoreCase(sheet.getSheetName())) {
            hardConfig = sheet
        }
        if ("singal_process".equalsIgnoreCase(sheet.getSheetName())) {
            singalProcess = sheet
        }
        if ("signal_config".equalsIgnoreCase(sheet.getSheetName())) {
            signalConfig = sheet
        }
    }

    StringBuilder diChannelSb = new StringBuilder()
    StringBuilder doChannelSb = new StringBuilder()
    StringBuilder adChannelSb = new StringBuilder()
    StringBuilder canChannelSb = new StringBuilder()
    StringBuilder daChannelSb = new StringBuilder()
    StringBuilder programPowerSb = new StringBuilder()
    StringBuilder dmmChannelSb = new StringBuilder()
    StringBuilder linChannelSb = new StringBuilder()
    StringBuilder rs232Sb = new StringBuilder()
    StringBuilder diProcessSb = new StringBuilder()
    StringBuilder doProcessSb = new StringBuilder()
    StringBuilder hardConfigSb = new StringBuilder()
    StringBuilder singalProcessSb = new StringBuilder()
    StringBuilder signalConfigSb = new StringBuilder()

    int diChannelCount = ExcelHandler.readSheet(diChannelSb, diChannel, "DI_channel")
    int doChannelCount = ExcelHandler.readSheet(doChannelSb, doChannel, "DO_channel")
    int adChannelCount = ExcelHandler.readSheet(adChannelSb, adChannel, "AD_channel")
    int canChannelCount = ExcelHandler.readSheet(canChannelSb, canChannel, "CAN_channel")
    int daChannelCount = ExcelHandler.readSheet(daChannelSb, daChannel, "DA_channel")
    int programPowerCount = ExcelHandler.readSheet(programPowerSb, programPower, "ProgramPower")
    int dmmChannelCount = ExcelHandler.readSheet(dmmChannelSb, dmmChannel, "DMM_channel")
    int linChannelCount = ExcelHandler.readSheet(linChannelSb, linChannel, "LIN_channel")
    int rs232Count = ExcelHandler.readSheet(rs232Sb, rs232, "RS232")
    int diProcessCount = ExcelHandler.readSheet(diProcessSb, diProcess, "DI_process")
    int doProcessCount = ExcelHandler.readSheet(doProcessSb, doProcess, "DO_process")
    int hardConfigCount = ExcelHandler.readSheet(hardConfigSb, hardConfig, "hard_config")
    int singalProcessCount = ExcelHandler.readSheet(singalProcessSb, singalProcess, "singal_process")
    int signalConfigCount = ExcelHandler.readSheet(signalConfigSb, singalProcess, "signal_config")

    StringBuilder ret = new StringBuilder()
    ret.append("<device_config>")

            .append("<implement_mode_config dim=\"[6]\">")
            // ad_channel
            .append("<AD_channel_config dim=\"[").append(adChannelCount).append("]\">")
            .append(adChannelSb.toString())
            .append("</AD_channel_config>")
            // can_channel
            .append("<CAN_channel_config dim=\"[").append(canChannelCount).append("]\">")
            .append(canChannelSb.toString())
            .append("</CAN_channel_config>")
            // da_channel
            .append("<DA_channel_config dim=\"[").append(daChannelCount).append("]\">")
            .append(daChannelSb.toString())
            .append("</DA_channel_config>")
            // ProgramPower
            .append("<ProgramPower_config dim=\"[").append(programPowerCount).append("]\">")
            .append(programPowerSb.toString())
            .append("</ProgramPower_config>")
            // di_channel
            .append("<DI_channel_config dim=\"[").append(diChannelCount).append("]\">")
            .append(diChannelSb.toString())
            .append("</DI_channel_config>")
            // dmm_channel
            .append("<DMM_channel_config dim=\"[").append(dmmChannelCount).append("]\">")
            .append(dmmChannelSb.toString())
            .append("</DMM_channel_config>")
            // do_channel
            .append("<DO_channel_config dim=\"[").append(doChannelCount).append("]\">")
            .append(doChannelSb.toString())
            .append("</DO_channel_config>")
            // lin_channel
            .append("<LIN_channel_config dim=\"[").append(linChannelCount).append("]\">")
            .append(linChannelSb.toString())
            .append("</LIN_channel_config>")
            // rs232
            .append("<RS232_config dim=\"[").append(rs232Count).append("]\">")
            .append(rs232Sb.toString())
            .append("</RS232_config>")
            .append("</implement_mode_config>")

            // di_process
            .append("<DI_process_config dim=\"[").append(diProcessCount).append("]\">")
            .append(diProcessSb.toString())
            .append("</DI_process_config>")
            // do_process
            .append("<DO_process_config dim=\"[").append(doProcessCount).append("]\">")
            .append(doProcessSb.toString())
            .append("</DO_process_config>")
            // hard_config
            .append("<device_hard_config dim=\"[").append(hardConfigCount).append("]\">")
            .append(hardConfigSb.toString())
            .append("</device_hard_config>")
            // signal_config
            .append("<device_signal_config dim=\"[").append(signalConfigCount).append("]\">")
            .append(signalConfigSb.toString())
            .append("</device_signal_config>")
            // singal_process
            .append("<process_config dim=\"[").append(singalProcessCount).append("]\">")
            .append(singalProcessSb.toString())
            .append("</process_config>")

            .append("</device_config>")

    return ret.toString()
}