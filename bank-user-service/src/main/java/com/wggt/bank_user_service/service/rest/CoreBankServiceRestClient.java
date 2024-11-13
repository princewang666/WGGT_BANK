package com.wggt.bank_user_service.service.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wggt.bank_user_service.model.rest.UserResponse;

@FeignClient(name = "core-bank-service")
public interface CoreBankServiceRestClient {
    @GetMapping("/api/v1/user/{identification}")
    UserResponse readUser(@PathVariable("identification") String identification);
}
