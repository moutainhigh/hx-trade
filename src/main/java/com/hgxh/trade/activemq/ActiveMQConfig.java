package com.hgxh.trade.activemq;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

/**
*@ClassName: ActiveMQConfig
*@Description: 
*@author YY 
*@date 2016年11月16日  上午10:50:42
*@version 1.0
*/
@Configuration  
@EnableJms
public class ActiveMQConfig {
	
	@Bean
    public Queue bidSucceedQueue() {  
        return new ActiveMQQueue("bidSucceed-queue");  
    }  
	
	@Bean
    public Queue sendMsgQueue() {  
        return new ActiveMQQueue("send-sms-queue");  
    }
    
    @Bean
    public Queue tradeMakeQueue() {  
        return new ActiveMQQueue("trade-make-queue");  
    }
    
    @Bean
    public Queue fastTransferQueue() {  
        return new ActiveMQQueue("contract-generate-queue");  
    }

}
