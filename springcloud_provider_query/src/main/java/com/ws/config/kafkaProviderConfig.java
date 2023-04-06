package com.ws.config;

import org.apache.kafka.clients.consumer.Consumer;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;

@SpringBootConfiguration
public class kafkaProviderConfig {

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
