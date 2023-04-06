package com.ws.consumer;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class kafkaConsumer {


    @KafkaListener(topics = {"query-topic"}, groupId = "${spring.kafka.consumer.group-id}", errorHandler = "dealError", concurrency = "2")
    public void consumer(ConsumerRecord<?, ?> record, Acknowledgment ack) {
        //手动确认
        ack.acknowledge();
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        kafkaMessage.ifPresent(message -> {
            System.out.println("开始消费：" + message);
        });
//        ack.acknowledge();
    }


    //因为手动确认，若消费失败，记录重刷
    @Bean
    public ConsumerAwareListenerErrorHandler dealError() {
        return new ConsumerAwareListenerErrorHandler() {
            @Override
            public Object handleError(Message<?> message, ListenerExecutionFailedException e, Consumer<?, ?> consumer) {
                System.out.println("consumer error" + e);
                // TODO 将失败的记录保存到数据库，再用定时任务查询记录，并重刷数据
                return null;
            }
        };
    }


}
