package com.hgxh.trade.web;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.hgxh.trade.util.RandomUtil;

public class AccountManageControllerTest {
	
	private String  baseUrl="http://192.168.0.59:8289/";
	
    @Test
    public void createAccount() throws Exception {
    	Map<String, String> params=new HashMap<String, String>();
    	params.put("flowId", RandomUtil.randString(10));
    	params.put("balance", new BigDecimal(10l).toString());
    	params.put("initiator", "TRADE-SERVICE");
    	params.put("providerCode", "ZHONGXIN");
    	params.put("remark", "交易系统");
//    	String result=HttpClient.doPost(baseUrl+"/account/createAccount", JSON.toJSON(params));
    	System.out.println("*******************");
//		System.out.println("*******"+result+"************");
    }
    

}
