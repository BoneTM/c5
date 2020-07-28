package com.bone.c5.service.impl;

import com.bone.c5.dto.server.ServerAddDTO;
import com.bone.c5.entity.SiteEntity;
import com.bone.c5.repository.SiteRepository;
import com.bone.c5.service.SiteService;
import com.bone.c5.vo.site.SiteInfoVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Bone
 * @Package com.bone.c5.service.impl
 * @date 2020/7/28 14:19
 */
@Service
public class SiteServiceImpl implements SiteService {
    @Resource
    private SiteRepository siteRepository;


    @Override
    public SiteInfoVO getSiteInfo() {
        SiteEntity siteEntity = siteRepository.findByLabel("sitename").orElse(new SiteEntity("sitename", "C5"));

        return SiteInfoVO.builder().siteName(siteEntity.getValue()).build();
    }
}
