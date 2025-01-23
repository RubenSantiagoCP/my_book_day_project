package com.app.mydaybook.user.infrastructure.adapters.input.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.mydaybook.user.application.service.UserCommandService;
import com.app.mydaybook.user.domain.model.User;
import com.app.mydaybook.user.infrastructure.adapters.input.rest.data.request.UserRequest;
import com.app.mydaybook.user.infrastructure.adapters.input.rest.data.response.UserResponse;
import com.app.mydaybook.user.infrastructure.adapters.input.rest.mapper.IUserRestMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserCommandController {
    
    private final UserCommandService userCommandService;
    private final IUserRestMapper userRestMapper;

    @PostMapping("/create")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) { 
        User user = userRestMapper.toUser(userRequest);
        user = userCommandService.createUser(user);
        return ResponseEntity.ok(userRestMapper.toUserResponse(user));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest userRequest, @PathVariable Long id) { 
        User user = userRestMapper.toUser(userRequest);
        user = userCommandService.updateUser(id, user);
        return ResponseEntity.ok(userRestMapper.toUserResponse(user));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id) { 
        Boolean deleted = userCommandService.deleteUser(id);
        return ResponseEntity.ok(deleted);
    }
}
