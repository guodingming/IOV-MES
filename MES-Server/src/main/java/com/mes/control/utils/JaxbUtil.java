package com.mes.control.utils;

import com.mes.control.device.ChipOperateData;
import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by xiuyou.xu on 2017/8/29.
 */
public class JaxbUtil {
    /**
     * 从字符串中反序列化得到java bean
     *
     * @param klass
     * @param xml
     * @param <T>
     * @return
     */
    public static <T> T unmarshal(Class<T> klass, String xml) {
        try {
            JAXBContext context = JAXBContext.newInstance(klass);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            return (T) unmarshaller.unmarshal(new StringReader(xml));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 序列化java bean到xml
     *
     * @param klass
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> String marshal(Class<T> klass, Object obj) {
        try {
            JAXBContext context = JAXBContext.newInstance(klass);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            return writer.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 格式化xml
     *
     * @param xml
     * @return
     */
    public static String format(String xml) {
        try {
            SAXReader reader = new SAXReader();
            StringReader in = new StringReader(xml);
            Document doc = reader.read(in);
            OutputFormat formater = OutputFormat.createPrettyPrint();
            formater.setSuppressDeclaration(true);
            StringWriter out = new StringWriter();
            XMLWriter writer = new XMLWriter(out, formater);
            writer.write(doc);
            writer.close();
            return out.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @Test
    public void test() {
        String xml = "<ChipOperateData>\n" +
                "    <DownloadResult>1</DownloadResult>\n" +
                "    <Channel>1</Channel>\n" +
                "    <ChipOperateResult>\n" +
                "        <ChipOperateUnit>\n" +
                "            <Address>FFAA</Address>\n" +
                "            <Content>16</Content>\n" +
                "            <SaveType>1</SaveType>\n" +
                "            <OldContent>16</OldContent>\n" +
                "        </ChipOperateUnit>\n" +
                "        <ChipOperateUnit>\n" +
                "            <Address>FFA1</Address>\n" +
                "            <Content>010101</Content>\n" +
                "            <SaveType>1</SaveType>\n" +
                "            <OldContent>1.1.1</OldContent>\n" +
                "        </ChipOperateUnit>\n" +
                "        <ChipOperateUnit>\n" +
                "            <Address>FF90</Address>\n" +
                "            <Content>0600160001000009</Content>\n" +
                "            <SaveType>1</SaveType>\n" +
                "            <OldContent>600160001</OldContent>\n" +
                "        </ChipOperateUnit>\n" +
                "        <ChipOperateUnit>\n" +
                "            <Address>FFA3</Address>\n" +
                "            <Content>3132353645</Content>\n" +
                "            <SaveType>1</SaveType>\n" +
                "            <OldContent>30021256E00</OldContent>\n" +
                "        </ChipOperateUnit>\n" +
                "        <ChipOperateUnit>\n" +
                "            <Address>1600</Address>\n" +
                "            <Content>040000</Content>\n" +
                "            <SaveType>1</SaveType>\n" +
                "            <OldContent>890000042</OldContent>\n" +
                "        </ChipOperateUnit>\n" +
                "        <ChipOperateUnit>\n" +
                "            <Address>7C33</Address>\n" +
                "            <Content>020000</Content>\n" +
                "            <SaveType>1</SaveType>\n" +
                "            <OldContent>890000041</OldContent>\n" +
                "        </ChipOperateUnit>\n" +
                "        <ChipOperateUnit>\n" +
                "            <Address>7C30</Address>\n" +
                "            <Content>020000</Content>\n" +
                "            <SaveType>1</SaveType>\n" +
                "            <OldContent>890000041</OldContent>\n" +
                "        </ChipOperateUnit>\n" +
                "        <ChipOperateUnit>\n" +
                "            <Address>F41A</Address>\n" +
                "            <Content>010205</Content>\n" +
                "            <SaveType>1</SaveType>\n" +
                "            <OldContent>890000094</OldContent>\n" +
                "        </ChipOperateUnit>\n" +
                "    </ChipOperateResult>\n" +
                "</ChipOperateData>";
        ChipOperateData info = unmarshal(ChipOperateData.class, xml);
        System.out.println(info);
    }
}
