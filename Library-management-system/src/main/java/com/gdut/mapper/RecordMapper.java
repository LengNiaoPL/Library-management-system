package com.gdut.mapper;
import com.gdut.pojo.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: 借书记录的持久层
 * @Author: 林锐涛
 * @Date: 2024/8/22 22:11
 */
@Mapper
public interface RecordMapper {
    int addRecord(Record record);

    int addBackTime(Record record);

    List<Record> findByID(String CardID);

    List<Record> findAll();

}
