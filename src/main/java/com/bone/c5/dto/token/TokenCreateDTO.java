package com.bone.c5.dto.token;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Bone
 * @Package com.bone.c5.dto.token
 * @date 2020/6/26 13:14
 */
@Data
public class TokenCreateDTO {
    @NotNull(message = "用户名不能为空")
    private String username;

    @NotNull(message = "密码不能为空")
    private String password;
}
