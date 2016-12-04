package com.hgxh.trade.result;
/**
*@ClassName: AccountResult
*@Description: 
*@author YY 
*@date 2016年12月4日  下午3:49:54
*@version 1.0
*/
public class AccountResult {
	
	//区域编号
	private String areaNo;
	//入社日期
	private String joinTime;
	//社员编号
	private String memberNo;
	//社员名称
	private String memberName;
	//户口类型
	private String censusRegisterType;
	//社员地址
	private String address;
	//手机号
	private String mobile;
	//介绍人姓名
	private String introducerName;
	//存折账号
	private String passbook;
	
	public String getAreaNo() {
		return areaNo;
	}
	public void setAreaNo(String areaNo) {
		this.areaNo = areaNo;
	}
	public String getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(String joinTime) {
		this.joinTime = joinTime;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getCensusRegisterType() {
		return censusRegisterType;
	}
	public void setCensusRegisterType(String censusRegisterType) {
		this.censusRegisterType = censusRegisterType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getIntroducerName() {
		return introducerName;
	}
	public void setIntroducerName(String introducerName) {
		this.introducerName = introducerName;
	}
	public String getPassbook() {
		return passbook;
	}
	public void setPassbook(String passbook) {
		this.passbook = passbook;
	}

}
