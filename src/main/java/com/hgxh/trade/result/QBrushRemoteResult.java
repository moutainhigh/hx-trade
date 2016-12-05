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
	private QBrushRemoteHeadResult REP_HEAD;
	//返回主题
	private QBrushRemoteBodyResult REP_BODY;
	
	public QBrushRemoteHeadResult getREP_HEAD() {
		return REP_HEAD;
	}
	public void setREP_HEAD(QBrushRemoteHeadResult rEP_HEAD) {
		REP_HEAD = rEP_HEAD;
	}
	public QBrushRemoteBodyResult getREP_BODY() {
		return REP_BODY;
	}
	public void setREP_BODY(QBrushRemoteBodyResult rEP_BODY) {
		REP_BODY = rEP_BODY;
	}
	
}
