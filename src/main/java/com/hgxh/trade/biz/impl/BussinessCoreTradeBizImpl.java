package com.hgxh.trade.biz.impl;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgxh.trade.biz.BussinessCoreTradeBiz;
import com.hgxh.trade.enums.BaseExceptionMsg;
import com.hgxh.trade.param.BussinessFundParam;
import com.hgxh.trade.result.ResultInfo;
import com.hgxh.trade.service.BussinessCoreTradeService;
import com.hgxh.trade.util.PropertyUtils;

/**
*@ClassName: BussinessCoreTradeBizImpl
*@Description: 
*@author YY 
*@date 2016年11月11日  下午4:12:29
*@version 1.0
*/

@Service
public class BussinessCoreTradeBizImpl implements BussinessCoreTradeBiz {
	
	private static final Logger logger = LoggerFactory.getLogger(BussinessCoreTradeBizImpl.class);
	
	@Autowired
	private BussinessCoreTradeService coreTradeService;

	/**
	 * 原始购买
	 * @param bussinessFundParam
	 * @return
	 */
	@Override
	public ResultInfo invest(BussinessFundParam bussinessFundParam) {
		//参数校验
		if(PropertyUtils.checkNull(bussinessFundParam, "userId,bidNo,share,tradeType")){
			return new ResultInfo(BaseExceptionMsg.PARAM_IS_NULL);
		}
		ResultInfo result=null;
		try {
			//投资
			result = coreTradeService.invset(bussinessFundParam);
		} catch (Exception e) {
			logger.error("failed in invest [bussinessFundParam:{}] with exception:{}", bussinessFundParam,ExceptionUtils.getStackTrace(e));
			result = new ResultInfo(BaseExceptionMsg.INVEST_EXCEPTION);
		}
		return result;
	}

}
