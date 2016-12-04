package com.hgxh.trade.util;

import java.util.Random;

/**
 * @author ZQ
 * @date 2015-5-21
 * @version 1.0
 */
public class NumberUtil {
	
	
	/**
	 * @author ZQ
	 * @date 2015-5-21
	 * @param length
	 * @return
	 */
	public static int getRandomNo(int length){
		String min=Constants.ONE;
		String max=Constants.NINE;
		for(int i=0;i<length;i++){
			min=min+Constants.ZERO;
			max=max+Constants.NINE;
		}
		return nextInt(Integer.parseInt(min),Integer.parseInt(max));
	}
	
	
	/**
	 * @author ZQ
	 * @date 2015-5-21
	 * @param min
	 * @param max
	 * @return
	 */
	public static int nextInt(int min,int max){
		Random random=new Random();
		int randomNo=random.nextInt(max)%(max-min+1) + min;
        return randomNo;
	}
	

}
