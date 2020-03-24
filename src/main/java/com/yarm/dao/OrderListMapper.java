package com.yarm.dao;

import com.yarm.pojo.OrderList;

public interface OrderListMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderList record);

    int insertSelective(OrderList record);

    OrderList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderList record);

    int updateByPrimaryKey(OrderList record);
}