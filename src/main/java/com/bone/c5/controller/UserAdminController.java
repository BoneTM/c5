package com.bone.c5.controller;

import com.bone.c5.dto.user.UserRegisterDTO;
import com.bone.c5.dto.user.UserUpdateDTO;
import com.bone.c5.service.UserService;
import com.bone.c5.util.RestCodeEnum;
import com.bone.c5.util.Result;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
@RequestMapping("/admin")
public class UserAdminController {
    @Resource
    private UserService userService;

    @PostMapping("/user")
    public Result addUser(@RequestBody @Validated UserRegisterDTO userRegisterDTO) {
        userService.register(userRegisterDTO);
        return Result.build(RestCodeEnum.CREATED);
    }

    @PutMapping("/user")
    public Result updateUser(@RequestBody @Validated UserUpdateDTO userUpdateDTO, Principal principal) {
        userService.updateUser(userUpdateDTO, principal.getName());
        return Result.build(RestCodeEnum.SUCCESS);
    }

    @DeleteMapping("/user")
    public Result removeUser(@RequestBody @Validated UserUpdateDTO userUpdateDTO, Principal principal) {
        userService.updateUser(userUpdateDTO, principal.getName());
        return Result.build(RestCodeEnum.SUCCESS);
    }

    @GetMapping("/user")
    public Result getAllUser(Pageable pageable) {
        System.out.println(pageable);
        return Result.build(RestCodeEnum.SUCCESS).data(userService.pageUser(pageable));
    }
}
