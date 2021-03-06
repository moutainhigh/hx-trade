package com.hgxh.trade.bussiness;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hgxh.trade.param.AddLoanParam;
import com.hgxh.trade.param.LoanRepayParam;
import com.hgxh.trade.result.ResultInfo;
import com.hgxh.trade.service.LoanService;

/**
*@ClassName: LoanServiceTest
*@Description: 
*@author YY 
*@date 2016年12月14日  下午2:33:12
*@version 1.0
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoanServiceTest {
	
	@Autowired
	LoanService loanService;
	
	@Test
	public void addLoan(){
		AddLoanParam param = new AddLoanParam();
		param.setIssueVoucherNo("3223423879");
		param.setAmount("100000");
		param.setBeginTime("1476288000000");
		param.setEndTime("1489334400000");
		param.setMemberNo("HS138968");
		param.setRepayType("MONTH");
		param.setRepayWay("AVERAGEINTEREST");
		param.setYield("2.23");
		param.setPenaltyYield("0.02");
		param.setPutinTime("1476288000000");
		ResultInfo resultInfo = loanService.addLoanNotice(param);
		System.out.println(resultInfo);
		
//		AddLoanParam param = new AddLoanParam();
//		param.setIssueVoucherNo("32234238791");
//		param.setAmount("100000");
//		param.setBeginTime("1480608000000");
//		param.setEndTime("1485964800000");
////		param.setBeginTime("1482508800000");
////		param.setEndTime("1487865600000");
////		param.setBeginTime("1482163200000");
////		param.setEndTime("1487520000000");
//		param.setMemberNo("HS138968");
//		param.setRepayType("MONTH");
//		param.setRepayWay("DISPOSABLE");
//		param.setYield("2.23");
//		ResultInfo resultInfo = loanService.addLoanNotice(param);
//		System.out.println(resultInfo);
	}
	
	@Test
	public void loanRepayNotice(){
		LoanRepayParam param = new LoanRepayParam();
		param.setIssueVoucherNo("3223423879");
		param.setUserRepayTime("1481558400000");
		param.setOverdueDays("0");
		param.setDefaultAmount("0");
		param.setSettleRepayTime("1481558400000");
		param.setAheadRepayAmount("0");
		ResultInfo resultInfo = loanService.loanReplyNotice(param);
		System.out.println(resultInfo);
	}

}
