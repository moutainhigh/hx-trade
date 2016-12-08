package com.hgxh.trade.enums;
/**
*@ClassName: OrderStatusEnum
*@Description: 
*@author YY 
*@date 2016年12月6日  下午12:03:35
*@version 1.0
*/
public enum OrderStatusEnum {
	INIT,//初始化
	SUCCESS,//支付成功
	FAILED,//支付失败
	DUETRANS,//到期转存
	AHEADDUE,//提前支取
	DUE;//正常到期
}
