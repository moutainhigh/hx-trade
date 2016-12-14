package com.hgxh.trade.dao;

import org.apache.ibatis.annotations.Param;

import com.hgxh.trade.entity.LoanRepayPlanEntity;

public interface LoanRepayPlanDao {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(LoanRepayPlanEntity record);

    public LoanRepayPlanEntity selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(LoanRepayPlanEntity record);
    
    public int updateCurrentByVoucherNo(String issueVoucherNo);
    
    public int updateStatusByConditions(@Param("issueVoucherNo")String issueVoucherNo, @Param("repayTime")long repayTime);
    
    public int updateStatusByVoucherNo(String issueVoucherNo);

}