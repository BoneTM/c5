package com.bone.c5.service;

import com.bone.c5.dto.user.UserChangeNicknameDTO;
import com.bone.c5.dto.user.UserRegisterDTO;
import com.bone.c5.dto.user.UserUpdateDTO;
import com.bone.c5.entity.UserEntity;
import com.bone.c5.vo.user.UserInfoVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Bone
 * @Package com.bone.c5.service
 * @date 2020/6/25 14:48
 */
public interface UserService {
    UserEntity updateUser(UserUpdateDTO userUpdateDTO, String username);
    UserEntity updateUserNickname(UserChangeNicknameDTO userChangeNicknameDTO, String username);
    UserEntity register(UserRegisterDTO userRegisterDTO);
    UserInfoVO getUserInfo(String username);
    Page<UserEntity> pageUser(Pageable page);
}
