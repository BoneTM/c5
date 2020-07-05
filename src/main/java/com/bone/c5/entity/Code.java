package com.bone.c5.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Bone
 * @Package com.bone.c5.entity
 * @date 2020/7/3 19:50
 */
@Data
@AllArgsConstructor
public class Code {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String code;
    private Integer time;
    private String steam64;
}
