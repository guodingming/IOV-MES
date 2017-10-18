package configs.barcodes

/**
 * 批次信息，倒数第1位,例如：A
 * Created by xiuyou.xu on 2017/9/29.
 */

String stringToAscii(String value) {//ASCII转换
    StringBuffer sbu = new StringBuffer();
    char[] chars = value.toCharArray();
    for (int i = 0; i < chars.length; i++) {
        if (i != chars.length - 1) {
            sbu.append(Integer.toHexString(((int) chars[i])));
        } else {
            sbu.append(Integer.toHexString((int) chars[i]));
        }
    }
    return sbu.toString();
}

return (Integer.valueOf(stringToAscii(batchNum.substring(17, 18))) - 40) + "";