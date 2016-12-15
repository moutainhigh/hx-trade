package com.hgxh.trade.param;
/**
*@ClassName: BindTerminalParam
*@Description: 
*@author YY 
*@date 2016年12月5日  上午10:39:46
*@version 1.0
*/
public class BindTerminalParam extends BaseParam{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	//用户ID
	private Long userId;
	//终端编码
	private String terminalNo;
	//蓝牙地址	安卓手机传参、IOS为空
	private String bluetoothUrl;
	//参数key
	private String paramKey;
	//参数Value
	private String paramValue;
	
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
	public String getParamKey() {
		return paramKey;
	}
	public void setParamKey(String paramKey) {
		this.paramKey = paramKey;
	}
	public String getParamValue() {
		return paramValue;
	}
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

}
