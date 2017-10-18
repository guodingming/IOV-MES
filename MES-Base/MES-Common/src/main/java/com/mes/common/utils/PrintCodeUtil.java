package com.mes.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dengyun.le on 2017/8/15.
 */
public class PrintCodeUtil {

    protected Logger log = LoggerFactory.getLogger(getClass());

    //时间格式化
    public static String dateFormat(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = null;
        if(!date.equals("")) {
            dateStr = formatter.format(date).replace("-","");
        }
        return dateStr;
    }
    public static String dateFormat(String date){
        String dateStr1=null;
        String dateStr =null;
        if(date.contains("-")) {
         dateStr1=date.replace("-", "");
        }else {
            dateStr1=date;
        }
        if(dateStr1.length()>=8) {
            dateStr = dateStr1.substring(0, 8);
        }else {
            dateStr = dateStr1.substring(0,dateStr1.length());
        }
        return dateStr;
    }

    //两位年
    public static String twoYear(String year ){
        String yy = null;
     if(!year.equals("")) {
         if(year.length()>=4) {
             yy = year.substring(2, 4);
         }else {
             if(year.length()>=2) {
                 yy = year.substring(year.length()-2,year.length());
             }else {
                 yy = year;
             }
         }
        }
    return yy;
    }
    //传入批次号截取两位年
    public static String tyear(String year){
        String yy = null;
        if(!year.equals("")){
            yy = year.substring(0,2);
        }else {
            yy = year;
        }
        return yy;
    }
    //两位月
    public static String towMonth(String month){
        String mm =null;
        if(!month.equals("")) {
            if(month.length()>=6) {
                mm = month.substring(4, 6);
            }else {
                if(month.length()>=4){
                    mm =month.substring(2,month.length());
                }else {
                    mm = month;
                }
            }
        }
    return mm;

    }

    //传入批次号截取两位月
    public static String tmonth(String month){
        String mm = null;
        if(!month.equals("")){
            mm = month.substring(2,4);
        }
        return mm;
    }

    //两位日
    public static String towDay(String day){
        String dd =null;
        if(!day.equals("")) {
            dd=day.substring(6,8);
        }
        return dd;
    }

    //传入批次号截取两位天
    public static String tday(String day){
        String dd = null;
        if(!day.equals("")){
            dd = day.substring(4,6);
        }
        return dd;
    }
    //三位天计算
    public static String threeDay(String threeDay) {//计算三位天
        int year = Integer.parseInt(threeDay.substring(0, 4));
        int month = Integer.parseInt(threeDay.substring(4, 6));
        int day = Integer.parseInt(threeDay.substring(6,8));
        int count = 0;
        int dd = 0;
        if (year > 0 && month > 0 && month < 13 && day > 0 && day < 32) {
            for (int i = 1; i < month; i++) {
                switch (i) {
                    case 01:
                    case 03:
                    case 05:
                    case 07:
                    case 8:
                    case 10:
                    case 12:
                        dd = 31;
                        break;
                    case 04:
                    case 06:
                    case 9:
                    case 11:
                        dd = 30;
                        break;
                    case 02: {
                        if ((year % 4 == 0 && year % 1 != 0) || (year % 400 == 0)) {
                            dd = 29;
                        } else {
                            dd = 28;
                        }
                        break;
                    }
                }
                count = count + dd;
            }
        }
        count = count + day;
        if (count < 100) {
            return ("0" + String.valueOf(count));
        } else {
            return (String.valueOf(count));
        }
    }

    //传入批次号计算三位天
    public static String countDay(String bath_no) {
        int year = Integer.parseInt("20" + bath_no.substring(0, 2));
        int month = Integer.parseInt(bath_no.substring(2, 4));
        int day = Integer.parseInt(bath_no.substring(4, 6));
        int count = 0;
        int dd = 0;
        if (year > 0 && month > 0 && month < 13 && day > 0 && day < 32) {
            for (int i = 1; i < month; i++) {
                switch (i) {
                    case 01:
                    case 03:
                    case 05:
                    case 07:
                    case 8:
                    case 10:
                    case 12:
                        dd = 31;
                        break;
                    case 04:
                    case 06:
                    case 9:
                    case 11:
                        dd = 30;
                        break;
                    case 02: {
                        if ((year % 4 == 0 && year % 1 != 0) || (year % 400 == 0)) {
                            dd = 29;
                        } else {
                            dd = 28;
                        }
                        break;
                    }
                }
                count = count + dd;
            }
        }
        count = count + day;
        if (count < 100) {
            return ("0" + String.valueOf(count));
        } else {
            return (String.valueOf(count));
        }
    }

    //将字符串转换成ASCII码
    public static String stringToAscii(String value) {//ASCII转换
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i != chars.length - 1) {
                sbu.append((int) chars[i]).append(" ");
            } else {
                sbu.append((int) chars[i]);
            }
        }
        return sbu.toString();
    }


    //字符串截取
    public  static String strCut(String str,int indexOrlast,int digit){
        String cutStr = null;
        if( indexOrlast>=0 && digit>0 ){
            cutStr = str.substring(indexOrlast,indexOrlast+digit);
        }
        if(indexOrlast<0){

            cutStr = str.substring(str.length()+indexOrlast,str.length());
        }
        return cutStr;
    }

    public static String strCut(String str,int flag){
        String cutStr = null;
        if (flag >0 ){
            if(str.length()>flag) {
                cutStr = str.substring(0, flag);
            }else {
                cutStr = str.substring(0,str.length());
            }
        }else if(flag <0){
            if((str.length()+flag)>0) {
                cutStr = str.substring(str.length() + flag, str.length());
            }else {
                cutStr = str;
            }

        }
        return cutStr;
    }

    //转换成8位16进制

    public static String toHex(int aa){
        String str ="";
        String hex = Integer.toHexString(aa).toUpperCase();
        int x = hex.length();
        if(x<8){
            for (int i=0;i<8-x;i++){
                str +="0";
            }

        }
        return str+hex;
    }
    public static String toHex(long ll){
        String str ="";
        String hex = Long.toHexString(ll).toUpperCase();
        int x = hex.length();
        if(x<8){
            for (int i=0;i<8-x;i++){
                str +="0";
            }

        }
        return str+hex;

    }
    //左截取5位不足补F

    public static String leftCut(String str){
        String sttr;
        String temp="";
        int x = str.length();
        if(x>5){
            sttr = str.substring(0,5);
        }else {
                sttr = str;
            for (int i=0;i<5-x;i++){
                temp +="F";
            }
        }
        return sttr+temp;
    }
    //右截取5位不足补F
    public static String rightCut(String str){
        String sttr;
        String temp="";
        int x = str.length();
        if(x>5){
            sttr = str.substring(x-5,x);
        }else {
            sttr = str;
            for (int i=0;i<5-x;i++){
                temp +="F";
            }
        }
        return temp+sttr;
    }
    public static void main(String[] args) {
      //  Date date = new Date();
       // String time =dateFormat(date);
      //  String time=dateFormat("017");
      // twoYear(time);
       // towMonth(time);
       // towDay(time);
       // threeDay(time);
       // stringToAscii("lele");
     //  strCut("789456123",2,4);
        //strCut("789456123",-4,4);
        //strCut("789654123",-4);
       // toHex(1821);
       // toHex(789654123L);
        //leftCut("1234");
        //rightCut("1234");
       // tyear("13C08AA");
        //tmonth("13C08AA ");
       // tday("13C08AA ");

        String strXML = "<taskinfo>\n\t" + "<bill_no>" + "C1111AA" + "</bill_no>\n\t" + "<procedure_name>" +
                "软件注入" + "</procedure_name>\n\t" + "<procedure_id>" +"1111"+
                "</procedure_id>\n\t" + "<batch>" + "122809AA" + "</batch>\n\t" + "<product_id>" +"23232" +
                "</product_id>\n\t"+"<material_id>" + "879897" +"</material_id>\n\t" +
                "<product_code>" + "60060006007899" + "</product_code>\n\t" + "<machine_id>" + "45678" +
                "</machine_id>\n\t" + "<task_mode>0</task_mode>" +"\n</taskinfo>\n";

        System.out.print(strXML);
    }

}
