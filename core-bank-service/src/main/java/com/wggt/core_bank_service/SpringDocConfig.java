/*
 * @Author: princewang666 1213246620@qq.com
 * @Date: 2024-11-06 15:59:41
 * @LastEditors: princewang666 1213246620@qq.com
 * @LastEditTime: 2024-11-06 16:26:43
 * @FilePath: \WGGT_BANK\core-bank-service\src\main\java\com\wggt\core_bank_service\SpringDocConfig.java
 * @Description: SpringDoc页面展示配置
 * 
 * Copyright (c) 2024 by wggt, All Rights Reserved. 
 */
package com.wggt.core_bank_service;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "core-bank-service API 文档",
        description = "说明 core-bank-service 的相关API",
        version = "1.0",
        contact = @Contact(
            name = "wggt",
            email = "1213246620@qq.com",
            url = "https://github.com/princewang666"
        ),
        license = @License(
            name = "MIT License",
            url = "https://mit-license.org/"
        )
    ),
    servers = {
        @Server(url = "http://localhost:8080/1", description = "本地服务器一"),
        @Server(url = "http://localhost:8080/2", description = "本地服务器二")
    }
)
public class SpringDocConfig {

}
