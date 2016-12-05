package com.hgxh.trade.biz.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgxh.trade.biz.AccountTradeBiz;
import com.hgxh.trade.enums.BaseExceptionMsg;
import com.hgxh.trade.param.InvestParam;
import com.hgxh.trade.param.WithdrawParam;
import com.hgxh.trade.remote.RuifudeRemote;
import com.hgxh.trade.result.ResultInfo;
import com.hgxh.trade.util.PropertyUtils;

/**
*@ClassName: AccountTradeBizImpl
*@Description: 
*@author YY 
*@date 2016年12月4日  下午6:34:59
*@version 1.0
*/

@Service
public class AccountTradeBizImpl implements AccountTradeBiz {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountTradeBizImpl.class);
	
	@Autowired
	private RuifudeRemote ruifudeRemote;

	/**
	 * 获取账户信息校验
	 * @param param
	 * @return
	 */
	@Override
	public ResultInfo getAccountInfo(String idCardNo) {
		if(StringUtils.isBlank(idCardNo)){
			return new ResultInfo(BaseExceptionMsg.PARAM_IS_NULL);
		}
		ResultInfo result=null;
		try {
			result = ruifudeRemote.getAccountInfo(idCardNo);
		} catch (Exception e) {
			logger.error("failed in getAccountInfo [idCardNo:{}] with exception:{}", idCardNo,ExceptionUtils.getStackTrace(e));
			result = new ResultInfo(BaseExceptionMsg.INVEST_EXCEPTION);
		}
		return result;
	}

	/**
	 * 购买校验
	 * @param param
	 * @return
	 */
	@Override
	public ResultInfo invest(InvestParam param) {
		//参数校验
		if(PropertyUtils.checkNull(param, "memberNo,passbook,productType,amount,investTime,transferSaveType")){
			return new ResultInfo(BaseExceptionMsg.PARAM_IS_NULL);
		}
		ResultInfo result=null;
		try {
			result = ruifudeRemote.invest(param);
		} catch (Exception e) {
			logger.error("failed in invest [param:{}] with exception:{}", param,ExceptionUtils.getStackTrace(e));
			result = new ResultInfo(BaseExceptionMsg.INVEST_EXCEPTION);
		}
		return result;
	}

	/**
	 * 提现校验
	 * @param param
	 * @return
	 */
	@Override
	public ResultInfo withdraw(WithdrawParam param) {
		//参数校验
		if(PropertyUtils.checkNull(param, "memberNo,passbook,productType,amount,voucherNo,bankCode,memberName,bankCardNo")){
			return new ResultInfo(BaseExceptionMsg.PARAM_IS_NULL);
		}
		ResultInfo result=null;
		try {
			result = ruifudeRemote.withdraw(param);
		} catch (Exception e) {
			logger.error("failed in withdraw [param:{}] with exception:{}", param,ExceptionUtils.getStackTrace(e));
			result = new ResultInfo(BaseExceptionMsg.INVEST_EXCEPTION);
		}
		return result;
	}

}
