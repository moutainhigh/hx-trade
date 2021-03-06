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
    public Queue sendMsgQueue() {  
        return new ActiveMQQueue("send-sms-queue");  
    }
	
	@Bean
    public Queue counterTradeQueue() {  
        return new ActiveMQQueue("counter-trade-queue");  
    }  
	
	@Bean
    public Queue upsertProductQueue() {  
        return new ActiveMQQueue("upsert-product-queue");  
    }
	
	@Bean
    public Queue addLoanQueue() {  
        return new ActiveMQQueue("add-loan-queue");  
    }
	
	@Bean
    public Queue loanRepayQueue() {  
        return new ActiveMQQueue("loan-repay-queue");  
    }

}
