/*
 * @Author: princewang666 1213246620@qq.com
 * @Date: 2024-11-06 17:24:24
 * @LastEditors: princewang666 1213246620@qq.com
 * @LastEditTime: 2024-11-06 17:27:40
 * @FilePath: \WGGT_BANK\core-bank-service\src\main\java\com\wggt\core_bank_service\model\entity\UtilityAccountEntity.java
 * @Description: 对公账户实体类
 * 
 * Copyright (c) 2024 by wggt, All Rights Reserved. 
 */
package com.wggt.core_bank_service.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "对公账户实体类")
public class UtilityAccountEntity {
    @Schema(name = "对公账户ID", format = "int64", example = "1")
    private Long id;
    @Schema(name = "个人账户号", example = "6000100080007000300")
    private String number;
    @Schema(name = "提供者姓名", example = "中国银行")
    private String providerName;

}
