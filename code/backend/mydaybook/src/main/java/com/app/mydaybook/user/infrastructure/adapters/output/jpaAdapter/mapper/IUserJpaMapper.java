package com.app.mydaybook.user.infrastructure.adapters.output.jpaAdapter.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.app.mydaybook.user.domain.model.User;
import com.app.mydaybook.user.infrastructure.adapters.output.jpaAdapter.entity.UserEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserJpaMapper {
    
    @Mapping(target = "tasks", ignore = true)
    @Mapping(target = "habits", ignore = true)
    @Mapping(target = "categories", ignore = true)
    User toUser(UserEntity userEntity);

    @Mapping(target = "tasks", ignore = true)
    @Mapping(target = "habits", ignore = true)
    @Mapping(target = "categories", ignore = true)
    UserEntity toUserEntity(User user);

    @Mapping(target = "tasks", ignore = true)
    @Mapping(target = "habits", ignore = true)
    @Mapping(target = "categories", ignore = true)
    List<User> toUserList(List<UserEntity> lstUserEntities);

    @Mapping(target = "tasks", ignore = true)
    @Mapping(target = "habits", ignore = true)
    @Mapping(target = "categories", ignore = true)
    List<UserEntity> toUserEntities(List<User> users);
}
