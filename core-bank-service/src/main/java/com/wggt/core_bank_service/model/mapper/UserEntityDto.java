package com.wggt.core_bank_service.model.mapper;

import org.springframework.beans.BeanUtils;

import com.wggt.core_bank_service.model.dto.User;
import com.wggt.core_bank_service.model.entity.UserEntity;

public class UserEntityDto extends BaseMapper<UserEntity, User>{
    private BankAccountEntityDto bankAccountEntityDto = new BankAccountEntityDto();

    @Override
    public UserEntity convertToEntity(User dto) {
        UserEntity entity = new UserEntity();
        if (dto != null) {
            BeanUtils.copyProperties(dto, entity, "accounts");
            entity.setAccounts(bankAccountEntityDto.convertToEntityList(dto.getBankAccounts()));
        }
        return entity;
    }

    @Override
    public User convertToDto(UserEntity entity) {
        User dto = new User();
        if (entity != null) {
            BeanUtils.copyProperties(entity, dto, "accounts");
            dto.setBankAccounts(bankAccountEntityDto.convertToDtoList(entity.getAccounts()));
        }
        return dto;
    }
    
}
