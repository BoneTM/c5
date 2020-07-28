package com.bone.c5.service.impl;

import com.bone.c5.entity.VipCodeEntity;
import com.bone.c5.repository.VipCodeRepository;
import com.bone.c5.service.VipCodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Bone
 * @Package com.bone.c5.service.impl
 * @date 2020/7/26 22:16
 */
@Service
public class VipCodeServiceImpl implements VipCodeService {
    @Resource
    private VipCodeRepository vipCodeRepository;


    @Override
    public List<VipCodeEntity> getAllUnUseVipCode() {
        return vipCodeRepository.findAllBySteam("");
    }
}
