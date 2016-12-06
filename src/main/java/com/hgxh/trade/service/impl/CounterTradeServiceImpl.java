package com.hgxh.trade.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgxh.trade.dao.FinancialInformationsDao;
import com.hgxh.trade.dao.OrdersDao;
import com.hgxh.trade.dao.ProductInformationsDao;
import com.hgxh.trade.dao.UserMemberInformationsDao;
import com.hgxh.trade.entity.FinancialInformationsEntity;
import com.hgxh.trade.entity.OrdersEntity;
import com.hgxh.trade.entity.ProductInformationsEntity;
import com.hgxh.trade.entity.UserMemberInformationsEntity;
import com.hgxh.trade.enums.BaseExceptionMsg;
import com.hgxh.trade.enums.OrderTypeEnum;
import com.hgxh.trade.enums.TradeSourceEnum;
import com.hgxh.trade.enums.TradeTypeEnum;
import com.hgxh.trade.param.CounterTradeParam;
import com.hgxh.trade.param.OrderStatusEnum;
import com.hgxh.trade.result.ResultInfo;
import com.hgxh.trade.service.CounterTradeService;
import com.hgxh.trade.util.Constants;
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
		UserMemberInformationsEntity member = memberDao.selectByMemberNo(param.getMemberNo());
		if(TradeTypeEnum.PURCHASE.toString().equals(param.getTradeType())||
				TradeTypeEnum.CAPITALTRANS.toString().equals(param.getTradeType())||
				TradeTypeEnum.INTERESTTRANS.toString().equals(param.getTradeType())||
				TradeTypeEnum.FIXEDTOCURRENT.toString().equals(param.getTradeType())){
			saveOrders(param, member);
		}
		saveFinancialInformations(param, member);
		return new ResultInfo(BaseExceptionMsg.SUCCESS);
	}
	
	/**
	 * 保存订单
	 * @param param
	 */
	public void saveOrders(CounterTradeParam param, UserMemberInformationsEntity member){
		ProductInformationsEntity product = productDao.selectByProductNo(param.getProductNo());
		if(TradeTypeEnum.FIXEDTOCURRENT.equals(param.getTradeType())){		
			OrdersEntity order = ordersDao.selectSucByBizNo(member.getBankCardNo());
			if(order != null){
				//update
				order.setAmount(order.getAmount().add(new BigDecimal(param.getAmount())));
				ordersDao.updateByPrimaryKeySelective(order);
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
				long tradeTimestamp = DateUtil.stringToTimestamp(param.getTradeTime());
				ordersEntity.setOrderTime(tradeTimestamp);
				ordersEntity.setLastModifyTime(DateUtil.getLastModifyTime());
				long expirationTime = DateUtil.getDayBegin(tradeTimestamp) + product.getCycle()*Constants.ONEDAY;
				ordersEntity.setExpirationTime(expirationTime);
				ordersEntity.setYeild(product.getYield());
				ordersEntity.setAmount(new BigDecimal(param.getAmount()));
				ordersDao.insertSelective(ordersEntity);
			}
		}else{
			OrdersEntity ordersEntity = new OrdersEntity();
			BeanUtils.copyProperties(param, ordersEntity);
			ordersEntity.setOrderNo(SequenceUtil.getOrderNo());
			ordersEntity.setUserId(member.getUserId());
			ordersEntity.setWithdrawalAmount(new BigDecimal(param.getAmount()));
			ordersEntity.setAlreadyWithdrawCount(0);
			ordersEntity.setStatus(OrderStatusEnum.SUCCESS);
			ordersEntity.setOrderType(OrderTypeEnum.PURCHASE);
			long tradeTimestamp = DateUtil.stringToTimestamp(param.getTradeTime());
			ordersEntity.setOrderTime(tradeTimestamp);
			ordersEntity.setLastModifyTime(DateUtil.getLastModifyTime());
			long expirationTime = DateUtil.getDayBegin(tradeTimestamp) + product.getCycle()*Constants.ONEDAY;
			ordersEntity.setExpirationTime(expirationTime);
			ordersEntity.setYeild(product.getYield());
			ordersEntity.setAmount(new BigDecimal(param.getAmount()));
			ordersDao.insertSelective(ordersEntity);
		}
		
	}
	
	/**
	 * 保存交易流水
	 * @param param
	 */
	public void saveFinancialInformations(CounterTradeParam param, UserMemberInformationsEntity member){
		FinancialInformationsEntity entity = new FinancialInformationsEntity();
		BeanUtils.copyProperties(param, entity);
		entity.setAmount(new BigDecimal(param.getAmount()));
		entity.setFlowNo(SequenceUtil.getFlowNo());
		entity.setUserId(member.getUserId());
		entity.setSource(TradeSourceEnum.COUNTER);
		entity.setCreateTime(DateUtil.stringToTimestamp(param.getTradeTime()));
		entity.setLastModifyTime(DateUtil.getLastModifyTime());
		financialDao.insertSelective(entity);
	}

}
