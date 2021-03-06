package com.hgxh.trade.remote.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hgxh.trade.dao.PurchaseFailDao;
import com.hgxh.trade.entity.PurchaseFailEntity;
import com.hgxh.trade.enums.BaseExceptionMsg;
import com.hgxh.trade.param.InvestParam;
import com.hgxh.trade.param.WithdrawParam;
import com.hgxh.trade.remote.RuifudeRemote;
import com.hgxh.trade.result.AccountResult;
import com.hgxh.trade.result.InvestResult;
import com.hgxh.trade.result.RuifudeRemoteResult;
import com.hgxh.trade.result.ResultInfo;
import com.hgxh.trade.result.RuifudeRemoteListResult;
import com.hgxh.trade.util.Constants;
import com.hgxh.trade.util.DateUtil;
import com.hgxh.trade.util.JSONUtil;
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
	
	private static final Logger logger = LoggerFactory.getLogger(RuifudeRemoteImpl.class);
	
	@Value("${ruifude.remote.url}")
	private String ruifudeRemoteUrl;
	@Autowired
	private PurchaseFailDao purchaseFailDao;
	
	/**
	 * 查询开户信息
	 */
	@Override
	public ResultInfo getAccountInfo(String idCardNo) throws Exception{
		ResultInfo result = null;
		Map<String, String> params=new HashMap<String, String>();	
    	params.put("idCardNo", idCardNo);
    	//调用瑞福德查询开户信息接口
    	logger.info("调用瑞福德查询开户信息接口传入参数 :"+params);
    	String res = SimpleHttpUtil.doPostGb(ruifudeRemoteUrl+"bankInfo", params);
    	logger.info("调用瑞福德查询开户信息接口返回结果 :"+res);
    	//封装返回信息
    	RuifudeRemoteListResult<AccountResult> remoteResult = new RuifudeRemoteListResult<AccountResult>();
		remoteResult =  (RuifudeRemoteListResult<AccountResult>) JSONUtil.JSONToObject(res, remoteResult);
		String jsonString = JSONUtil.toJSONString(remoteResult.getData());
    	if(Constants.SUCCEED.equals(remoteResult.getRspCode())){
    		result = new ResultInfo(BaseExceptionMsg.SUCCESS,jsonString);
    	}else{
    		result = new ResultInfo(remoteResult.getRspCode(),remoteResult.getRspMsg());
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
    	params.put("productNo", param.getProductNo());
    	params.put("yield", param.getYield());
    	params.put("productType", param.getProductType());
    	params.put("amount", param.getAmount());
    	params.put("investTime", param.getInvestTime());
    	params.put("transferSaveType", param.getTransferSaveType());
    	if(StringUtils.isNotBlank(param.getPassword())){
    		params.put("password", param.getPassword());
    	}
    	if(StringUtils.isNotBlank(param.getExpirationTime())){
    		params.put("expirationTime", param.getExpirationTime());	
    	}
    	//调用瑞福德购买接口
    	logger.info("调用瑞福德购买接口传入参数 :"+params);
    	String res = SimpleHttpUtil.doPostGb(ruifudeRemoteUrl+"buyProduct", params);
    	logger.info("调用瑞福德购买接口返回结果 :"+res);
    	//封装返回信息
    	RuifudeRemoteListResult<InvestResult> remoteResult = new RuifudeRemoteListResult<InvestResult>();
		remoteResult =  (RuifudeRemoteListResult<InvestResult>) JSONUtil.JSONToObject(res, remoteResult);
		String jsonString = JSONUtil.toJSONString(remoteResult.getData());
    	if(Constants.SUCCEED.equals(remoteResult.getRspCode())){
    		result = new ResultInfo(BaseExceptionMsg.SUCCESS,jsonString);
    	}else{
    		result = new ResultInfo(remoteResult.getRspCode(),remoteResult.getRspMsg());
    		//保存错误信息
    		PurchaseFailEntity entity = copyProperies(param);
    		entity.setRspCode(remoteResult.getRspCode());
    		entity.setRspMsg(remoteResult.getRspMsg());
    		purchaseFailDao.insertSelective(entity);
    	}
		return result;
	}
	
	/**
	 * 复制参数
	 * @param param
	 */
	private PurchaseFailEntity copyProperies(InvestParam param){
		PurchaseFailEntity entity = new PurchaseFailEntity();
		BeanUtils.copyProperties(param, entity);
		entity.setOrderTime(Long.parseLong(param.getInvestTime()));
		entity.setAmount(new BigDecimal(param.getAmount()));
		entity.setYield(new BigDecimal(param.getYield()));
		entity.setCreateTime(DateUtil.getLastModifyTime());
		return entity;
	}

	/**
	 * 提现
	 */
	@Override
	public ResultInfo withdraw(WithdrawParam param) throws Exception {
		ResultInfo result = null;
		Map<String, String> params = new HashMap<String, String>();
    	params.put("memberNo", param.getMemberNo());
    	params.put("bizNo", param.getBizNo());
    	params.put("productNo", param.getProductNo());
    	params.put("productType", param.getProductType());
    	params.put("amount", param.getAmount());
    	params.put("bankCode", param.getBankCode());
    	params.put("memberName", param.getMemberName());
    	params.put("bankCardNo", param.getBankCardNo());
    	params.put("password", param.getPassword());
    	//调用瑞福德购买接口
    	logger.info("调用瑞福德提现接口传入参数 :"+params);
    	String res = SimpleHttpUtil.doPostGb(ruifudeRemoteUrl+"drawMoney", params);
    	logger.info("调用瑞福德提现接口返回结果 :"+res);
    	//封装返回信息
    	RuifudeRemoteResult remoteResult = new RuifudeRemoteResult();
		remoteResult =   (RuifudeRemoteResult) JSONUtil.JSONToObject(res, remoteResult);
		if(Constants.SUCCEED.equals(remoteResult.getRspCode())){
    		result = new ResultInfo(BaseExceptionMsg.SUCCESS);
    	}else{
    		result = new ResultInfo(remoteResult.getRspCode(),remoteResult.getRspMsg());
    	}
		return result;
	}

}
