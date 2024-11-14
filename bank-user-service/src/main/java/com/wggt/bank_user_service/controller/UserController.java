/*
 * @Author: princewang666 1213246620@qq.com
 * @Date: 2024-08-22 17:09:40
 * @LastEditors: princewang666 1213246620@qq.com
 * @LastEditTime: 2024-11-14 10:06:39
 * @FilePath: \WGGT_BANK\bank-user-service\src\main\java\com\wggt\bank_user_service\controller\UserController.java
 * @Description: 用户服务controller
 * 
 * Copyright (c) 2024 by wggt, All Rights Reserved. 
 */
package com.wggt.bank_user_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wggt.bank_user_service.model.dto.User;
import com.wggt.bank_user_service.model.dto.request.UserUpdateRequest;
import com.wggt.bank_user_service.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/api/v1/bank-user")
@Tag(name = "Bank User API", description = "关联表用户查询接口")
public class UserController {
    @Autowired
    private UserService userService;

    @Operation(summary = "根据请求信息创建用户", description = "提供用户创建的相关信息，返回创建的用户", 
    parameters = {
        @Parameter(name = "request", description = "请求创建用户体", required = true, schema = @Schema(implementation = User.class))
    }, 
    responses = {
        @ApiResponse(responseCode = "200", description = "创建用户成功", 
            content = @Content(mediaType = "application/json", schema = @Schema(title = "User", description = "User DTO模型", implementation = User.class)))
    })
    @PostMapping(value = "/register")
    public ResponseEntity<User> createUser(@RequestBody User request) {
        return ResponseEntity.ok(userService.creatUser(request));
    }

    @Operation(summary = "根据用户id和更新内容更新用户", description = "提供用户id和更新内容，返回更新后的用户", 
    parameters = {
        @Parameter(name = "userId", description = "用户id", required = true, schema = @Schema(implementation = Long.class)),
        @Parameter(name = "userUpdateRequest", description = "更新请求体", required = true, schema = @Schema(implementation = UserUpdateRequest.class))
    }, 
    responses = {
        @ApiResponse(responseCode = "200", description = "更新用户成功", 
            content = @Content(mediaType = "application/json", schema = @Schema(title = "User", description = "User DTO模型", implementation = User.class)))
    })
    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId, @RequestBody UserUpdateRequest userUpdateRequest) {
        return ResponseEntity.ok(userService.updateUser(userId, userUpdateRequest));
    }

    @Operation(summary = "分页读取用户", description = "提供分页信息，返回读取到的用户", 
    parameters = {
        @Parameter(name = "pageable", description = "分页信息", required = true, schema = @Schema(implementation = Pageable.class))
    }, 
    responses = {
        @ApiResponse(responseCode = "200", description = "分页读取用户成功", 
            content = @Content(mediaType = "application/json", schema = @Schema(title = "List<User>", description = "List<User> 集合DTO模型", type = "array", example = "[User1, User2]", implementation = User.class)))
    })
    @GetMapping
    public ResponseEntity<List<User>> readUsers(Pageable pageable) {
        return ResponseEntity.ok(userService.readUsers(pageable));
    }

    @Operation(summary = "根据id读取用户", description = "提供用户id，返回读取到的用户", 
    parameters = {
        @Parameter(name = "id", description = "用户id", required = true, schema = @Schema(implementation = Long.class))
    }, 
    responses = {
        @ApiResponse(responseCode = "200", description = "读取用户成功", 
            content = @Content(mediaType = "application/json", schema = @Schema(title = "User", description = "User DTO模型", implementation = User.class)))
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> readUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.readUser(id));
    }
}
