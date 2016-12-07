package com.hgxh.trade.bussiness;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hgxh.trade.param.CounterTradeParam;
import com.hgxh.trade.result.ResultInfo;
import com.hgxh.trade.service.CounterTradeService;

/**
*@ClassName: ProductInformationsDaoTest
*@Description: 
*@author YY 
*@date 2016年12月4日  下午11:14:48
*@version 1.0
*/

@RunWith(SpringRunner.class)
@SpringBootTest
public class CounterTradeServiceTest {
	
	@Autowired
	private CounterTradeService counterTradeService;
	
	@Test
	public void saveCounterTrade(){
		CounterTradeParam param = new CounterTradeParam();
		param.setAmount("1000");
		param.setBizNo("63495044533431301");
		param.setFundsDirection("INCR");
		param.setMemberNo("HS10002");
		param.setPayType("EBANK");
		param.setProductNo("FIXED-3-1");
		param.setTradeTime("20161206153445");
		param.setTradeType("PURCHASE");
		param.setTransferSavaType("INTERESTTRANS");
		param.setProductType("FIXED");
		ResultInfo resultInfo = counterTradeService.saveCounterTrade(param);
		System.out.println(resultInfo);
	}

}
