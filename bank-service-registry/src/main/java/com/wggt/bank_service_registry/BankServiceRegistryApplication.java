/*
 * @Author: princewang666 1213246620@qq.com
 * @Date: 2024-08-20 16:59:44
 * @LastEditors: princewang666 1213246620@qq.com
 * @LastEditTime: 2024-08-20 17:38:09
 * @FilePath: \WGGT_BANK\bank-service-registry\src\main\java\com\wggt\bank_service_registry\BankServiceRegistryApplication.java
 * @Description: 启动类
 * 
 * Copyright (c) 2024 by wggt, All Rights Reserved. 
 */
package com.wggt.bank_service_registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class BankServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankServiceRegistryApplication.class, args);
	}

}
