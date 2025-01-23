package com.app.mydaybook.user.infrastructure.adapters.input.rest.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.app.mydaybook.user.domain.model.User;
import com.app.mydaybook.user.infrastructure.adapters.input.rest.data.request.UserRequest;
import com.app.mydaybook.user.infrastructure.adapters.input.rest.data.response.UserResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserRestMapper {
    User toUser(UserRequest userRequest);

    UserRequest toUserRequest(User user);

    UserResponse toUserResponse(User user);

    List<UserResponse> toUserResponseList(List<User> users);

} 