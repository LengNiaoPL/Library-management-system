package com.gdut.mapper;

import com.gdut.pojo.Card;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description: 卡的持久层
 * @Author: 林锐涛
 * @Date: 2024/8/22 22:09
 */

@Mapper
public interface CardMapper {

    int addCard(Card card);

    Card findByID(String CardID);

}
