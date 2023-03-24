package com.ws.controller;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.ws.entity.Book;
import com.ws.service.UpdateBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/book")
public class UpdateBookController {

    @Autowired
    private UpdateBookService updateBookService;

    @PostMapping(value = "/updateBookById")
    public String updateBookById(@RequestBody(required = true) Book book){  //@RequestBody注解不要忘记加 否则拿不到请求体body的值
        Integer id = book.getId();
        boolean b = updateBookService.updataBookById(book);
        if (b){
            return "更新成功！" + "id为：" + id;
        }else {
            return "更新失败！";
        }
    }

}
