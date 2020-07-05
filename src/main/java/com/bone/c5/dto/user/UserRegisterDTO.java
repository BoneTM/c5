package com.bone.c5.dto.user;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Bone
 * @Package com.bone.c5.dto.user
 * @date 2020/6/25 18:18
 */
@Data
public class UserRegisterDTO {
    @NotNull(message = "用户名不能为空")
    private String username;
    @NotNull(message = "密码不能为空")
    private String password;
    @NotNull(message = "验证码不能为空")
    private String code;
}
