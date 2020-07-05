package com.bone.c5.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bone.c5.entity.Binder;
import com.bone.c5.entity.User;

/**
 * @author Bone
 * @Package com.bone.c5.mapper
 * @date 2020/6/25 14:46
 */
public interface BinderMapper extends BaseMapper<Binder> {
    Binder getByCode(String code);
}
