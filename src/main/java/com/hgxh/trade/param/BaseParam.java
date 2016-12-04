package com.hgxh.trade.param;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @Description: 参数基类，传入参数对象需继承此对象
 * @author Leo Wu
 * @date 2016年5月31日  下午4:12:53
 * @version 1.0
 */
public class BaseParam implements Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
