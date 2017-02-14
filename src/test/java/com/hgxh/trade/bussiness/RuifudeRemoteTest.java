package com.hgxh.trade.bussiness;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hgxh.trade.param.InvestParam;
import com.hgxh.trade.remote.RuifudeRemote;
import com.hgxh.trade.result.ResultInfo;

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
	
	//获取用户开户信息
	@Test
	public void getAccountInfo(){
		try {
			ResultInfo result = ruifudeRemote.getAccountInfo("340123199412121133");
			System.out.println("getAccountInfo: "+result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//购买
	@Test
	public void invest(){
		InvestParam param = new InvestParam();
		param.setMemberNo("SY2017011602000496123213");
		param.setPassbook("58028888000000183213");
		param.setProductNo("13");
		param.setYield("2.1");
		param.setProductType("FIXED");
		param.setAmount("10000.00");
		param.setInvestTime("1484126606315");
		param.setTransferSaveType("INTERESTTRANS");
		param.setPassword("mDAwEk2RG4E=");
		param.setExpirationTime("1486457186000");
		try {
			ResultInfo result = ruifudeRemote.invest(param);
			System.out.println("invest: "+result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
