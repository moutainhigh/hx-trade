package com.hgxh.trade.param;
/**
*@ClassName: AddLoanParam
*@Description: 
*@author YY 
*@date 2016年12月13日  上午10:43:13
*@version 1.0
*/
public class AddLoanParam extends BaseParam{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	//社员编号
	private String memberNo;
	//发放凭证号
	private String issueVoucherNo;
	//还款类型
	private String repayType;
	//还款方式
	private String repayWay;
	//贷款金额
	private String amount;
	//贷款利率
	private String yeild;
	//开始时间
	private String beginTime;
	//结束时间
	private String endTime;
	//加罚利率
	private String penaltyYeild;
	//投放时间
	private String putinTime;
	
	public String getPenaltyYeild() {
		return penaltyYeild;
	}
	public void setPenaltyYeild(String penaltyYeild) {
		this.penaltyYeild = penaltyYeild;
	}
	public String getPutinTime() {
		return putinTime;
	}
	public void setPutinTime(String putinTime) {
		this.putinTime = putinTime;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getIssueVoucherNo() {
		return issueVoucherNo;
	}
	public void setIssueVoucherNo(String issueVoucherNo) {
		this.issueVoucherNo = issueVoucherNo;
	}
	public String getRepayType() {
		return repayType;
	}
	public void setRepayType(String repayType) {
		this.repayType = repayType;
	}
	public String getRepayWay() {
		return repayWay;
	}
	public void setRepayWay(String repayWay) {
		this.repayWay = repayWay;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getYeild() {
		return yeild;
	}
	public void setYeild(String yeild) {
		this.yeild = yeild;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
}
