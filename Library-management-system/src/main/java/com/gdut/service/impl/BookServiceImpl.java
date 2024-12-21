package com.gdut.service.impl;

import com.gdut.mapper.BookMapper;
import com.gdut.mapper.ClassificationMapper;
import com.gdut.pojo.Book;
import com.gdut.service.BookService;
import com.mysql.cj.Session;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description: 书的服务层实现类
 * @Author: 林锐涛
 * @Date: 2024/9/14 11:05
 */

@Service
public class BookServiceImpl implements BookService {



    @Autowired(required = false)
    private BookMapper bookMapper;

    @Autowired(required = false)
    private ClassificationMapper classificationMapper;



    @Override
    public int addBook(Book book) {
      return bookMapper.addBook(book);
    }

    @Override
    public Book findByBookID(String BookID) {
       Book book= bookMapper.findByBookID(BookID);
       book.setClassification(classificationMapper.findClassByID(book.getClassificationID()));
       return book;
    }

    @Override
    public Book findByBookName(String BookName) {
        Book book= bookMapper.findByTitle(BookName);
        book.setClassification(classificationMapper.findClassByID(book.getClassificationID()));
        return book;
    }



}
