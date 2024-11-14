package com.wggt.bank_user_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class BankUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankUserServiceApplication.class, args);
	}

}
