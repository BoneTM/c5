package com.bone.c5.controller;

import com.bone.c5.dto.user.UserChangeNicknameDTO;
import com.bone.c5.dto.user.UserRegisterDTO;
import com.bone.c5.dto.user.UserUpdateDTO;
import com.bone.c5.service.UserService;
import com.bone.c5.util.Result;
import com.bone.c5.util.RestCodeEnum;
import com.bone.c5.vo.user.UserInfoVO;
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
        userService.register(userRegisterDTO);
        return Result.build(RestCodeEnum.CREATED);
    }

    @PutMapping("/user")
    public Result update(@RequestBody @Validated UserUpdateDTO userUpdateDTO, Principal principal) {
        userService.updateUser(userUpdateDTO, principal.getName());
        return Result.build(RestCodeEnum.SUCCESS);
    }

    @PutMapping("/user/nickname")
    public Result updateNickname(@RequestBody @Validated UserChangeNicknameDTO userChangeNicknameDTO, Principal principal) {
        userService.updateUserNickname(userChangeNicknameDTO, principal.getName());
        return Result.build(RestCodeEnum.SUCCESS);
    }

    @GetMapping("/user/info")
    public Result getUserInfo(Principal principal) {
        return Result.build(RestCodeEnum.SUCCESS).data(userService.getUserInfo(principal.getName()));
    }
}
