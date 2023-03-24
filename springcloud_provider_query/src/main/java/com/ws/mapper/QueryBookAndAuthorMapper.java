package com.ws.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ws.vo.BookAndAuthorVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QueryBookAndAuthorMapper extends BaseMapper<BookAndAuthorVo> {
}
