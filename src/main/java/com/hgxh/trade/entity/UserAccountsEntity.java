package com.hgxh.trade.entity;

import java.math.BigDecimal;

/**
 * @ClassName UserAccountsEntity
 * @Description 用户产品统计表
 * @author yuyang
 * @date 2016-12-07 11:31:14
 * @version 1.0 
 */
public class UserAccountsEntity extends BaseEntity{

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
    //乐观锁
    private Long version;
    //用户编号
    private Long userId;
    //总投资金额
    private BigDecimal totalInvested;
    //总在投金额
    private BigDecimal totalOnInvested;
    //总获取利息
    private BigDecimal totalInterest;
    //昨日收益
    private BigDecimal yesterdayInterest;
    //最近修改时间
    private Long lastModifyTime;
    //创建时间
    private Long createtime;
    //社员编号
    private String memberNo;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getVersion() {
        return version;
    }
    public void setVersion(Long version) {
        this.version = version;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public BigDecimal getTotalInvested() {
        return totalInvested;
    }
    public void setTotalInvested(BigDecimal totalInvested) {
        this.totalInvested = totalInvested;
    }
    public BigDecimal getTotalOnInvested() {
        return totalOnInvested;
    }
    public void setTotalOnInvested(BigDecimal totalOnInvested) {
        this.totalOnInvested = totalOnInvested;
    }
    public BigDecimal getTotalInterest() {
        return totalInterest;
    }
    public void setTotalInterest(BigDecimal totalInterest) {
        this.totalInterest = totalInterest;
    }
    public BigDecimal getYesterdayInterest() {
        return yesterdayInterest;
    }
    public void setYesterdayInterest(BigDecimal yesterdayInterest) {
        this.yesterdayInterest = yesterdayInterest;
    }
    public Long getLastModifyTime() {
        return lastModifyTime;
    }
    public void setLastModifyTime(Long lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
    public Long getCreatetime() {
        return createtime;
    }
    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }
    public String getMemberNo() {
        return memberNo;
    }
    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

}