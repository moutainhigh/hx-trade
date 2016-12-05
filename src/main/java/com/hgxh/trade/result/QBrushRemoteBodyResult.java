package com.hgxh.trade.result;
/**
*@ClassName: QBrushRemoteBodyResult
*@Description: 
*@author YY 
*@date 2016年12月5日  下午2:46:55
*@version 1.0
*/
public class QBrushRemoteBodyResult {
	
	//返回编码
	private String RSPCOD;
	//返回信息
	private String RSPMSG;
	
	private String balance;
	
	public String getRSPCOD() {
		return RSPCOD;
	}
	public void setRSPCOD(String rSPCOD) {
		RSPCOD = rSPCOD;
	}
	public String getRSPMSG() {
		return RSPMSG;
	}
	public void setRSPMSG(String rSPMSG) {
		RSPMSG = rSPMSG;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}

}
