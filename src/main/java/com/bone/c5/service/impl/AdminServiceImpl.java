package com.bone.c5.service.impl;

import com.bone.c5.dto.admin.LoginDTO;
import com.bone.c5.entity.AdminEntity;
import com.bone.c5.repository.AdminRepository;
import com.bone.c5.service.AdminService;
import com.bone.c5.shiro.JWTUtil;
import com.bone.c5.util.BizException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Bone
 * @Package com.bone.c5.service.impl
 * @date 2020/7/28 14:40
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminRepository adminRepository;

    @Override
    public String login(LoginDTO loginDTO) {
        AdminEntity adminEntity = adminRepository.findByUsername(loginDTO.getUsername()).orElseThrow(() -> new BizException("账号或密码错误"));
        if (!loginDTO.getPassword().equals(adminEntity.getPassword())) {
            throw new BizException("账号或密码错误");
        }
        return JWTUtil.generateToken(adminEntity.getUsername());
    }
}
