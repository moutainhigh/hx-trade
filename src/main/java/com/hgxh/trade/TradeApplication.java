package com.hgxh.trade;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@MapperScan("com.hgxh.trade.dao")
public class TradeApplication {
    public static void main(String[] args) {
		SpringApplication.run(TradeApplication.class, args);
	}
}
