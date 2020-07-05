package com.bone.c5.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bone.c5.entity.Role;
import com.bone.c5.entity.User;
import com.bone.c5.entity.Vip;

import java.util.Date;
import java.util.List;

/**
 * @author Bone
 * @Package com.bone.c5.mapper
 * @date 2020/6/25 14:46
 */
public interface UserMapper extends BaseMapper<User> {
    User getByUsername(String username);

    List<Role> getUserRolesByUserId(Integer id);

    User getUserRolesBySteam64(String steam64);

    Boolean setVip(String steam64, Integer time);

    Vip getVipTime(String steam64);
}
