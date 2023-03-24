package com.ws.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ws.entity.Book;

public interface DeleteBookService extends IService<Book> {

    boolean deleteBookById(Integer id);

}
