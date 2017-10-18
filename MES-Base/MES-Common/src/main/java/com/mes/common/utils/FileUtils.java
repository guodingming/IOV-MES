package com.mes.common.utils;

import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * Created by xiuyou.xu on 2017/7/19.
 */
public class FileUtils {
    /**
     * 读取输入流中的数据，写入文件中
     *
     * @param file
     * @param is
     * @return
     */
    public static boolean write(File file, InputStream is) {
        file.getParentFile().mkdirs();
        try (OutputStream os = new FileOutputStream(file)) {
            byte[] buf = new byte[2048];
            int len = -1;
            while ((len = is.read(buf)) != -1) {
                os.write(buf, 0, len);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 读取输入流中的数据，写入文件中
     *
     * @param filepath
     * @param is
     * @return
     */
    public static boolean write(String filepath, InputStream is) {
        return write(new File(filepath), is);
    }

    /**
     * 将原文件路径对应的文件写入目标路径对应的文件
     * @param sourceFilePath    原文件路径
     * @param targetFilePath    目标文件路径
     * @param isCover           存在同名时是否覆盖
     * @return
     */
    public static boolean copyFileTo(String sourceFilePath, String targetFilePath, boolean isCover) {
        boolean flag = true;
        try {
            File sourceFile = new File(sourceFilePath);
            File targetFile = new File(targetFilePath);
            if (targetFile.exists()) {
                if (isCover) {
                    targetFile.delete();
                } else {
                    flag = false;
                    throw new Exception("存在同名文件");
                }
            } else {
                targetFile.getParentFile().mkdirs();
            }
            FileInputStream fis = new FileInputStream(sourceFile);
            FileOutputStream fos = new FileOutputStream(targetFile);
            byte[] buf = new byte[1024];
            int c;
            while ((c = fis.read(buf)) != -1) {
                fos.write(buf, 0, c);
            }
            fos.flush();
            fis.close();
            fos.close();
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 获取文件扩展名
     *
     * @param file
     * @return
     */
    public static String getExt(File file) {
        if (file == null) {
            return "";
        }
        String name = file.getName();
        return name.contains(".") ? name.substring(name.lastIndexOf(".") + 1) : name;
    }

    /**
     * 将给定字符写入目标文件
     *
     * @param content
     * @param file
     * @return
     */
    public static boolean write(String content, File file) throws Exception {
        boolean flag = false;
        file.getParentFile().mkdirs();
        InputStream in = new ByteArrayInputStream(content.getBytes("UTF-8"));
        try (OutputStream os = new FileOutputStream(file)) {
            byte[] buf = new byte[2048];
            int len = -1;
            while ((len = in.read(buf)) != -1) {
                os.write(buf, 0, len);
            }
            flag = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 文件内容读取为一个字符串
     * @param file
     * @return
     */
    public static String readToString(File file) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            InputStream is = new FileInputStream(file);
            IOUtils.copy(is, baos);
            IOUtils.closeQuietly(is);
            return new String(baos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
