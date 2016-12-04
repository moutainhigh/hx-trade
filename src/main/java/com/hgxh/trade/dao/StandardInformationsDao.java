package com.hgxh.trade.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.hgxh.trade.entity.StandardInformationsEntity;

public interface StandardInformationsDao {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(StandardInformationsEntity record);

    public StandardInformationsEntity selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(StandardInformationsEntity record);
    
    public List<StandardInformationsEntity> getBidByConditions(Map<String, Object> conditions);
	
	public StandardInformationsEntity getBidByBidNo(String bidNo);
	
	public List<StandardInformationsEntity> getOpenBids();
	
	public BigDecimal getFinishedBids();

}