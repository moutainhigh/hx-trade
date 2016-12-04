package com.hgxh.trade.remote;

import com.hgxh.trade.param.InvestParam;
import com.hgxh.trade.param.WithdrawParam;
import com.hgxh.trade.result.ResultInfo;

/**
*@ClassName: RuifudeRemote
*@Description: 
*@author YY 
*@date 2016年12月4日  下午3:36:37
*@version 1.0
*/
public interface RuifudeRemote {
	
	public ResultInfo getAccountInfo(String idCardNo) throws Exception;
	
	public ResultInfo invest(InvestParam param) throws Exception;
	
	public ResultInfo withdraw(WithdrawParam param) throws Exception;

}
