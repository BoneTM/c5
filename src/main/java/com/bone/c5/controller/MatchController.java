package com.bone.c5.controller;

import com.bone.c5.service.MatchService;
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
public class MatchController {
    @Resource
    private MatchService matchService;

    @GetMapping("/match")
    public Result getMatches() {
        return Result.build(RestCodeEnum.SUCCESS).data(matchService.getAllMatch());
    }

    @GetMapping("/match/{matchId}")
    public Result getMatchDetailById(@PathVariable String matchId) {
        return Result.build(RestCodeEnum.SUCCESS).data(matchService.getMatchDetailById(Integer.parseInt(matchId)));
    }
}
