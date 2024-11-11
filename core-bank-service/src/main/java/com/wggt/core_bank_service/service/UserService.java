package com.wggt.core_bank_service.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.wggt.core_bank_service.model.dto.User;

public interface UserService {
    
    /**
     * 根据 identificationNumber 读取用户
     * @param identification 
     * @return User DTO类型
     */
    User readUser(String identification);

    /**
     * 读取所有用户，分页显示
     * @param pageable 分页参数
     * @return Page<List<User>> DTO类型
     */
    List<User> readUsers(Pageable pageable);
}