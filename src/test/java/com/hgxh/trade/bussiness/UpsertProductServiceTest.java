package com.hgxh.trade.bussiness;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hgxh.trade.param.ProductParam;
import com.hgxh.trade.result.ResultInfo;
import com.hgxh.trade.service.UpsertProductService;

/**
*@ClassName: UpsertProductServiceTest
*@Description: 
*@author YY 
*@date 2016年12月8日  上午9:45:28
*@version 1.0
*/

@RunWith(SpringRunner.class)
@SpringBootTest
public class UpsertProductServiceTest {
	
	@Autowired
	private UpsertProductService productService;
	
	@Test
	public void upsertProduct(){
		ProductParam productParam = new ProductParam();
		productParam.setProductNo("FIXED-6-1");
		productParam.setProductName("定期六个月测试1");
		productParam.setProductType("FIXED");
		productParam.setCycle("180");
		productParam.setYield("4.25");
		productParam.setWithdrawCount("3");
		productParam.setCreateTime("1481162129000");
		productParam.setBriefIntroduction("定期六个月测试1");
		productParam.setIntroduction("定期六个月测试1");
		ResultInfo resultInfo = productService.insertOrUpdateProduct(productParam);
		System.out.println(resultInfo);
	}

}
