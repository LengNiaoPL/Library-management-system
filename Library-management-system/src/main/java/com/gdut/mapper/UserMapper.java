package com.gdut.mapper;

import com.gdut.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Description: 用户持久层
 * @Author: 林锐涛
 * @Date: 2024/9/21 13:31
 */


@Mapper
public interface UserMapper {

     User findUser(String CardID);

     int addUser(User user);


}
