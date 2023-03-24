package com.ws.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ws.entity.Author;
import com.ws.entity.Book;
import com.ws.vo.BookAndAuthorVo;

import java.util.List;

public interface QueryBookService extends IService<Book> {

    List<Book> queryAllBook();

    List<Author> queryAllAuthor();

    List<BookAndAuthorVo> queryByName(String name);

}
