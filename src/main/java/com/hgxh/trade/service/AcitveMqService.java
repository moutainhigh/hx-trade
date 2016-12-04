package com.hgxh.trade.service;
/**
*@ClassName: AcitveMqService
*@Description: 
*@author YY 
*@date 2016年11月18日  下午5:03:39
*@version 1.0
*/
public interface AcitveMqService {
	
	public void sendBidSucceedQueue(String bidNo);
	
	public void sendMsgQueue(String mobile,String content);
	
	public void sendInvestTransQueue(String bidNo,Long requestId);
	
	public void sendTransferQueue(String bidNo,Long transferId);
	
	public void sendFastTransferQueue(String orderNo);

}
