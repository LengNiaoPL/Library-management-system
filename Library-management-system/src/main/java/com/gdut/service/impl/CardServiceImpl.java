package com.gdut.service.impl;

import com.gdut.mapper.CardMapper;
import com.gdut.pojo.Card;
import com.gdut.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 借书证服务层实现类
 * @Author: 林锐涛
 * @Date: 2024/12/3 17:34
 */

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    CardMapper cardMapper;



    @Override
    public Card selectCard(String cardID) {
        return cardMapper.findByID(cardID);
    }

    @Override
    public int addCard(Card card) {
        return cardMapper.addCard(card);
    }
}
