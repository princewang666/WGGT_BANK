package com.wggt.core_bank_service.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.wggt.core_bank_service.model.dto.User;

public interface UserService {
    
    /**
     * 根据 identificationNumber 读取用户
     * @param identificationNumber 识别码
     * @return User DTO类型
     */
    User readUser(String identificationNumber);

    /**
     * 根据 id 读取用户
     * @param id id
     * @return User DTO类型
     */
    User readUser(Long id);

    /**
     * 读取所有用户，分页显示
     * @param pageable 分页参数
     * @return Page<List<User>> DTO类型
     */
    List<User> readUsers(Pageable pageable);
}