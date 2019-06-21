package com.xsyu.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Created by HYDYD.
 * 2019/6/20 16:56
 */
@RestController
@RequestMapping("/luckymoneys")
public class LuckymoneyController {
    @Autowired
    private LuckymoneyDao dao;

    @Autowired
    private LuckymoneyService service;

    /**
     * 获取红包列表
     *
     * @return
     */
    @GetMapping("/getlist")
    public List<Luckymoney> getList() {
        return dao.findAll();
    }

    /**
     * 创建红包（发红包）
     *
     * @param producer
     * @param money
     * @return
     */
    @PostMapping("/createLM")
    public Luckymoney createLM(@RequestParam("producer") String producer,
                               @RequestParam("money") BigDecimal money) {
        Luckymoney luckymoney = new Luckymoney();
        luckymoney.setMoney(money);
        luckymoney.setProducer(producer);
        return dao.save(luckymoney);
    }

    /**
     * 通过ID查询红包
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Luckymoney findById(@PathVariable("id") Integer id) {
        return dao.findById(id).orElse(null);
    }


    /**
     * 更新红包（领红包）
     * <p>
     * PUT请求：如果两个请求相同，后一个请求会把第一个请求覆盖掉。（所以PUT用来改资源）
     * Post请求：后一个请求不会把第一个请求覆盖掉。（所以Post用来增资源）
     *
     * @param id
     * @param consumer
     * @return
     */
    @PutMapping("/{id}")
    public Luckymoney update(@PathVariable("id") Integer id,
                             @RequestParam("consumer") String consumer) {
        Optional<Luckymoney> optional = dao.findById(id);
        if (optional.isPresent()) {
            Luckymoney luckymoney = optional.get();
            luckymoney.setConsumer(consumer);
            return dao.save(luckymoney);
        }
        return null;
    }

    @PostMapping("/two")
    public void createTwo(){
        service.createTwo();
    }

}
