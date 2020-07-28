package com.bone.c5.controller;

import com.bone.c5.dto.admin.LoginDTO;
import com.bone.c5.service.AdminService;
import com.bone.c5.service.SiteService;
import com.bone.c5.util.RestCodeEnum;
import com.bone.c5.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Bone
 * @Package com.bone.c5.controller
 * @date 2020/6/25 14:45
 */
@RestController
public class AdminController {
    @Resource
    private AdminService adminService;

    @PostMapping("/token")
    public Result getSiteInfo(@RequestBody LoginDTO loginDTO) {
        return Result.build(RestCodeEnum.SUCCESS).data(adminService.login(loginDTO));
    }

    @GetMapping("/admin/info")
    public Result getAdminInfo() {
        return Result.build(RestCodeEnum.SUCCESS);
    }
}
