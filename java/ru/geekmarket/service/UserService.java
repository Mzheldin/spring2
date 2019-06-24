package com.geekbrains.spring2.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.geekbrains.spring2.service.model.SystemUser;

import java.util.List;

public interface UserService extends UserDetailsService {

    SystemUser findById(Long id);

    SystemUser findByUserName(String username);

    boolean save(SystemUser systemUser);

    List<SystemUser> findAll();

    boolean deleteUser(Long id);
}