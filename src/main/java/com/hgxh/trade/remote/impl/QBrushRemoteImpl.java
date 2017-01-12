package com.hgxh.trade.remote.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hgxh.trade.dao.UserTerminalInformationsDao;
import com.hgxh.trade.entity.UserTerminalInformationsEntity;
import com.hgxh.trade.enums.BaseExceptionMsg;
import com.hgxh.trade.enums.TerminalTypeEnum;
import com.hgxh.trade.param.BindTerminalParam;
import com.hgxh.trade.remote.QBrushRemote;
import com.hgxh.trade.result.QBrushRemoteResult;
import com.hgxh.trade.result.ResultInfo;
import com.hgxh.trade.util.DateUtil;
import com.hgxh.trade.util.JSONUtil;
import com.hgxh.trade.util.SimpleHttpUtil;

/**
*@ClassName: QBrushRemoteImpl
*@Description: 
*@author YY 
*@date 2016年12月5日  上午9:32:37
*@version 1.0
*/

@Service
public class QBrushRemoteImpl implements QBrushRemote {
	
	private static final Logger logger = LoggerFactory.getLogger(QBrushRemoteImpl.class);
	
	@Value("${qbrush.remote.url}")
	private String qBrushRemoteUrl;
	
	@Autowired
	private UserTerminalInformationsDao termainalDao;

	@Override
	public ResultInfo bindTerminal(BindTerminalParam param) throws Exception{
		ResultInfo result = null;
		Map<String, String> params = new HashMap<String, String>();
		String value = param.getParamValue().replace("\\", "");
    	params.put(param.getParamKey(), value);
    	//调用Q刷绑定终端接口
    	logger.info("绑定Q刷传入参数 :"+params);
    	String res=SimpleHttpUtil.doPost(qBrushRemoteUrl, params);
    	logger.info("绑定Q刷接口返回结果 :"+res);
    	QBrushRemoteResult remoteResult = new QBrushRemoteResult();
    	remoteResult = (QBrushRemoteResult) JSONUtil.JSONToObject(res, remoteResult);
    	if(StringUtils.isNotBlank(res) && "000000".equals(remoteResult.getREP_BODY().getRSPCOD())){
    		termainalDao.insertSelective(converEntity(param));
    		result = new ResultInfo(BaseExceptionMsg.SUCCESS);
    	}else{
    		result = new ResultInfo(remoteResult.getREP_BODY().getRSPCOD(),remoteResult.getREP_BODY().getRSPMSG());
    	}
		return result;
	}
	
	public UserTerminalInformationsEntity converEntity(BindTerminalParam param){
		UserTerminalInformationsEntity entity = new UserTerminalInformationsEntity();
		entity.setTerminalNo(param.getTerminalNo());
		entity.setTerminalType(TerminalTypeEnum.QBRUSH);
		entity.setUserId(param.getUserId());
		entity.setBluetoothUrl(param.getBluetoothUrl());
		entity.setBindTime(DateUtil.getLastModifyTime());
		return entity;
	}

}
