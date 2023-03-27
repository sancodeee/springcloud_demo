package com.ws.controller;

import com.ws.entity.Author;
import com.ws.entity.Book;
import com.ws.service.AddAuthorService;
import com.ws.service.AddBookService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        boolean b = addBookService.addBook(book);
        if (b) {
            return "添加成功！";
        } else {
            return "添加失败!";
        }
    }

    @ApiOperation(value = "添加书籍作者信息")
    @PostMapping("/addAuthor")
    public String addAuthor(@RequestBody(required = true)Author author){
        boolean b = addAuthorService.addAuthor(author);
        if (b){
            return "添加成功";
        }else {
            return "添加失败";
        }
    }

}
