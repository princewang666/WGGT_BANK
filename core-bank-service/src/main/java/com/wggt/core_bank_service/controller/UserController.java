package com.wggt.core_bank_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wggt.core_bank_service.model.dto.User;
import com.wggt.core_bank_service.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/api/v1/user")
@Tag(name = "User API", description = "用户查询接口")
public class UserController {
    @Autowired
    private UserService userService;
    
    @Operation(summary = "根据标识号读取用户", description = "提供标识号，返回查询到的用户", 
    parameters = {
        @Parameter(name = "identification", description = "标识号", required = true, example = "1")
    }, 
    responses = {
        @ApiResponse(responseCode = "200", description = "根据标识号读取用户成功", 
            content = @Content(mediaType = "application/json", schema = @Schema(title = "User", description = "User DTO模型", implementation = User.class)))
    })
    @GetMapping(value = "/{identification}")
    public ResponseEntity<User> readUser(@PathVariable("identification") String identification) {
        return ResponseEntity.ok(userService.readUser(identification));
    }

    @Operation(summary = "分页读取所有用户", description = "提供分页信息，返回查询到的所有用户", 
    parameters = {
        @Parameter(name = "pageable", description = "分页信息", required = true)
    }, 
    responses = {
        @ApiResponse(responseCode = "200", description = "分页读取所有用户成功", 
            content = @Content(mediaType = "application/json", schema = @Schema(title = "List<User>", description = "List<User> 集合DTO模型", type = "array", example = "[User1, User2]", implementation = User.class)))
    })
    @GetMapping
    public ResponseEntity<List<User>> readUsers(Pageable pageable) {
        return ResponseEntity.ok(userService.readUsers(pageable));
    }
}
