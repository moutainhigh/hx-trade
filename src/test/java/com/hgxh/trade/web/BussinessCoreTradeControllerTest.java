package com.hgxh.trade.web;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.hgxh.trade.util.SimpleHttpUtil;

/**
*@ClassName: BussinessCoreTradeControllerTest
*@Description: 
*@author YY 
*@date 2016年11月22日  上午10:03:34
*@version 1.0
*/
public class BussinessCoreTradeControllerTest {

	private String  baseUrl="http://localhost:8286/coreTrade/";
	
    @Test
    public void invest() throws Exception {
    	Map<String, String> params=new HashMap<String, String>();	
    	params.put("bidNo", "INVEST_TEST_1");
    	params.put("userId", "79240");
    	params.put("share", "100");
    	params.put("tradeType", "INVEST");
    	String result=SimpleHttpUtil.doPost(baseUrl+"invest", params);
    	System.out.println("*******************");
		System.out.println("**********"+result+"**********");
    }
    
}
