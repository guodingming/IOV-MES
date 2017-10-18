package com.mes.common.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.ws.rs.core.StreamingOutput;
import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Created by xiuyou.xu on 2017/7/21.
 */
public class ExcelHandler {
    /**
     * 读取xls文件
     *
     * @param is
     * @return
     */
    public static List<Map<String, Object>> readXls(InputStream is) {
        List<Map<String, Object>> ret = Lists.newArrayList();
        try (HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is)) {
            // 只读取第一个sheet，其他的丢弃
            HSSFSheet sheet = hssfWorkbook.getSheetAt(0);
            if (sheet != null) {
                for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                    readRow(ret, sheet.getRow(i));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ret;
    }

    /**
     * 读取xlsx文件
     *
     * @param is
     * @return
     */
    public static List<Map<String, Object>> readXlsx(InputStream is) {
        List<Map<String, Object>> ret = Lists.newArrayList();
        try (XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is)) {
            // 只读取第一个sheet，其他的丢弃
            XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
            if (sheet != null) {
                for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                    readRow(ret, sheet.getRow(i));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ret;
    }

    /**
     * 根据excel扩展名读取
     *
     * @param fileExt
     * @param sheetIndex sheet索引，从0开始
     * @param is
     * @return
     */
    public static List<Map<String, Object>> read(String fileExt, int sheetIndex, InputStream is) throws Exception {
        try (Workbook xssfWorkbook = fileExt.equalsIgnoreCase("xlsx") ? new XSSFWorkbook(is) : new HSSFWorkbook(is)) {
            List<Map<String, Object>> ret = Lists.newArrayList();
            Sheet sheet = xssfWorkbook.getSheetAt(sheetIndex);
            if (sheet != null) {
                for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                    readRow(ret, sheet.getRow(i));
                }
            }

            return ret;
        } catch (Exception e) {
            throw e;
        }
    }

    private static void readRow(List<Map<String, Object>> ret, Row row) {
        if (row != null) {
            int columnCount = row.getPhysicalNumberOfCells();
            Map<String, Object> record = Maps.newHashMap();
            for (int j = 0; j < columnCount; j++) {
                record.put("column" + j, row.getCell(j) != null ? row.getCell(j).toString() : "");
            }
            ret.add(record);
        }
    }

    /**
     * 将excel读取为map，key为sheet名，value为sheet对象
     *
     * @param fileExt
     * @param is
     * @return
     */
    public static Map<String, Sheet> getSheetMap(String fileExt, InputStream is) {
        Map<String, Sheet> ret = Maps.newHashMap();
        try (Workbook xssfWorkbook = fileExt.equalsIgnoreCase("xlsx") ? new XSSFWorkbook(is) : new HSSFWorkbook(is)) {
            int count = xssfWorkbook.getNumberOfSheets();
            for (int i = 0; i < count; i++) {
                Sheet sheet = xssfWorkbook.getSheetAt(i);
                ret.put(sheet.getSheetName(), sheet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ret;
    }

    /**
     * 将excel读取为list，每个元素为sheet
     *
     * @param fileExt
     * @param is
     * @return
     */
    public static List<Sheet> getSheetList(String fileExt, InputStream is) {
        List<Sheet> ret = Lists.newArrayList();
        try (Workbook xssfWorkbook = fileExt.equalsIgnoreCase("xlsx") ? new XSSFWorkbook(is) : new HSSFWorkbook(is)) {
            int count = xssfWorkbook.getNumberOfSheets();
            for (int i = 0; i < count; i++) {
                Sheet sheet = xssfWorkbook.getSheetAt(i);
                ret.add(sheet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ret;
    }

    /**
     * 读取excel文件内容并转换为xml格式字符串
     *
     * @param fileExt
     * @param is
     * @param rootNodeName
     * @param rowNodeNames 每个sheet中的行的节点名称，每个sheet一个，如果为null，则默认为row
     * @return
     */
    public static String toXml(String fileExt, InputStream is, String rootNodeName, String... rowNodeNames) {
        StringBuilder sb = new StringBuilder();
        if (rootNodeName != null && !rootNodeName.isEmpty()) {
            sb.append("<").append(rootNodeName).append(">");
        }
        try (Workbook xssfWorkbook = fileExt.equalsIgnoreCase("xlsx") ? new XSSFWorkbook(is) : new HSSFWorkbook(is)) {
            int count = xssfWorkbook.getNumberOfSheets();
            for (int i = 0; i < count; i++) {
                Sheet sheet = xssfWorkbook.getSheetAt(i);
                if (sheet != null) {
                    sb.append("<").append(sheet.getSheetName()).append(">");
                    readSheet(sb, sheet, rowNodeNames.length > i ? rowNodeNames[i] : null);
                    sb.append("</").append(sheet.getSheetName()).append(">");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (rootNodeName != null && !rootNodeName.isEmpty()) {
            sb.append("</").append(rootNodeName).append(">");
        }
        return sb.toString();
    }

    /**
     * 读取单个sheet
     *
     * @param sb
     * @param sheet
     * @param rowNodeName
     * @return sheet中的行数，不含表头
     */
    public static int readSheet(StringBuilder sb, Sheet sheet, String rowNodeName) {
        rowNodeName = rowNodeName == null ? "row" : rowNodeName;
        int rows = 0;
        if (sheet != null) {
            // 第一行为表头，值为各列名称
            Row header = sheet.getRow(0);
            List<String> columns = Lists.newArrayList();
            if (header != null) {
                int count = header.getPhysicalNumberOfCells();
                for (int j = 0; j < count; j++) {
                    Cell cell = header.getCell(j);
                    columns.add(cell != null ? cell.toString() : "");
                }
            }
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    rows++;
                    sb.append("<").append(rowNodeName).append(">");
                    int columnCount = row.getPhysicalNumberOfCells();
                    for (int j = 0; j < columnCount; j++) {
                        Cell cell = row.getCell(j);
                        sb.append("<").append(columns.get(j)).append(">").append(cell != null ? cell.toString() : "").append("</").append(columns.get(j)).append(">");
                    }
                    sb.append("</").append(rowNodeName).append(">");
                }
            }
        }
        return rows;
    }

    public static StreamingOutput write(List<Map<String, Object>> rows, String sheetName) throws IOException {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet(sheetName);
            if (sheet != null && rows != null && !rows.isEmpty()) {
                for (int i = 0; i < rows.size(); i++) {
                    writeRow(rows.get(i), sheet, i);
                }
            }
            File f = new File("./tmp/" + IDGenerator.getID() + ".xlsx");
            f.getParentFile().mkdirs();
            FileOutputStream os = new FileOutputStream(f);
            workbook.write(os);
            return new StreamingOutput() {
                @Override
                public void write(OutputStream output) throws IOException {
                    FileInputStream is = new FileInputStream(f);
                    IOUtils.copy(is, output);
                    IOUtils.closeQuietly(is);
                    f.delete();
                }
            };
        } catch (Exception e) {
            throw e;
        }
    }

    private static void writeRow(Map<String, Object> row, Sheet sheet, int index) {
        Row r = sheet.createRow(index);
        for (int i = 0; i < row.size(); i++) {
            //判断是否为null，否则没法做toString
            if(row.get("column" + i)!=null) {
                r.createCell(i).setCellValue(row.get("column" + i).toString());
            }else {
                r.createCell(i).setCellValue("");
            }
        }
    }
}
