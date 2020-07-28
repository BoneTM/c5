package com.bone.c5.controller;

import com.bone.c5.dto.admin.LoginDTO;
import com.bone.c5.service.AdminService;
import com.bone.c5.service.VipCodeService;
import com.bone.c5.util.RestCodeEnum;
import com.bone.c5.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Bone
 * @Package com.bone.c5.controller
 * @date 2020/6/25 14:45
 */
@RestController
public class VipCodeController {
    @Resource
    private VipCodeService vipCodeService;

    @PostMapping("/admin/vipcode")
    public Result getSiteInfo(@RequestBody LoginDTO loginDTO) {
        return Result.build(RestCodeEnum.SUCCESS);
    }

    @GetMapping("/admin/vipcode")
    public Result getAdminInfo() {
        return Result.build(RestCodeEnum.SUCCESS).data(vipCodeService.getAllUnUseVipCode());
    }
}
