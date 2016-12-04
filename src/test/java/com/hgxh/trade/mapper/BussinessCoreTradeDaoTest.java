package com.hgxh.trade.mapper;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hgxh.trade.dao.OrderDao;
import com.hgxh.trade.dao.StandardInformationsDao;
import com.hgxh.trade.dao.UserDao;
import com.hgxh.trade.entity.OrderEntity;
import com.hgxh.trade.entity.StandardInformationsEntity;
import com.hgxh.trade.entity.UserEntity;
import com.hgxh.trade.enums.BuyTypeEnum;
import com.hgxh.trade.enums.GoodsTypeEnum;
import com.hgxh.trade.enums.OrderStatusEnum;
import com.hgxh.trade.param.BussinessFundParam;
import com.hgxh.trade.util.DateUtil;
import com.hgxh.trade.util.SequenceUtil;

/**
*@ClassName: BussinessCoreTradeTest
*@Description: 
*@author YY 
*@date 2016年11月16日  下午5:11:04
*@version 1.0
*/

@RunWith(SpringRunner.class)
@SpringBootTest
public class BussinessCoreTradeDaoTest {

	@Autowired
	private OrderDao orderDao;	
	@Autowired
	private UserDao userDao;
	@Autowired
	private StandardInformationsDao bidDao;
	
	@Test
	public void createOrder(){
		BussinessFundParam bussinessFundParam = new BussinessFundParam();
		bussinessFundParam.setBidNo("ZJDB-01-03");
		bussinessFundParam.setUserId("78716");
		bussinessFundParam.setShare(999L);
		bussinessFundParam.setYield("9.5");
		UserEntity user=userDao.selectByPrimaryKey(Long.parseLong(bussinessFundParam.getUserId()));
		StandardInformationsEntity bid=bidDao.getBidByBidNo(bussinessFundParam.getBidNo());
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++user: "+user.toString());
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++bid: "+bid.toString());
		//创建订单
		BigDecimal buyAmount = bid.getFinancedAmount().divide(new BigDecimal(bid.getFinancedShare()))
				.multiply(new BigDecimal(bussinessFundParam.getShare()));
		OrderEntity order=new OrderEntity();
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
//		orderDao.insertSelective(order);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++order: "+order.getId());
	}
}
