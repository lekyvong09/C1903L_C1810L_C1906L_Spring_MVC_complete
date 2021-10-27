package com.ray.springmvc.service;

import com.ray.springmvc.dao.UserDAO;
import com.ray.springmvc.entity.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    private UserDAO userDAO;

    @Autowired
    public MyUserDetailsService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.ray.springmvc.entity.User user = userDAO.findByUserName(username);
        List<Authority> authorityList = user.getAuthorities();

        List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
        for (Authority authority : authorityList) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthority());
            grantedAuthorityList.add(grantedAuthority);
        }

        UserDetails userDetails = new User(user.getUsername(), user.getPassword(), grantedAuthorityList);
        return userDetails;
    }
}
