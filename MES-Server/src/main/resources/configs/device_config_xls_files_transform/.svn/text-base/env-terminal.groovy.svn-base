package configs.device_config_xls_files_transform

import com.mes.common.utils.ExcelHandler
import org.apache.poi.ss.usermodel.Sheet

/**
 * 设备环境参数_终端
 * Created by xiuyou.xu on 2017/9/26.
 */

def handle(List<Sheet> sheets) {
    StringBuilder sb = new StringBuilder();

    int count = ExcelHandler.readSheet(sb, sheets.get(0), "test_device_parameter")
    StringBuilder ret = new StringBuilder()
    ret.append("<test_device_array dim=\"[").append(count).append("]\">").append(sb.toString()).append("</test_device_array>")

    return ret.toString()
}