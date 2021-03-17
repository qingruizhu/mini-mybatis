package com.dove.study.mybatis.v2;

import com.dove.study.mybatis.v2.mapper.Book;
import com.dove.study.mybatis.v2.mapper.BookMapper;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        DoveSqlSesssion sqlSesssion = new DoveSqlSesssion(new DoveConfiguration(), new DoveExecutor());
        BookMapper bookMapper = sqlSesssion.getMapper(BookMapper.class, Book.class);
        Book book = bookMapper.selectById(1L);
    }

}
