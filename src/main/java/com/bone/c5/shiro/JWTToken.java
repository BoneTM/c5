package com.bone.c5.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author Bone
 * @Package com.bone.c5.shiro
 * @date 2020/7/28 12:20
 */
public class JWTToken implements AuthenticationToken {
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
