package com.hgxh.trade.entity;

import java.math.BigDecimal;

/**
 * @ClassName FinancialInformationsEntity
 * @Description 资金流水表
 * @author yuyang
 * @date 2016-12-06 10:02:24
 * @version 1.0 
 */
public class FinancialInformationsEntity extends BaseEntity{

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
    //流水号
    private String flowNo;
    //产品编号
    private String productNo;
    //交易方式
    //PURCHASE:购买;WITHDRAW:提现;CAPITALTRANS:本金转存;INTERESTTRANS:本息转存;
    //FIXEDTOCURRENT:定期转活期;TRANSFER:转账;INTERESTDEDUCTION:利息划扣;SENDINTEREST:派息
    //AHEADDUE:定期提前支取;
    private String tradeType;
    //资金方向
    private String fundsDirection;
    //用户编号
    private Long userId;
    //交易金额
    private BigDecimal amount;
    //源:APP:手机端;COUNTER:柜台
    private String source;
    //提现卡号
    private String bankCardNo;
    //创建时间
    private Long createTime;
    //最近修改时间
    private Long lastModifyTime;
    //业务编号 活期:存折号;定期:凭证号
    private String bizNo;
    private String memberNo;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFlowNo() {
        return flowNo;
    }
    public void setFlowNo(String flowNo) {
        this.flowNo = flowNo;
    }
    public String getProductNo() {
        return productNo;
    }
    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }
    public String getTradeType() {
        return tradeType;
    }
    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }
    public String getFundsDirection() {
        return fundsDirection;
    }
    public void setFundsDirection(String fundsDirection) {
        this.fundsDirection = fundsDirection;
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
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getBankCardNo() {
        return bankCardNo;
    }
    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
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

}