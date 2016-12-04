package com.hgxh.trade.entity;

import com.hgxh.trade.enums.AuthStatusEnum;
import com.hgxh.trade.enums.BankBindStatusEnum;
import com.hgxh.trade.enums.CustomTypeEnum;
import com.hgxh.trade.enums.PayPassStatusEnum;
import com.hgxh.trade.enums.UserStatusEnum;

/**
 * @ClassName UserEntity
 * @Description 用户表
 * @author yuyang
 * @date 2016-11-14 19:50:32
 * @version 1.0 
 */
public class UserEntity extends BaseEntity{

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
    //用户编号
    private String userNo;
    //用户别名
    private String userNickName;
    //用户登录密码
    private String userPass;
    //用户支付密码设置状态:INIT:初始未设置 SETED:已设置
    private PayPassStatusEnum payPassStatus;
    //昵称修改状态：初始化：INIT；已修改：SETED
    private String nicknameStatus;
    //用户状态：NORM：正常；FROZED：已冻结；RMVED：已注销
    private UserStatusEnum userStatus;
    //用户类型:USR:个人用户;MER:商户
    private CustomTypeEnum userType;
    //用户来源：PC/QPOS/MR/ZXB
    private String userSource;
    //实名认证状态：INIT：初始未认证；AUTHED：已认证
    private AuthStatusEnum authStatus;
    //银行卡绑定状态：INIT：初始未绑定；BINDED：已绑定
    private BankBindStatusEnum bankBindStatus;
    //已绑定银行卡张数
    private Integer bindedBankCardNum;
    //用户手机号码
    private String mobile;
    //平台商户号：如果为QPOS注册，则此为众信用户关联的支付通QPOS商户号
    private String platformMerNo;
    //平台用户Id
    private String platformUserId;
    //平台客户号
    private String platformCustomNo;
    //用户注册时间
    private Long userRegTime;
    //最近修改时间
    private Long lastModifyTime;
    private String icardpayuser;
    private String payPass;//支付密码
    private String userip;
    //用户设备Id
    private String devId;
    private String osType;
    //金帐号用户编号
    private String accountNo;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserNo() {
        return userNo;
    }
    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }
    public String getUserNickName() {
        return userNickName;
    }
    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }
    public String getUserPass() {
        return userPass;
    }
    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
    public String getNicknameStatus() {
        return nicknameStatus;
    }
    public void setNicknameStatus(String nicknameStatus) {
        this.nicknameStatus = nicknameStatus;
    }
    public String getUserSource() {
        return userSource;
    }
    public void setUserSource(String userSource) {
        this.userSource = userSource;
    }
    public PayPassStatusEnum getPayPassStatus() {
		return payPassStatus;
	}
	public void setPayPassStatus(PayPassStatusEnum payPassStatus) {
		this.payPassStatus = payPassStatus;
	}
	public UserStatusEnum getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(UserStatusEnum userStatus) {
		this.userStatus = userStatus;
	}
	public CustomTypeEnum getUserType() {
		return userType;
	}
	public void setUserType(CustomTypeEnum userType) {
		this.userType = userType;
	}
	public AuthStatusEnum getAuthStatus() {
		return authStatus;
	}
	public void setAuthStatus(AuthStatusEnum authStatus) {
		this.authStatus = authStatus;
	}
	public BankBindStatusEnum getBankBindStatus() {
		return bankBindStatus;
	}
	public void setBankBindStatus(BankBindStatusEnum bankBindStatus) {
		this.bankBindStatus = bankBindStatus;
	}
	public Integer getBindedBankCardNum() {
        return bindedBankCardNum;
    }
    public void setBindedBankCardNum(Integer bindedBankCardNum) {
        this.bindedBankCardNum = bindedBankCardNum;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getPlatformMerNo() {
        return platformMerNo;
    }
    public void setPlatformMerNo(String platformMerNo) {
        this.platformMerNo = platformMerNo;
    }
    public String getPlatformUserId() {
        return platformUserId;
    }
    public void setPlatformUserId(String platformUserId) {
        this.platformUserId = platformUserId;
    }
    public String getPlatformCustomNo() {
        return platformCustomNo;
    }
    public void setPlatformCustomNo(String platformCustomNo) {
        this.platformCustomNo = platformCustomNo;
    }
    public Long getUserRegTime() {
        return userRegTime;
    }
    public void setUserRegTime(Long userRegTime) {
        this.userRegTime = userRegTime;
    }
    public Long getLastModifyTime() {
        return lastModifyTime;
    }
    public void setLastModifyTime(Long lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
    public String getIcardpayuser() {
        return icardpayuser;
    }
    public void setIcardpayuser(String icardpayuser) {
        this.icardpayuser = icardpayuser;
    }
    public String getPayPass() {
        return payPass;
    }
    public void setPayPass(String payPass) {
        this.payPass = payPass;
    }
    public String getUserip() {
        return userip;
    }
    public void setUserip(String userip) {
        this.userip = userip;
    }
    public String getDevId() {
        return devId;
    }
    public void setDevId(String devId) {
        this.devId = devId;
    }
    public String getOsType() {
        return osType;
    }
    public void setOsType(String osType) {
        this.osType = osType;
    }
    public String getAccountNo() {
        return accountNo;
    }
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

}