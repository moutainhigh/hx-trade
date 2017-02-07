package com.hgxh.trade.param;
/**
*@ClassName: WithdrawParam
*@Description: 
*@author YY 
*@date 2016年12月4日  下午5:52:10
*@version 1.0
*/
public class WithdrawParam extends BaseParam{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	//社员编号
	private String memberNo;
	//业务编号
	private String bizNo;
	//产品编号
	private String productNo;
	//产品类型
	private String productType;
	//金额
	private String amount;
	//开户行
	private String bankCode;
	//开户名
	private String memberName;
	//开户账号
	private String bankCardNo;
	//密码
	private String password;
	
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getBankCardNo() {
		return bankCardNo;
	}
	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}
	public String getBizNo() {
		return bizNo;
	}
	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

}
