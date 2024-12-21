package com.gdut.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.ibatis.type.Alias;
import java.sql.Date;

/**
 * @Description: 借书卡的实体类
 * @Author: 林锐涛
 * @Date: 2024/8/22 21:49
 */

@Data
public class Card {
    String cardID;
    String name;
    String phone;
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date registerDate;
    String gender;
    String unit;
    String state;

}
