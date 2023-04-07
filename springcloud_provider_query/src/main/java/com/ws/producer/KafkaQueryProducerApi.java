package com.ws.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//作为生产者 传递controller中的请求给service进行处理 然后返回到该类
//需要两个消息队列，一个用于发送请求，一个用于接收service处理后的返回值
@Component
@Slf4j
public class KafkaQueryProducerApi {

    private final static String TOPIC_QUERY = "topic_query";

    private final static String TOPIC_QUERY_RETURN = "topic_query_return";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    //发送请求到消费者处理
    public String queryAllProducer() {
        kafkaTemplate.send(TOPIC_QUERY, 0, "query_all", "查询全部数据");
        log.info("send msg success");
        return "send msg success";
    }

    //接收消费者消费后 返回的返回值
    @KafkaListener(topics = {TOPIC_QUERY_RETURN}, groupId = "${spring.kafka.consumer.group-id}", errorHandler = "dealError", concurrency = "2")
    public List<String> queryAllReturn(ConsumerRecord<?, ?> record, Acknowledgment ack) {
        ack.acknowledge();//手动确认
        Optional<?> value = Optional.ofNullable(record.value());
        if (value.isPresent()) {
            String s = value.get().toString();
//            List<Book> bookList = JSON.parseObject(s, List.class);
            List<String> list = Arrays.asList(s);
//            List<Book> bookList = list.stream().map(s1 -> JSON.parseObject(s1, Book.class)).collect(Collectors.toList());  //通过stream的方式将List<String>转换成List<Book>
            log.info("从返回队列中获得的值：" + list);
            return list;
        } else {
            log.error("对象不能为空");
            return null;
        }
    }


}
