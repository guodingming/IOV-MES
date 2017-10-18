package configs.device_config_xls_files_transform

import com.mes.common.utils.ExcelHandler
import org.apache.poi.ss.usermodel.Sheet

/**
 * 设备自检标准_zh终端
 * Created by xiuyou.xu on 2017/9/26.
 */

def handle(List<Sheet> sheets) {
    StringBuilder sb = new StringBuilder();

    int count = ExcelHandler.readSheet(sb, sheets.get(0), "selftest_parameter")
    StringBuilder ret = new StringBuilder()
    ret.append("<selftest_array dim=\"[").append(count).append("]\">").append(sb.toString()).append("</selftest_array>")

    return ret.toString()
}