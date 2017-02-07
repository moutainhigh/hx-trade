package com.hgxh.trade.result;

/**
*@ClassName: RuifudeRemoteResult
*@Description: 
*@author YY 
*@date 2016年12月4日  下午5:23:57
*@version 1.0
*/
//public class RuifudeRemoteResult {
public class RuifudeRemoteResult<T> {
	//返回码
	private String rspCode;
	//返回信息
	private String rspMsg;
	//返回数据
	private T data;

	public String getRspCode() {
		return rspCode;
	}

	public void setRspCode(String rspCode) {
		this.rspCode = rspCode;
	}

	public String getRspMsg() {
		return rspMsg;
	}

	public void setRspMsg(String rspMsg) {
		this.rspMsg = rspMsg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
