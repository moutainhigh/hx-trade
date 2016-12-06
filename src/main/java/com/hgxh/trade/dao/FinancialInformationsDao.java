package com.hgxh.trade.dao;

import com.hgxh.trade.entity.FinancialInformationsEntity;

public interface FinancialInformationsDao {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(FinancialInformationsEntity record);

    public FinancialInformationsEntity selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(FinancialInformationsEntity record);

}