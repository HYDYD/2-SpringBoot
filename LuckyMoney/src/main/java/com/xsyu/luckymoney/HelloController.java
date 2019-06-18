package com.xsyu.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * Created by HYDYD.
 * 2019/6/18 12:48
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private LimitConfig limitConfig;

    @GetMapping("/say")
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id){
        //return "index";
        return "id:" + id;
        //return "Hello!" + limitConfig.getMinMoney() + " " + limitConfig.getDescription();
    }
}
