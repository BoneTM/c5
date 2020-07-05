package com.bone.c5.controller;

import com.bone.c5.dto.user.UserRegisterDTO;
import com.bone.c5.service.UserService;
import com.bone.c5.util.Result;
import com.bone.c5.util.RestCodeEnum;
import com.bone.c5.vo.user.UserInfoVO;
import net.sourceforge.queried.QueriEd;
import net.sourceforge.queried.ServerInfo;
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
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/user")
    public Result register(@RequestBody @Validated UserRegisterDTO userRegisterDTO) {
        if (userService.register(userRegisterDTO)) {
            return Result.build(RestCodeEnum.CREATED);
        } else {
            return Result.build(RestCodeEnum.CONFLICT).msg("用户名已存在");
        }
    }

    @GetMapping("/user/steam")
    public Result register(@RequestParam("openid.claimed_id") String claimed_id) {
        System.out.println(claimed_id);
        return Result.build(RestCodeEnum.SUCCESS);
    }

    @GetMapping("/user/info")
    public Result getUserInfo(Principal principal) {
        return Result.build(RestCodeEnum.SUCCESS).data(userService.getUserInfo(principal.getName()));
    }

    @GetMapping("/user/test")
    public Result getUserInfo() {

        ServerInfo serverInfo = QueriEd.serverQuery(9998, "HL2", "120.92.155.228", 27016);
        if (serverInfo == null) {
            System.out.println("ServerInfo == null");
        } else {
            System.out.println(serverInfo.getName() + " :: IP: " + serverInfo.getIp()
                    + ":" + serverInfo.getPort() + " :: " + serverInfo.getGame() + " :: Map: " + serverInfo.getMap()
                    + " :: Players: " + serverInfo.getPlayerCount() + "/" + serverInfo.getMaxPlayers());
        }
        return Result.build(RestCodeEnum.SUCCESS).data(serverInfo.getName() + " :: IP: " + serverInfo.getIp()
                + ":" + serverInfo.getPort() + " :: " + serverInfo.getGame() + " :: Map: " + serverInfo.getMap()
                + " :: Players: " + serverInfo.getPlayerCount() + "/" + serverInfo.getMaxPlayers());
    }


}
