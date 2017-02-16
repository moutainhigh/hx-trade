package com.hgxh.trade.web;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

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
    	params.put("userId", "15210158919");
    	params.put("terminalNo", "81505060029205");
    	params.put("paramKey", "REQ_MESSAGE");
    	params.put("paramValue", "{\"ip\":\"fe80::38b7:ea92:6f3:f2db\",\"REQ_BODY\":{\"termNo\":\"81505060029205\",\"appVersion\":\"1.0.1\",\"custId\":\"1000131727\",\"sysTerNo\":\"E169B60D-2215-499B-94BC-7BB3A3556104\",\"MODEL\":\"iPhone8,1\",\"custMobile\":\"13261855286\",\"sysVersion\":\"10.1.1\",\"txnDate\":\"170104\",\"txnTime\":\"142924\",\"sysType\":\"IOS\"},\"REQ_HEAD\":{\"SIGN\":\"2acbddb0a7e82cb30a25be8759390c4c\"}}");
    	String result=SimpleHttpUtil.doPost(baseUrl+"bindQBrush", params);
//    	String result=HttpClient.doPost(baseUrl+"bindQBrush", JSON.toJSON(params));
    	System.out.println("*******************");
		System.out.println("**********"+result+"**********");
    }
    
}
