package com.ray.springmvc.dao;

import com.ray.springmvc.entity.User;

public interface UserDAO {
    User findByUserName(String username);

    void save(User user);
}
