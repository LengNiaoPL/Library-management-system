package com.gdut.controller;


import com.gdut.pojo.Book;
import com.gdut.service.BookService;
import com.gdut.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Description: 书的控制层
 * @Author: 林锐涛
 * @Date: 2024/9/14 11:40
 */

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;



    @PostMapping("add")
    public Integer addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }


    @GetMapping("find")
    public R findBook(String BookID,String BookName){

        if (BookID!=null){
            return R.ok(bookService.findByBookID(BookID));
        }else if(BookName!=null){
            return R.ok(bookService.findByBookName(BookName));
        }

        return R.fail("error");

    }






}
