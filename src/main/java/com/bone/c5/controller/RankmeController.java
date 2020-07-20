package com.bone.c5.controller;

import com.bone.c5.service.MatchService;
import com.bone.c5.service.RankmeService;
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
public class RankmeController {
    @Resource
    private MatchService matchService;
    @Resource
    private RankmeService rankmeService;

    @GetMapping("/profile/{steam}")
    public Result getProfile(@PathVariable String steam) {
        return Result.build(RestCodeEnum.SUCCESS).data(rankmeService.getProfile(steam));
    }

    @GetMapping("/profile/{steam}/match")
    public Result getProfileMatch(@PathVariable String steam) {
        return Result.build(RestCodeEnum.SUCCESS).data(matchService.getMatchBySteam(steam));
    }

}
