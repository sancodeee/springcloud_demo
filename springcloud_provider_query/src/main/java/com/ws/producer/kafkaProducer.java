package com.ws.producer;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//用于controller作为生产者生产消息，向service层传递消息的消息队列
@RestController
@RequestMapping(value = "/kafka")
public class kafkaProducer {

    //定义topic名称
    private final static String TOPIC_TEST = "query-topic";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @ApiOperation(value = "测试生产者接口")
    @GetMapping(value = "test1")
    public String test() {
        //同一个消费者组中的多个消费者可以同时消费同一个topic的消息，一个topic可以被多个消费者消费
        //但是同一个分区(partition)中的消息只能被同一个消费者组中的一个消费者消费
        kafkaTemplate.send(TOPIC_TEST, 0, "key_test_1", "hello");
        return "send msg success";
    }


}

