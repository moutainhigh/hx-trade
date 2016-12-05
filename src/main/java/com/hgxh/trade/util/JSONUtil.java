package com.hgxh.trade.util;

import java.util.List;

import com.hgxh.trade.result.QBrushRemoteResult;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
* @ClassName: JSONUtils
* @Description: JSON工具类
* @author JA
* @date 2016-1-8 下午12:43:14
*/
public class JSONUtil
{


	/***
	* 将json字符串转换为java对象
	*/
	@SuppressWarnings("static-access")
	public static <T> Object JSONToObject(String jsonStr, Object object){
		JSONObject json = new JSONObject().fromObject(jsonStr);
		Object obj = JSONObject.toBean(json, object.getClass());
		return obj;
	}
	
	
	/***
	* 将List对象序列化为JSON文本
	*/
	public static <T> String toJSONString(List<T> list){
		JSONArray jsonArray = JSONArray.fromObject(list); 
		return jsonArray.toString();
	}

	/***
	* 将对象序列化为JSON文本
	* @param object
	* @return
	*/
	public static String toJSONString(Object object){
		JSONArray jsonArray = JSONArray.fromObject(object); 
		return jsonArray.toString();
	} 

	/***
	* 将JSON对象数组序列化为JSON文本
	* @param jsonArray
	* @return
	*/
	public static String toJSONString(JSONArray jsonArray){
		return jsonArray.toString();
	} 

	/***
	* 将JSON对象序列化为JSON文本
	* @param jsonObject
	* @return
	*/
	public static String toJSONString(JSONObject jsonObject){
		return jsonObject.toString();
	} 

	/***
	* 将对象转换为JSON对象数组
	* @param object
	* @return
	*/
	public static JSONArray toJSONArray(Object object){
		return JSONArray.fromObject(object);
	} 

	/***
	* 将对象转换为JSON对象
	* @param object
	* @return
	*/
	public static JSONObject toJSONObject(Object object){
		return JSONObject.fromObject(object);
	}
	
	public static void main(String[] args) {
		String res = "{'REP_HEAD':{'SIGN':'0ff505d911df1af5982bfba45ff066b7'},'REP_BODY':{'balance':'null','RSPMSG':'null','RSPCOD':'null'}}";	
//		QBrushRemoteResult remoteResult = new QBrushRemoteResult();
//    	remoteResult = (QBrushRemoteResult) JSONUtil.JSONToObject(res, remoteResult);
//    	System.out.println(remoteResult.getREP_BODY().toString());
//    	String json = "{balance='null', RSPCOD='mps-30007', RSPMSG='无效卡号，请重试'}";
//    	remoteResult = (QBrushRemoteResult) JSONUtil.JSONToObject(remoteResult.getREP_BODY().toString(), remoteResult);

		QBrushRemoteResult remoteResult = new QBrushRemoteResult();
    	remoteResult = (QBrushRemoteResult) JSONUtil.JSONToObject(res, remoteResult);
    	System.out.println(remoteResult.getREP_BODY().toString());
	}

} 

