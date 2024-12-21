package com.gdut.controller;

import com.gdut.pojo.Card;
import com.gdut.service.CardService;
import com.gdut.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 借书证控制层
 * @Author: 林锐涛
 * @Date: 2024/12/3 17:24
 */

@RestController
@RequestMapping("card")
public class CardController {
    @Autowired
    CardService cardService;


    @GetMapping("select")
    public Card selectCard(String cardID){
        return cardService.selectCard(cardID);
    }


    @PostMapping("add")
    public Object addCard(@RequestBody Card card){
        System.out.println(card.toString());
        int a= cardService.addCard(card);
        if (a>0){
            return R.ok("添加成功");
        }else {
            return R.fail("添加失败");
        }
    }


}
