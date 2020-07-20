package com.bone.c5.service.impl;

import com.bone.c5.dto.user.UserChangeNicknameDTO;
import com.bone.c5.dto.user.UserRegisterDTO;
import com.bone.c5.dto.user.UserUpdateDTO;
import com.bone.c5.entity.BinderEntity;
import com.bone.c5.entity.UserEntity;
import com.bone.c5.entity.VipEntity;
import com.bone.c5.repository.BinderRepository;
import com.bone.c5.repository.UserRepository;
import com.bone.c5.repository.VipRepository;
import com.bone.c5.service.UserService;
import com.bone.c5.util.BizException;
import com.bone.c5.vo.user.UserInfoVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Bone
 * @Package com.bone.c5.service
 * @date 2020/6/25 14:47
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;
    @Resource
    private BinderRepository binderRepository;
    @Resource
    private VipRepository vipRepository;

    @Override
    public UserEntity updateUser(UserUpdateDTO userUpdateDTO, String username) {
        Optional<UserEntity> userEntityOptional = userRepository.findByUsername(username);
        UserEntity userEntity = userEntityOptional.orElseThrow(() -> new BizException("用户未找到"));
        userEntity.setUsername(userUpdateDTO.getUsername());
        userEntity.setNickname(userUpdateDTO.getNickname());
        userEntity.setEmail(userUpdateDTO.getEmail());
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity updateUserNickname(UserChangeNicknameDTO userChangeNicknameDTO, String username) {
        Optional<UserEntity> userEntityOptional = userRepository.findByUsername(username);
        UserEntity userEntity = userEntityOptional.orElseThrow(() -> new BizException("用户未找到"));
        userEntity.setNickname(userChangeNicknameDTO.getNickname());
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity register(UserRegisterDTO userRegisterDTO) {
        Optional<BinderEntity> binderEntityOptional = binderRepository.findByCode(userRegisterDTO.getCode());
        if (userRepository.findByUsername(userRegisterDTO.getUsername()).isPresent()) {
            throw new BizException("用户名已存在");
        }
        BinderEntity binderEntity = binderEntityOptional.orElseThrow(() -> new BizException("绑定码无效"));

        if (userRepository.findBySteam64(binderEntity.getSteam64()).isPresent()) {
            throw new BizException("绑定码已被使用");
        }

        UserEntity userEntity = UserEntity.builder().username(userRegisterDTO.getUsername()).nickname(userRegisterDTO.getNickname())
                .password(new BCryptPasswordEncoder().encode(userRegisterDTO.getPassword()))
                .steam64(binderEntity.getSteam64()).email(userRegisterDTO.getEmail()).build();

        return userRepository.save(userEntity);
    }

    @Override
    public UserInfoVO getUserInfo(String username) {
        Optional<UserEntity> userEntityOptional = userRepository.findByUsername(username);
        UserEntity userEntity = userEntityOptional.orElseThrow(() -> new BizException("用户未找到"));

        Optional<VipEntity> vipEntityOptional = vipRepository.findById(userEntity.getSteam64());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        if (vipEntityOptional.isPresent()) {
            timestamp = vipEntityOptional.get().getTime();
        }

        return UserInfoVO.builder().username(username).vip(timestamp).email(userEntity.getEmail())
                .nickname(userEntity.getNickname()).roles(userEntity.getRoles()
                        .stream().map(x -> x.getName()).collect(Collectors.toList()))
                .steam(userEntity.getSteam64()).build();
    }

    @Override
    public Page<UserEntity> pageUser(Pageable page) {
        return userRepository.findAll(page);
    }
}
