package com.bone.c5.service.impl;

import com.bone.c5.entity.RankmeEntity;
import com.bone.c5.repository.RankmeRepository;
import com.bone.c5.service.RankmeService;
import com.bone.c5.util.BizException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author itar
 * @email wuhandzy@gmail.com
 * @date 2020-07-06 13:49:15
 */
@Service
public class RankmeServiceImpl implements RankmeService {

    @Resource
    public RankmeRepository rankmeRepository;

    @Override
    public RankmeEntity getProfile(String steam) {
        return rankmeRepository.findBySteam(steam).orElseThrow(() -> new BizException("用户未找到"));
    }
}
