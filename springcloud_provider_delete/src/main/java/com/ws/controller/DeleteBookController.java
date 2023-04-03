package com.ws.controller;

import com.ws.service.DeleteBookService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/book")
public class DeleteBookController {

    @Autowired
    private DeleteBookService deleteBookService;

    @ApiOperation(value = "根据id删除数据")
    @GetMapping(value = "/deleteBookById")
    public String deleteBookById(@ApiParam(value = "主键id", required = true)
                                 @RequestParam(value = "id", required = true) Integer id) {
        boolean b = deleteBookService.deleteBookById(id);
        if (b) {
            return "删除id为" + id + "的数据成功";
        } else {
            return "删除id为" + id + "的数据失败";
        }
    }

    @ApiOperation(value = "根据id删除数据")
    @DeleteMapping(value = "/deleteBookById2")
    public String deleteBookById2(@ApiParam(value = "主键id", required = true)
                                  @RequestParam(value = "id", required = true) Integer id) {
        boolean b = deleteBookService.deleteBookById(id);
        if (b) {
            return "删除id为" + id + "的数据成功";
        } else {
            return "删除id为" + id + "的数据失败";
        }

    }

}

