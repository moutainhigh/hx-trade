package com.hgxh.trade.entity;

import java.math.BigDecimal;

import com.hgxh.trade.enums.ProductTypeEnum;

/**
 * @ClassName ProductInformationsEntity
 * @Description 产品信息表
 * @author yuyang
 * @date 2016-12-04 22:04:10
 * @version 1.0 
 */
public class ProductInformationsEntity extends BaseEntity{

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
    //乐观锁
    private Long version;
    //产品编号
    private String productNo;
    //产品名称
    private String productName;
    //产品类型：CURRENT:活期；FIXED:定期
    private ProductTypeEnum productType;
    //产品周期：单位:天;每月按30天,每年按365天
    private Integer cycle;
    //利率
    private BigDecimal yield;
    //产品状态:INIT：初始,AUDITED：已审核,PUBLISHED：已发布,FINISHED：已结束
    private String status;
    //允许提现次数
    private Integer withdrawCount;
    //简介
    private String briefIntroduction;
    //详细介绍
    private String introduction;
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
    public Long getVersion() {
        return version;
    }
    public void setVersion(Long version) {
        this.version = version;
    }
    public String getProductNo() {
        return productNo;
    }
    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public ProductTypeEnum getProductType() {
        return productType;
    }
    public void setProductType(ProductTypeEnum productType) {
        this.productType = productType;
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
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Integer getWithdrawCount() {
        return withdrawCount;
    }
    public void setWithdrawCount(Integer withdrawCount) {
        this.withdrawCount = withdrawCount;
    }
    public String getBriefIntroduction() {
        return briefIntroduction;
    }
    public void setBriefIntroduction(String briefIntroduction) {
        this.briefIntroduction = briefIntroduction;
    }
    public String getIntroduction() {
        return introduction;
    }
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
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