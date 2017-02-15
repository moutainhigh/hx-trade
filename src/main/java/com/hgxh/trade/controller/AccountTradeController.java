package com.hgxh.trade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hgxh.trade.biz.AccountTradeBiz;
import com.hgxh.trade.enums.BaseExceptionMsg;
import com.hgxh.trade.param.InvestParam;
import com.hgxh.trade.param.WithdrawParam;
import com.hgxh.trade.result.ResultInfo;

/**
*@ClassName: AccountTradeController
*@Description: 
*@author YY 
*@date 2016年12月4日  下午4:40:13
*@version 1.0
*/

@RestController
@RequestMapping("/accountTrade")
public class AccountTradeController extends BaseController {
	
	@Autowired
	private AccountTradeBiz accountTradeBiz;
	
	/**
	 * 获取用户开户信息
	 * @param idCardNo
	 * @return
	 */
	@RequestMapping(value = "/getAccountInfo")
	public ResultInfo getAccountInfo(String idCardNo){
		logger.info("获取用户开户信息入参 idCardNo:"+idCardNo);
 		ResultInfo result = new ResultInfo();
 		try {
 			result = accountTradeBiz.getAccountInfo(idCardNo);
 		}catch (Exception e){
 			logger.error("getAccountInfo Exception：",e);
 			result.setResult(BaseExceptionMsg.UNKNOW_ERROR);
 		}
 		return result;
	}
	
	/**
	 * 购买
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/invest")
	public ResultInfo invest(InvestParam param){
		logger.info("购买入参 :"+param);
 		ResultInfo result = new ResultInfo();
 		try {
 			result = accountTradeBiz.invest(param);
 		}catch (Exception e){
 			logger.error("invest Exception：",e);
 		}
 		return result;
	}
	
	/**
	 * 提现
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/withdraw")
	public ResultInfo withdraw(WithdrawParam param){
		logger.info("提现入参 :"+param);
 		ResultInfo result = new ResultInfo();
 		try {
 			result = accountTradeBiz.withdraw(param);
 		}catch (Exception e){
 			logger.error("withdraw Exception：",e);
 			result.setResult(BaseExceptionMsg.UNKNOW_ERROR);
 		}
 		return result;
	}

}
