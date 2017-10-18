package com.mes.agent.utils;

import com.mes.common.framework.config.ConfigHelper;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import org.junit.Test;

import javax.print.*;
import javax.print.attribute.PrintServiceAttribute;
import javax.print.attribute.standard.PrinterName;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.Socket;

/**
 * Created by xiuyou.xu on 2017/9/20.
 */
public class PrintUtil {
    /**
     * usb端口打印
     *
     * @param cmd
     * @throws Exception
     */
    public static void usbPrint(String cmd) throws Exception {
        PrintService printService = null;
        String sPrinterName = null;
        PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);

        for (int i = 0; i < services.length; i++) {
            PrintServiceAttribute attr = services[i].getAttribute(PrinterName.class);
            sPrinterName = ((PrinterName) attr).getValue();
            if (sPrinterName.startsWith(ConfigHelper.getValue("printer.name.prefix"))) {
                printService = services[i];
                break;
            }
        }

        if (printService == null) {
            System.out.println("Printer not found.");
            return;
        }
        DocPrintJob job = printService.createPrintJob();
        byte[] by = cmd.getBytes();
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        Doc doc = new SimpleDoc(by, flavor, null);
        job.print(doc, null);
    }

    private static void addLibraryDir(String libraryPath) throws Exception {
        Field userPathsField = ClassLoader.class.getDeclaredField("usr_paths");
        userPathsField.setAccessible(true);
        String[] paths = (String[]) userPathsField.get(null);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < paths.length; i++) {
            if (libraryPath.equals(paths[i])) {
                continue;
            }
            sb.append(paths[i]).append(";");
        }
        sb.append(libraryPath);
        System.setProperty("java.library.path", sb.toString());
        final Field sysPathsField = ClassLoader.class.getDeclaredField("sys_paths");
        sysPathsField.setAccessible(true);
        sysPathsField.set(null, null);
    }

    String cmd = "CT~~CD,~CC^~CT~\n^XA~TA000~JSN^LT0^MNW^MTT^PON^PMN^LH0,0^JMA^PR4,4~SD15^JUS^LRN^CI0^XZ\n~DG000.GRF,03456,036,,:::::::::::::::::::::::::::::::::N07FHFH03E0H0783C001E0V0E0J038,N07FHFC03E0H0781C001C0V0C0J018,N07FHFE03E0H0F81C0H0C0V0E0J038,N07001F03F0H0FC1C001C0V0C0J018,N070H0F03F0H0F83C0H0E0V0E0J038,N070H07037001D81C001C0V0C0J018,N060H0383B801B81C0H0C0V0E0J038,N070H07031801981C001C0H043C0F001F80078C0C01C1807C0,N070H0783B803B83C001E0H0EFE3FE03FE03FEE0E038380FF8,N070H07031C03181C001C0H06FF3FC07FF03FFC1C01C181FFC,N06001E039C03381C0H0C0H0F87E1E0E0F8383E0C01838381E,N07FHFC030C071C1C001C0H0703C0C1C038701C0C01C18700C,N07FHF8038E06381C0H0E0H0E0380E3C038E00E0E03838600E,N07FHFH030606181C001C0H06038061801C600C1C01C186007,N0603C0038E0E381C0H0C0H0E0380E38018E00E0C01838FHFE,N0700F003070C181C001C0H04018041801CC0040C01C187FHF,N0700F803830C383C003E0H0E0380E3803CE00E0E03838FIF,N070038030318181C001C0H06038061801C60041C01C1860,N06003C038398380C001C0H0E0380E18038E00E0E01838E0,N07001C0301901C0C001C0H04018061C018600C0C01C1870,N070H0E0383B8380F00380H0E0380E1E038703E0E03838780E,N070H070301F018078070I06038060F070783C0707C183C1E,N060H0F8380E03803FFE0I0E0380E0FFE03FEE0FHF8383FFC,N070H078300E01801FFC0I040180407FC01FCC07F9C181FF8,N070H03E380E038007F80I0E0380E01F80078E03F383803E0,,::::::::::::::::::::::::::::::::::::~DG001.GRF,01920,020,,::::::::::::::::::::::V040H05FDF80,T03F23FLFE,S01F4150K07E,S0F80F80L03E0,R07C0580N07C40,Q03F20F0P0F80,Q07C01E0P01E0,Q0F80BE0Q038,P05C007F0Q01C,P0FE07FE2FKF80I02F20,P07007FC1FKF80J0780,P07003FC3FKF80J0388,P06001FF7FFDHDF80J01C0,O02E003FIFEB9BF80K0E0,O01C0H07FHFC599F80K060,O01C0I0IFCFACF80K0E2,O01C0I01DFC585F80K060,O03E0J03FEDA7F80K0FE,O01C0K07C185F80K07C,O01C0K0LF80K03C,O01C0K07C001F80K01C,P0E0K0FE23FFB820I038,P070K07F77FIFK070,P0780J0NFC80H0E0,P01C0J07FJFDFE5001C0,P03E00200FKF8FHF80380,P04780P01FF046,Q0DE0Q0FE03C,Q0560P01FC050,Q02E20N023F9380,R0140N01F614,S03E0L03FF8E0,T0150J01FF84,R02020FLF3E0,,::O02E203E0383FFE0H03FF3E03E0,N0150501F0187FFC001FF71E07E0,N03C0H03B038E0J03C003F83E0,O0540071819E0H05E1C5D1985E0,P07E0E3E39E0H03E3E3F39AEE0,Q079F5E19E0J01C0719F9E0,O0IFB80E38F80I03E0FB8F8E0,O05F878051815540H0H591851C0,O020J020H020J0202,,::::::::::::::::::::::::::^XA\n^MMT\n^PW480\n^LL0304\n^LS0\n^FT192,96^XG000.GRF,1,1^FS\n^FT32,128^XG001.GRF,1,1^FS\n^FT308,105^A0N,34,33^FH\\^FD9112^FS\n^FT61,267^A0N,23,24^FH\\^FDICCID:89860617020032123766^FS\n^FT219,106^A0N,23,24^FH\\^FD2624^FS\n^FT219,146^A0N,23,24^FH\\^FD0000000075204X^FS\n^FT219,186^A0N,23,24^FH\\^FD545245003^FS\n^FT219,227^A0N,23,24^FH\\^FD1117171A04000004^FS\n^BY78,78^FT64,215^BXN,3,200,0,0,1,~\n^FH\\^FD[)>06Y0000000075204XP2623815812V545245003T1117171A04000004^FS\n^PQ1,0,1,Y^XZ\n^XA^ID000.GRF^FS^XZ\n^XA^ID001.GRF^FS^XZ";

    /**
     * COM端口打印
     */
    @Test
    public void testCom() {
        try {
            PrintUtil.serialPrint(cmd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 串口打印，需要在java.library.path中放rxtxSerial.dll
     *
     * @param cmd
     * @throws Exception
     */
    public static void serialPrint(String cmd) throws Exception {
//        try {
        addLibraryDir(PrintUtil.class.getClassLoader().getResource("printer-dll").getFile());

        //1.定义变量
        CommPortIdentifier commPortIdentifier = null;//用于记录本地串口
        SerialPort serialCom3 = null;//用于标识打开的串口

//            try {
        commPortIdentifier = CommPortIdentifier.getPortIdentifier(ConfigHelper.getValue("printer.com.port"));

        //3.打开COM11
        serialCom3 = (SerialPort) commPortIdentifier.open("COMWriter", 1000);

        //4.往串口写数据（使用串口对应的输出流对象）
        //4.1.获取串口的输出流对象
        OutputStream outputStream = serialCom3.getOutputStream();

        //4.2.通过串口的输出流向串口写数据“Hello World!”：
        //使用输出流往串口写数据的时候必须将数据转换为byte数组格式或int格式，
        //当另一个串口接收到数据之后再根据双方约定的规则，对数据进行解码。
        outputStream.write(cmd.getBytes());
        outputStream.flush();
        //4.3.关闭输出流
        outputStream.close();

        //5.关闭串口
        serialCom3.close();


//            } catch (NoSuchPortException e) {
//                //找不到串口的情况下抛出该异常
//                e.printStackTrace();
//            } catch (PortInUseException e) {
//                //如果因为端口被占用而导致打开失败，则抛出该异常
//                e.printStackTrace();
//            } catch (IOException e) {
//                //如果获取输出流失败，则抛出该异常
//                e.printStackTrace();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    /**
     * tcp网络打印
     *
     * @param ip
     * @param port
     * @param cmd
     * @throws Exception
     */
    public static void tcpPrint(String ip, int port, String cmd) throws Exception {
        try (Socket socket = new Socket(ip, port)) {
            OutputStream os = socket.getOutputStream();
            os.write(cmd.getBytes());
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
