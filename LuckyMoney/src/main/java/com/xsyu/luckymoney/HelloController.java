package com.xsyu.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Created by HYDYD.
 * 2019/6/18 12:48
 */
@RestController
public class HelloController {
    @Autowired
    private LimitConfig limitConfig;

    @GetMapping("/hello")
    public String say(){
        return "Hello!" + limitConfig.getMinMoney() + " " + limitConfig.getDescription();
    }
}
