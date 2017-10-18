package com.mes.control.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Constants;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.groovy.GroovyUtil;
import com.mes.common.framework.spring.ServiceBeanContext;
import com.mes.dubbo.interprovider.control.IPdBomWorkProvider;
import com.mes.entity.control.PdBomWork;
import com.mes.entity.control.PdWorkOrder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 扩展通配符操作工具类
 * Created by xiuyou.xu on 2017/10/10.
 */
public class ExtWildcardUtil {
    private static Logger logger = LoggerFactory.getLogger(ExtWildcardUtil.class);

    public static class TransformMessage {
        /**
         * 转换是否成功
         */
        private boolean success;
        /**
         * 转换操作结果
         */
        private String result;
        /**
         * 转换出错信息
         */
        private String message;

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    /**
     * 替换标签或条码中的通配符为实际值
     *
     * @param origin
     * @param params
     * @return
     */
    public static String replace(String origin, Map<String, Object> params) throws Exception {
        logger.debug("开始替换通配符：{}", origin);

        StringBuilder sb = new StringBuilder();

        // 当前通配符位置
        int i = origin.indexOf("@");
        // 上个通配符结束位置
        int j = 0;
        // 添加通配符前常量字符串，通配符后的常量字符串由while循环中添加
        if (i >= 0) {
            sb.append(origin.substring(j, i));
        }
        while (i >= 0) {
            int k = origin.indexOf("@", i + 1);
            String wildcard = null;
            if (k < 0) {
                wildcard = origin.substring(i);
                j += origin.length();
            } else {
                wildcard = origin.substring(i, k);
                j = k;
            }
            List<String> list = getTransformation(wildcard);
            String wc = list.get(0);
            String w = wc.substring(0, 4);
            try {
                if (wc.contains("(") && wc.contains(")")) {
                    // 通配符中的参数，使用特殊的key：_wc_param
                    params.put("_wc_param", wc.substring(wc.indexOf("(") + 1, wc.indexOf(")")));
                }
                String expected = (String) GroovyUtil.runScriptFile(GroovyUtil.class.getClassLoader().getResource("configs/barcodes/" + w + ".groovy").getFile(), params);
                if (expected != null && expected.contains("@")) {
                    expected = replace(expected, params);
                }
                if (wc.length() > 4) {
                    if (wc.contains(")")) {
                        if (!wc.endsWith(")")) {
                            expected += wc.substring(wc.indexOf(")") + 1);
                        }
                    } else {
                        expected += wc.substring(4);
                    }
                }
                if (list.size() > 1) {
                    for (int m = 1; m < list.size(); m++) {
                        String s = list.get(m);
                        TransformMessage message = null;
                        if (s.startsWith("%")) {
                            message = substring(expected, s);
                        }
                        if (s.startsWith("~")) {
                            message = transform(expected, s);
                        }
                        if (message != null) {
                            if (message.isSuccess()) {
                                expected = message.getResult();
                            } else {
                                throw new Exception(message.getMessage());
                            }
                        }
                    }
                }
                sb.append(expected);
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }

            i = origin.indexOf("@", j);
        }

        return sb.toString();
    }

    /**
     * 获取扩展通配符表达式列表，可能为空
     *
     * @param wildcard 原始的单个通配符表达式，如@902(3)%(-8:8)~(3:8)
     * @return [@902(3),%(-8:8),~(3:8)]
     */
    public static List<String> getTransformation(String wildcard) {
        List<String> ret = Lists.newArrayList();
        int current = -1;
        while (current < wildcard.length()) {
            int i = wildcard.indexOf("%", current + 1);
            int j = wildcard.indexOf("~", current + 1);
            // 如果i，j都非-1，则取其中小的，否则取其中非-1的，如果都为-1，则直接返回
            int h = -1;
            if (i >= 0) {
                if (j >= 0) {
                    h = Math.min(i, j);
                } else {
                    h = i;
                }
            } else {
                if (j >= 0) {
                    h = j;
                }
            }
            if (current < 0) {
                current = 0;
            }
            if (h >= 0) {
                ret.add(wildcard.substring(current, h));
                current = h;
            } else {
                ret.add(wildcard.substring(current));
                // 终止循环
                break;
            }
        }

        return ret;
    }

    /**
     * 截取字符串
     *
     * @param value    待操作字符串
     * @param wildcard 类似%(-8:8)
     * @return
     */
    public static TransformMessage substring(String value, String wildcard) {
        TransformMessage ret = new TransformMessage();

        int i = wildcard.indexOf("(");
        int j = wildcard.indexOf(")");
        String tail = "";
        if (j < wildcard.length() - 1) {
            tail = wildcard.substring(j + 1);
        }
        if (i < 0) {
            ret.setSuccess(false);
            ret.setMessage("缺少左括号(：" + wildcard);
            return ret;
        }
        if (j < 0) {
            ret.setSuccess(false);
            ret.setMessage("缺少右括号)：" + wildcard);
            return ret;
        }
        String[] s = wildcard.substring(i + 1, j).split(":");
        if (s == null || s.length != 2) {
            ret.setSuccess(false);
            ret.setMessage("参数个数错误：" + wildcard);
            return ret;
        }
        try {
            i = Integer.parseInt(s[0]);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setSuccess(false);
            ret.setMessage("参数不正确：" + s[0]);
            return ret;
        }
        try {
            j = Integer.parseInt(s[1]);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setSuccess(false);
            ret.setMessage("参数不正确：" + s[1]);
            return ret;
        }
        if (i < 0) {
            i = value.length() + i;
        }
        j = i + j;
        ret.setSuccess(true);
        ret.setResult(value.substring(i, j) + tail);

        return ret;
    }

    /**
     * 按函数转换
     *
     * @param value
     * @param wildcard
     * @return
     */
    public static TransformMessage transform(String value, String wildcard) {
        TransformMessage ret = new TransformMessage();

        int i = wildcard.indexOf("(");
        int j = wildcard.indexOf(")");
        String tail = "";
        if (j < wildcard.length() - 1) {
            tail = wildcard.substring(j + 1);
        }
        if (i < 0) {
            ret.setSuccess(false);
            ret.setMessage("缺少左括号(：" + wildcard);
            return ret;
        }
        if (j < 0) {
            ret.setSuccess(false);
            ret.setMessage("缺少右括号)：" + wildcard);
            return ret;
        }
        String[] s = wildcard.substring(i + 1, j).split(":");
        if (s == null || s.length != 2) {
            ret.setSuccess(false);
            ret.setMessage("参数个数错误：" + wildcard);
            return ret;
        }
        try {
            i = Integer.parseInt(s[0]);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setSuccess(false);
            ret.setMessage("参数不正确：" + s[0]);
            return ret;
        }
        try {
            String result = (String) GroovyUtil.runScriptFile(ExtWildcardUtil.class.getClassLoader().getResource("configs/barcodes/fn" + i + ".groovy").getFile(),
                    GroovyUtil.buildMap("value", value, "param", s[1]));
            ret.setSuccess(true);
            ret.setResult(result + tail);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setSuccess(false);
            ret.setMessage("转换出错：" + e.getMessage());
        }

        return ret;
    }

    /**
     * 根据工单id得到生成条码所需的所有信息，如线别、班次、流水号规则等
     *
     * @param pdWorkOrder     工单信息
     * @param batchNum        批次号
     * @param pdProductInfoId 单个产品信息id
     * @return
     */
    public static Map<String, Object> getBarcodeGenInfo(PdWorkOrder pdWorkOrder, String batchNum, String pdProductInfoId) {
        Map<String, Object> ret = Maps.newHashMap();
        // 得到生产线信息，班次信息，产品单项配置，bom清单
        if (pdWorkOrder != null) {
            ret.put("workOrderStartTime", pdWorkOrder.getRealStartTime());
            ret.put("productionLineId", pdWorkOrder.getProductionLineId());
            ret.put("workOrderNum", pdWorkOrder.getWorkOrderNum());
            ret.put("pdId", pdWorkOrder.getPdId());
            ret.put("workOrderStartTime", pdWorkOrder.getRealStartTime());

            String bomWorkId = pdWorkOrder.getBomWorkId();
            ret.put("bomWorkId", pdWorkOrder.getBomWorkId());
            try {
                IPdBomWorkProvider pdBomWorkProvider = (IPdBomWorkProvider) ServiceBeanContext.getInstance().getBean("pdBomWorkProvider");
                PdBomWork pdBomWork = pdBomWorkProvider.findById(bomWorkId);
                if (pdBomWork != null) {
                    ret.put("bomProduceId", pdBomWork.getBomProduceId());
                }
            } catch (DubboProviderException e) {
                e.printStackTrace();
            }
        }
        ret.put("batchNum", batchNum);
        ret.put("pdProductInfoId", pdProductInfoId);

        return ret;
    }

    @Test
    public void test() {
//        System.out.println(getTransformation("254@904(SN)@903(pl_client_number)abc"));
//        System.out.println(JSON.toJSONString(substring("12345678", "%(-2:2)ABC")));
//        System.out.println(JSON.toJSONString(transform("1234565468925", "~(3:8)kkk")));
        try {
            ServiceBeanContext.getInstance().loadContext(Constants.Env.BASE_HOME + "applicationContext.xml");
//            System.out.println(replace("@904(SN)~(3:8)bbb%(-8:8)ccc", GroovyUtil.buildMap("pdProductInfoId", "H9B7ADB610F554530BA8C516D06B35695")));
            System.out.println(replace("254@022@023@024@036@049@053@054@055@800@901(833600206)@903(pl_client_number)@904(SN)abc", GroovyUtil.buildMap("workOrderStartTime", new Date(),
                    "erpCode", "600160001", "batchNum", "1234567891234567ABC", "workOrderNum", "B123", "pdId", "H33C3FD2C246E4FC4A95279C70F554D28",
                    "bomWorkId", "HFB4A79C57B064D6A9E47089E4757DFDA", "bomProduceId", "H2310D507899B44DDBE80C7B8B6D4A096", "productionLineId", "H91B8D186D9E9456B89A99CA038CDDDFA",
                    "pdProductInfoId", "H23AB5B993BA24357A9E32145F653A93E")));
//            System.out.println(getTransformation("@904(SN)aaa~(3:8)bbb%(-8:8)ccc"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
