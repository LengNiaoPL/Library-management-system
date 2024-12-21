package com.gdut.pojo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
/**
 * @Description: 书的实体类
 * @Author: 林锐涛
 * @Date: 2024/8/22 21:37
 */

@Data
public class Book {

    String bookID;
    String title;
    String author;
    String publisher;

    @JsonFormat(pattern = "yyyy-MM-dd")
    Date publicationDate;

    int classificationID;
    int quantity;

    Classification classification;

}
