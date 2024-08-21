/*
 * @Author: princewang666 1213246620@qq.com
 * @Date: 2024-08-21 09:01:37
 * @LastEditors: princewang666 1213246620@qq.com
 * @LastEditTime: 2024-08-21 09:04:03
 * @FilePath: \WGGT_BANK\bank-api-gateway\src\main\java\com\wggt\bank_api_gateway\BankApiGatewayApplication.java
 * @Description: 启动类
 * 
 * Copyright (c) 2024 by wggt, All Rights Reserved. 
 */
package com.wggt.bank_api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BankApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApiGatewayApplication.class, args);
	}

}
