package com.hgxh.trade.util;

/**
 * @author ZQ
 * @date 2015-5-22
 * @version 1.0
 */
public class SequenceUtil {
	
	private static String flowType="F";//柜台购买流水号
	private static String orderType="O";//柜台购买订单号
	private static String voucherType="V";//凭证号
	
	private static String getNo(String type){
		return type+DateUtil.getDateSequence()+NumberUtil.getRandomNo(Constants.SIX);
	}
	
	private static String getShortNo(String type){
		return type+DateUtil.getDateSequence();
	}
	
	public static String getFlowNo(){
		return getNo(flowType);
	}
	
	public static String getOrderNo(){
		return getNo(orderType);
	}
	
	public static String getVoucherNo(){
		return getShortNo(voucherType);
	}

}
