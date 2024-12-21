package com.gdut.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @Description: 用户类
 * @Author: 林锐涛
 * @Date: 2024/9/21 13:21
 */


@Data
public class User {
    String userName;
    String passWord;
    boolean ofManager;
}
