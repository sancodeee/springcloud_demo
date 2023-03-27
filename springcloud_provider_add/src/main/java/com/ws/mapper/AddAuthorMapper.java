package com.ws.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ws.entity.Author;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddAuthorMapper extends BaseMapper<Author> {
}
