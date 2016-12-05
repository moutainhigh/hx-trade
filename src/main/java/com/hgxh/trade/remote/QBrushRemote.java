package com.hgxh.trade.remote;

import com.hgxh.trade.param.BindTerminalParam;
import com.hgxh.trade.result.ResultInfo;

/**
*@ClassName: QBrushRemote
*@Description: 
*@author YY 
*@date 2016年12月5日  上午9:32:06
*@version 1.0
*/
public interface QBrushRemote {
	
	public ResultInfo bindTerminal(BindTerminalParam param) throws Exception;

}
