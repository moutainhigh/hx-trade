package com.hgxh.trade.bussiness;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hgxh.trade.biz.AccountTradeBiz;
import com.hgxh.trade.param.InvestParam;
import com.hgxh.trade.param.WithdrawParam;
import com.hgxh.trade.remote.RuifudeRemote;
import com.hgxh.trade.result.ResultInfo;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

/**
*@ClassName: RuifudeRemoteTest
*@Description: 瑞福德接口测试类
*@author YY 
*@date 2017年2月7日  上午10:15:32
*@version 1.0
*/

@RunWith(SpringRunner.class)
@SpringBootTest
public class RuifudeRemoteTest {
	
	@Autowired
	private RuifudeRemote ruifudeRemote;
	@Autowired
	private AccountTradeBiz accountTradeBiz;
	
	//获取用户开户信息
	@Test
	public void getAccountInfo(){
		try {
//			ResultInfo result = ruifudeRemote.getAccountInfo("340123199412121133");
			ResultInfo result = accountTradeBiz.getAccountInfo("340123199412121133");
			System.out.println("getAccountInfo: "+result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//购买
	@Test
	public void invest(){
		InvestParam param = new InvestParam();
		param.setMemberNo("SY2017011602000496");
		param.setPassbook("5802888800000018");
		param.setProductNo("13");
		param.setYield("2.1");
		param.setProductType("FIXED");
		param.setAmount("10000.00");
		param.setInvestTime("1484126606315");
		param.setTransferSaveType("INTERESTTRANS");
		try {
			ResultInfo result = ruifudeRemote.invest(param);
			System.out.println("invest: "+result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//提现
	@Test
	public void withdraw(){
		WithdrawParam param = new WithdrawParam();
		//活期
//		param.setBizNo("5802888800000018");
//		param.setProductType("CURRENT");
		//定期
		param.setBizNo("5802666600000005");
		param.setProductType("FIXED");
		param.setPassword("d41d8cd98f00b204e9800998ecf8427e");
		param.setAmount("100");
		try {
			ResultInfo result = ruifudeRemote.withdraw(param);
			System.out.println("invest: "+result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
