package com.hgxh.trade.service;

import java.util.Map;

/**
*@ClassName: AcitveMqService
*@Description: 
*@author YY 
*@date 2016年11月18日  下午5:03:39
*@version 1.0
*/
public interface AcitveMqService {
	
	public void sendMsgQueue(String mobile,String content);
	
	public void sendCounterTradeQueue(Map<String, String> msg);
	
	public void sendUpsertProductQueue(Map<String, String> msg);

}
