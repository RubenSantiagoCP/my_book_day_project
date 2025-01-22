package com.app.mydaybook.user.infrastructure.adapters.output.jpaAdapter;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.mydaybook.common.enums.exception.ErrorCode;
import com.app.mydaybook.common.exception.ExceptionManager;
import com.app.mydaybook.user.application.ports.output.IUserQueryPersistentPort;
import com.app.mydaybook.user.domain.model.User;
import com.app.mydaybook.user.infrastructure.adapters.output.jpaAdapter.entity.UserEntity;
import com.app.mydaybook.user.infrastructure.adapters.output.jpaAdapter.mapper.IUserJpaMapper;
import com.app.mydaybook.user.infrastructure.adapters.output.jpaAdapter.repository.IUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserQueryJpaAdapter implements IUserQueryPersistentPort {
    
    private final IUserJpaMapper userJpaMapper;
    private final IUserRepository userRepository;
    private final ExceptionManager exceptionManager;
    
    @Override
    public User getUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> exceptionManager.createException(ErrorCode.USER_NOT_FOUND));
        return userJpaMapper.toUser(userEntity);
    }

    @Override
    public List<User> getAllUsers() {
        List<UserEntity> lstUserEntities = userRepository.findAll();
        return userJpaMapper.toUserList(lstUserEntities);
    }
    
}
