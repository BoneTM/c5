package com.bone.c5.security;

import com.bone.c5.entity.UserEntity;
import com.bone.c5.repository.UserRepository;
import com.bone.c5.util.BizException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Resource
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userEntityOptional = userRepository.findByUsername(username);
        UserEntity userEntity = userEntityOptional.orElseThrow(() -> new BizException("用户未找到"));
        JwtUserDetails jwtUserDetails = new JwtUserDetails();
        jwtUserDetails.setUsername(userEntity.getUsername());
        jwtUserDetails.setPassword(userEntity.getPassword());
        jwtUserDetails.setRoles(userEntity.getRoles());

        return jwtUserDetails;
    }
}
