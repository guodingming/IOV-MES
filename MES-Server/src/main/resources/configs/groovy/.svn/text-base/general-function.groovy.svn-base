package configs.groovy

import com.google.common.collect.Maps

/**
 * Created by xiuyou.xu on 2017/9/20.
 */
Map<String,Object> map = Maps.newHashMap();
String status = parameter.getStatus();
if ("1".equals(status)){
    map.put("message","Y");
}else {
    map.put("message","N");
}
parameter.getResponseMap().putAll(map);
return parameter;