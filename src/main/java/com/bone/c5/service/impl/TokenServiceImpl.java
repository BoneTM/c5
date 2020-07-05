package com.bone.c5.service.impl;

import com.bone.c5.dto.token.TokenCreateDTO;
import com.bone.c5.security.JwtTokenUtil;
import com.bone.c5.security.JwtUserDetailsService;
import com.bone.c5.service.TokenService;
import com.bone.c5.util.BizException;
import com.bone.c5.util.RestCodeEnum;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Bone
 * @Package com.bone.c5.service.impl
 * @date 2020/6/26 13:14
 */
@Service
public class TokenServiceImpl implements TokenService {
    @Resource
    private JwtUserDetailsService jwtUserDetailsService;

    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Resource
    private AuthenticationManager authenticationManager;

    @Override
    public String create(TokenCreateDTO tokenCreateDTO) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(tokenCreateDTO.getUsername(), tokenCreateDTO.getPassword()));
        } catch (Exception e) {
            throw new BizException("账号或密码错误");
        }
        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(tokenCreateDTO.getUsername());
        return jwtTokenUtil.generateToken(userDetails);
    }
}
