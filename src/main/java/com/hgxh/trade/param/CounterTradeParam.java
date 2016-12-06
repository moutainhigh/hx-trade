package com.hgxh.trade.param;
/**
*@ClassName: CounterTradeParam
*@Description: 
*@author YY 
*@date 2016年12月5日  下午4:57:48
*@version 1.0
*/
public class CounterTradeParam extends BaseParam{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	//社员编号
	private String memberNo;
	//产品编号
	private String productNo;
	//交易类型
	private String tradeType;
	//交易金额
	private String amount;
	//业务编号  活期:存折号  定期:凭证编号
	private String bizNo;
	//资金方向
	private String fundsDirection;
	//交易时间
	private String tradeTime;
	//支付方式
	private String payType;
	//提现卡号
	private String bankCardNo;
	//转存方式 
    private String transferSavaType;
	
	public String getTransferSavaType() {
		return transferSavaType;
	}
	public void setTransferSavaType(String transferSavaType) {
		this.transferSavaType = transferSavaType;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getBizNo() {
		return bizNo;
	}
	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	public String getFundsDirection() {
		return fundsDirection;
	}
	public void setFundsDirection(String fundsDirection) {
		this.fundsDirection = fundsDirection;
	}
	public String getTradeTime() {
		return tradeTime;
	}
	public void setTradeTime(String tradeTime) {
		this.tradeTime = tradeTime;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getTradeType() {
		return tradeType;
	}
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getBankCardNo() {
		return bankCardNo;
	}
	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}
	
}
