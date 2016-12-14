package com.hgxh.trade.param;
/**
*@ClassName: LoanReplyParam
*@Description: 
*@author YY 
*@date 2016年12月13日  上午10:43:42
*@version 1.0
*/
public class LoanReplyParam extends BaseParam{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	//发放凭证号
	private String issueVoucherNo;
	//还款时间
	private String userRepayTime;
	//是否提前还款
	private String aheadRepay;
	//是否逾期，YES：是；NO：否
	private String overdue;
	//逾期天数
	private String overdueDays;
	//罚息金额
	private String defaultAmount;
	
	public String getAheadRepay() {
		return aheadRepay;
	}
	public void setAheadRepay(String aheadRepay) {
		this.aheadRepay = aheadRepay;
	}
	public String getIssueVoucherNo() {
		return issueVoucherNo;
	}
	public void setIssueVoucherNo(String issueVoucherNo) {
		this.issueVoucherNo = issueVoucherNo;
	}
	public String getUserRepayTime() {
		return userRepayTime;
	}
	public void setUserRepayTime(String userRepayTime) {
		this.userRepayTime = userRepayTime;
	}
	public String getOverdue() {
		return overdue;
	}
	public void setOverdue(String overdue) {
		this.overdue = overdue;
	}
	public String getOverdueDays() {
		return overdueDays;
	}
	public void setOverdueDays(String overdueDays) {
		this.overdueDays = overdueDays;
	}
	public String getDefaultAmount() {
		return defaultAmount;
	}
	public void setDefaultAmount(String defaultAmount) {
		this.defaultAmount = defaultAmount;
	}

}
