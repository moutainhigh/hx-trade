package com.hgxh.trade.util;

import java.util.Random;

public class RandomUtil {
	
    private static Random r = new Random();
    private static String numberSource = "0123456789";
    private static char[] src = numberSource.toCharArray();
    //产生随机字符串
    public static String randString (int length) {
        char[] buf = new char[length];
        int rnd;
        for(int i=0; i<length; i++) {
                rnd = Math.abs(r.nextInt()) % src.length;

                buf[i] = src[rnd];
        }
        return new String(buf);
    }
}