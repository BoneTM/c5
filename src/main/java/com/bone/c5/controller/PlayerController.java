package com.bone.c5.controller;

import com.bone.c5.service.PlayerService;
import com.bone.c5.util.Result;
import com.bone.c5.util.RestCodeEnum;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Bone
 * @Package com.bone.c5.controller
 * @date 2020/6/25 14:45
 */
@RestController
public class PlayerController {
    @Resource
    private PlayerService playerService;

    @GetMapping("/player/{steam}")
    public Result update(@PathVariable String steam) {
        playerService.getPlayerInfo(steam);
        return Result.build(RestCodeEnum.SUCCESS);
    }

}
