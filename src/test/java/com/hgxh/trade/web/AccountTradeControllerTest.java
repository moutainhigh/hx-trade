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
    	params.put("idCardNo", "6201104598039428");
    	String result=SimpleHttpUtil.doPost(baseUrl+"getAccountInfo", params);
    	System.out.println("*******************");
		System.out.println("**********"+result+"**********");
    }
    
    @Test
    public void invest() throws Exception {
    	Map<String, String> params=new HashMap<String, String>();	
    	params.put("memberNo", "HS10002");
    	params.put("passbook", "6201104598039428");
    	params.put("productNo", "FIXED-3-1");
    	params.put("amount", "1000");
    	params.put("investTime", "1481014349000");
    	params.put("transferSaveType", "INTERESTTRANS");
    	String result=SimpleHttpUtil.doPost(baseUrl+"invest", params);
    	System.out.println("*******************");
		System.out.println("**********"+result+"**********");
    }
    
    @Test
    public void withdraw() throws Exception {
    	Map<String, String> params=new HashMap<String, String>();	
    	params.put("memberNo", "2131232");
    	params.put("passbook", "2131232");
    	params.put("productType", "2131232");
    	params.put("amount", "2131232");
    	params.put("voucherNo", "2131232");
    	params.put("bankCode", "2131232");
    	params.put("memberName", "2131232");
    	params.put("bankCardNo", "2131232");
    	String result=SimpleHttpUtil.doPost(baseUrl+"withdraw", params);
    	System.out.println("*******************");
		System.out.println("**********"+result+"**********");
    }
    

}
