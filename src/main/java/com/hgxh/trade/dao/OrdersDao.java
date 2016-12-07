package com.hgxh.trade.dao;

import com.hgxh.trade.entity.OrdersEntity;

public interface OrdersDao {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(OrdersEntity record);

    public OrdersEntity selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(OrdersEntity record);
    
    public OrdersEntity selectSucByBizNo(String bizNo);
    
    public OrdersEntity selectByBizNo(String bizNo);

}