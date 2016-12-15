package com.hgxh.trade.entity;

import com.hgxh.trade.enums.TerminalTypeEnum;

/**
 * @ClassName UserTerminalInformationsEntity
 * @Description 
 * @author yuyang
 * @date 2016-12-05 10:34:44
 * @version 1.0 
 */
public class UserTerminalInformationsEntity extends BaseEntity{

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
    //用户ID
    private Long userId;
    //终端号
    private String terminalNo;
    //蓝牙地址	安卓手机传参、IOS为空
  	private String bluetoothUrl;
    //终端类型
    private TerminalTypeEnum terminalType;
    //绑定时间
    private Long bindTime;

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
    public String getTerminalNo() {
        return terminalNo;
    }
    public void setTerminalNo(String terminalNo) {
        this.terminalNo = terminalNo;
    }
    public String getBluetoothUrl() {
		return bluetoothUrl;
	}
	public void setBluetoothUrl(String bluetoothUrl) {
		this.bluetoothUrl = bluetoothUrl;
	}
	public TerminalTypeEnum getTerminalType() {
        return terminalType;
    }
    public void setTerminalType(TerminalTypeEnum terminalType) {
        this.terminalType = terminalType;
    }
    public Long getBindTime() {
        return bindTime;
    }
    public void setBindTime(Long bindTime) {
        this.bindTime = bindTime;
    }

}