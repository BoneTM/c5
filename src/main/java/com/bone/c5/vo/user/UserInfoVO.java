package com.bone.c5.vo.user;

import com.bone.c5.entity.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Bone
 * @Package com.bone.c5.vo.user
 * @date 2020/7/3 19:40
 */
@Data
@Builder
public class UserInfoVO {
    private String username;
    private List<String> roles;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date vip;
}
