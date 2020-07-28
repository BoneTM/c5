package com.bone.c5.controller;

import com.bone.c5.dto.server.ServerAddDTO;
import com.bone.c5.service.ServerService;
import com.bone.c5.service.SiteService;
import com.bone.c5.util.RestCodeEnum;
import com.bone.c5.util.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Bone
 * @Package com.bone.c5.controller
 * @date 2020/6/25 14:45
 */
@RestController
public class SiteController {
    @Resource
    private SiteService siteService;

    @GetMapping("/site")
    public Result getSiteInfo() {
        return Result.build(RestCodeEnum.SUCCESS).data(siteService.getSiteInfo());
    }

    @GetMapping("/admin/site")
    public Result getAllSiteInfo() {
        return Result.build(RestCodeEnum.SUCCESS).data(siteService.getSiteInfo());
    }
}
