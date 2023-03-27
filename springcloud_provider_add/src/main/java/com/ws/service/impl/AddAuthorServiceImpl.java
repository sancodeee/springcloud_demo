package com.ws.service.impl;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ws.entity.Author;
import com.ws.mapper.AddAuthorMapper;
import com.ws.service.AddAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddAuthorServiceImpl extends ServiceImpl<AddAuthorMapper, Author> implements AddAuthorService {

    @Autowired
    private AddAuthorMapper authorMapper;

    //添加作者信息
    @Transactional
    @Override
    public boolean addAuthor(Author author) {
        if (ObjectUtils.isNotEmpty(author)) {
            return authorMapper.insert(author) > 0;
        }
        return false;
    }

}
