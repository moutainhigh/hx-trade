package com.hgxh.trade.biz.impl;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgxh.trade.biz.CounterTradeBiz;
import com.hgxh.trade.enums.BaseExceptionMsg;
import com.hgxh.trade.param.CounterTradeParam;
import com.hgxh.trade.result.ResultInfo;
import com.hgxh.trade.service.CounterTradeService;
import com.hgxh.trade.util.PropertyUtils;

/**
*@ClassName: CounterTradeBizImpl
*@Description: 
*@author YY 
*@date 2016年12月5日  下午5:08:20
*@version 1.0
*/
@Service
public class CounterTradeBizImpl implements CounterTradeBiz{
	
	private static final Logger logger = LoggerFactory.getLogger(CounterTradeBizImpl.class);
	
	@Autowired
	private CounterTradeService counterTradeService;

	/**
	 * 柜台交易校验
	 */
	@Override
	public ResultInfo counterTrade(CounterTradeParam param) {
		//参数校验
		if(PropertyUtils.checkNull(param, "memberNo,productNo,tradeType,amount,bizNo,fundsDirection,tradeTime,payType,bankCardNo")){
			return new ResultInfo(BaseExceptionMsg.PARAM_IS_NULL);
		}
		ResultInfo result=null;
		try {
			result = counterTradeService.saveCounterTrade(param);
		} catch (Exception e) {
			logger.error("failed in invest [param:{}] with exception:{}", param,ExceptionUtils.getStackTrace(e));
			result = new ResultInfo(BaseExceptionMsg.CALL_REMOTE_SERVICE_FAILED);
		}
		return result;
	}

}
