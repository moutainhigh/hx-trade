package com.hgxh.trade.dao;

import com.hgxh.trade.entity.UserMemberInformationsEntity;

public interface UserMemberInformationsDao {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(UserMemberInformationsEntity record);

    public UserMemberInformationsEntity selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(UserMemberInformationsEntity record);
    
    public UserMemberInformationsEntity selectByMemberNo(String memberNo);

}