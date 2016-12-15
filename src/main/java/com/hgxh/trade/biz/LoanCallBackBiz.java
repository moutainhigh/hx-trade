package com.hgxh.trade.biz;

import com.hgxh.trade.param.AddLoanParam;
import com.hgxh.trade.param.LoanRepayParam;
import com.hgxh.trade.result.ResultInfo;

/**
*@ClassName: LoanCallBackBiz
*@Description: 
*@author YY 
*@date 2016年12月15日  上午10:49:51
*@version 1.0
*/
public interface LoanCallBackBiz {
	
	public ResultInfo addLoanNotice(AddLoanParam param);
	
	public ResultInfo loanReplyNotice(LoanRepayParam param);

}
