package com.bone.c5.security;

import com.bone.c5.entity.User;
import com.bone.c5.mapper.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userMapper.getByUsername(username);
        JwtUserDetails jwtUserDetails = new JwtUserDetails();
        jwtUserDetails.setUsername(user.getUsername());
        jwtUserDetails.setPassword(user.getPassword());
        jwtUserDetails.setRoles(userMapper.getUserRolesByUserId(user.getId()));

        return jwtUserDetails;
    }
}
