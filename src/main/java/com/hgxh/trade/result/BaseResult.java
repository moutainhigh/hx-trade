package  com.hgxh.trade.result;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author ZQ
 * @date 2015-9-10
 * @version 1.0
 */
public class BaseResult implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/** 返回信息码*/
	private String rspCode;
	/** 返回信息内容*/
	private String rspMsg;

	public BaseResult(){}
	
	public BaseResult(String rspCode, String rspMsg) {
		this.rspCode = rspCode;
		this.rspMsg = rspMsg;
	}
	
	public String getRspCode() {
		return rspCode;
	}

	public String getRspMsg() {
		return rspMsg;
	}
	
	public void setRspCode(String rspCode) {
		this.rspCode = rspCode;
	}

	public void setRspMsg(String rspMsg) {
		this.rspMsg = rspMsg;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
