package com.hgxh.trade.entity;

import java.math.BigDecimal;

import com.hgxh.trade.enums.WhetherEnum;

/**
 * @ClassName LoanRepayInformationsEntity
 * @Description 借款还款详情表
 * @author yuyang
 * @date 2016-12-13 20:01:54
 * @version 1.0 
 */
public class LoanRepayInformationsEntity extends BaseEntity{

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

    private Long id;
    //发放凭证号
    private String issueVoucherNo;
    //是否逾期  YES：是；NO：否
    private WhetherEnum overdue;
    //逾期天数
    private Integer overdueDays;
    //罚息金额
    private BigDecimal defaultAmount;
    //是否提前还款  YES：是；NO：否
    private WhetherEnum aheadRepay;
    //用户还款时间
    private Long userRepayTime;
    //创建时间
    private Long createTime;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getIssueVoucherNo() {
        return issueVoucherNo;
    }
    public void setIssueVoucherNo(String issueVoucherNo) {
        this.issueVoucherNo = issueVoucherNo;
    }
    public Integer getOverdueDays() {
        return overdueDays;
    }
    public void setOverdueDays(Integer overdueDays) {
        this.overdueDays = overdueDays;
    }
    public BigDecimal getDefaultAmount() {
        return defaultAmount;
    }
    public void setDefaultAmount(BigDecimal defaultAmount) {
        this.defaultAmount = defaultAmount;
    }
    public WhetherEnum getOverdue() {
		return overdue;
	}
	public void setOverdue(WhetherEnum overdue) {
		this.overdue = overdue;
	}
	public WhetherEnum getAheadRepay() {
		return aheadRepay;
	}
	public void setAheadRepay(WhetherEnum aheadRepay) {
		this.aheadRepay = aheadRepay;
	}
	public Long getUserRepayTime() {
        return userRepayTime;
    }
    public void setUserRepayTime(Long userRepayTime) {
        this.userRepayTime = userRepayTime;
    }
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

}