package com.gdut.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @Description: 分类的实体类
 * @Author: 林锐涛
 * @Date: 2024/8/22 21:57
 */
@Data
public class Classification {

    int classificationID;
    String classificationName;
    String address;

}
