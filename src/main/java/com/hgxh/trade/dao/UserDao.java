package com.hgxh.trade.dao;

import com.hgxh.trade.entity.UserEntity;

public interface UserDao {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(UserEntity record);

    public UserEntity selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(UserEntity record);

	public int updatePlatformmerno(UserEntity userEntity);
	
	public UserEntity getUserByUserId(String userId);

}