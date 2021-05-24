package com.demo.springcloud.log.callback;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

/**
 * @author ppmsn2005@gmail.com
 * @date 2020/10/02
 */
public class kafkaLogCallBack implements Callback {
    @Override
    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
        if (e != null) {
            e.printStackTrace();
        }
    }
}
