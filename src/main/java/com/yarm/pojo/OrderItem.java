package com.yarm.pojo;

import java.math.BigDecimal;

public class OrderItem {
    private Integer id;

    private String orderListNo;

    private String orderItemNo;

    private BigDecimal orderListPrice;

    private BigDecimal orderItemPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderListNo() {
        return orderListNo;
    }

    public void setOrderListNo(String orderListNo) {
        this.orderListNo = orderListNo == null ? null : orderListNo.trim();
    }

    public String getOrderItemNo() {
        return orderItemNo;
    }

    public void setOrderItemNo(String orderItemNo) {
        this.orderItemNo = orderItemNo == null ? null : orderItemNo.trim();
    }

    public BigDecimal getOrderListPrice() {
        return orderListPrice;
    }

    public void setOrderListPrice(BigDecimal orderListPrice) {
        this.orderListPrice = orderListPrice;
    }

    public BigDecimal getOrderItemPrice() {
        return orderItemPrice;
    }

    public void setOrderItemPrice(BigDecimal orderItemPrice) {
        this.orderItemPrice = orderItemPrice;
    }
}