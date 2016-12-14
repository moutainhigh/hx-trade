package com.hgxh.trade.entity;

import java.math.BigDecimal;

import com.hgxh.trade.enums.LoanStatusEnum;
import com.hgxh.trade.enums.RepayTypeEnum;
import com.hgxh.trade.enums.RepayWayEnum;

/**
 * @ClassName LoanInformationsEntity
 * @Description 借款详情表
 * @author yuyang
 * @date 2016-12-13 16:36:31
 * @version 1.0 
 */
public class LoanInformationsEntity extends BaseEntity{

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
    //发放凭证号
    private String issueVoucherNo;
    //社员编号
    private String memberNo;
    //还款类型  MONTH：按月还款
    private RepayTypeEnum repayType;
    //还款方式   AVERAGECAPITAL：等额本金;AVERAGEINTEREST：等额本息;DISPOSABLE：一次性还本
    private RepayWayEnum repayWay;
    //借款金额
    private BigDecimal amount;
    //借款利率
    private BigDecimal yeild;
    //开始时间
    private Long beginTime;
    //结束时间
    private Long endTime;
    //状态  PROCESSING：进行中；PUBLISH：已完成;PREPAY：提前还款
    private LoanStatusEnum status;
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
    public String getMemberNo() {
        return memberNo;
    }
    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }
    public RepayTypeEnum getRepayType() {
		return repayType;
	}
	public void setRepayType(RepayTypeEnum repayType) {
		this.repayType = repayType;
	}
	public RepayWayEnum getRepayWay() {
		return repayWay;
	}
	public void setRepayWay(RepayWayEnum repayWay) {
		this.repayWay = repayWay;
	}
	public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public BigDecimal getYeild() {
        return yeild;
    }
    public void setYeild(BigDecimal yeild) {
        this.yeild = yeild;
    }
    public Long getBeginTime() {
        return beginTime;
    }
    public void setBeginTime(Long beginTime) {
        this.beginTime = beginTime;
    }
    public Long getEndTime() {
        return endTime;
    }
    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }
    public LoanStatusEnum getStatus() {
        return status;
    }
    public void setStatus(LoanStatusEnum status) {
        this.status = status;
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