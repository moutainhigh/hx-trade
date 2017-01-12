package com.hgxh.trade.biz.impl;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgxh.trade.biz.BindTerminalBiz;
import com.hgxh.trade.enums.BaseExceptionMsg;
import com.hgxh.trade.param.BindTerminalParam;
import com.hgxh.trade.remote.QBrushRemote;
import com.hgxh.trade.result.ResultInfo;
import com.hgxh.trade.util.PropertyUtils;

/**
*@ClassName: BindTerminalBizImpl
*@Description: 
*@author YY 
*@date 2016年12月5日  下午2:18:26
*@version 1.0
*/

@Service
public class BindTerminalBizImpl implements BindTerminalBiz {
	
	private static final Logger logger = LoggerFactory.getLogger(BindTerminalBizImpl.class);
	
	@Autowired
	private QBrushRemote qBrushRemote;

	/**
	 * 绑定终端校验
	 */
	@Override
	public ResultInfo bindTerminalQBrush(BindTerminalParam param) {
		//参数校验
		if(PropertyUtils.checkNull(param, "userId,terminalNo,paramKey,paramValue")){
			return new ResultInfo(BaseExceptionMsg.PARAM_IS_NULL);
		}
		ResultInfo result=null;
		try {
			result = qBrushRemote.bindTerminal(param);
		} catch (Exception e) {
			logger.error("failed in bind qBrush [param:{}] with exception:{}", param,ExceptionUtils.getStackTrace(e));
			result = new ResultInfo(BaseExceptionMsg.CALL_REMOTE_SERVICE_FAILED);
		}
		return result;
	}

	
}
