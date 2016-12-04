package com.hgxh.trade.entity;

import java.math.BigDecimal;

import com.hgxh.trade.enums.BidPublishWayEnum;
import com.hgxh.trade.enums.BidStatusEnum;
import com.hgxh.trade.enums.BidTypeEnum;

/**
 * @ClassName StandardInformationsEntity
 * @Description 标的信息表
 * @author yuyang
 * @date 2016-11-15 19:45:57
 * @version 1.0 
 */
public class StandardInformationsEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	private Long id;
    //乐观锁
    private Integer version;
    //项目编码
    private String projectNo;
    //标的所属行业
    private BidTypeEnum bidType;
    //标的编码
    private String bidNo;
    //标的名称
    private String bidName;
    //标的短描述：适应于APP端
    private String bidDescShort;
    //标的描述：适用于PC端
    private String bidDesc;
    //借款方客户编号
    private String bidCustomNo;
    //原始标的托底购买客户编号
    private String lowCustomNo;
    //募投标的状态：INIT：初始;AUDITED：已审核；PUBLISHED：已发布
    private BidStatusEnum bidStatus;
    //排序标记：9对应PUBLISHED；5对应SUCCEED；1对应FINISHED
    private Integer sortFlag;
    //标的额
    private BigDecimal financedAmount;
    //标的份额
    private Long financedShare;
    //最小起买份额
    private Long leastBuyShare;
    //标的周期：单位:日
    private Integer cycle;
    //标的收益率
    private BigDecimal yield;
    private BigDecimal lowestYield;
    //标的起息日
    private Long startDate;
    //标的到期日
    private Long endDate;
    //标的封闭期
    private Integer transferForbidPeriod;
    //开放募集期
    private Integer openBidPeriod;
    //募集结束日期
    private Long openEndDate;
    //担保方客户编号
    private String guarantorCustomNo;
    //允许转让和购买的最后日期
    private Long permitTransferLastDate;
    //上线日期
    private Long onlineDate;
    //创建时间
    private Long createTime;
    //最近修改时间
    private Long lastModifyTime;
    private String use;
    private String proxyCustomNo;
    private BigDecimal realFinancedAmount;
    //manual 手动；auto 自动
    private BidPublishWayEnum publishWay;
    private BigDecimal floatingrate;
    //标的场景
    private String bidScene;
    //最大购买份额
    private Integer maxBuyShare;
    //锁定状态 锁定:LOCK,未锁定:UNLOCK
    private String lockState;
    private String advanceRepay;
    private String penaltyType;
    private Long advanceRepayTime;
    //转让状态 不可快速转让NO_KUICK_TRANSFER 不可普通转让NO_NORMAL_TRANSFER 可转让TRANSFER
    private String transferStatus;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getVersion() {
        return version;
    }
    public void setVersion(Integer version) {
        this.version = version;
    }
    public String getProjectNo() {
        return projectNo;
    }
    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }
    public String getBidNo() {
        return bidNo;
    }
    public void setBidNo(String bidNo) {
        this.bidNo = bidNo;
    }
    public String getBidName() {
        return bidName;
    }
    public void setBidName(String bidName) {
        this.bidName = bidName;
    }
    public String getBidDescShort() {
        return bidDescShort;
    }
    public void setBidDescShort(String bidDescShort) {
        this.bidDescShort = bidDescShort;
    }
    public String getBidDesc() {
        return bidDesc;
    }
    public void setBidDesc(String bidDesc) {
        this.bidDesc = bidDesc;
    }
    public String getBidCustomNo() {
        return bidCustomNo;
    }
    public void setBidCustomNo(String bidCustomNo) {
        this.bidCustomNo = bidCustomNo;
    }
    public String getLowCustomNo() {
        return lowCustomNo;
    }
    public void setLowCustomNo(String lowCustomNo) {
        this.lowCustomNo = lowCustomNo;
    }
    public Integer getSortFlag() {
        return sortFlag;
    }
    public void setSortFlag(Integer sortFlag) {
        this.sortFlag = sortFlag;
    }
    public BigDecimal getFinancedAmount() {
        return financedAmount;
    }
    public void setFinancedAmount(BigDecimal financedAmount) {
        this.financedAmount = financedAmount;
    }
    public Long getFinancedShare() {
        return financedShare;
    }
    public void setFinancedShare(Long financedShare) {
        this.financedShare = financedShare;
    }
    public Long getLeastBuyShare() {
        return leastBuyShare;
    }
    public void setLeastBuyShare(Long leastBuyShare) {
        this.leastBuyShare = leastBuyShare;
    }
    public Integer getCycle() {
        return cycle;
    }
    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }
    public BigDecimal getYield() {
        return yield;
    }
    public void setYield(BigDecimal yield) {
        this.yield = yield;
    }
    public BigDecimal getLowestYield() {
        return lowestYield;
    }
    public void setLowestYield(BigDecimal lowestYield) {
        this.lowestYield = lowestYield;
    }
    public Long getStartDate() {
        return startDate;
    }
    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }
    public Long getEndDate() {
        return endDate;
    }
    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }
    public Integer getTransferForbidPeriod() {
        return transferForbidPeriod;
    }
    public void setTransferForbidPeriod(Integer transferForbidPeriod) {
        this.transferForbidPeriod = transferForbidPeriod;
    }
    public Integer getOpenBidPeriod() {
        return openBidPeriod;
    }
    public void setOpenBidPeriod(Integer openBidPeriod) {
        this.openBidPeriod = openBidPeriod;
    }
    public Long getOpenEndDate() {
        return openEndDate;
    }
    public void setOpenEndDate(Long openEndDate) {
        this.openEndDate = openEndDate;
    }
    public String getGuarantorCustomNo() {
        return guarantorCustomNo;
    }
    public void setGuarantorCustomNo(String guarantorCustomNo) {
        this.guarantorCustomNo = guarantorCustomNo;
    }
    public Long getPermitTransferLastDate() {
        return permitTransferLastDate;
    }
    public void setPermitTransferLastDate(Long permitTransferLastDate) {
        this.permitTransferLastDate = permitTransferLastDate;
    }
    public Long getOnlineDate() {
        return onlineDate;
    }
    public void setOnlineDate(Long onlineDate) {
        this.onlineDate = onlineDate;
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
    public String getUse() {
        return use;
    }
    public void setUse(String use) {
        this.use = use;
    }
    public String getProxyCustomNo() {
        return proxyCustomNo;
    }
    public void setProxyCustomNo(String proxyCustomNo) {
        this.proxyCustomNo = proxyCustomNo;
    }
    public BigDecimal getRealFinancedAmount() {
        return realFinancedAmount;
    }
    public void setRealFinancedAmount(BigDecimal realFinancedAmount) {
        this.realFinancedAmount = realFinancedAmount;
    }
    public BigDecimal getFloatingrate() {
        return floatingrate;
    }
    public void setFloatingrate(BigDecimal floatingrate) {
        this.floatingrate = floatingrate;
    }
    public String getBidScene() {
        return bidScene;
    }
    public void setBidScene(String bidScene) {
        this.bidScene = bidScene;
    }
    public Integer getMaxBuyShare() {
        return maxBuyShare;
    }
    public void setMaxBuyShare(Integer maxBuyShare) {
        this.maxBuyShare = maxBuyShare;
    }
    public String getLockState() {
        return lockState;
    }
    public void setLockState(String lockState) {
        this.lockState = lockState;
    }
    public String getAdvanceRepay() {
        return advanceRepay;
    }
    public void setAdvanceRepay(String advanceRepay) {
        this.advanceRepay = advanceRepay;
    }
    public String getPenaltyType() {
        return penaltyType;
    }
    public void setPenaltyType(String penaltyType) {
        this.penaltyType = penaltyType;
    }
    public Long getAdvanceRepayTime() {
        return advanceRepayTime;
    }
    public void setAdvanceRepayTime(Long advanceRepayTime) {
        this.advanceRepayTime = advanceRepayTime;
    }
    public String getTransferStatus() {
        return transferStatus;
    }
    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }
	public BidTypeEnum getBidType() {
		return bidType;
	}
	public void setBidType(BidTypeEnum bidType) {
		this.bidType = bidType;
	}
	public BidStatusEnum getBidStatus() {
		return bidStatus;
	}
	public void setBidStatus(BidStatusEnum bidStatus) {
		this.bidStatus = bidStatus;
	}
	public BidPublishWayEnum getPublishWay() {
		return publishWay;
	}
	public void setPublishWay(BidPublishWayEnum publishWay) {
		this.publishWay = publishWay;
	}

}