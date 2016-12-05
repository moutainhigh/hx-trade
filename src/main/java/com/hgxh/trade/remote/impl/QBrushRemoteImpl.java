package com.hgxh.trade.remote.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

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
public class QBrushRemoteImpl implements QBrushRemote {
	
	@Value("${qbrush.remote.url}")
	private String qBrushRemoteUrl;
	
	@Autowired
	private UserTerminalInformationsDao termainalDao;

	@Override
	public ResultInfo bindTerminal(BindTerminalParam param) throws Exception{
		ResultInfo result = null;
		Map<String, String> params = new HashMap<String, String>();
    	params.put(param.getParamKey(), param.getParamValue());
    	//调用Q刷绑定终端接口
    	String res = SimpleHttpUtil.doPost(qBrushRemoteUrl, params);	
    	//res -> QBrushRemoteResult
    	QBrushRemoteResult remoteResult = new QBrushRemoteResult();
    	//测试信息开始
    	remoteResult.setRSPCOD("000000");
//    	String res = "success";
    	//测试信息结束
    	if(StringUtils.isNotBlank(res) && "000000".equals(remoteResult.getRSPCOD())){
    		termainalDao.insertSelective(converEntity(param));
    		result = new ResultInfo(BaseExceptionMsg.SUCCESS);
    	}else{
    		result = new ResultInfo(BaseExceptionMsg.INVEST_EXCEPTION);
    	}
		return result;
	}
	
	public UserTerminalInformationsEntity converEntity(BindTerminalParam param){
		UserTerminalInformationsEntity entity = new UserTerminalInformationsEntity();
		entity.setTerminalNo(param.getTerminalNo());
		entity.setTerminalType(TerminalTypeEnum.QBRUSH);
		entity.setUserId(param.getUserId());
		entity.setBindTime(DateUtil.getLastModifyTime());
		return entity;
	}

}
