package com.hgxh.trade.service;

import com.hgxh.trade.param.CounterTradeParam;
import com.hgxh.trade.result.ResultInfo;

/**
*@ClassName: CounterTradeService
*@Description: 
*@author YY 
*@date 2016年12月5日  下午6:33:35
*@version 1.0
*/
public interface CounterTradeService {
	
	ResultInfo saveCounterTrade(CounterTradeParam param);

}
