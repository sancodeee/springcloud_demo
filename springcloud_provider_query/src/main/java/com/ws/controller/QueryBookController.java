package com.ws.controller;

import com.ws.entity.Book;
import com.ws.service.QueryBookService;
import com.ws.vo.BookAndAuthorVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class QueryBookController {

    @Autowired
    private QueryBookService queryBookService;

    @ApiOperation(value = "查询全部书籍")
    @GetMapping(value = "/queryAll")
    public List<Book> queryAll(){
        List<Book> bookList = queryBookService.queryAllBook();
        return bookList;
    }

    @ApiOperation(value = "根据书名查询书籍详细信息")
    @GetMapping(value = "/queryBookInfoByName")
    public List<BookAndAuthorVo> queryBookInfoByName(String name){
        return queryBookService.queryByName(name);
    }




}
