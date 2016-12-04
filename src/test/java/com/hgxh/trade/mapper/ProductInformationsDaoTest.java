package com.hgxh.trade.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hgxh.trade.dao.ProductInformationsDao;

/**
*@ClassName: ProductInformationsDaoTest
*@Description: 
*@author YY 
*@date 2016年12月4日  下午11:14:48
*@version 1.0
*/

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInformationsDaoTest {
	
	@Autowired
	private ProductInformationsDao productInformationsDao;
	
	@Test
	public void selectById(){
		System.out.println(productInformationsDao.selectByPrimaryKey(1L));
	}

}
