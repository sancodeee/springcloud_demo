package com.ws.controller;

import com.ws.service.DeleteBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/book")
public class DeleteBookController {

    @Autowired
    private DeleteBookService deleteBookService;

    @GetMapping(value = "/deleteBookById")
    public String deleteBookById(@RequestParam(value = "id" ,required = true) Integer id) {
        boolean b = deleteBookService.deleteBookById(id);
        if (b) {
            return "删除id为" + id + "的数据成功";
        } else {
            return "删除id为" + id + "的数据失败";
        }
    }

}
