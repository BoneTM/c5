package com.bone.c5.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Bone
 * @Package com.bone.c5.entity
 * @date 2020/6/25 14:43
 */

@Data
@NoArgsConstructor
public class Binder {
    private String steam64;

    private String code;
}
