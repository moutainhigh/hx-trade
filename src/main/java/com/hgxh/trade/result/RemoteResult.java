package com.hgxh.trade.result;
/**
*@ClassName: RemoteResult
*@Description: 
*@author YY 
*@date 2016年12月4日  下午5:23:57
*@version 1.0
*/
public class RemoteResult {
	//返回码
	private String rspCode;
	//返回信息
	private String rspMsg;
	//凭证号
	private String voucherNo;

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

	public String getVoucherNo() {
		return voucherNo;
	}

	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}

}
