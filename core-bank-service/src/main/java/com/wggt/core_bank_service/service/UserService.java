package com.wggt.core_bank_service.service;

import com.wggt.core_bank_service.model.dto.User;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(title = "用户服务类")
public interface UserService {
    
    User readUser(String identification);


}