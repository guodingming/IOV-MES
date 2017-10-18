package configs.barcodes
/**
 * 按批次计算出三位天，即从批次号中得到日期对应的一年中的第多少天，传入工单实际开始时间workOrderStartTime
 * Created by xiuyou.xu on 2017/9/29.
 */
//SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
//String str = batchNum.substring(11, 17)
//Date d = sdf.parse(str)
//String ret = "000"
//if (d != null) {
//    Calendar calendar = Calendar.getInstance();
//    calendar.setTime(d);
//    ret = ret + calendar.get(Calendar.DAY_OF_YEAR);
//}
//return ret.substring(ret.length() - 3);

String ret = "000"
Calendar calendar = Calendar.getInstance();
calendar.setTime(workOrderStartTime);
ret = ret + calendar.get(Calendar.DAY_OF_YEAR);
return ret.substring(ret.length() - 3);