package configs.device_config_xls_files_transform

import com.mes.common.utils.ExcelHandler
import org.apache.poi.ss.usermodel.Sheet

/**
 * 设备远程配置_GP12
 * Created by xiuyou.xu on 2017/9/26.
 */

def handle(List<Sheet> sheets) {
    StringBuilder sb = new StringBuilder();

    int count = ExcelHandler.readSheet(sb, sheets.get(0), "item")
    StringBuilder ret = new StringBuilder()
    ret.append("<root>").append(sb.toString()).append("</root>")

    return ret.toString()
}