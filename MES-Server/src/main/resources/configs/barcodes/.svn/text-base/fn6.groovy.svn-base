package configs.barcodes

import java.util.regex.Pattern

/**
 * ~(6:./)，替换函数，将“.”替换为“”，即将“.”剔除。 ~(6:a/b) ，将“a”t替换为“b”
 * Created by xiuyou.xu on 2017/10/10.
 */
int i = param.indexOf("/");
String[] s = new String[2];
s[0] = param.substring(0, i)
s[1] = param.substring(i + 1);
return value.replaceAll(Pattern.quote(s[0]), s[1]);