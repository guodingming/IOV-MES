package configs.barcodes

/**
 * 转换为8位16进制数，第二个参数是转换位数；
 * Created by xiuyou.xu on 2017/10/10.
 */
String s = Long.toHexString(Long.parseLong(value)).toUpperCase();
int len = s.length()
int n = Integer.parseInt(param)
if (len < n) {
    for (int i = 0; i < n - len; i++) {
        s = "0" + s;
    }
} else if (len > n) {
    s = s.substring(s.length() - n)
}

return s;