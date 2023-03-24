package com.ws.controller;

import com.ws.entity.Book;
import com.ws.service.AddBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/book")
public class AddBookController {

    @Autowired
    private AddBookService addBookService;

    @PostMapping("/addBook")
    public String addBook(@RequestBody(required = true) Book book) {
        boolean b = addBookService.addBook(book);
        if (b == true) {
            return "添加成功！";
        } else {
            return "添加失败!";
        }
    }

}
