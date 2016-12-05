package com.hgxh.trade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hgxh.trade.biz.BindTerminalBiz;
import com.hgxh.trade.enums.BaseExceptionMsg;
import com.hgxh.trade.param.BindTerminalParam;
import com.hgxh.trade.result.ResultInfo;

/**
*@ClassName: BindTerminalController
*@Description: 
*@author YY 
*@date 2016年12月5日  下午2:23:48
*@version 1.0
*/

@RestController
@RequestMapping("/bindTerminal")
public class BindTerminalController extends BaseController {
	
	@Autowired
	private BindTerminalBiz bindTerminalBiz;
	
	/**
	 * 绑定Q刷
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/bindQBrush")
	public ResultInfo bindQBrush(BindTerminalParam param){
		logger.info("绑定Q刷入参 :"+param);
 		ResultInfo result = new ResultInfo();
 		try {
 			result = bindTerminalBiz.bindTerminalQBrush(param);
 		}catch (Exception e){
 			logger.error("bindQBrush Exception：",e);
 			result.setResult(BaseExceptionMsg.UNKNOW_ERROR);
 		}
 		return result;
	}

}
