package com.ws.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ws.entity.Author;
import com.ws.entity.Book;
import com.ws.vo.BookAndAuthorVo;
import com.ws.vo.NumsOfBookVo;
import io.swagger.models.auth.In;

import java.util.List;

public interface QueryBookService extends IService<Book> {

    List<Book> queryAllBook();

    List<Author> queryAllAuthor();

    List<BookAndAuthorVo> queryByName(String name);

    //查询表中所有数据的条数
    Integer getNumsOfData();

    //查询每本书相关信息在表中的条数
    List<NumsOfBookVo> getBookNum();

    //手写分页查询书籍信息
    List<Book> getPage(Integer pageNum , Integer pageSize);

    //分页查询书籍信息
    IPage<Book> getPageBook(Integer pageNum ,Integer pageSize);

    //分页查询作者信息
    IPage<Author> getPageAuthor(Integer pageNum ,Integer pageSize);

}
