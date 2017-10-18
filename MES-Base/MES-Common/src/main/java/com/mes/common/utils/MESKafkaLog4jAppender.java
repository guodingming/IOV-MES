package com.mes.common.utils;

import com.mes.common.framework.Constants;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.log4jappender.KafkaLog4jAppender;
import org.apache.log4j.spi.LoggingEvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * log4j日志处理器，用于将日志集中发送到Kafka。
 * <p>
 * Created by he.liu on 2017/7/13.
 */
public class MESKafkaLog4jAppender extends KafkaLog4jAppender {
    @Override
    protected void append(LoggingEvent event) {
        String message = subAppend(event);
        // 与基类KafkaLog4jAppender的区别：当异常上报时，将异常栈内容也加入上报字符串。
        String[] throwableStrRep = event.getThrowableStrRep();
        if (null != throwableStrRep) {
            StringBuilder sb = new StringBuilder();
            sb.append(message);
            for (String s : throwableStrRep) {
                sb.append(s).append("\n");
            }
            message = sb.toString();
        }

        // LogLog.debug("[" + new Date(event.getTimeStamp()) + "]" + message);
        Future<RecordMetadata> response = getProducer().send(new ProducerRecord<>(getTopic(), message.getBytes()));
        if (getSyncSend()) {
            try {
                response.get();
            } catch (InterruptedException | ExecutionException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private String subAppend(LoggingEvent event) {
        return (this.layout == null) ? event.getRenderedMessage() : this.layout.format(event);
    }


    @Override
    public void activateOptions() {
        String kafkaBrokerUrl = KafkaConfigHelper.getValue("log.kafka.url");
//        String kafkaTopic = KafkaConfigHelper.getValue("log.kafka.topic");

        this.setBrokerList(kafkaBrokerUrl);
//        this.setTopic(kafkaTopic);
        super.activateOptions();
    }

    /**
     * log4j kafka config helper，使用单独的配置文件读取方法，内部不进行日志打印。
     */
    private static class KafkaConfigHelper {
        private static Properties properties = new Properties();

        static {
            try {
                InputStream input = new FileInputStream(getFile("configs/config.properties",
                        Constants.Env.BASE_HOME));
                properties.load(input);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private static File getFile(String fileName, String propertyName) throws Exception {
            String filePath = null;
            if (propertyName != null && !"".equals(propertyName)) {
                filePath = System.getProperty(propertyName);
            }
            File file;

            if (filePath == null || "".equals(filePath)) {
                URI uri;
                try {
                    uri = KafkaConfigHelper.class.getClassLoader().getResource(fileName).toURI();
                } catch (Exception e) {
                    uri = null;
                }

                if (uri == null) {
                    throw new FileNotFoundException(fileName + " not found!");
                }
                file = new File(uri.getPath());
            } else {
                filePath = filePath.endsWith("/") ? filePath.concat(fileName)
                        : filePath.concat("/").concat(fileName);
                file = new File(filePath);
            }
            return file;
        }

        static String getValue(String key) {
            return properties.getProperty(key);
        }
    }
}
