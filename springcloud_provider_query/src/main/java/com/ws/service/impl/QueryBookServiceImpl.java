package com.ws.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ws.entity.Author;
import com.ws.entity.Book;
import com.ws.mapper.QueryAuthorMapper;
import com.ws.mapper.QueryBookAndAuthorMapper;
import com.ws.mapper.QueryBookMapper;
import com.ws.service.QueryBookService;
import com.ws.vo.BookAndAuthorVo;
import com.ws.vo.NumsOfBookVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class QueryBookServiceImpl extends ServiceImpl<QueryBookMapper, Book> implements QueryBookService {

    @Autowired
    private QueryBookMapper queryBookMapper;

    @Autowired
    private QueryAuthorMapper queryAuthorMapper;

    @Autowired
    private QueryBookAndAuthorMapper queryBookAndAuthorMapper;

    @Override
    public List<Book> queryAllBook() {

        return queryBookMapper.selectList(null);
    }

    @Override
    public List<Author> queryAllAuthor() {
        return queryAuthorMapper.selectList(null);
    }

    //通过书名查询书籍详细信息
    @Override
    public List<BookAndAuthorVo> queryByName(String name) {
        if (StringUtils.isNotBlank(name)) {
            LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Book::getName, name);
            List<Book> bookList = queryBookMapper.selectList(queryWrapper);
            ArrayList<BookAndAuthorVo> bookAndAuthors = new ArrayList<>();
            bookList.forEach(book -> {
                BookAndAuthorVo bookAndAuthorVo = new BookAndAuthorVo();
                BeanUtils.copyProperties(book, bookAndAuthorVo);
                Author author = queryAuthorMapper.selectById(book.getBookAuthor());
                bookAndAuthorVo.setAuthor(author);
                bookAndAuthors.add(bookAndAuthorVo);
            });
            return bookAndAuthors;
        }
        log.info("字段不能为空!");
        return null;
    }

    //查询表中所有数据的条数
    @Override
    public Integer getNumsOfData() {
        Integer numsOfData = queryBookMapper.getNumsOfData();
        return numsOfData;
    }

    //查询表中各个书相关信息的条数
    @Override
    public List<NumsOfBookVo> getBookNum() {

        List<NumsOfBookVo> booksNumList = queryBookMapper.getBooksNum();

        return booksNumList;
    }


}
