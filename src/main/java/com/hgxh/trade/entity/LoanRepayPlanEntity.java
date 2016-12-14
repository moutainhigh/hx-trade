package com.hgxh.trade.entity;

import java.math.BigDecimal;

import com.hgxh.trade.enums.RepayPlanEnum;
import com.hgxh.trade.enums.WhetherEnum;

/**
 * @ClassName LoanRepayPlanEntity
 * @Description 借款还款计划表
 * @author yuyang
 * @date 2016-12-14 16:59:07
 * @version 1.0 
 */
public class LoanRepayPlanEntity extends BaseEntity{

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
    //发放凭证号
    private String issueVoucherNo;
    //还款日期
    private Long repayTime;
    //还款本金
    private BigDecimal capital;
    //还款利息
    private BigDecimal interest;
    //还款状态  YES：已还；NO：未还
    private RepayPlanEnum status;
    //是否是本期 YES：是；NO：不是
    private WhetherEnum current;
    //创建时间
    private Long createTime;
    //最近修改时间
    private Long lastModifyTime;

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
    public Long getRepayTime() {
        return repayTime;
    }
    public void setRepayTime(Long repayTime) {
        this.repayTime = repayTime;
    }
    public BigDecimal getCapital() {
        return capital;
    }
    public void setCapital(BigDecimal capital) {
        this.capital = capital;
    }
    public BigDecimal getInterest() {
        return interest;
    }
    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }
    public RepayPlanEnum getStatus() {
		return status;
	}
	public void setStatus(RepayPlanEnum status) {
		this.status = status;
	}
	public WhetherEnum getCurrent() {
		return current;
	}
	public void setCurrent(WhetherEnum current) {
		this.current = current;
	}
	public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    public Long getLastModifyTime() {
        return lastModifyTime;
    }
    public void setLastModifyTime(Long lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

}