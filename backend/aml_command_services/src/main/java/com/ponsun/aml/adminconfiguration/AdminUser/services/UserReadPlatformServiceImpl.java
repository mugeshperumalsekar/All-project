package com.ponsun.aml.adminconfiguration.AdminUser.services;


import com.ponsun.aml.adminconfiguration.AdminUser.domain.User;
import com.ponsun.aml.adminconfiguration.AdminUser.domain.UserRepository;
import com.ponsun.aml.adminconfiguration.AdminUser.domain.UserRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserReadPlatformServiceImpl implements UserReadPlatformService {

    private final UserRepositoryWrapper userRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final UserRepository userRepository;

    @Override
    public User fetchUserById(Integer id){return this.userRepository.findById(id).get();}

    @Override
    public List<User> fetchAllUsers(){
        return this.userRepository.findAll();
    }
}
