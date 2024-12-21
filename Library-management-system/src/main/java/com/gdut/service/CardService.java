package com.gdut.service;

import com.gdut.pojo.Card;

/**
 * @Description: 借书证服务层接口
 * @Author: 林锐涛
 * @Date: 2024/12/3 17:32
 */

public interface CardService {

      Card selectCard(String cardID);

      int addCard(Card card);

}
