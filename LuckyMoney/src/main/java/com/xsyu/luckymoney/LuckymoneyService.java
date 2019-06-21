package com.xsyu.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * Created by HYDYD.
 * 2019/6/21 16:14
 */
@Service
public class LuckymoneyService {
    @Autowired
    private LuckymoneyDao dao;

    /**
     * 事务 数据库的事务
     */
    @Transactional
    public void createTwo(){
        Luckymoney luckymoney = new Luckymoney();
        luckymoney.setProducer("HYDYD");
        luckymoney.setMoney(new BigDecimal("520"));
        dao.save(luckymoney);

        Luckymoney luckymoney2 = new Luckymoney();
        luckymoney2.setProducer("HYDYD");
        luckymoney2.setMoney(new BigDecimal("1314"));
        dao.save(luckymoney2);
    }
}
