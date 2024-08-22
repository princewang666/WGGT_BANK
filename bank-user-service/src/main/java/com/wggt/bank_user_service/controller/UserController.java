/*
 * @Author: princewang666 1213246620@qq.com
 * @Date: 2024-08-22 17:09:40
 * @LastEditors: princewang666 1213246620@qq.com
 * @LastEditTime: 2024-08-22 17:22:02
 * @FilePath: \WGGT_BANK\bank-user-service\src\main\java\com\wggt\bank_user_service\controller\UserController.java
 * @Description: 用户服务controller
 * 
 * Copyright (c) 2024 by wggt, All Rights Reserved. 
 */
package com.wggt.bank_user_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping(value = "/id")
    public String readUser() {
        return "OK";
    }
}
