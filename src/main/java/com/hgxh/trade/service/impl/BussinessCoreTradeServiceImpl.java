package com.hgxh.trade.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgxh.trade.dao.OrderDao;
import com.hgxh.trade.dao.StandardInformationsDao;
import com.hgxh.trade.dao.UserDao;
import com.hgxh.trade.entity.OrderEntity;
import com.hgxh.trade.entity.StandardInformationsEntity;
import com.hgxh.trade.entity.UserEntity;
import com.hgxh.trade.enums.BaseExceptionMsg;
import com.hgxh.trade.enums.BuyTypeEnum;
import com.hgxh.trade.enums.GoodsTypeEnum;
import com.hgxh.trade.enums.OrderStatusEnum;
import com.hgxh.trade.param.BussinessFundParam;
import com.hgxh.trade.result.ResultInfo;
import com.hgxh.trade.service.BussinessCoreTradeService;
import com.hgxh.trade.util.DateUtil;
import com.hgxh.trade.util.SequenceUtil;

/**
*@ClassName: BussinessCoreTradeServiceImpl
*@Description: 
*@author YY 
*@date 2016年11月15日  下午3:56:58
*@version 1.0
*/
@Service
public class BussinessCoreTradeServiceImpl implements BussinessCoreTradeService {
	
	private static Logger logger = LoggerFactory.getLogger(BussinessCoreTradeServiceImpl.class);
	
	@Autowired
	private StandardInformationsDao bidDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private OrderDao orderDao;
	
	/**
	 * 原始购买
	 * @param bussinessFundParam
	 * @return
	 */
	@Override
	public ResultInfo invset(BussinessFundParam bussinessFundParam) {
		ResultInfo result = new ResultInfo(BaseExceptionMsg.SUCCESS);
//		StandardInformationsEntity bid=bidDao.getBidByBidNo(bussinessFundParam.getBidNo());
//		UserEntity customUser=userDao.getUserByUserId(bid.getBidCustomNo());
//		OrderEntity order=createOrder(bussinessFundParam,bid);
		return result;
	}
	
	/**
	 * 保存订单详情
	 * @param bussinessFundParam
	 * @param bid
	 * @return
	 */
	private OrderEntity createOrder(BussinessFundParam bussinessFundParam,StandardInformationsEntity bid){
		OrderEntity order=new OrderEntity();
		try {
			//购买金额=发标总金额/发标总份额*购买份额
			BigDecimal buyAmount = bid.getFinancedAmount().divide(new BigDecimal(bid.getFinancedShare()))
					.multiply(new BigDecimal(bussinessFundParam.getShare()));
			order.setVersion(0);
			order.setOrderNo(SequenceUtil.getOrderNo());
			order.setBuyCustomNo(bussinessFundParam.getUserId().toString());
			order.setSellerCustomNo(bid.getBidCustomNo());
			order.setGoodsType(GoodsTypeEnum.ORIG);
			order.setGoodsNo(bid.getBidNo());
			order.setBuyType(BuyTypeEnum.GENE);
			order.setGoodsType(GoodsTypeEnum.ORIG);
			order.setGoodsName(bid.getBidName());
			order.setGoodsDesc("");
			order.setOrgBidNo(bid.getBidNo());
			order.setBuyAmount(buyAmount);
			order.setCostAmount(buyAmount);
			order.setBuyShare(bussinessFundParam.getShare());
			order.setEndDate(bid.getEndDate());
			order.setLockPeriod(bid.getTransferForbidPeriod());
			order.setLockStartDate(DateUtil.getDayAfter(0));
			order.setLockEndDate(DateUtil.getDayAfter(bid.getTransferForbidPeriod()));
			order.setStartDate(bid.getStartDate());
			order.setBuyRequestNo(bussinessFundParam.getRequestNo());
			order.setOrderStatus(OrderStatusEnum.INIT);
			order.setOrderTime(DateUtil.getLastModifyTime());
			order.setLastModifyTime(DateUtil.getLastModifyTime());
			order.setAchievedInterest(new BigDecimal("0"));
			order.setAchievingInterest(new BigDecimal("0"));
			order.setBuyerFee(new BigDecimal("0"));
			order.setTransferedAmount(new BigDecimal("0"));
			order.setTransferedShare(0);
			order.setTransferingAmount(new BigDecimal("0"));
			order.setTransferingShare(0);
			orderDao.insertSelective(order);
		} catch (Exception e) {
			logger.error("failed in createOrder[order:{}] with exception:{}", order, e.getMessage());
		}
		return order;
	}

}
