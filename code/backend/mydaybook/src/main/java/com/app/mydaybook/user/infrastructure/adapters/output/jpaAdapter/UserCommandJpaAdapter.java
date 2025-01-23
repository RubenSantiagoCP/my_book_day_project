package com.app.mydaybook.user.infrastructure.adapters.output.jpaAdapter;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import com.app.mydaybook.common.enums.exception.ErrorCode;
import com.app.mydaybook.common.exception.ExceptionManager;
import com.app.mydaybook.user.application.ports.output.IUserCommandPersistentPort;
import com.app.mydaybook.user.domain.model.User;
import com.app.mydaybook.user.infrastructure.adapters.output.jpaAdapter.entity.UserEntity;
import com.app.mydaybook.user.infrastructure.adapters.output.jpaAdapter.mapper.IUserJpaMapper;
import com.app.mydaybook.user.infrastructure.adapters.output.jpaAdapter.repository.IUserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserCommandJpaAdapter implements IUserCommandPersistentPort {

    private final IUserRepository userRepository;
    private final IUserJpaMapper userJpaMapper;
    private final ExceptionManager exceptionManager;

    @Override
    public User createUser(User user) {
        UserEntity userEntity = userJpaMapper.toUserEntity(user);
        try {
            userEntity = userRepository.save(userEntity);
            return userJpaMapper.toUser(userEntity);
        } catch (DataIntegrityViolationException ex) {
            throw exceptionManager.createException(ErrorCode.USERNAME_ALREADY_EXISTS);
        }
    }

    @Override
    public User updateUser(Long id, User user) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> exceptionManager.createException(ErrorCode.USER_NOT_FOUND));
        try {
            userEntity.setName(user.getName());
            userEntity.setSurname(user.getSurname());
            userEntity.setEmail(user.getEmail());
            userEntity = userRepository.save(userEntity);
            return userJpaMapper.toUser(userEntity);
        } catch (DataIntegrityViolationException ex) {
            throw exceptionManager.createException(ErrorCode.USERNAME_ALREADY_EXISTS);
        }
    }

    @Override
    public boolean deleteUser(Long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> exceptionManager.createException(ErrorCode.USER_NOT_FOUND));
        userRepository.delete(userEntity);
        return true;
    }
    
}
