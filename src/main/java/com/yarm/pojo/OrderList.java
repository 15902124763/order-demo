package com.yarm.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderList {
    private Integer id;

    private String orderNo;

    private String orderListNo;

    private BigDecimal orderPrice;

    private BigDecimal orderListPrice;
}