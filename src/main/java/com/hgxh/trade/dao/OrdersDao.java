package com.hgxh.trade.dao;

import org.apache.ibatis.annotations.Param;

import com.hgxh.trade.entity.OrdersEntity;
import com.hgxh.trade.enums.OrderStatusEnum;

public interface OrdersDao {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(OrdersEntity record);

    public OrdersEntity selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(OrdersEntity record);
    
    public OrdersEntity selectSucByBizNo(String bizNo);
    
    public OrdersEntity selectByBizNo(String bizNo);
    
    public int updateOrderStatusByBizNo(@Param("status")OrderStatusEnum status,@Param("bizNo")String bizNo);
    
    public OrdersEntity selectDueByBizNo(String bizNo);

}