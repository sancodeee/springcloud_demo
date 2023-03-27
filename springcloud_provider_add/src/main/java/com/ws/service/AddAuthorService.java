package com.ws.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ws.entity.Author;

public interface AddAuthorService extends IService<Author> {

    //添加作者
    boolean addAuthor(Author author);

}
