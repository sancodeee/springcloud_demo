package com.ws.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ws.entity.Author;
import com.ws.entity.Book;
import com.ws.producer.KafkaQueryProducerApi;
import com.ws.service.QueryBookService;
import com.ws.vo.BookAndAuthorVo;
import com.ws.vo.NumsOfBookVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class QueryBookController {

    @Autowired
    private QueryBookService queryBookService;

    @Autowired
    private KafkaQueryProducerApi kafkaQueryProducerApi;


    @ApiOperation(value = "查询全部书籍")
    @GetMapping(value = "/queryAll")
    public List<Book> queryAll() {
        return queryBookService.queryAllBook();
    }

    @ApiOperation(value = "将请求添加到消息队列后查询")
    @GetMapping("kafkaQueryAll")
    public List<Book> kafkaQueryAll(){
        //往消息队列中添加该请求
        kafkaQueryProducerApi.queryAllProducer();
        //消费完毕后拿到返回值

        return null;
    }

    @ApiOperation(value = "分页查询全部书籍信息手写")
    @GetMapping(value = "/getPage")
    public List<Book> getPage(@ApiParam(value = "页码", required = true) @RequestParam(value = "pageNum", required = true) Integer pageNum,
                              @ApiParam(value = "每页显示的数据条数", required = true) @RequestParam(value = "pageSize", required = true) Integer pageSize) {
        return queryBookService.getPage(pageNum, pageSize);
    }

    @ApiOperation(value = "分页查询全部书籍信息")
    @GetMapping(value = "/getPageBook")
    public IPage<Book> getPageBook(@ApiParam(value = "页码", required = true) @RequestParam(value = "pageNum", required = true) Integer pageNum,
                                   @ApiParam(value = "每页显示的数据条数", required = true) @RequestParam(value = "pageSize", required = true) Integer pageSize) {
        return queryBookService.getPageBook(pageNum, pageSize);
    }

    @ApiOperation(value = "查询全部作者")
    @GetMapping(value = "/queryAllAuthor")
    public List<Author> queryAllAuthor() {
        return queryBookService.queryAllAuthor();
    }

    @ApiOperation(value = "分页查询全部作者")
    @GetMapping(value = "/getPageAuthor")
    public IPage<Author> getPageAuthor(@ApiParam(value = "页码", required = true) @RequestParam(value = "pageNum", required = true) Integer pageNum,
                                       @ApiParam(value = "每页显示的数据条数", required = true) @RequestParam(value = "pageSize", required = true) Integer pageSize) {
        return queryBookService.getPageAuthor(pageNum, pageSize);
    }

    @ApiOperation(value = "根据书名查询书籍详细信息")
    @GetMapping(value = "/queryBookInfoByName")
    public List<BookAndAuthorVo> queryBookInfoByName(String name) {
        return queryBookService.queryByName(name);
    }

    @ApiOperation(value = "查询表中一共有多少条数据")
    @GetMapping(value = "/getNumsOfData")
    public String getNumsOfData() {
        Integer numsOfData = queryBookService.getNumsOfData();
        return "该表中共有" + numsOfData + "条数据";
    }

    @ApiOperation(value = "获取各个书籍在表中的相关数据的条数")
    @GetMapping(value = "/getBookNum")
    public List<NumsOfBookVo> getBookNum() {
        return queryBookService.getBookNum();
    }

}
