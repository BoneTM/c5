package com.bone.c5.dto.code;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Bone
 * @Package com.bone.c5.dto.code
 * @date 2020/7/3 19:56
 */
@Data
public class CodeUseDTO {
    @NotNull
    private String code;
}
