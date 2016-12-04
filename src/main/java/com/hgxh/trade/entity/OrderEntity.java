package com.hgxh.trade.entity;

import java.math.BigDecimal;

import com.hgxh.trade.enums.BuyTypeEnum;
import com.hgxh.trade.enums.GoodsTypeEnum;
import com.hgxh.trade.enums.OrderStatusEnum;

/**
 * @ClassName OrderEntity
 * @Description 订单管理
 * @author yuyang
 * @date 2016-11-15 16:51:42
 * @version 1.0 
 */
public class OrderEntity extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

    private Long id;
    //乐观锁
    private Integer version;
    //订单号
    private String orderNo;
    //购买客户编码
    private String buyCustomNo;
    //卖出客户编码
    private String sellerCustomNo;
    //商品类型：ORIG:原始标的购买；TRANS：转让信息购买
    private GoodsTypeEnum goodsType;
    //商品编码
    private String goodsNo;
    //购买类型：GENE：一般购买；LOW：托底购买
    private BuyTypeEnum buyType;
    //订单有效期
    private Integer orderValidPeriod;
    //订单有效期结束日期
    private Long orderValidEndDate;
    //商品名称
    private String goodsName;
    //商品描述
    private String goodsDesc;
    //原始募投标的编码
    private String orgBidNo;
    //购买金额
    private BigDecimal buyAmount;
    //成本
    private BigDecimal costAmount;
    //购买份额
    private Long buyShare;
    //买方交易手续费
    private BigDecimal buyerFee;
    //卖方交易手续费
    private BigDecimal sellerFee;
    //封闭周期
    private Integer lockPeriod;
    //封闭起始日期
    private Long lockStartDate;
    //封闭结束日期
    private Long lockEndDate;
    //订单状态：INIT:初始化；SUCCESS:购买成功；FAILED:购买失败；TRANSFERED:已转让；TRANSFERING:正在转让
    private OrderStatusEnum orderStatus;
    //已转让金额
    private BigDecimal transferedAmount;
    //已转让份额
    private Integer transferedShare;
    //正在转让金额
    private BigDecimal transferingAmount;
    //正在转让份额
    private Integer transferingShare;
    //账面收益
    private BigDecimal achievingInterest;
    //已获取收益
    private BigDecimal achievedInterest;
    //转让信息编码
    private String transferNo;
    //购买意愿请求编码
    private String buyRequestNo;
    //托底收益率：托底购买时记录
    private BigDecimal lowYield;
    //起息日：针对原始购买者，起息日为标的起息日；针对转让购买者，起息日为购买日的下一工作日
    private Long startDate;
    //项目到期日：针对转让中的出让人，计息结束日为转让购买成交的前一工作日
    private Long endDate;
    //下订单时间
    private Long orderTime;
    //最近修改时间
    private Long lastModifyTime;
    private Integer existContract;
    private String couponno;

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
    public String getOrderNo() {
        return orderNo;
    }
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    public String getBuyCustomNo() {
        return buyCustomNo;
    }
    public void setBuyCustomNo(String buyCustomNo) {
        this.buyCustomNo = buyCustomNo;
    }
    public String getSellerCustomNo() {
        return sellerCustomNo;
    }
    public void setSellerCustomNo(String sellerCustomNo) {
        this.sellerCustomNo = sellerCustomNo;
    }
    public String getGoodsNo() {
        return goodsNo;
    }
    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }
    public Integer getOrderValidPeriod() {
        return orderValidPeriod;
    }
    public void setOrderValidPeriod(Integer orderValidPeriod) {
        this.orderValidPeriod = orderValidPeriod;
    }
    public Long getOrderValidEndDate() {
        return orderValidEndDate;
    }
    public void setOrderValidEndDate(Long orderValidEndDate) {
        this.orderValidEndDate = orderValidEndDate;
    }
    public String getGoodsName() {
        return goodsName;
    }
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    public String getGoodsDesc() {
        return goodsDesc;
    }
    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }
    public String getOrgBidNo() {
        return orgBidNo;
    }
    public void setOrgBidNo(String orgBidNo) {
        this.orgBidNo = orgBidNo;
    }
    public BigDecimal getBuyAmount() {
        return buyAmount;
    }
    public void setBuyAmount(BigDecimal buyAmount) {
        this.buyAmount = buyAmount;
    }
    public BigDecimal getCostAmount() {
        return costAmount;
    }
    public void setCostAmount(BigDecimal costAmount) {
        this.costAmount = costAmount;
    }
    public Long getBuyShare() {
        return buyShare;
    }
    public void setBuyShare(Long buyShare) {
        this.buyShare = buyShare;
    }
    public BigDecimal getBuyerFee() {
        return buyerFee;
    }
    public void setBuyerFee(BigDecimal buyerFee) {
        this.buyerFee = buyerFee;
    }
    public BigDecimal getSellerFee() {
        return sellerFee;
    }
    public void setSellerFee(BigDecimal sellerFee) {
        this.sellerFee = sellerFee;
    }
    public Integer getLockPeriod() {
        return lockPeriod;
    }
    public void setLockPeriod(Integer lockPeriod) {
        this.lockPeriod = lockPeriod;
    }
    public Long getLockStartDate() {
        return lockStartDate;
    }
    public void setLockStartDate(Long lockStartDate) {
        this.lockStartDate = lockStartDate;
    }
    public Long getLockEndDate() {
        return lockEndDate;
    }
    public void setLockEndDate(Long lockEndDate) {
        this.lockEndDate = lockEndDate;
    }
    public BigDecimal getTransferedAmount() {
        return transferedAmount;
    }
    public void setTransferedAmount(BigDecimal transferedAmount) {
        this.transferedAmount = transferedAmount;
    }
    public Integer getTransferedShare() {
        return transferedShare;
    }
    public void setTransferedShare(Integer transferedShare) {
        this.transferedShare = transferedShare;
    }
    public BigDecimal getTransferingAmount() {
        return transferingAmount;
    }
    public void setTransferingAmount(BigDecimal transferingAmount) {
        this.transferingAmount = transferingAmount;
    }
    public Integer getTransferingShare() {
        return transferingShare;
    }
    public void setTransferingShare(Integer transferingShare) {
        this.transferingShare = transferingShare;
    }
    public BigDecimal getAchievingInterest() {
        return achievingInterest;
    }
    public void setAchievingInterest(BigDecimal achievingInterest) {
        this.achievingInterest = achievingInterest;
    }
    public BigDecimal getAchievedInterest() {
        return achievedInterest;
    }
    public void setAchievedInterest(BigDecimal achievedInterest) {
        this.achievedInterest = achievedInterest;
    }
    public String getTransferNo() {
        return transferNo;
    }
    public void setTransferNo(String transferNo) {
        this.transferNo = transferNo;
    }
    public String getBuyRequestNo() {
        return buyRequestNo;
    }
    public void setBuyRequestNo(String buyRequestNo) {
        this.buyRequestNo = buyRequestNo;
    }
    public BigDecimal getLowYield() {
        return lowYield;
    }
    public void setLowYield(BigDecimal lowYield) {
        this.lowYield = lowYield;
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
    public Long getOrderTime() {
        return orderTime;
    }
    public void setOrderTime(Long orderTime) {
        this.orderTime = orderTime;
    }
    public Long getLastModifyTime() {
        return lastModifyTime;
    }
    public void setLastModifyTime(Long lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
    public Integer getExistContract() {
        return existContract;
    }
    public void setExistContract(Integer existContract) {
        this.existContract = existContract;
    }
    public String getCouponno() {
        return couponno;
    }
    public void setCouponno(String couponno) {
        this.couponno = couponno;
    }
	public GoodsTypeEnum getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(GoodsTypeEnum goodsType) {
		this.goodsType = goodsType;
	}
	public BuyTypeEnum getBuyType() {
		return buyType;
	}
	public void setBuyType(BuyTypeEnum buyType) {
		this.buyType = buyType;
	}
	public OrderStatusEnum getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatusEnum orderStatus) {
		this.orderStatus = orderStatus;
	}

}