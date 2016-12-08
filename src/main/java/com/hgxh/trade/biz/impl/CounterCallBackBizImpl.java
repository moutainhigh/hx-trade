package com.hgxh.trade.biz.impl;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgxh.trade.biz.CounterCallBackBiz;
import com.hgxh.trade.enums.BaseExceptionMsg;
import com.hgxh.trade.param.CounterTradeParam;
import com.hgxh.trade.param.ProductParam;
import com.hgxh.trade.result.ResultInfo;
import com.hgxh.trade.service.CounterTradeService;
import com.hgxh.trade.service.UpsertProductService;
import com.hgxh.trade.util.PropertyUtils;

/**
*@ClassName: CounterCallBackBizImpl
*@Description: 
*@author YY 
*@date 2016年12月8日  上午10:26:20
*@version 1.0
*/

@Service
public class CounterCallBackBizImpl implements CounterCallBackBiz {
	
	private static final Logger logger = LoggerFactory.getLogger(CounterCallBackBizImpl.class);
	
	@Autowired
	private CounterTradeService counterTradeService;
	
	@Autowired
	private UpsertProductService upsertProductService;

	@Override
	public ResultInfo counterTrade(CounterTradeParam param) {
		//参数校验
		if(PropertyUtils.checkNull(param, "memberNo,productNo,tradeType,amount,bizNo,fundsDirection,tradeTime,productType")){
			return new ResultInfo(BaseExceptionMsg.PARAM_IS_NULL);
		}
		ResultInfo result=null;
		try {
			result = counterTradeService.saveCounterTrade(param);
		} catch (Exception e) {
			logger.error("failed in counterTrade [param:{}] with exception:{}", param,ExceptionUtils.getStackTrace(e));
			result = new ResultInfo(BaseExceptionMsg.RESULT_SAVE_FAILED);
		}
		return result;
	}

	@Override
	public ResultInfo upsertProduct(ProductParam param) {
		//参数校验
		if(PropertyUtils.checkNull(param, "productNo")){
			return new ResultInfo(BaseExceptionMsg.PARAM_IS_NULL);
		}
		ResultInfo result=null;
		try {
			result = upsertProductService.insertOrUpdateProduct(param);
		} catch (Exception e) {
			logger.error("failed in upsertProduct [param:{}] with exception:{}", param,ExceptionUtils.getStackTrace(e));
			result = new ResultInfo(BaseExceptionMsg.RESULT_SAVE_FAILED);
		}
		return result;
	}

}
