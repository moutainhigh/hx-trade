package com.hgxh.trade.param;

/**
*@ClassName: InvestParam
*@Description: 
*@author YY 
*@date 2016年12月4日  下午5:08:41
*@version 1.0
*/
public class InvestParam extends BaseParam{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	//社员编号
	private String memberNo;
	//存折账号
	private String passbook;
	//产品编号
	private String productNo;
	//金额
	private String amount;
	//投资时间
	private String investTime;
	//转存方式
	private String transferSaveType;
	//密码
	private String password;
	//利率
	private String yield;
	//产品类型
	private String productType;
	//到期时间
	private String expirationTime;
	
	public String getExpirationTime() {
		return expirationTime;
	}
	public void setExpirationTime(String expirationTime) {
		this.expirationTime = expirationTime;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getYield() {
		return yield;
	}
	public void setYield(String yield) {
		this.yield = yield;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTransferSaveType() {
		return transferSaveType;
	}
	public void setTransferSaveType(String transferSaveType) {
		this.transferSaveType = transferSaveType;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getPassbook() {
		return passbook;
	}
	public void setPassbook(String passbook) {
		this.passbook = passbook;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getInvestTime() {
		return investTime;
	}
	public void setInvestTime(String investTime) {
		this.investTime = investTime;
	}

}
