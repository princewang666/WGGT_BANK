/*
 * @Author: princewang666 1213246620@qq.com
 * @Date: 2024-11-06 17:24:24
 * @LastEditors: princewang666 1213246620@qq.com
 * @LastEditTime: 2024-11-11 16:23:04
 * @FilePath: \WGGT_BANK\core-bank-service\src\main\java\com\wggt\core_bank_service\model\entity\UtilityAccountEntity.java
 * @Description: 公共账户实体类
 * 
 * Copyright (c) 2024 by wggt, All Rights Reserved. 
 */
package com.wggt.core_bank_service.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "公共账户实体类")
public class UtilityAccountEntity {
    @Schema(name = "公共账户ID", format = "int64", example = "1")
    private Long id;
    @Schema(name = "账户号", description = "暂时没用到好像")
    private String number;
    @Schema(name = "公共账户名", example = "淘宝网")
    private String providerName;

}
