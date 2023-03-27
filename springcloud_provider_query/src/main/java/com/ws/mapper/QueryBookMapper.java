package com.ws.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ws.entity.Book;
import com.ws.vo.NumsOfBookVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QueryBookMapper extends BaseMapper<Book> {

    //查询表中的数据条数
    Integer getNumsOfData();

    //查询各个书籍相关信息的条数
    List<NumsOfBookVo> getBooksNum();

}
