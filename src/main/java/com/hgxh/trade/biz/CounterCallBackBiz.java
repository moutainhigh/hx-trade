package com.hgxh.trade.biz;

import com.hgxh.trade.param.CounterTradeParam;
import com.hgxh.trade.param.ProductParam;
import com.hgxh.trade.result.ResultInfo;

/**
*@ClassName: CounterCallBackBiz
*@Description: 
*@author YY 
*@date 2016年12月8日  上午10:26:00
*@version 1.0
*/
public interface CounterCallBackBiz {
	
	public ResultInfo counterTrade(CounterTradeParam param);
	
	public ResultInfo upsertProduct(ProductParam param);

}
