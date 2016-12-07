package com.hgxh.trade.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgxh.trade.dao.FinancialInformationsDao;
import com.hgxh.trade.dao.OrdersDao;
import com.hgxh.trade.dao.ProductInformationsDao;
import com.hgxh.trade.dao.UserAccountsDao;
import com.hgxh.trade.dao.UserMemberInformationsDao;
import com.hgxh.trade.entity.FinancialInformationsEntity;
import com.hgxh.trade.entity.OrdersEntity;
import com.hgxh.trade.entity.ProductInformationsEntity;
import com.hgxh.trade.entity.UserAccountsEntity;
import com.hgxh.trade.entity.UserMemberInformationsEntity;
import com.hgxh.trade.enums.BaseExceptionMsg;
import com.hgxh.trade.enums.FundsDirectionEnum;
import com.hgxh.trade.enums.OrderTypeEnum;
import com.hgxh.trade.enums.ProductTypeEnum;
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
	@Autowired
	private UserAccountsDao userAccountsDao;

	/**
	 * 柜台交易数据保存
	 * @param param
	 */
	@Override
	public ResultInfo saveCounterTrade(CounterTradeParam param) {
		UserMemberInformationsEntity member = memberDao.selectByMemberNo(param.getMemberNo());
		ProductInformationsEntity product = productDao.selectByProductNo(param.getProductNo());
		if(TradeTypeEnum.PURCHASE.toString().equals(param.getTradeType())||
				TradeTypeEnum.CAPITALTRANS.toString().equals(param.getTradeType())||
				TradeTypeEnum.INTERESTTRANS.toString().equals(param.getTradeType())||
				TradeTypeEnum.FIXEDTOCURRENT.toString().equals(param.getTradeType())||
				TradeTypeEnum.AHEADWITDRAW.toString().equals(param.getTradeType())){
			saveOrders(param, member, product);
		}
		saveFinancialInformations(param, member);
		savaUserAccounts(param, member, product);
		return new ResultInfo(BaseExceptionMsg.SUCCESS);
	}
	
	/**
	 * 保存订单
	 * @param param
	 */
	public void saveOrders(CounterTradeParam param, UserMemberInformationsEntity member, ProductInformationsEntity product){
		if(TradeTypeEnum.AHEADWITDRAW.toString().equals(param.getTradeType())){
			OrdersEntity order = ordersDao.selectSucByBizNo(param.getBizNo());
			order.setWithdrawalAmount(order.getWithdrawalAmount().subtract(new BigDecimal(param.getAmount())));
			order.setAlreadyWithdrawCount(order.getAlreadyWithdrawCount()+1);
			if(order.getWithdrawalAmount() == new BigDecimal("0")){
				order.setStatus(OrderStatusEnum.AHEADDUE);
			}else{
				order.setPredictInterest(order.getWithdrawalAmount().multiply(product.getYield().divide(new BigDecimal(100)))
						.multiply(new BigDecimal(product.getCycle())).divide(new BigDecimal(365),2,BigDecimal.ROUND_HALF_UP));
			}
			ordersDao.updateByPrimaryKeySelective(order);
		}else if(TradeTypeEnum.FIXEDTOCURRENT.toString().equals(param.getTradeType())){		
			OrdersEntity order = ordersDao.selectSucByBizNo(member.getBankCardNo());
			if(order != null){
				//update
				order.setAmount(order.getAmount().add(new BigDecimal(param.getAmount())));
				order.setWithdrawalAmount(order.getWithdrawalAmount().add(new BigDecimal(param.getAmount())));
				ordersDao.updateByPrimaryKeySelective(order);
			}else{
				//insert
				OrdersEntity ordersEntity = copyProperties(param,member,product);
				ordersDao.insertSelective(ordersEntity);
			}
		}else{
			OrdersEntity ordersEntity = copyProperties(param,member,product);
			ordersDao.insertSelective(ordersEntity);
		}
	}
	
	/**
	 * 复制参数
	 * @param param
	 * @param member
	 * @param product
	 */
	public OrdersEntity copyProperties(CounterTradeParam param, UserMemberInformationsEntity member, ProductInformationsEntity product){
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
		if(ProductTypeEnum.FIXED.toString().equals(param.getProductType())){
			long expirationTime = DateUtil.getDayBegin(tradeTimestamp) + product.getCycle()*Constants.ONEDAY;
			ordersEntity.setExpirationTime(expirationTime);
			ordersEntity.setPredictInterest(ordersEntity.getWithdrawalAmount().multiply(product.getYield().divide(new BigDecimal(100)))
					.multiply(new BigDecimal(product.getCycle())).divide(new BigDecimal(365),2,BigDecimal.ROUND_HALF_UP));
		}
		ordersEntity.setYeild(product.getYield());
		ordersEntity.setAmount(new BigDecimal(param.getAmount()));
		return ordersEntity;
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
	
	/**
	 * 保存分社账户统计表
	 * @param param
	 * @param member
	 * @param product
	 */
	public void savaUserAccounts(CounterTradeParam param, UserMemberInformationsEntity member, ProductInformationsEntity product){
		UserAccountsEntity account = userAccountsDao.selectByMemberNo(param.getMemberNo());
		if(account==null){
			UserAccountsEntity accountsEntity = new UserAccountsEntity();
			accountsEntity.setVersion(1L);
			accountsEntity.setUserId(member.getUserId());
			accountsEntity.setMemberNo(param.getMemberNo());
			accountsEntity.setTotalInvested(new BigDecimal(param.getAmount()));
			accountsEntity.setTotalOnInvested(new BigDecimal(param.getAmount()));
			accountsEntity.setTotalInterest(new BigDecimal(0));
			accountsEntity.setYesterdayInterest(new BigDecimal(0));
			accountsEntity.setCreateTime(DateUtil.getLastModifyTime());
			accountsEntity.setLastModifyTime(DateUtil.getLastModifyTime());
			userAccountsDao.insertSelective(accountsEntity);
		}else{
			//减少	提现、利息划扣、转账、定期提前提取
			if(TradeTypeEnum.WITHDRAW.toString().equals(param.getTradeType())||TradeTypeEnum.INTERESTDEDUCTION.toString().equals(param.getTradeType())
					||(TradeTypeEnum.TRANSFER.toString().equals(param.getTradeType())&&FundsDirectionEnum.DECR.toString().equals(param.getFundsDirection()))
					||TradeTypeEnum.AHEADWITDRAW.toString().equals(param.getTradeType())){
				account.setTotalOnInvested(account.getTotalOnInvested().subtract(new BigDecimal(param.getAmount())));
				account.setLastModifyTime(DateUtil.getLastModifyTime());
				userAccountsDao.updateByPrimaryKeySelective(account);
			}
			//增加	派息
			if(TradeTypeEnum.SENDINTEREST.toString().equals(param.getTradeType())){
				account.setTotalInvested(account.getTotalInvested().add(new BigDecimal(param.getAmount())));
				account.setTotalOnInvested(account.getTotalOnInvested().add(new BigDecimal(param.getAmount())));
				account.setTotalInterest(account.getTotalInterest().add(new BigDecimal(param.getAmount())));
				account.setLastModifyTime(DateUtil.getLastModifyTime());
				userAccountsDao.updateByPrimaryKeySelective(account);
			}
			//增加	购买、转账
			if(TradeTypeEnum.PURCHASE.toString().equals(param.getTradeType())
					||(TradeTypeEnum.TRANSFER.toString().equals(param.getTradeType())&&FundsDirectionEnum.INCR.toString().equals(param.getFundsDirection()))){
				account.setTotalInvested(account.getTotalInvested().add(new BigDecimal(param.getAmount())));
				account.setTotalOnInvested(account.getTotalOnInvested().add(new BigDecimal(param.getAmount())));
				account.setLastModifyTime(DateUtil.getLastModifyTime());
				userAccountsDao.updateByPrimaryKeySelective(account);
			}
			//增加	本息转存、定期转活期  本金转存相互抵消
			if(TradeTypeEnum.INTERESTTRANS.toString().equals(param.getTradeType())||TradeTypeEnum.FIXEDTOCURRENT.toString().equals(param.getTradeType())){
				OrdersEntity orgOrder = ordersDao.selectByBizNo(param.getOrgiVoucherNo());
				account.setTotalInvested(account.getTotalInvested().add(new BigDecimal(param.getAmount())));
				BigDecimal interest = new BigDecimal(param.getAmount()).subtract(orgOrder.getWithdrawalAmount());
				account.setTotalOnInvested(account.getTotalOnInvested().add(interest));
				account.setTotalInterest(account.getTotalInterest().add(interest));
				account.setLastModifyTime(DateUtil.getLastModifyTime());
				userAccountsDao.updateByPrimaryKeySelective(account);
			}
		}
	}

}
