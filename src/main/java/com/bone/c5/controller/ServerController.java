package com.bone.c5.controller;

import com.bone.c5.dto.server.ServerAddDTO;
import com.bone.c5.service.ServerService;
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
public class ServerController {
    @Resource
    private ServerService serverService;

    @GetMapping("/server")
    public Result getServersInfo() {
        return Result.build(RestCodeEnum.SUCCESS).data(serverService.list());
    }

    @GetMapping("/server/{serverId}")
    public Result getServersInfo(@PathVariable Integer serverId) {
        return Result.build(RestCodeEnum.SUCCESS).data(serverService.getInfoByServerId(serverId));
    }

    @GetMapping("/admin/server")
    public Result getServers() {
        return Result.build(RestCodeEnum.SUCCESS).data(serverService.list());
    }

    @PostMapping("/admin/server")
    public Result addServer(@RequestBody @Validated ServerAddDTO serverAddDTO) {
        serverService.add(serverAddDTO);
        return Result.build(RestCodeEnum.SUCCESS);
    }
}
