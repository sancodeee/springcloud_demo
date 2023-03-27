package com.ws.service.impl;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ws.entity.Book;
import com.ws.mapper.AddBookMapper;
import com.ws.service.AddBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddBookServiceImpl extends ServiceImpl<AddBookMapper, Book> implements AddBookService {

    @Autowired
    private AddBookMapper addBookMapper;

    @Transactional
    @Override
    public boolean addBook(Book book) {
        if(ObjectUtils.isNotEmpty(book)){
            boolean b = addBookMapper.insert(book) > 0; //影响行数>0才执行
            return b;
        }else {
            return false;
        }

    }


}
