package com.mes.utils;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;
import java.io.*;

/**
 * Created by dengyun.le on 2017/9/22.
 */
public class DownLoadUntil {

    /**
     * 下载指定路径下的文件
     * @param path
     * @return
     */
    public static StreamingOutput LoadFileByPath(String path){
        InputStream fis = null;
        try {
            fis = new BufferedInputStream(new FileInputStream(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStream finalFis = fis;
        StreamingOutput stream = new StreamingOutput() {
            InputStream inputStream = finalFis;
            @Override
            public void write(OutputStream os) throws IOException,
                    WebApplicationException {
                try {
                    byte[] bytes = new byte[1024];
                    int n = inputStream.read(bytes);
                    while (n != -1) {
                        os.write(bytes, 0, n);
                        n = inputStream.read(bytes);
                    }
                } catch (Exception e) {
                    throw new IOException(e);
                } finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            }
        };
        return stream;
    }
}
