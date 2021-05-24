package com.demo.springcloud.log;


import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import com.demo.springcloud.log.callback.kafkaLogCallBack;
import com.demo.springcloud.log.formatter.Formatter;
import com.demo.springcloud.log.formatter.MessageFormatter;
import lombok.Data;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @author ppmsn2005@gmail.com
 * @date 2020/10/02
 */

@Data
public class KafkaAppender extends AppenderBase<ILoggingEvent> {

    private String topic;
    private String zookeeperHost;
    private String brokerList;
    private Producer<String, String> producer;
    private Formatter formatter;

    @Override
    public void start() {
        if (null == this.formatter) {
            this.formatter = new MessageFormatter();
        }
        super.start();
        Properties properties = new Properties();
        // properties.put("metadata.broker.list",brokerList);
        properties.put("serializer.class", "kafka.serializer.StringEncoder");
        properties.put("request.required.acks", "1");

        properties.put("bootstrap.servers", brokerList);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        this.producer = new KafkaProducer<>(properties);
    }

    @Override
    public void stop() {
        super.stop();
        if (producer != null) {
            this.producer.close();
        }
    }

    @Override
    protected void append(ILoggingEvent iLoggingEvent) {
        String payload = this.formatter.format(iLoggingEvent);
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, payload);

        producer.send(record, new kafkaLogCallBack());
    }
}
