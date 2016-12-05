package com.hgxh.trade.dao;

import com.hgxh.trade.entity.UserTerminalInformationsEntity;

public interface UserTerminalInformationsDao {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(UserTerminalInformationsEntity record);

    public UserTerminalInformationsEntity selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(UserTerminalInformationsEntity record);

}