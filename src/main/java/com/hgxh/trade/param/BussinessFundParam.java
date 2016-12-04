package com.hgxh.trade.param;

import com.hgxh.trade.enums.CoreTradeTypeEnum;
import com.hgxh.trade.enums.CustomTypeEnum;

/**
*@ClassName: BussinessFundParam
*@Description: 核心交易参数
*@author YY 
*@date 2016年11月15日  下午3:51:12
*@version 1.0
*/
public class BussinessFundParam extends BaseParam {

	private static final long serialVersionUID = 1L;
	//用户ID
	private String userId;
	//标的编号
	private String bidNo;
	//交易份额
	private Long share;
	//利率
	private String yield;
	//交易类型  原始购买:INVEST,转让购买:INVESTTRANS,一般转让:TRANSFER,快速转让:FASTTRANSFER
    private CoreTradeTypeEnum tradeType;
	//商户类型   USER:个人 ,MER:商户 
	private CustomTypeEnum customType;
	//请求编号
	private String requestNo;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBidNo() {
		return bidNo;
	}
	public void setBidNo(String bidNo) {
		this.bidNo = bidNo;
	}
	public Long getShare() {
		return share;
	}
	public void setShare(Long share) {
		this.share = share;
	}
	public String getYield() {
		return yield;
	}
	public void setYield(String yield) {
		this.yield = yield;
	}
	public CustomTypeEnum getCustomType() {
		return customType;
	}
	public void setCustomType(CustomTypeEnum customType) {
		this.customType = customType;
	}
	public CoreTradeTypeEnum getTradeType() {
		return tradeType;
	}
	public void setTradeType(CoreTradeTypeEnum tradeType) {
		this.tradeType = tradeType;
	}
	public String getRequestNo() {
		return requestNo;
	}
	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

}
