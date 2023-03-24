package com.ws.service.impl;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ws.entity.Book;
import com.ws.mapper.UpdateBookMapper;
import com.ws.service.UpdateBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class UpdateBookServiceImpl extends ServiceImpl<UpdateBookMapper, Book> implements UpdateBookService {

    @Autowired
    private UpdateBookMapper updateBookMapper;

    @Override
    @Transactional
    public boolean updataBookById(Book book) {
        if (ObjectUtils.isNotNull(book)) {
            boolean b = updateBookMapper.updateById(book) > 0; //影响行数大于0才更新
            if (b) {
                return b;
            } else {
                log.info("更新数据影响行数为0 ，没有字段更改");
                return false;
            }
        } else {
            return false;
        }
    }


}
