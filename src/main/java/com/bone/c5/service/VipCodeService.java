package com.bone.c5.service;

import com.bone.c5.entity.VipCodeEntity;

import java.util.List;

/**
 * @author Bone
 * @Package com.bone.c5.service
 * @date 2020/7/26 21:48
 */
public interface VipCodeService {
    List<VipCodeEntity> getAllUnUseVipCode();
}
