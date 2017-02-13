package com.hgxh.trade.bussiness;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hgxh.trade.biz.CounterCallBackBiz;
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
	@Autowired
	private CounterCallBackBiz counterCallBackBiz;
	
	@Test
	public void saveCounterTrade(){
		CounterTradeParam param = new CounterTradeParam();
		param.setAmount("1000");
		param.setBizNo("63495044533431301");
		param.setFundsDirection("INCR");
		param.setMemberNo("HS10002");
		param.setPayType("EBANK");
		param.setProductNo("2");
		param.setTradeTime("1486974386000");
		param.setTradeType("PURCHASE");
		param.setTransferSavaType("INTERESTTRANS");
		param.setProductType("FIXED");
		param.setExpirationTime("1494604800000");
		ResultInfo resultInfo = counterTradeService.saveCounterTrade(param);
		System.out.println(resultInfo);
	}
	
	@Test
	public void counterTradeBiz(){
		CounterTradeParam param = new CounterTradeParam();
		param.setTradeType("INTERESTTRANS");
		param.setBizNo("8803666600000886");
//		param.setOrgiVoucherNo("8803666600000886");
		param.setAmount("1100");
		param.setFundsDirection("INCR");
		param.setMemberNo("HS274460");
		param.setPayType("EBANK");
		param.setProductNo("2");
		param.setTradeTime("1486974386000");
		param.setTransferSavaType("INTERESTTRANS");
		param.setProductType("FIXED");
		param.setExpirationTime("1494604800000");
		ResultInfo resultInfo = counterCallBackBiz.counterTrade(param);
		System.out.println("counterTradeBiz Result: "+resultInfo);
	}

}
