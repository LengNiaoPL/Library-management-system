package com.gdut.controller;

import com.gdut.mapper.CardMapper;
import com.gdut.pojo.Record;
import com.gdut.service.BookService;
import com.gdut.service.RecordService;
import com.gdut.utils.PageBean;
import com.gdut.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 借书记录控制层
 * @Author: 林锐涛
 * @Date: 2024/11/23 16:02
 */

@RestController
@RequestMapping("record")
public class RecordController {
    @Autowired
    RecordService recordService;

    @GetMapping("stufind")
    public PageBean stuFindRecord(String cardID,Integer page,Integer pageSize){

        return recordService.stuFindRecord(cardID,page,pageSize);
    }

    @PostMapping("return")
    public Object reBook(@RequestBody Record record){

        int a=recordService.returnBook(record);
        if (a==-1){
            return R.fail("没有该书的未归还记录");
        }else {
            return R.ok("归还成功");
        }

    }



    @PostMapping("add")
    public Object add(@RequestBody Record record){

        try {
            int a=recordService.addRecord(record);
            if (a>0){
                return R.ok("借书完成");
            }else if (a==-1){
                return R.fail("状态异常");
            }else if (a==-2){
                return R.fail("查无此书");
            }else if (a==-3){
                return R.fail("书籍数量不足");
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.fail("存在相同记录,请勿重复操作");
        }

        return null;

    }

}
