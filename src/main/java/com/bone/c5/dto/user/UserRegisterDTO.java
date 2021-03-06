package com.bone.c5.dto.user;

import lombok.Data;

import javax.validation.constraints.*;

/**
 * @author Bone
 * @Package com.bone.c5.dto.user
 * @date 2020/6/25 18:18
 */
@Data
public class UserRegisterDTO {
    @Size(min = 4, max = 16, message = "用户名长度应处于4~16")
    @Pattern(regexp = "^[A-Za-z0-9_]+$", message = "用户名只能包含数字、英文和下划线")
    @NotBlank(message = "用户名不能为空")
    private String username;

    @Size(min = 1, max = 16, message = "昵称长度应处于1~16")
    @Pattern(regexp = "^[\u4E00-\u9FA5A-Za-z0-9_]+$", message = "昵称只能包含中文、数字、英文和下划线")
    @NotBlank(message = "昵称不能为空")
    private String nickname;

    @Size(min = 6, max = 16, message = "密码长度应处于6~16")
    @NotBlank(message = "密码不能为空")
    private String password;

    @NotBlank(message = "验证码不能为空")
    private String code;

    @Email(message = "邮箱格式异常")
    @NotBlank(message = "邮箱不能为空")
    private String email;
}
