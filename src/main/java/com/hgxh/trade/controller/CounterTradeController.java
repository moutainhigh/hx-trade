package com.hgxh.trade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hgxh.trade.biz.CounterTradeBiz;
import com.hgxh.trade.enums.BaseExceptionMsg;
import com.hgxh.trade.param.CounterTradeParam;
import com.hgxh.trade.result.ResultInfo;

/**
*@ClassName: CounterTradeController
*@Description: 
*@author YY 
*@date 2016年12月5日  下午4:51:16
*@version 1.0
*/

@RestController
@RequestMapping("/counterTrade")
public class CounterTradeController extends BaseController {
	
	@Autowired
	private CounterTradeBiz counterTradeBiz;

	/**
	 * 保存柜台交易
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/counterTrade")
	public ResultInfo counterTrade(CounterTradeParam param){
		logger.info("保存柜台交易入参 :"+param);
 		ResultInfo result = new ResultInfo();
 		try {
 			result = counterTradeBiz.counterTrade(param);
 		}catch (Exception e){
 			logger.error("counterTrade Exception：",e);
 			result.setResult(BaseExceptionMsg.UNKNOW_ERROR);
 		}
 		return result;
	}
	
}
