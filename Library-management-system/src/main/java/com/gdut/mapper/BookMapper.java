package com.gdut.mapper;

import com.gdut.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: 书的持久层
 * @Author: 林锐涛
 * @Date: 2024/8/22 22:08
 */

@Mapper
public interface BookMapper {
     Book findByBookID(String BookID);

     Book findByTitle(String Title);

     int addBook(Book book);

     int borrowBook(@Param("num")int num,@Param("bookID") String bookID);

     int returnBook(@Param("reNum")int reNum,@Param("bookID") String bookID);


}
