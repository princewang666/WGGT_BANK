/*
 * @Author: princewang666 1213246620@qq.com
 * @Date: 2024-08-22 15:25:23
 * @LastEditors: princewang666 1213246620@qq.com
 * @LastEditTime: 2024-11-14 15:57:05
 * @FilePath: \WGGT_BANK\bank-fund-transfer-service\src\main\java\com\wggt\bank_fund_transfer_service\BankFundTransferServiceApplication.java
 * @Description: 后面转账和支付微服务大同小异了，都是本地再建一张表，和core-bank-service中的表通过外键关联，后面的课是微服务通信Feign和异常处理，没有新东西了
 * 因此整个项目就到此结束，也学习到不少东西，圆满完结！
 * 
 * Copyright (c) 2024 by wggt, All Rights Reserved. 
 */
package com.wggt.bank_fund_transfer_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankFundTransferServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankFundTransferServiceApplication.class, args);
	}

}
