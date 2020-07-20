package com.bone.c5.controller;

import com.bone.c5.dto.server.ServerAddDTO;
import com.bone.c5.dto.user.UserRegisterDTO;
import com.bone.c5.dto.user.UserUpdateDTO;
import com.bone.c5.service.ServerService;
import com.bone.c5.service.UserService;
import com.bone.c5.util.RestCodeEnum;
import com.bone.c5.util.Result;
import com.ibasco.agql.protocols.valve.source.query.client.SourceQueryClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.net.InetSocketAddress;
import java.security.Principal;

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
    @GetMapping("/server/{serverId}/player")
    public Result getServersPlayers(@PathVariable Integer serverId) {
        return Result.build(RestCodeEnum.SUCCESS).data(serverService.getPlayersByServerId(serverId));
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
