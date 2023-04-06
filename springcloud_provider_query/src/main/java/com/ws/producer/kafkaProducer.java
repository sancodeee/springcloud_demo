package com.ws.producer;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class kafkaProducer {


    private final static String TOPIC_TEST = "query-topic";

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @ApiOperation(value = "测试生产者接口")
    @GetMapping(value = "test1")
    public String test(){
        kafkaTemplate.send(TOPIC_TEST,0,"key_test_1","hello");
        return "send msg success";
    }
}

