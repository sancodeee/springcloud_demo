package com.ws.controller;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.ws.entity.Book;
import com.ws.service.UpdateBookService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/book")
public class UpdateBookController {

    @Autowired
    private UpdateBookService updateBookService;

    @ApiOperation(value = "根据id更新数据")
    @PostMapping(value = "/updateBookById")
    public String updateBookById(@ApiParam(value = "书籍实体类", required = true)
                                 @RequestBody(required = true) Book book) {  //@RequestBody注解不要忘记加 否则拿不到请求体body的值
        Integer id = book.getId();
        if (ObjectUtils.isNotEmpty(id)) {
            boolean b = updateBookService.updataBookById(book);
            if (b) {
                return "更新成功！" + "id为：" + id;
            } else {
                return "更新失败！";
            }
        }
        return "更新失败，id字段不能为空";
    }

    @ApiOperation(value = "根据id更新数据2")
    @PutMapping(value = "/updateBookById2")
    public String updateBookById2(@ApiParam(value = "书籍实体类", required = true)
                                  @RequestBody(required = true) Book book) {
        Integer id = book.getId();
        if (ObjectUtils.isNotEmpty(id)) {
            boolean b = updateBookService.updataBookById(book);
            if (b) {
                return "更新成功！" + "id为：" + id;
            } else {
                return "更新失败";
            }
        } else {
            return "更新失败，id不能为空";
        }
    }

}
