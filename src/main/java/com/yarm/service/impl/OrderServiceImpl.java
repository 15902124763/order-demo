package com.yarm.service.impl;

import com.yarm.constant.TablePrefix;
import com.yarm.dao.OrderItemMapper;
import com.yarm.dao.OrderListMapper;
import com.yarm.dao.OrderMapper;
import com.yarm.pojo.Order;
import com.yarm.pojo.OrderItem;
import com.yarm.pojo.OrderList;
import com.yarm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderListMapper orderListMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;


    @Override
    @Transactional(rollbackFor=Exception.class)
    public void insert() {
        // 获取主单号
        String orderNo = getUUID(TablePrefix.T_ORDER);
        Order order = new Order();
        order.setOrderNo(orderNo);
        order.setOrderPrice(new BigDecimal(1));
        orderMapper.insert(order);

        // 获取子单号
        String orderListNo = getUUID(TablePrefix.T_ORDER_LIST);
        OrderList orderList = new OrderList();
        orderList.setOrderNo(orderNo);
        orderList.setOrderListNo(orderListNo);
        orderList.setOrderListPrice(new BigDecimal(1));
        orderList.setOrderPrice(new BigDecimal(1));
        orderListMapper.insert(orderList);

        // 获取子单明细
        String orderItemNo = getUUID(TablePrefix.T_ORDER_ITEM);
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderListNo(orderListNo);
        orderItem.setOrderItemNo(orderItemNo);
        orderItem.setOrderItemPrice(new BigDecimal(1));
        orderItem.setOrderListPrice(new BigDecimal(1));
        orderItemMapper.insert(orderItem);
        System.out.println(Thread.currentThread().getId());
    }

    @Override
    public void fechInsert() {
        for (int i = 0; i < 1000 ;i++){
            this.insert();
        }
    }

    public String getUUID(String prefix){
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        return prefix + uuid;
    }

}
