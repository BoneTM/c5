package com.bone.c5.service;

import com.bone.c5.dto.admin.LoginDTO;
import com.bone.c5.vo.site.SiteInfoVO;

/**
 * @author Bone
 * @Package com.bone.c5.service
 * @date 2020/7/8 9:50
 */
public interface AdminService {
    String login(LoginDTO loginDTO);
}
