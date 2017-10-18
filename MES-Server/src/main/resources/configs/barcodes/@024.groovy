package configs.barcodes

import java.text.SimpleDateFormat

/**
 * 两位日，传入工单实际开始时间workOrderStartTime
 * Created by xiuyou.xu on 2017/9/29.
 */

SimpleDateFormat sdf = new SimpleDateFormat("dd")
return sdf.format(workOrderStartTime)
//return batchNum.substring(15, 17)