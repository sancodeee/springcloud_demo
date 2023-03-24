package com.ws.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ws.entity.Book;

public interface UpdateBookService extends IService<Book> {

    boolean updataBookById(Book book);

}
