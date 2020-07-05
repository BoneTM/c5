package com.bone.c5.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bone.c5.dto.user.UserRegisterDTO;
import com.bone.c5.entity.Binder;
import com.bone.c5.entity.User;
import com.bone.c5.entity.Vip;
import com.bone.c5.mapper.BinderMapper;
import com.bone.c5.mapper.UserMapper;
import com.bone.c5.service.UserService;
import com.bone.c5.util.BizException;
import com.bone.c5.vo.user.UserInfoVO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * @author Bone
 * @Package com.bone.c5.service
 * @date 2020/6/25 14:47
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private BinderMapper binderMapper;

    @Override
    public Boolean register(UserRegisterDTO userRegisterDTO) {
        Binder binder = binderMapper.getByCode(userRegisterDTO.getCode());
        if (userMapper.getByUsername(userRegisterDTO.getUsername()) != null) {
            throw new BizException("用户名已存在");
        }
        if (binder == null) {
            throw new BizException("绑定码无效");
        }
        if (userMapper.getUserRolesBySteam64(binder.getSteam64()) != null) {
            throw new BizException("绑定码已被使用");
        }

        User user = new User();
        user.setUsername(userRegisterDTO.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode(userRegisterDTO.getPassword()));
        user.setSteam64(binder.getSteam64());
        return this.save(user);
    }

    @Override
    public UserInfoVO getUserInfo(String username) {
        User user = userMapper.getByUsername(username);
        Vip vip = userMapper.getVipTime(user.getSteam64());
        Date date = new Date();
        if (vip != null) {
            date = vip.getTime();
        }
        return UserInfoVO.builder().username(username).vip(date).roles(userMapper.getUserRolesByUserId(user.getId()).stream().map(x -> x.getName()).collect(Collectors.toList())).build();
    }
}
