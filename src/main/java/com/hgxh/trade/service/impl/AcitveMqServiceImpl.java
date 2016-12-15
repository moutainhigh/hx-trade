package com.hgxh.trade.service.impl;

import java.util.Map;

import javax.jms.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import com.hgxh.trade.service.AcitveMqService;

/**
*@ClassName: AcitveMqServiceImpl
*@Description: 
*@author YY 
*@date 2016年11月18日  下午5:04:01
*@version 1.0
*/
@Service
public class AcitveMqServiceImpl implements AcitveMqService {
	
	private static Logger logger = LoggerFactory.getLogger(AcitveMqServiceImpl.class);
	
	@Autowired  
    private JmsMessagingTemplate jmsMessagingTemplate;   
    @Autowired  
    private Queue sendMsgQueue;
    @Autowired  
    private Queue counterTradeQueue;
    @Autowired  
    private Queue upsertProductQueue;
    @Autowired  
    private Queue addLoanQueue;
    @Autowired  
    private Queue loanRepayQueue;
    
    /**
	 * 发送发送短信消息
	 * @param mobile
	 * @param content
	 */
    @Override
    public void sendMsgQueue(String mobile,String content) {
		final String contentMsg = mobile+"|" + content+"|N";
		try {
			jmsMessagingTemplate.convertAndSend(sendMsgQueue, contentMsg); 
		} catch (Exception e) {
			logger.error("send msgQueue fail ", e);
		}
	}

	@Override
	public void sendCounterTradeQueue(Map<String, String> msg) {
		try {
			jmsMessagingTemplate.convertAndSend(counterTradeQueue, msg); 
		} catch (Exception e) {
			logger.error("send counterTradeQueue fail ", e);
		}
	}

	@Override
	public void sendUpsertProductQueue(Map<String, String> msg) {
		try {
			jmsMessagingTemplate.convertAndSend(upsertProductQueue, msg); 
		} catch (Exception e) {
			logger.error("send upsertProductQueue fail ", e);
		}
	}

	@Override
	public void sendAddLoanQueue(Map<String, String> msg) {
		try {
			jmsMessagingTemplate.convertAndSend(addLoanQueue, msg); 
		} catch (Exception e) {
			logger.error("send addLoanQueue fail ", e);
		}
	}

	@Override
	public void sendLoanRepayQueue(Map<String, String> msg) {
		try {
			jmsMessagingTemplate.convertAndSend(loanRepayQueue, msg); 
		} catch (Exception e) {
			logger.error("send loanRepayQueue fail ", e);
		}
	}

}
