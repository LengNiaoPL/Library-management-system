package com.gdut.service;

import com.gdut.pojo.Book;

/**
 * @Description: 书的服务层接口
 * @Author: 林锐涛
 * @Date: 2024/9/14 11:04
 */


public interface BookService {

    public int addBook(Book book);

    public Book findByBookID(String BookID);


    public Book findByBookName(String BookName);


}
