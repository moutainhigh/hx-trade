package com.hgxh.trade.service;

import com.hgxh.trade.param.AddLoanParam;
import com.hgxh.trade.param.LoanReplyParam;
import com.hgxh.trade.result.ResultInfo;

/**
*@ClassName: LoanService
*@Description: 
*@author YY 
*@date 2016年12月13日  下午3:28:24
*@version 1.0
*/
public interface LoanService {
	
	public ResultInfo addLoanNotice(AddLoanParam param);
	
	public ResultInfo loanReplyNotice(LoanReplyParam param);

}
