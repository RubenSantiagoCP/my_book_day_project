package com.app.mydaybook.user.infrastructure.adapters.input.rest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.mydaybook.user.application.service.UserQueryService;
import com.app.mydaybook.user.domain.model.User;
import com.app.mydaybook.user.infrastructure.adapters.input.rest.data.response.UserResponse;
import com.app.mydaybook.user.infrastructure.adapters.input.rest.mapper.IUserRestMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserQueryController {
    
    private final UserQueryService userQueryService;
    private final IUserRestMapper userRestMapper;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id){
        User user = userQueryService.getUserById(id);
        return ResponseEntity.ok(userRestMapper.toUserResponse(user));
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        List<User> lstUsers = userQueryService.getAllUsers();
        return ResponseEntity.ok(userRestMapper.toUserResponseList(lstUsers));
    }


}
