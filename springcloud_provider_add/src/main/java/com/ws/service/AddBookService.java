package com.ws.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ws.entity.Book;

public interface AddBookService extends IService<Book> {

    //添加书籍
    boolean addBook(Book book);

}
