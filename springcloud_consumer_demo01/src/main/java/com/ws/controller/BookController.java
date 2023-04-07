package com.ws.controller;

import com.ws.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String QUERY_SERVICE_NAME = "http://query-service"; //服务名称：注册到注册中心的服务名
    private static final String ADD_SERVICE_NAME = "http://add-service";
    private static final String UPDATE_SERVICE_NAME = "http://update-service";

    //查询全部
    @GetMapping(value = "/queryAll")
    public List<Book> queryAll() {
        String url = QUERY_SERVICE_NAME + "/book/queryAll";
        List bookList = restTemplate.getForObject(url, List.class);
        return bookList;
    }

    //添加数据
    @PostMapping(value = "/addBook")
    public String addBook(@RequestBody(required = true) Book book) {
        String url = ADD_SERVICE_NAME + "/book/addBook";
        String s = restTemplate.postForObject(url, book, String.class);
        return s;
    }

    //更新数据
    @PostMapping(value = "/updateBookById")
    public String updateBookById(@RequestBody(required = true) Book book){
        String url = UPDATE_SERVICE_NAME + "/book/updateBookById";
        String s = restTemplate.postForObject(url, book, String.class);
        return s;
    }

}
