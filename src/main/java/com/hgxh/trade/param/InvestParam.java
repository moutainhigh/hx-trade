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
