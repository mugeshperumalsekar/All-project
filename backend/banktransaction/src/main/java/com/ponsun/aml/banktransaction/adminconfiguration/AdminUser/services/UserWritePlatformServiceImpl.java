package com.ponsun.aml.banktransaction.adminconfiguration.AdminUser.services;


import com.ponsun.aml.banktransaction.accountDetails.data.AppicationException;
import com.ponsun.aml.banktransaction.adminconfiguration.AdminUser.data.UserDataValidator;
import com.ponsun.aml.banktransaction.adminconfiguration.AdminUser.domain.User;
import com.ponsun.aml.banktransaction.adminconfiguration.AdminUser.domain.UserRepository;
import com.ponsun.aml.banktransaction.adminconfiguration.AdminUser.domain.UserRepositoryWrapper;
import com.ponsun.aml.banktransaction.adminconfiguration.AdminUser.request.CreateUserRequest;
import com.ponsun.aml.banktransaction.adminconfiguration.AdminUser.request.UpdateUserRequest;
import com.ponsun.aml.banktransaction.common.entity.Status;
import com.ponsun.aml.banktransaction.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserWritePlatformServiceImpl implements UserWritePlatformService  {

    private final UserRepository userRepository;
    private final UserRepositoryWrapper userRepositoryWrapper;
    private final UserDataValidator userDataValidator;
    @Override
    @Transactional
    public Response createUser(CreateUserRequest createUserRequest) throws AppicationException {
        try {
         this.userDataValidator.validateSaveModuleDet(createUserRequest);
            final User user = User.create(createUserRequest);
            this.userRepository.saveAndFlush(user);
            return Response.of(Integer.valueOf(user.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response updateUser(Integer id, UpdateUserRequest updateUserRequest) throws AppicationException {
        try {
            this.userDataValidator.validateUpdateModuleDet(updateUserRequest);
           final User user = this.userRepositoryWrapper.findOneWithNotFoundDetection(id);
            user.update(updateUserRequest);
             this.userRepository.saveAndFlush(user);
            return Response.of(Integer.valueOf(user.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response blockUser(Integer id) throws AppicationException {
        try {
            final User user = this.userRepositoryWrapper.findOneWithNotFoundDetection(id);
            user.setStatus(Status.DELETE);
            user.setUpdatedAt(LocalDateTime.now());
            this.userRepository.saveAndFlush(user);
            return Response.of(Integer.valueOf(id));
        } catch (DataIntegrityViolationException e) {
            throw new AppicationException(e.getMessage());
        }
    }


    @Override
    @Transactional
    public Response unblockUser(Integer id) throws AppicationException {
        try {
            final User user = this.userRepositoryWrapper.findOneWithNotFoundDetection(id);
            user.setStatus(Status.ACTIVE);
            user.setUpdatedAt(LocalDateTime.now());
            this.userRepository.saveAndFlush(user);
            return Response.of(Integer.valueOf(id));
        } catch (DataIntegrityViolationException e) {
            throw new AppicationException(e.getMessage());
        }
    }

}
