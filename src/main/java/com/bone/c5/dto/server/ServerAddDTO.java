package com.bone.c5.dto.server;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Bone
 * @Package com.bone.c5.dto.server
 * @date 2020/7/8 11:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServerAddDTO {
    @NotBlank(message = "名称不能为空")
    private String name;
    @NotBlank(message = "IP不能为空")
    private String ip;
    @NotNull(message = "端口不能为空")
    private Integer port;
}
