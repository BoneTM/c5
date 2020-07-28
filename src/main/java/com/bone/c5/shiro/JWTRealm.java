package com.bone.c5.shiro;

import com.bone.c5.entity.AdminEntity;
import com.bone.c5.entity.PlayerEntity;
import com.bone.c5.repository.AdminRepository;
import com.bone.c5.repository.StatsMatchesRepository;
import com.bone.c5.util.BizException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Bone
 * @Package com.bone.c5.shiro
 * @date 2020/7/28 12:22
 */
@Component
public class JWTRealm extends AuthorizingRealm {
    @Resource
    private AdminRepository adminRepository;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        String username = JWTUtil.getUsernameFromToken(principals.toString());
//        AdminEntity adminEntity = adminRepository.findByUsername(username).orElseThrow(() -> new AuthenticationException("User didn't existed!"));;
//        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        simpleAuthorizationInfo.addRole(user.getRole());
//        Set<String> permission = new HashSet<>(Arrays.asList(user.getPermission().split(",")));
//        simpleAuthorizationInfo.addStringPermissions(permission);
        return new SimpleAuthorizationInfo();
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String auth = (String) token.getCredentials();
        String username = JWTUtil.getUsernameFromToken(auth);
        if (username == null) {
            throw new AuthenticationException("token invalid");
        }
        AdminEntity adminEntity = adminRepository.findByUsername(username).orElseThrow(() -> new AuthenticationException("User didn't existed!"));

        return new SimpleAuthenticationInfo(auth, auth, "token_realm");
    }
}
