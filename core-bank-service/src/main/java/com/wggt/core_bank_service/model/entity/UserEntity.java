/*
 * @Author: princewang666 1213246620@qq.com
 * @Date: 2024-11-06 15:39:09
 * @LastEditors: princewang666 1213246620@qq.com
 * @LastEditTime: 2024-11-06 17:13:40
 * @FilePath: \WGGT_BANK\core-bank-service\src\main\java\com\wggt\core_bank_service\model\entity\UserEntity.java
 * @Description: 用户实体类
 * 
 * Copyright (c) 2024 by wggt, All Rights Reserved. 
 */
package com.wggt.core_bank_service.model.entity;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "用户实体类")
public class UserEntity {
    @Schema(name = "用户ID", format = "int64", example = "1")
    private Long id;
    @Schema(name = "用户名", example = "Donald")
    private String firstName;
    @Schema(name = "用户姓", example = "Trump")
    private String lastName;
    @Schema(name = "邮件", example = "11115555@qq.com")
    private String email;
    @Schema(name = "识别号", description = "用于识别用户(暂时不知)")
    private String identificationNumber;
    @Schema(name = "用户账户", description = "用户名下的所有账户(List类型)", type = "array", example = "[BankAccountEntity1, BankAccountEntity2]", implementation = BankAccountEntity.class)
    private List<BankAccountEntity> accounts;
}
