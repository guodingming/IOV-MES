package com.mes.control.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Lists;
import com.mes.es.cloudindex.CloudIndexClient;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by xiuyou.xu on 2017/8/3.
 */
public class KafkaConsumerUtil {
    public static KafkaConsumer createConsumer(List<String> addresses, String groupId) {
        Properties props = new Properties();
        props.put("bootstrap.servers", String.join(",", addresses));
        props.put("group.id", groupId);
//        props.put("retries", 0);
//        props.put("batch.size", 16384);
//        props.put("max.poll.records", 100); // default is 500
//        props.put("linger.ms", 1);
//        props.put("buffer.memory", 33554432);
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer consumer = new KafkaConsumer(props);
        return consumer;
    }

    public static void writeToES(KafkaConsumer consumer, String topic, CloudIndexClient client, String index, String type) {
        consumer.subscribe(Lists.newArrayList(topic));

//        TopicPartition partition = new TopicPartition(topic, 0);
//        consumer.assign(Lists.newArrayList(partition));
//        consumer.seekToBeginning(Lists.newArrayList(partition));

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(3000);
            List<Map<String, Object>> list = Lists.newArrayList();
            records.forEach(record -> {
                list.add(JSON.parseObject(record.value(), new TypeReference<Map<String, Object>>() {
                }));
            });
            try {
                client.bulkIndex(index, type, list);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
