package com.hgxh.trade.dao;

import com.hgxh.trade.entity.UserAccountsEntity;

public interface UserAccountsDao {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(UserAccountsEntity record);

    public UserAccountsEntity selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(UserAccountsEntity record);

    public UserAccountsEntity selectByMemberNo(String memberNo);
    
}