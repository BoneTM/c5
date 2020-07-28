package com.bone.c5.shiro;

import com.bone.c5.entity.AdminEntity;
import com.bone.c5.repository.AdminRepository;
import com.bone.c5.util.RestCodeEnum;
import com.bone.c5.util.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Bone
 * @Package com.bone.c5.shiro
 * @date 2020/7/28 12:22
 */
@Component
public class JWTFilter extends BasicHttpAuthenticationFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String authorization = httpServletRequest.getHeader("Authorization");
        if (StringUtils.isBlank(authorization)) {
            responseError(response);
            return false;
        }
        return true;
    }

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        return super.executeLogin(request, response);
    }

    private void responseError(ServletResponse response) throws IOException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "*");
        httpServletResponse.setContentType("application/json; charset=UTF-8");

        OutputStream os = httpServletResponse.getOutputStream();
        os.write(new ObjectMapper().writeValueAsString(Result.build(RestCodeEnum.UNAUTHORIZED)).getBytes("UTF-8"));
        os.flush();
        os.close();
    }
}
