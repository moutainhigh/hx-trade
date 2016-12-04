package com.hgxh.trade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hgxh.trade.biz.BussinessCoreTradeBiz;
import com.hgxh.trade.enums.BaseExceptionMsg;
import com.hgxh.trade.param.BussinessFundParam;
import com.hgxh.trade.result.ResultInfo;

/**
*@ClassName: BussinessCoreTradeController
*@Description: 
*@author YY 
*@date 2016年11月11日  下午4:05:42
*@version 1.0
*/

@RestController
@RequestMapping("/coreTrade")
public class BussinessCoreTradeController extends BaseController{
	
	@Autowired
	private BussinessCoreTradeBiz bussinessCoreTradeBiz;
	
	/**
	 * 原始购买
	 * @param bussinessFundParam
	 * @return
	 */
	@RequestMapping(value = "/invest")
	public ResultInfo invest(BussinessFundParam bussinessFundParam){
		logger.info("原始购买入参:"+bussinessFundParam);
 		ResultInfo result = new ResultInfo();
 		try {
 			result = bussinessCoreTradeBiz.invest(bussinessFundParam);
 		}catch (Exception e){
 			logger.error("Exception：",e);
 			result.setResult(BaseExceptionMsg.NUKNOW_ERROR);
 		}
 		return result;
	}
	
}
