package com.ws.controller;

import com.ws.entity.Author;
import com.ws.entity.Book;
import com.ws.service.AddAuthorService;
import com.ws.service.AddBookService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/book")
public class AddBookController {

    @Autowired
    private AddBookService addBookService;

    @Autowired
    private AddAuthorService addAuthorService;

    @ApiOperation(value = "添加书籍信息")
    @PostMapping("/addBook")
    public String addBook(@RequestBody(required = true) Book book) {
        try {
            boolean b = addBookService.addBook(book);
            if (b) {
                return "添加成功！";
            } else {
                return "添加失败!";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "添加失败，该id已存在数据库！";
        }
    }

    @ApiOperation(value = "添加书籍作者信息")
    @PostMapping("/addAuthor")
    public String addAuthor(@RequestBody(required = true) Author author) {
        try {
            boolean b = addAuthorService.addAuthor(author);
            if (b) {
                return "添加成功";
            } else {
                return "添加失败";
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("该id已存在！");
            return "添加失败，该id已存在数据库";
        }
    }


}
