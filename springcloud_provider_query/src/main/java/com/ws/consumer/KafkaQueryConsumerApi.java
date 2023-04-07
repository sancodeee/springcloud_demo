package com.ws.consumer;

import com.ws.entity.Book;
import com.ws.service.QueryBookService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

//用于消费controller层传来的消息
@Component
@Slf4j
public class KafkaQueryConsumerApi {

    //发送请求的消息队列
    private final static String TOPIC_QUERY = "topic_query";

    //返回值的消息队列
    private final static String TOPIC_QUERY_RETURN = "topic_query_return";

    @Autowired
    private QueryBookService queryBookService;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @KafkaListener(topics = {TOPIC_QUERY}, groupId = "${spring.kafka.consumer.group-id}", errorHandler = "dealError", concurrency = "2")
    public String queryAllConsumer(ConsumerRecord<?, ?> record, Acknowledgment ack) {
        //手动确认
        ack.acknowledge();
        Optional<?> value = Optional.ofNullable(record.value());
        //处理请求
        List<Book> bookList = queryBookService.queryAllBook();
        //因为消费者采用StringDeserializer序列化方式，所以先将bookList转成json字符串，便于向消息队列中传输
        //        String bookListJson = JSON.toJSONString(bookList);
        //为了使转换统一 ，还是转成String类型吧
        String join = StringUtils.join(bookList, ",");
        log.info("查询结果：{}", bookList);
        //消息处理完毕，将其添加到返回值的消息队列中，向上层返回
        log.info("开始将结果添加到返回队列...");
        kafkaTemplate.send(TOPIC_QUERY_RETURN, 0, "query_all_return", join);
        log.info("已将结果添加到返回队列");
        return "msg has been consumed";
    }


}
