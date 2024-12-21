package com.gdut.mapper;

import com.gdut.pojo.Classification;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description: 分类的持久层
 * @Author: 林锐涛
 * @Date: 2024/8/22 22:10
 */
@Mapper
public interface ClassificationMapper {

    Classification findClassByID(int ClassID);


}
