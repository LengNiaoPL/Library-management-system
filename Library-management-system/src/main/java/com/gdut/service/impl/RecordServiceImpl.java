package com.gdut.service.impl;

import com.gdut.mapper.BookMapper;
import com.gdut.mapper.CardMapper;
import com.gdut.mapper.RecordMapper;
import com.gdut.pojo.Book;
import com.gdut.pojo.Record;
import com.gdut.service.RecordService;
import com.gdut.utils.PageBean;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 借书记录服务层实现
 * @Author: 林锐涛
 * @Date: 2024/11/23 16:29
 */

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    RecordMapper recordMapper;
    @Autowired
    BookMapper bookMapper;
    @Autowired
    CardMapper cardMapper;



    @Override
    public int addRecord(Record record) {
        //先查看卡的状态,如果状态异常返回-1
        String state=cardMapper.findByID(record.getCardID()).getState();
        if (state.equals("异常")) return -1;
        //再查看书,查无此书返回-2,书籍数量不足返回-3
        Book book=bookMapper.findByBookID(record.getBookID());
        if (book==null) return -2;
        if (book.getQuantity()<record.getNum()) return -3;

        //如果一切正常则减少数的存量
        bookMapper.borrowBook(record.getNum(),record.getBookID());

        //增加借书记录
        return recordMapper.addRecord(record);
    }

    @Override
    public int returnBook(Record record) {

        //先尝试添加归还时间和归还数量
        //若影响行数为0说明没有该记录,返回-1
        if (recordMapper.addBackTime(record)==0)
            return -1;
        //确认有对应记录后将书的存量增加
        bookMapper.returnBook(record.getReNum(),record.getBookID());

        return 0;
    }


    @Override//返回分页后的数据
    public PageBean<Record> stuFindRecord(String cardID,Integer page,Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        Page p =(Page) recordMapper.findByID(cardID);
        return new PageBean(page,pageSize,p.getTotal(),p.getResult());
    }


}
