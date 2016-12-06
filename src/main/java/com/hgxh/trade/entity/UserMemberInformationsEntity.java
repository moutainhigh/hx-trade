package com.hgxh.trade.entity;

/**
 * @ClassName UserMemberInformationsEntity
 * @Description 用户社员信息表
 * @author yuyang
 * @date 2016-12-06 10:34:29
 * @version 1.0 
 */
public class UserMemberInformationsEntity extends BaseEntity{

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
    //用户id
    private Long userId;
    //社员编号
    private String memberNo;
    //社员名称
    private String memberName;
    //区域编号
    private String areaNo;
    //介绍人姓名
    private String introducerName;
    //账号
    private String bankCardNo;
    //地址
    private String address;
    //户口类型
    private String censusRegisterType;
    //入社时间
    private Long joinTime;
    private Long createTime;
    private Long lastModifyTime;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
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
    public String getAreaNo() {
        return areaNo;
    }
    public void setAreaNo(String areaNo) {
        this.areaNo = areaNo;
    }
    public String getIntroducerName() {
        return introducerName;
    }
    public void setIntroducerName(String introducerName) {
        this.introducerName = introducerName;
    }
    public String getBankCardNo() {
        return bankCardNo;
    }
    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCensusRegisterType() {
        return censusRegisterType;
    }
    public void setCensusRegisterType(String censusRegisterType) {
        this.censusRegisterType = censusRegisterType;
    }
    public Long getJoinTime() {
        return joinTime;
    }
    public void setJoinTime(Long joinTime) {
        this.joinTime = joinTime;
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