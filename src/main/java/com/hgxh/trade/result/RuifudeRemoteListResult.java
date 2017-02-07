package com.hgxh.trade.result;

import java.util.List;
/**
*@ClassName: RuifudeRemoteListResult
*@Description: 
*@author YY 
*@date 2017年2月7日  下午2:47:43
*@version 1.0
*/
public class RuifudeRemoteListResult<T> {
	//返回码
	private String rspCode;
	//返回信息
	private String rspMsg;
	//返回数据
	private List<T> data;
	
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
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}

}
