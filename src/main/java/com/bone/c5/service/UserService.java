package com.bone.c5.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bone.c5.dto.user.UserRegisterDTO;
import com.bone.c5.entity.User;
import com.bone.c5.vo.user.UserInfoVO;

/**
 * @author Bone
 * @Package com.bone.c5.service
 * @date 2020/6/25 14:48
 */
public interface UserService extends IService<User> {
    Boolean register(UserRegisterDTO userRegisterDTO);
    UserInfoVO getUserInfo(String username);
}
