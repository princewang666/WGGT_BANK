/*
 * @Author: princewang666 1213246620@qq.com
 * @Date: 2024-11-08 16:24:41
 * @LastEditors: princewang666 1213246620@qq.com
 * @LastEditTime: 2024-11-08 16:43:51
 * @FilePath: \WGGT_BANK\core-bank-service\src\main\java\com\wggt\core_bank_service\model\mapper\BaseMapper.java
 * @Description: Dto 和 Entity 的映射基类
 * 
 * Copyright (c) 2024 by wggt, All Rights Reserved. 
 */
package com.wggt.core_bank_service.model.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class BaseMapper<E, D> {
    public abstract E convertToEntity(D dto);

    public abstract D convertToDto(E entity);

    public Collection<E> convertToEntity(Collection<D> dto) {
        return dto.stream().map(d -> convertToEntity(d)).collect(Collectors.toList());
    }

    public Collection<D> convertToDto(Collection<E> entity) {
        return entity.stream().map(e -> convertToDto(e)).collect(Collectors.toList());
    }

    public List<E> convertToEntityList(Collection<D> dto) {
        return convertToEntity(dto).stream().collect(Collectors.toList());
    }

    public List<D> convertToDtoList(Collection<E> entity) {
        return convertToDto(entity).stream().collect(Collectors.toList());
    }

    public Set<E> convertToEntitySet(Collection<D> dto) {
        return convertToEntity(dto).stream().collect(Collectors.toSet());
    }

    public Set<D> convertToDtoSet(Collection<E> entity) {
        return convertToDto(entity).stream().collect(Collectors.toSet());
    }
}