package com.hgxh.trade.activemq.listener;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.hgxh.trade.biz.CounterCallBackBiz;
import com.hgxh.trade.param.CounterTradeParam;
import com.hgxh.trade.param.ProductParam;
import com.hgxh.trade.result.ResultInfo;

/**
*@ClassName: CounterListener
*@Description: 
*@author YY 
*@date 2016年12月8日  上午11:17:18
*@version 1.0
*/
@Component
public class CounterListener {
	
	private static final Logger logger = LoggerFactory.getLogger(CounterListener.class);
	
	@Autowired
	private CounterCallBackBiz counterBiz;

	/**
     * 监听柜台交易消息队列
     * @param text
     */
    @JmsListener(destination = "counter-trade-queue")
    public void receiveCounterTradeQueue(Map<String,String> map) {  
        System.out.println(map);
        logger.info("activemp counter-trade-queue receive map: " + map);
        ResultInfo resultInfo = counterBiz.counterTrade(copyTradeProperties(map));
        logger.info("receiveCounterTradeQueue execute result："+resultInfo);
    } 
    
    /**
     * 将Map转换成param对象
     * @param map
     * @return
     */
    public CounterTradeParam copyTradeProperties(Map<String,String> map){
    	CounterTradeParam tradeParam = new CounterTradeParam();
    	tradeParam.setMemberNo(map.get("memberNo"));
    	tradeParam.setProductNo(map.get("productNo"));
    	tradeParam.setTradeType(map.get("tradeType"));
    	tradeParam.setAmount(map.get("amount"));
    	tradeParam.setCapital(map.get("capital"));
    	tradeParam.setInterest(map.get("interest"));
    	tradeParam.setBizNo(map.get("bizNo"));
    	tradeParam.setFundsDirection(map.get("fundsDirection"));
    	tradeParam.setTradeTime(map.get("tradeTime"));
    	tradeParam.setTransferSavaType(map.get("transferSavaType"));
    	tradeParam.setProductType(map.get("productType"));
    	tradeParam.setPayType(map.get("payType"));
    	tradeParam.setBankCardNo(map.get("bankCardNo"));
    	tradeParam.setOrgiVoucherNo(map.get("orgiVoucherNo"));
    	tradeParam.setExpirationTime(map.get("expirationTime"));
    	return tradeParam;
    }
    
    /**
     * 监听更新产品消息队列
     * @param text
     */
    @JmsListener(destination = "upsert-product-queue")
    public void receiveUpsertProductQueue(Map<String,String> map) {  
    	logger.info("activemp upsert-product-queue receive map: "+ map );
    	ResultInfo resultInfo = counterBiz.upsertProduct(copyProductProperties(map));
    	logger.info("receiveUpsertProductQueue execute result："+resultInfo);
    } 
    
    /**
     * 将Map转换成param对象
     * @param map
     * @return
     */
    public ProductParam copyProductProperties(Map<String,String> map){
    	ProductParam param = new ProductParam();
    	param.setProductNo(map.get("productNo"));
    	param.setProductName(map.get("productName"));
    	param.setProductType(map.get("productType"));
    	param.setCycle(map.get("cycle"));
    	param.setYield(map.get("yield"));
    	param.setPartYield(map.get("partYield"));
    	param.setWithdrawCount(map.get("withdrawCount"));
    	param.setBriefIntroduction(map.get("briefIntroduction"));
    	param.setIntroduction(map.get("introduction"));
    	param.setCreateTime(map.get("createTime"));
    	param.setAreaNo(map.get("areaNo"));
    	return param;
    }
	
}
