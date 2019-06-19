package com.xsyu.luckymoney;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by HYDYD.
 * 2019/6/19 14:37
 */
@Entity
public class Luckymoney {
    @Id
    @GeneratedValue
    private Integer id;

    private BigDecimal money;
    /**
     * 红包发送方
     */
    private String producer;

    /**
     * 红包接受方
     */
    private String consumer;

    public Luckymoney() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }
}
