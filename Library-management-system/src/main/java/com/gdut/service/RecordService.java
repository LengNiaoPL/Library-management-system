package com.gdut.service;

import com.gdut.mapper.RecordMapper;
import com.gdut.pojo.Record;
import com.gdut.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description: 借书记录服务层接口
 * @Author: 林锐涛
 * @Date: 2024/11/23 16:16
 */

public interface RecordService {

    public int addRecord(Record record);

    public int returnBook(Record record);

    public PageBean<Record> stuFindRecord(String cardID,Integer page,Integer pageSize);


}
