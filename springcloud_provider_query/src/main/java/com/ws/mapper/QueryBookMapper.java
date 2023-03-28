package com.ws.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ws.entity.Book;
import com.ws.vo.NumsOfBookVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QueryBookMapper extends BaseMapper<Book> {

    //查询表中的数据条数
    Integer getNumsOfData();

    //查询各个书籍相关信息的条数
    List<NumsOfBookVo> getBooksNum();

    //手写分页查询全部数据
    List<Book> getPage(@Param(value = "pageNum") Integer pageNum, @Param(value = "pageSize") Integer pageSize);

}
