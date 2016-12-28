package com.hgxh.trade.web;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.hgxh.trade.util.HttpClient;
import com.hgxh.trade.util.SimpleHttpUtil;

/**
*@ClassName: BindTerminalControllerTest
*@Description: 
*@author YY 
*@date 2016年12月5日  下午2:28:21
*@version 1.0
*/
public class BindTerminalControllerTest {
	
//	private String  baseUrl="http://59.151.121.92:8080/bindTerminal/";
	private String  baseUrl="http://localhost:8080/bindTerminal/";
	
    @Test
    public void bindQBrush() throws Exception {
    	Map<String, String> params=new HashMap<String, String>();	
    	params.put("userId", "15210158919");
    	params.put("terminalNo", "80110400130615");
    	params.put("paramKey", "REQ_MESSAGE");
    	params.put("paramValue", "{\'ip\':\'fe80::76cf:1b38:e2c7:f289\',\'REQ_BODY\':{\'termNo\':\'80110400130615\',\'appVersion\':\'1.0.1\',\'custId\':\'1000158270\',\'sysTerNo\':\'E169B60D-2215-499B-94BC-7BB3A3556104\',\'MODEL\':\'iPhone8,1\',\'custMobile\':\'18500330325\',\'sysVersion\':\'10.1.1\',\'txnDate\':\'161228\',\'txnTime\':\'101721\',\'sysType\':\'IOS\'},\'REQ_HEAD\':{\'SIGN\':\'23deed852d80c118b6dd68413ff4a37f\'}}'}");
    	String result=SimpleHttpUtil.doPost(baseUrl+"bindQBrush", params);
//    	String result=HttpClient.doPost(baseUrl+"bindQBrush", JSON.toJSON(params));
    	System.out.println("*******************");
		System.out.println("**********"+result+"**********");
    }

}
