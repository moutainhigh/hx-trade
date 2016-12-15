package com.hgxh.trade.biz.impl;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgxh.trade.biz.LoanCallBackBiz;
import com.hgxh.trade.enums.BaseExceptionMsg;
import com.hgxh.trade.param.AddLoanParam;
import com.hgxh.trade.param.LoanRepayParam;
import com.hgxh.trade.result.ResultInfo;
import com.hgxh.trade.service.LoanService;
import com.hgxh.trade.util.PropertyUtils;

/**
*@ClassName: LoanCallBackBizImpl
*@Description: 
*@author YY 
*@date 2016年12月15日  上午10:50:14
*@version 1.0
*/

@Service
public class LoanCallBackBizImpl implements LoanCallBackBiz {
	
	private static final Logger logger = LoggerFactory.getLogger(LoanCallBackBizImpl.class);
	
	@Autowired
	private LoanService loanService;

	@Override
	public ResultInfo addLoanNotice(AddLoanParam param) {
		//参数校验
		if(PropertyUtils.checkNull(param, "memberNo,issueVoucherNo,repayWay,amount,yeild,beginTime,endTime")){
			return new ResultInfo(BaseExceptionMsg.PARAM_IS_NULL);
		}
		ResultInfo result=null;
		try {
			result = loanService.addLoanNotice(param);
		} catch (Exception e) {
			logger.error("failed in addLoanNotice [param:{}] with exception:{}", param,ExceptionUtils.getStackTrace(e));
			result = new ResultInfo(BaseExceptionMsg.RESULT_SAVE_FAILED);
		}
		return result;
	}

	@Override
	public ResultInfo loanReplyNotice(LoanRepayParam param) {
		//参数校验
		if(PropertyUtils.checkNull(param, "issueVoucherNo,userRepayTime")){
			return new ResultInfo(BaseExceptionMsg.PARAM_IS_NULL);
		}
		ResultInfo result=null;
		try {
			result = loanService.loanReplyNotice(param);
		} catch (Exception e) {
			logger.error("failed in loanReplyNotice [param:{}] with exception:{}", param,ExceptionUtils.getStackTrace(e));
			result = new ResultInfo(BaseExceptionMsg.RESULT_SAVE_FAILED);
		}
		return result;
	}

}
