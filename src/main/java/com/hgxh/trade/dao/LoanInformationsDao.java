package com.hgxh.trade.dao;

import org.apache.ibatis.annotations.Param;

import com.hgxh.trade.entity.LoanInformationsEntity;

public interface LoanInformationsDao {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(LoanInformationsEntity record);

    public LoanInformationsEntity selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(LoanInformationsEntity record);
    
    public int updateStatusByVoucherNo(String issueVoucherNo);
    
}