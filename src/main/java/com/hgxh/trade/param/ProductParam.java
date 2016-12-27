package com.hgxh.trade.param;

/**
*@ClassName: ProductParam
*@Description: 
*@author YY 
*@date 2016年12月6日  下午4:34:20
*@version 1.0
*/
public class ProductParam extends BaseParam{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	//产品编号
    private String productNo;
    //产品名称
    private String productName;
    //产品类型：CURRENT:活期；FIXED:定期
    private String productType;
    //产品周期：单位:天;每月按30天,每年按360天
    private String cycle;
    //利率
    private String yield;
    //允许提现次数
    private String withdrawCount;
    //简介
    private String briefIntroduction;
    //详细介绍
    private String introduction;
    //产品开通时间
    private String createTime;
    //分红利率
    private String partYield;
    //分社编号
    private String areaNo;
    
	public String getPartYield() {
		return partYield;
	}
	public void setPartYield(String partYield) {
		this.partYield = partYield;
	}
	public String getAreaNo() {
		return areaNo;
	}
	public void setAreaNo(String areaNo) {
		this.areaNo = areaNo;
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
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getCycle() {
		return cycle;
	}
	public void setCycle(String cycle) {
		this.cycle = cycle;
	}
	public String getYield() {
		return yield;
	}
	public void setYield(String yield) {
		this.yield = yield;
	}
	public String getWithdrawCount() {
		return withdrawCount;
	}
	public void setWithdrawCount(String withdrawCount) {
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
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
    
}
