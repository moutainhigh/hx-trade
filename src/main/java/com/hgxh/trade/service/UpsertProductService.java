package com.hgxh.trade.service;

import com.hgxh.trade.param.ProductParam;
import com.hgxh.trade.result.ResultInfo;

/**
*@ClassName: UpsertProductService
*@Description: 
*@author YY 
*@date 2016年12月6日  下午4:31:28
*@version 1.0
*/
public interface UpsertProductService {
	
	ResultInfo insertOrUpdateProduct(ProductParam param);

}
