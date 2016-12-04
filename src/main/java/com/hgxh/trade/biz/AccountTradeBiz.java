package com.hgxh.trade.biz;

import com.hgxh.trade.param.InvestParam;
import com.hgxh.trade.param.WithdrawParam;
import com.hgxh.trade.result.ResultInfo;

/**
*@ClassName: AccountTradeBiz
*@Description: 
*@author YY 
*@date 2016年12月4日  下午6:34:24
*@version 1.0
*/
public interface AccountTradeBiz {
	
	public ResultInfo getAccountInfo(String idCardNo);
	
	public ResultInfo invest(InvestParam param);
	
	public ResultInfo withdraw(WithdrawParam param);

}
