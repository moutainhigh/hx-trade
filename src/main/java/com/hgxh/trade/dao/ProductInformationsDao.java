package com.hgxh.trade.dao;

import com.hgxh.trade.entity.ProductInformationsEntity;

public interface ProductInformationsDao {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(ProductInformationsEntity record);

    public ProductInformationsEntity selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(ProductInformationsEntity record);
    
    public ProductInformationsEntity selectByProductNo(String productNo);

}