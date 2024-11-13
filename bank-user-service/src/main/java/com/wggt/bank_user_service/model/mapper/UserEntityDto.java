package com.wggt.bank_user_service.model.mapper;

import org.springframework.beans.BeanUtils;

import com.wggt.bank_user_service.model.dto.User;
import com.wggt.bank_user_service.model.entity.UserEntity;

public class UserEntityDto extends BaseEntityDto<UserEntity, User> {

    @Override
    public UserEntity convertToEntity(User dto) {
        UserEntity userEntity = new UserEntity();
        if (dto != null) {
            BeanUtils.copyProperties(dto, userEntity);
        }
        return userEntity;
    }

    @Override
    public User convertToDto(UserEntity entity) {
        User user = new User();
        if (entity != null) {
            BeanUtils.copyProperties(entity, user);
        }
        return user;
    }
    
}
