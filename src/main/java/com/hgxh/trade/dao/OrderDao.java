package com.hgxh.trade.dao;

import com.hgxh.trade.entity.OrderEntity;

public interface OrderDao {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(OrderEntity record);

    public OrderEntity selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(OrderEntity record);

}