package com.hgxh.trade.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgxh.trade.dao.FinancialInformationsDao;
import com.hgxh.trade.dao.OrdersDao;
import com.hgxh.trade.dao.ProductInformationsDao;
import com.hgxh.trade.dao.UserMemberInformationsDao;
import com.hgxh.trade.entity.OrdersEntity;
import com.hgxh.trade.entity.ProductInformationsEntity;
import com.hgxh.trade.entity.UserMemberInformationsEntity;
import com.hgxh.trade.enums.OrderTypeEnum;
import com.hgxh.trade.enums.TradeTypeEnum;
import com.hgxh.trade.param.CounterTradeParam;
import com.hgxh.trade.param.OrderStatusEnum;
import com.hgxh.trade.result.ResultInfo;
import com.hgxh.trade.service.CounterTradeService;
import com.hgxh.trade.util.DateUtil;
import com.hgxh.trade.util.SequenceUtil;

/**
*@ClassName: CounterTradeServiceImpl
*@Description: 
*@author YY 
*@date 2016年12月5日  下午6:34:14
*@version 1.0
*/
@Service
public class CounterTradeServiceImpl implements CounterTradeService {
	
	@Autowired
	private OrdersDao ordersDao;
	@Autowired
	private FinancialInformationsDao financialDao;
	@Autowired
	private UserMemberInformationsDao memberDao;
	@Autowired
	private ProductInformationsDao productDao;

	@Override
	public ResultInfo saveCounterTrade(CounterTradeParam param) {
		if(TradeTypeEnum.PURCHASE.equals(param.getTradeType())||
				TradeTypeEnum.CAPITALTRANS.equals(param.getTradeType())||
				TradeTypeEnum.INTERESTTRANS.equals(param.getTradeType())||
				TradeTypeEnum.FIXEDTOCURRENT.equals(param.getTradeType())){
			saveOrders(param);
		}
		return null;
	}
	
	public void saveOrders(CounterTradeParam param){
		if(TradeTypeEnum.FIXEDTOCURRENT.equals(param.getTradeType())){
			UserMemberInformationsEntity member = memberDao.selectByMemberNo(param.getMemberNo());
			OrdersEntity order = ordersDao.selectByBizNo(member.getBankCardNo());
			if(order != null){
				//update
				
			}else{
				//insert
				OrdersEntity ordersEntity = new OrdersEntity();
				BeanUtils.copyProperties(param, ordersEntity);
				ordersEntity.setOrderNo(SequenceUtil.getOrderNo());
				ordersEntity.setUserId(member.getUserId());
				ordersEntity.setWithdrawalAmount(new BigDecimal(param.getAmount()));
				ordersEntity.setAlreadyWithdrawCount(0);
				ordersEntity.setStatus(OrderStatusEnum.SUCCESS);
				ordersEntity.setOrderType(OrderTypeEnum.PURCHASE);
				//获取传来时间转换成13位时间戳
				ordersEntity.setOrderTime(DateUtil.stringToTimestamp(param.getTradeTime()));
				ordersEntity.setLastModifyTime(DateUtil.getLastModifyTime());
				//到期时间
//				expirationTime
				
			}
		}else{
			
		}
		OrdersEntity ordersEntity = new OrdersEntity();
		
	}
	
	public void saveFinancialInformations(CounterTradeParam param){
		
	}

}
