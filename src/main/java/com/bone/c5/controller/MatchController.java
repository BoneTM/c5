package com.bone.c5.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bone.c5.dto.user.UserRegisterDTO;
import com.bone.c5.entity.Match;
import com.bone.c5.service.MatchService;
import com.bone.c5.service.UserService;
import com.bone.c5.util.RestCodeEnum;
import com.bone.c5.util.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Principal;

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
        return Result.build(RestCodeEnum.SUCCESS).data(matchService.list(new QueryWrapper<Match>().orderByDesc("start_time")));
    }

    @GetMapping("/match/{matchId}")
    public Result getMatchDetailById(@PathVariable String matchId) {
        return Result.build(RestCodeEnum.SUCCESS).data(matchService.getMatchDetailById(Integer.parseInt(matchId)));
    }
}
