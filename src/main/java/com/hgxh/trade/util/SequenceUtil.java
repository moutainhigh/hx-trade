package com.hgxh.trade.util;

/**
 * @author ZQ
 * @date 2015-5-22
 * @version 1.0
 */
public class SequenceUtil {
	
	private static String requstType="R";//充值
	private static String orderType="O";//订单
	private static String accountType="A";//账户
	private static String transferType="T";//转账
	private static String logisticsType="L";//物流
	private static String productType="P";//产品
	private static String projectType="PJ";//项目
	private static String bindCardType = "BC"; //绑卡
	private static String withdrawType = "W"; //提现
	private static String buyWillingType="B";//购买意愿
	
	/**
	 * @author ZQ
	 * @date 2015-5-22
	 * @return
	 */
	public static String getRequestNo(){
		return getNo(requstType);
	}
	
	/**
	 * @author ZQ
	 * @date 2015-5-22
	 * @return
	 */
	public static String getOrderNo(){
		return getNo(orderType);
	}
	
	/**
	 * @author ZQ
	 * @date 2015-5-28
	 * @return
	 */
	public static String getAccountNo(){
		return getNo(accountType);
	}
	
	
	/**
	 * @author ZQ
	 * @date 2015-7-14
	 * @return
	 */
	public static String getTransferNo(){
		return getNo(transferType);
	}
	
	
	/**
	 * @author ZQ
	 * @date 2015-7-14
	 * @return
	 */
	public static String getLogisticsNo(){
		return getNo(logisticsType);
	}
	
	/**
	 * @author ZQ
	 * @date 2015-5-22
	 * @param type
	 * @return
	 */
	private static String getNo(String type){
		return type+DateUtil.getDateSequence()+NumberUtil.getRandomNo(Constants.SIX);
	}
	
	
	/**
	 * @author ZQ
	 * @date 2016-2-19
	 * @return
	 */
	public static String getProudctNo(){
		return getNo(productType);
	}
	
	/**
	 * @author ZQ
	 * @date 2016-2-22
	 * @return
	 */
	public static String getPrjedctNo(){
		return getNo(projectType);
	}

	public static String getBindCardNo(){
		return getNo(bindCardType);
	}
	
	public static String getWithdrawNo(){
		return getNo(withdrawType);
	}
	
	public static String getBuyWillingTransNo(){
		return getNo(buyWillingType);
	}
}
