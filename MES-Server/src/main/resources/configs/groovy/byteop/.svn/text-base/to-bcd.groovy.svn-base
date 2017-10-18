package configs.groovy.byteop

/**
 * 转换为bcd码
 *
 * Created by xiuyou.xu on 2017/9/4.
 */

def to_bcd(content) {
    String[] a = content.split("\\.")
    StringBuilder sb = new StringBuilder()
    for (String s : a) {
        if (s != null && !s.isEmpty()) {
            if (s.length() == 1) {
                sb.append("0").append(s)
            } else {
                sb.append(s.substring(s.length() - 2, s.length()))
            }
        }
    }

    return sb.toString()
}