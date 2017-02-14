package com.hgxh.trade.entity;

import java.math.BigDecimal;

/**
 * @ClassName PurchaseFailEntity
 * @Description 购买调用接口失败记录表
 * @author yuyang
 * @date 2017-02-14 11:32:59
 * @version 1.0 
 */
public class PurchaseFailEntity extends BaseEntity{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
    //ID
    private Long id;
    //社员编号
    private String memberNo;
    //产品编号
    private String productNo;
    //产品类型
    private String productType;
    //购买金额
    private BigDecimal amount;
    //下单时间
    private Long orderTime;
    //转存方式
    private String transferSaveType;
    //利息
    private BigDecimal yield;
    //存折号
    private String passbook;
    //返回码
    private String rspCode;
    //返回信息
    private String rspMsg;
    //创建时间
    private Long createTime;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMemberNo() {
        return memberNo;
    }
    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }
    public String getProductNo() {
        return productNo;
    }
    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }
    public String getProductType() {
        return productType;
    }
    public void setProductType(String productType) {
        this.productType = productType;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public Long getOrderTime() {
        return orderTime;
    }
    public void setOrderTime(Long orderTime) {
        this.orderTime = orderTime;
    }
    public String getTransferSaveType() {
		return transferSaveType;
	}
	public void setTransferSaveType(String transferSaveType) {
		this.transferSaveType = transferSaveType;
	}
	public BigDecimal getYield() {
        return yield;
    }
    public void setYield(BigDecimal yield) {
        this.yield = yield;
    }
    public String getPassbook() {
        return passbook;
    }
    public void setPassbook(String passbook) {
        this.passbook = passbook;
    }
    public String getRspCode() {
        return rspCode;
    }
    public void setRspCode(String rspCode) {
        this.rspCode = rspCode;
    }
    public String getRspMsg() {
        return rspMsg;
    }
    public void setRspMsg(String rspMsg) {
        this.rspMsg = rspMsg;
    }
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

}