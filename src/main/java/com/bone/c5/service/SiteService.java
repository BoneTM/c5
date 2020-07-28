package com.bone.c5.service;

import com.bone.c5.dto.server.ServerAddDTO;
import com.bone.c5.entity.ServerEntity;
import com.bone.c5.vo.server.ServerInfoVO;
import com.bone.c5.vo.site.SiteInfoVO;

import java.util.List;

/**
 * @author Bone
 * @Package com.bone.c5.service
 * @date 2020/7/8 9:50
 */
public interface SiteService {
    SiteInfoVO getSiteInfo();
}
