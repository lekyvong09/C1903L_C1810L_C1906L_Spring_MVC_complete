package com.ray.springmvc.dao;

import com.ray.springmvc.entity.Role;

public interface RoleDAO {
    public Role findRoleByName(String theRoleName);
}
