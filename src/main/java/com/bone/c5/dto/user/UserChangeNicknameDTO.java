package com.bone.c5.dto.user;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Bone
 * @Package com.bone.c5.dto.user
 * @date 2020/6/25 18:18
 */
@Data
public class UserChangeNicknameDTO {
    @Size(min = 1, max = 16, message = "昵称长度应处于1~16")
    @Pattern(regexp = "^[\u4E00-\u9FA5A-Za-z0-9_]+$", message = "昵称只能包含中文、数字、英文和下划线")
    @NotBlank(message = "昵称不能为空")
    private String nickname;
}
