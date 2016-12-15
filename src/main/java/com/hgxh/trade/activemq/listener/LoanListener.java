package com.hgxh.trade.activemq.listener;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.hgxh.trade.biz.LoanCallBackBiz;
import com.hgxh.trade.param.AddLoanParam;
import com.hgxh.trade.param.LoanRepayParam;
import com.hgxh.trade.result.ResultInfo;

/**
*@ClassName: LoanListener
*@Description: 
*@author YY 
*@date 2016年12月15日  上午11:00:58
*@version 1.0
*/
@Component
public class LoanListener {
	
	private static final Logger logger = LoggerFactory.getLogger(LoanListener.class);

	@Autowired
	private LoanCallBackBiz loanCallBackBiz;
	
	/**
     * 监听增加借款信息消息队列
     * @param map
     */
    @JmsListener(destination = "add-loan-queue")
    public void receiveAddLoanQueue(Map<String,String> map) {  
        System.out.println(map);
        logger.info("activemp add-loan-queue receive map: " + map);
        ResultInfo resultInfo = loanCallBackBiz.addLoanNotice(copyLoanProperties(map));
        logger.info("receiveAddLoanQueue execute result："+resultInfo);
    }
    
    /**
    * 将Map转换成param对象
    * @param map
    * @return
    */
   public AddLoanParam copyLoanProperties(Map<String,String> map){
	   AddLoanParam param = new AddLoanParam();
	   param.setMemberNo(map.get("memberNo"));
	   param.setIssueVoucherNo(map.get("issueVoucherNo"));
	   param.setRepayType(map.get("repayType"));
	   param.setRepayWay(map.get("repayWay"));
	   param.setAmount(map.get("amount"));
	   param.setYeild(map.get("yeild"));
	   param.setBeginTime(map.get("beginTime"));
	   param.setEndTime(map.get("endTime"));
	   return param;
   }
   
   /**
    * 监听借款还款消息队列
    * @param map
    */
   @JmsListener(destination = "loan-repay-queue")
   public void receiveLoanRepayQueue(Map<String,String> map) {  
       System.out.println(map);
       logger.info("activemp loan-repay-queue receive map: " + map);
       ResultInfo resultInfo = loanCallBackBiz.loanReplyNotice(copyRepayProperties(map));
       logger.info("receiveLoanRepayQueue execute result："+resultInfo);
   }
   
   /**
   * 将Map转换成param对象
   * @param map
   * @return
   */
  public LoanRepayParam copyRepayProperties(Map<String,String> map){
	   LoanRepayParam param = new LoanRepayParam();
	   param.setIssueVoucherNo(map.get("issueVoucherNo"));
	   param.setUserRepayTime(map.get("userRepayTime"));
	   param.setAheadRepay(map.get("aheadRepay"));
	   param.setOverdue(map.get("overdue"));
	   param.setOverdueDays(map.get("overdueDays"));
	   param.setDefaultAmount(map.get("defaultAmount"));
	   return param;
  }
	

}
