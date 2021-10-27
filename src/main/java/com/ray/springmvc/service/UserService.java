package com.ray.springmvc.service;

import com.ray.springmvc.entity.RegisteredUser;
import com.ray.springmvc.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByUserName(String userName);
    void save(RegisteredUser registeredUser);
}
