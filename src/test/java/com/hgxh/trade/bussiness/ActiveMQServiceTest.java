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

}
