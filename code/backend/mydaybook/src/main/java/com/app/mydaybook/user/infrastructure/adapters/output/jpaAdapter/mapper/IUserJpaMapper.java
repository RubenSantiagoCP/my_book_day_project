package com.app.mydaybook.user.infrastructure.adapters.output.jpaAdapter.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.app.mydaybook.user.domain.model.User;
import com.app.mydaybook.user.infrastructure.adapters.output.jpaAdapter.entity.UserEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserJpaMapper {
    
    User toUser(UserEntity userEntity);

    UserEntity toUserEntity(User user);

    List<User> toUserList(List<UserEntity> lstUserEntities);

    List<UserEntity> toUserEntities(List<User> users);
}
