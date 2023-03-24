package com.ws.service.impl;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ws.entity.Book;
import com.ws.mapper.DeleteBookMapper;
import com.ws.service.DeleteBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DeleteBookServiceImpl extends ServiceImpl<DeleteBookMapper, Book> implements DeleteBookService {

    @Autowired
    private DeleteBookMapper deleteBookMapper;

    @Override
    public boolean deleteBookById(Integer id) {

        if (ObjectUtils.isNotEmpty(id)) {
            boolean b = deleteBookMapper.deleteById(id) > 0;
            if (b) {
                log.info("删除成功！");
                return b;
            } else {
                log.info("删除失败！数据不存在");
                return b;
            }
        } else {
            log.info("删除失败！id不能为空");
            return false;
        }


    }
}
