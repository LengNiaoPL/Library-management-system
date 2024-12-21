package com.gdut.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Date;

/**
 * @Description: 借书记录的实体类
 * @Author: 林锐涛
 * @Date: 2024/8/22 21:59
 */
@Data
public class Record {
    String bookID;
    String cardID;
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date borrowDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date returnDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date shouldBeReturnDate;
    int num;
    Book book;
    Card card;
    int reNum;
}
