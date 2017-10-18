package configs.device_config_xls_files_transform

import com.mes.common.utils.ExcelHandler
import org.apache.poi.ss.usermodel.Sheet

/**
 * 硬件配置_软件注入
 * Created by xiuyou.xu on 2017/9/26.
 */

def handle(List<Sheet> sheets) {
    Sheet diChannel = null;
    Sheet doChannel = null;
    Sheet hardConfig = null;

    sheets.each { sheet ->
        if ("di_channel".equalsIgnoreCase(sheet.getSheetName())) {
            diChannel = sheet
        }
        if ("do_channel".equalsIgnoreCase(sheet.getSheetName())) {
            doChannel = sheet
        }
        if ("hard_config".equalsIgnoreCase(sheet.getSheetName())) {
            hardConfig = sheet
        }
    }

    StringBuilder diChannelSb = new StringBuilder()
    StringBuilder doChannelSb = new StringBuilder()
    StringBuilder hardConfigSb = new StringBuilder()

    int diChannelCount = ExcelHandler.readSheet(diChannelSb, diChannel, "DI_channel")
    int doChannelCount = ExcelHandler.readSheet(doChannelSb, doChannel, "DO_channel")
    int hardConfigCount = ExcelHandler.readSheet(hardConfigSb, hardConfig, "hard_config")

    StringBuilder ret = new StringBuilder()
    ret.append("<device_config>").append("<implement_mode_config dim=\"[2]\">").append("<DI_channel_config dim=\"[").append(diChannelCount).append("]\">")
            .append(diChannelSb.toString())
            .append("</DI_channel_config>").append("<DO_channel_config dim=\"[").append(doChannelCount).append("]\">")
            .append(doChannelSb.toString())
            .append("</DO_channel_config>")
            .append("</implement_mode_config>").append("<device_hard_config dim\"[").append(hardConfigCount).append("]\">")
            .append(hardConfigSb.toString())
            .append("</device_hard_config>").append("</device_config>")

    return ret.toString()
}