package com.hgxh.trade.remote.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hgxh.trade.enums.BaseExceptionMsg;
import com.hgxh.trade.param.InvestParam;
import com.hgxh.trade.param.WithdrawParam;
import com.hgxh.trade.remote.RuifudeRemote;
import com.hgxh.trade.result.AccountResult;
import com.hgxh.trade.result.RuiFuDeRemoteResult;
import com.hgxh.trade.result.ResultInfo;
import com.hgxh.trade.util.SimpleHttpUtil;

/**
*@ClassName: RuifudeRemoteImpl
*@Description: 
*@author YY 
*@date 2016年12月4日  下午3:37:33
*@version 1.0
*/
@Service
public class RuifudeRemoteImpl implements RuifudeRemote {
	
	@Value("${ruifude.remote.url}")
	private String ruifudeRemoteUrl;

	/**
	 * 查询卡户信息
	 */
	@Override
	public ResultInfo getAccountInfo(String idCardNo)  throws Exception {
		ResultInfo result = null;
		Map<String, String> params=new HashMap<String, String>();	
    	params.put("idCardNo", idCardNo);
    	//调用瑞福德查询开户信息接口
//    	String res = SimpleHttpUtil.doPost(ruifudeRemoteUrl+"/getAccount", params);	
    	//封装返回信息
    	AccountResult accountResult = new AccountResult();
    	//测试信息开始
    	accountResult.setMemberNo("123");
    	String res = "success";
    	//测试信息结束
    	if(StringUtils.isNotBlank(res) && StringUtils.isNotBlank(accountResult.getMemberNo())){
    		result = new ResultInfo(BaseExceptionMsg.SUCCESS,accountResult);
    	}else{
    		result = new ResultInfo(BaseExceptionMsg.ACCOUNT_NOT_EXIST);
    	}
		return result; 
	}

	/**
	 * 购买
	 */
	@Override
	public ResultInfo invest(InvestParam param) throws Exception {
		ResultInfo result = null;
		Map<String, String> params = new HashMap<String, String>();
    	params.put("memberNo", param.getMemberNo());
    	params.put("passbook", param.getPassbook());
    	params.put("productType", param.getProductType());
    	params.put("amount", param.getAmount());
    	params.put("investTime", param.getInvestTime());
    	params.put("transferSaveType", param.getTransferSaveType());
    	//调用瑞福德查询开户信息接口
//    	String res = SimpleHttpUtil.doPost(ruifudeRemoteUrl+"/save", params);	
    	//res -> RuiFuDeRemoteResult
    	RuiFuDeRemoteResult remoteResult = new RuiFuDeRemoteResult();
    	//测试信息开始
    	remoteResult.setRspCode("00");
    	remoteResult.setVoucherNo("123");
    	String res = "success";
    	//测试信息结束
    	if(StringUtils.isNotBlank(res) && "00".equals(remoteResult.getRspCode())){
    		Map<String, String> map = new HashMap<String, String>();
    		params.put("voucherNo", remoteResult.getVoucherNo());
    		result = new ResultInfo(BaseExceptionMsg.SUCCESS,map);
    	}else{
    		result = new ResultInfo(remoteResult.getRspCode(),remoteResult.getRspMsg());
    	}
		return result;
	}

	@Override
	public ResultInfo withdraw(WithdrawParam param) throws Exception {
		ResultInfo result = null;
		Map<String, String> params = new HashMap<String, String>();
    	params.put("memberNo", param.getMemberNo());
    	params.put("passbook", param.getPassbook());
    	params.put("productType", param.getProductType());
    	params.put("amount", param.getAmount());
    	params.put("voucherNo", param.getVoucherNo());
    	params.put("bankCode", param.getBankCode());
    	params.put("memberName", param.getMemberName());
    	params.put("bankCardNo", param.getBankCardNo());
    	//调用瑞福德查询开户信息接口
//    	String res = SimpleHttpUtil.doPost(ruifudeRemoteUrl+"/withdraw", params);	
    	//res -> RuiFuDeRemoteResult
    	RuiFuDeRemoteResult remoteResult = new RuiFuDeRemoteResult();
    	//测试信息开始
    	remoteResult.setRspCode("00");
    	String res = "success";
    	//测试信息结束
    	if(StringUtils.isNotBlank(res) && "00".equals(remoteResult.getRspCode())){
    		result = new ResultInfo(BaseExceptionMsg.SUCCESS);
    	}else{
    		result = new ResultInfo(remoteResult.getRspCode(),remoteResult.getRspMsg());
    	}
		return result;
	}

}
