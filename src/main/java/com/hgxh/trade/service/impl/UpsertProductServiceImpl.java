package com.hgxh.trade.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgxh.trade.dao.ProductInformationsDao;
import com.hgxh.trade.entity.ProductInformationsEntity;
import com.hgxh.trade.enums.BaseExceptionMsg;
import com.hgxh.trade.enums.ProductStatusEnum;
import com.hgxh.trade.enums.ProductTypeEnum;
import com.hgxh.trade.param.ProductParam;
import com.hgxh.trade.result.ResultInfo;
import com.hgxh.trade.service.UpsertProductService;
import com.hgxh.trade.util.DateUtil;

/**
*@ClassName: UpsertProductServiceImpl
*@Description: 
*@author YY 
*@date 2016年12月6日  下午4:31:57
*@version 1.0
*/

@Service
public class UpsertProductServiceImpl implements UpsertProductService {
	
	@Autowired
	private ProductInformationsDao productDao;

	/**
	 * 产品插入或更新时回调
	 * @param param
	 */
	@Override
	public ResultInfo insertOrUpdateProduct(ProductParam param) {
		ProductInformationsEntity product = productDao.selectByProductNo(param.getProductNo());
		if(product != null){
			updateProdct(param, product);
		}else{
			insertProduct(param);
		}
		return new ResultInfo(BaseExceptionMsg.SUCCESS);
	}
	
	/**
	 * 更新产品
	 * @param param
	 * @param product
	 */
	public void updateProdct(ProductParam param, ProductInformationsEntity product){
		BeanUtils.copyProperties(param, product);
		if(param.getCycle() != null){
			product.setCycle(Integer.parseInt(param.getCycle()));
		}
		if(product.getYield() != null){
			product.setYield(new BigDecimal(param.getYield()));
		}
		if(param.getWithdrawCount() != null){
			product.setWithdrawCount(Integer.parseInt(param.getWithdrawCount()));
		}
		if(param.getProductType() != null){
			if(ProductTypeEnum.CURRENT.toString().equals(param.getProductType())){
				product.setProductType(ProductTypeEnum.CURRENT);
			}
			if(ProductTypeEnum.FIXED.toString().equals(param.getProductType())){
				product.setProductType(ProductTypeEnum.FIXED);
			}
		}
		product.setLastModifyTime(DateUtil.getLastModifyTime());
		productDao.updateByProductNo(product);
	}
	
	/**
	 * 插入产品
	 * @param param
	 */
	public void insertProduct(ProductParam param){
		ProductInformationsEntity productEntity = new ProductInformationsEntity();
		BeanUtils.copyProperties(param, productEntity);
		productEntity.setVersion(1L);
		productEntity.setStatus(ProductStatusEnum.PUBLISHED);
		productEntity.setCycle(Integer.parseInt(param.getCycle()));
		productEntity.setYield(new BigDecimal(param.getYield()));
		productEntity.setWithdrawCount(Integer.parseInt(param.getWithdrawCount()));
		if(ProductTypeEnum.CURRENT.toString().equals(param.getProductType())){
			productEntity.setProductType(ProductTypeEnum.CURRENT);
		}
		if(ProductTypeEnum.FIXED.toString().equals(param.getProductType())){
			productEntity.setProductType(ProductTypeEnum.FIXED);
		}
		productEntity.setCreateTime(DateUtil.getLastModifyTime());
		productEntity.setLastModifyTime(DateUtil.getLastModifyTime());
		productDao.insertSelective(productEntity);
	}

}
