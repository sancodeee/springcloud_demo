package com.ws.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.Optional;

//用于消费controller层传来的消息
@Component
public class kafkaConsumer {

    @KafkaListener(topics = {"query-topic"}, groupId = "${spring.kafka.consumer.group-id}", errorHandler = "dealError", concurrency = "2")
    public void consumer(ConsumerRecord<?, ?> record, Acknowledgment ack) {
        //手动确认
//        ack.acknowledge();
        //Optional类是为了解决NullPointException异常而设计的，用来处理可能为空的对象，优雅的处理空指针异常
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        kafkaMessage.ifPresent(message -> {
            System.out.println("开始消费：" + message);
        });
        ack.acknowledge();
    }


}
