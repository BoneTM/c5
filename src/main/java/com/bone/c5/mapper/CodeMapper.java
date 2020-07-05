package com.bone.c5.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bone.c5.entity.Code;
import com.bone.c5.entity.Role;
import com.bone.c5.entity.User;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

/**
 * @author Bone
 * @Package com.bone.c5.mapper
 * @date 2020/6/25 14:46
 */
public interface CodeMapper extends BaseMapper<Code> {
    Code getByCode(String code);
    Boolean setSteam64ByCode(String code, String steam64);
    List<Code> getAllUnUse();
}
