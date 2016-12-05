package com.hgxh.trade.biz;

import com.hgxh.trade.param.CounterTradeParam;
import com.hgxh.trade.result.ResultInfo;

/**
*@ClassName: CounterTradeBiz
*@Description: 
*@author YY 
*@date 2016年12月5日  下午5:08:00
*@version 1.0
*/
public interface CounterTradeBiz {
	
	public ResultInfo counterTrade(CounterTradeParam param);

}
