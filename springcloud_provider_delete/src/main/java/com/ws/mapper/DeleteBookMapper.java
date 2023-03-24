package com.ws.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ws.entity.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeleteBookMapper extends BaseMapper<Book> {
}
