package com.hgxh.trade.dao;

import com.hgxh.trade.entity.LoanRepayInformationsEntity;

public interface LoanRepayInformationsDao {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(LoanRepayInformationsEntity record);

    public LoanRepayInformationsEntity selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(LoanRepayInformationsEntity record);

}