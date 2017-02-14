package com.hgxh.trade.dao;

import com.hgxh.trade.entity.PurchaseFailEntity;

public interface PurchaseFailDao {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(PurchaseFailEntity record);

    public PurchaseFailEntity selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(PurchaseFailEntity record);

}