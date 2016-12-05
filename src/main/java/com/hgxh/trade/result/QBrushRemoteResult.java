package com.hgxh.trade.result;
/**
*@ClassName: QBrushRemoteResult
*@Description: 
*@author YY 
*@date 2016年12月5日  上午11:26:28
*@version 1.0
*/
//Q刷接口返回信息
public class QBrushRemoteResult {
	
	//返回头信息
	private Object REP_HEAD;
	//返回主题
	private Object REP_BODY;
	//返回编码
	private String RSPCOD;
	//返回信息
	private String RSPMSG;
	public Object getREP_HEAD() {
		return REP_HEAD;
	}
	public void setREP_HEAD(Object rEP_HEAD) {
		REP_HEAD = rEP_HEAD;
	}
	public Object getREP_BODY() {
		return REP_BODY;
	}
	public void setREP_BODY(Object rEP_BODY) {
		REP_BODY = rEP_BODY;
	}
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
}
