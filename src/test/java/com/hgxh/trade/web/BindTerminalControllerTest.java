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
	
	private String  baseUrl="http://localhost:8080/bindTerminal/";
	
    @Test
    public void bindQBrush() throws Exception {
    	Map<String, String> params=new HashMap<String, String>();	
    	params.put("userId", "1");
    	params.put("terminalNo", "12321423423");
    	params.put("paramKey", "REQ_MESSAGE");
    	params.put("paramValue", "request message");
    	String result=SimpleHttpUtil.doPost(baseUrl+"bindQBrush", params);
//    	String result=HttpClient.doPost(baseUrl+"bindQBrush", JSON.toJSON(params));
    	System.out.println("*******************");
		System.out.println("**********"+result+"**********");
    }

}
