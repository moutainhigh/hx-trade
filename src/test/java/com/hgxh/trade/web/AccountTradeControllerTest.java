package com.hgxh.trade.web;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.hgxh.trade.util.SimpleHttpUtil;

/**
*@ClassName: AccountTradeControllerTest
*@Description: 
*@author YY 
*@date 2016年12月4日  下午6:32:50
*@version 1.0
*/
public class AccountTradeControllerTest {
	
	private String  baseUrl="http://localhost:8080/accountTrade/";
	
    @Test
    public void getAccountInfo() throws Exception {
    	Map<String, String> params=new HashMap<String, String>();	
    	params.put("idCardNo", "340123199412121133");
    	String result=SimpleHttpUtil.doPost(baseUrl+"getAccountInfo", params);
    	System.out.println("*******************");
		System.out.println("**********"+result+"**********");
    }
    
    @Test
    public void invest() throws Exception {
    	Map<String, String> params=new HashMap<String, String>();	
    	params.put("memberNo", "SY2017011602000496");
    	params.put("passbook", "5802888800000018");
    	params.put("productNo", "13");
    	params.put("yield", "2.1");
    	params.put("amount", "10000.00");
    	params.put("productType", "FIXED");
    	params.put("investTime", "1484126606315");
    	params.put("transferSaveType", "INTERESTTRANS");
    	String result=SimpleHttpUtil.doPost(baseUrl+"invest", params);
    	System.out.println("*******************");
		System.out.println("**********"+result+"**********");
    }
    
    @Test
    public void withdraw() throws Exception {
    	Map<String, String> params=new HashMap<String, String>();	
    	params.put("productType", "FIXED");
    	params.put("amount", "100");
    	params.put("bizNo", "5802666600000005");
    	params.put("password", "d41d8cd98f00b204e9800998ecf8427e");
    	String result=SimpleHttpUtil.doPost(baseUrl+"withdraw", params);
    	System.out.println("*******************");
		System.out.println("**********"+result+"**********");
    }
    

}
