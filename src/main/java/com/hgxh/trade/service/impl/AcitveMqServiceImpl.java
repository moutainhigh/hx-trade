package com.hgxh.trade.service.impl;

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
    private Queue bidSucceedQueue;
    @Autowired  
    private Queue tradeMakeQueue;
    @Autowired  
    private Queue sendMsgQueue;
    @Autowired
    private Queue fastTransferQueue;
    
    /**
     * 监听消息队列实例  
     * @param text
     */
//    @JmsListener(destination = "sample.queue")
//    public void receiveQueue(String text) {  
//        //test为监听到的消息 
//    } 
    
    /**
	 * 发送标的成功消息
	 * @param bidno
	 */
    @Override
	public void sendBidSucceedQueue(String bidNo) {
		final String msg = "B|" + bidNo;
		try {			
			jmsMessagingTemplate.convertAndSend(bidSucceedQueue, msg); 
		} catch (Exception e) {
			logger.warn("sendQueue bidSuccessd failed, [bidno is {}] exception [[]]",bidNo,e);
		}
	}
    
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
    
    /**
	 * 发送转让购买消息
	 * @param bidNo
	 * @param requestId
	 */
    @Override
    public void sendInvestTransQueue(String bidNo,Long requestId) {
		final String msg = "BUYTRANS|" + bidNo+"|"+requestId;
		try {
			jmsMessagingTemplate.convertAndSend(tradeMakeQueue, msg); 
		} catch (Exception e) {
			logger.error("send investTransQueue fail ", e);
		}
	}

    /**
   	 * 发送普通转让消息
   	 * @param bidNo
   	 * @param transferId
   	 */
	@Override
	public void sendTransferQueue(String bidNo, Long transferId) {
		final String msg = "TRANSFER|" + bidNo+"|"+transferId;
		try {
			jmsMessagingTemplate.convertAndSend(tradeMakeQueue, msg); 
		} catch (Exception e) {
			logger.error("send transferQueue fail ", e);
		}
	}

	 /**
   	 * 发送快速转让消息
   	 * @param orderNo
   	 */
	@Override
	public void sendFastTransferQueue(String orderNo) {
		final String msg = "T|" + orderNo;
		try {
			jmsMessagingTemplate.convertAndSend(fastTransferQueue, msg); 
		} catch (Exception e) {
			logger.error("send fastTransferQueue fail ", e);
		}
	}

}
