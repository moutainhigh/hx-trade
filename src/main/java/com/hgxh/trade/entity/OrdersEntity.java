package com.hgxh.trade.entity;

import java.math.BigDecimal;

import com.hgxh.trade.enums.OrderStatusEnum;
import com.hgxh.trade.enums.OrderTypeEnum;

/**
 * @ClassName OrdersEntity
 * @Description 订单管理
 * @author yuyang
 * @date 2016-12-07 15:53:09
 * @version 1.0 
 */
public class OrdersEntity extends BaseEntity{

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
    //乐观锁
    private Long version;
    //业务编号:定期:凭证号;活期:存折号
    private String bizNo;
    //社员编号
    private String memberNo;
    //订单号
    private String orderNo;
    //产品编号
    private String productNo;
    //用户编号
    private Long userId;
    //订单金额
    private BigDecimal amount;
    //剩余可提现金额
    private BigDecimal withdrawalAmount;
    //已提现次数
    private Integer alreadyWithdrawCount;
    //订单状态：INIT:初始化;SUCCESS:支付成功;FAILED:支付失败;AHEADDUE:提前支取;DUE:正常到期;
    private OrderStatusEnum status;
    //订单类型:PURCHASE:购买
    private OrderTypeEnum orderType;
    //到期时间
    private Long expirationTime;
    //下订单时间
    private Long orderTime;
    //最近修改时间
    private Long lastModifyTime;
    //转存方式 
    private String transferSavaType;
    //支付方式
    private String payType;
    //利率
    private BigDecimal yeild;
    //定期到期预计收益
    private BigDecimal predictInterest;

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
    public String getBizNo() {
        return bizNo;
    }
    public void setBizNo(String bizNo) {
        this.bizNo = bizNo;
    }
    public String getMemberNo() {
        return memberNo;
    }
    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }
    public String getOrderNo() {
        return orderNo;
    }
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    public String getProductNo() {
        return productNo;
    }
    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public BigDecimal getWithdrawalAmount() {
        return withdrawalAmount;
    }
    public void setWithdrawalAmount(BigDecimal withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
    }
    public Integer getAlreadyWithdrawCount() {
        return alreadyWithdrawCount;
    }
    public void setAlreadyWithdrawCount(Integer alreadyWithdrawCount) {
        this.alreadyWithdrawCount = alreadyWithdrawCount;
    }
    public OrderStatusEnum getStatus() {
		return status;
	}
	public void setStatus(OrderStatusEnum status) {
		this.status = status;
	}
	public OrderTypeEnum getOrderType() {
		return orderType;
	}
	public void setOrderType(OrderTypeEnum orderType) {
		this.orderType = orderType;
	}
	public Long getExpirationTime() {
        return expirationTime;
    }
    public void setExpirationTime(Long expirationTime) {
        this.expirationTime = expirationTime;
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
    public String getTransferSavaType() {
        return transferSavaType;
    }
    public void setTransferSavaType(String transferSavaType) {
        this.transferSavaType = transferSavaType;
    }
    public String getPayType() {
        return payType;
    }
    public void setPayType(String payType) {
        this.payType = payType;
    }
    public BigDecimal getYeild() {
        return yeild;
    }
    public void setYeild(BigDecimal yeild) {
        this.yeild = yeild;
    }
    public BigDecimal getPredictInterest() {
        return predictInterest;
    }
    public void setPredictInterest(BigDecimal predictInterest) {
        this.predictInterest = predictInterest;
    }

}