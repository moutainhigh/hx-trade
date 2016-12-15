package com.hgxh.trade.bussiness;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hgxh.trade.service.AcitveMqService;

/**
*@ClassName: ActiveMQServiceTest
*@Description: 
*@author YY 
*@date 2016年12月8日  下午3:32:57
*@version 1.0
*/

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActiveMQServiceTest {
	
	@Autowired
	private AcitveMqService mqService;
	
	/**
	 * 线下柜台交易发送通知测试
	 */
	@Test
	public void sendCounterTradeQueue(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("amount", "1000");
		map.put("bizNo", "63495044533431302");
		map.put("memberNo", "HS10002");
		map.put("fundsDirection", "INCR");
		map.put("payType", "EBANK");
		map.put("productNo", "FIXED-3-1");
		map.put("tradeTime", "1481163841645");
		map.put("tradeType", "PURCHASE");
		map.put("transferSavaType", "INTERESTTRANS");
		map.put("productType", "FIXED");
		mqService.sendCounterTradeQueue(map);
	}
	
	/**
	 * 增加更新产品发送通知测试
	 */
	@Test
	public void sendUpsertProductQueue(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("productNo", "FIXED-6-2");
		map.put("productName", "定期六个月测试2");
		map.put("productType", "FIXED");
		map.put("cycle", "182");
		map.put("yield", "4.24");
		map.put("withdrawCount", "2");
		map.put("briefIntroduction", "定期六个月测试2");
		map.put("introduction", "定期六个月测试2");
		map.put("createTime", "1481162129000");
		mqService.sendUpsertProductQueue(map);
	}
	
	/**
	 * 增加借款发送通知测试
	 */
	@Test
	public void sendAddLoanQueue(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("issueVoucherNo", "3223423879");
		map.put("amount", "100000");
		map.put("beginTime","1476288000000");
		map.put("endTime","1489334400000");
		map.put("memberNo","HS138968");
		map.put("repayType","MONTH");
		map.put("repayWay","AVERAGEINTEREST");
		map.put("yeild","2.23");
		mqService.sendAddLoanQueue(map);
	}
	
	/**
	 * 借款还款发送通知测试
	 */
	@Test
	public void sendLoanRepayQueuee(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("issueVoucherNo", "3223423879");
		map.put("userRepayTime", "1478966400000");
		map.put("capital", "20000");
		map.put("interest", "183.2");
		map.put("aheadRepay", "NO");
		map.put("overdue", "NO");
		map.put("overdueDays", "0");
		map.put("defaultAmount", "0");
		mqService.sendLoanRepayQueue(map);
	}

}
