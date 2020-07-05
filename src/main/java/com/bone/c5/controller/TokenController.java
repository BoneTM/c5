package com.bone.c5.controller;

import com.bone.c5.dto.token.TokenCreateDTO;
import com.bone.c5.dto.user.UserRegisterDTO;
import com.bone.c5.service.TokenService;
import com.bone.c5.service.UserService;
import com.bone.c5.util.RestCodeEnum;
import com.bone.c5.util.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Bone
 * @Package com.bone.c5.controller
 * @date 2020/6/25 14:45
 */
@RestController
public class TokenController {
    @Resource
    private TokenService tokenService;

    @PostMapping("/token")
    public Result addToken(@RequestBody @Validated TokenCreateDTO tokenCreateDTO) {
        return Result.build(RestCodeEnum.SUCCESS).data(tokenService.create(tokenCreateDTO));
    }

}
