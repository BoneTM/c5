package com.bone.c5.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bone.c5.dto.code.CodeCreateDTO;
import com.bone.c5.dto.code.CodeUseDTO;
import com.bone.c5.entity.Code;

import java.util.List;

/**
 * @author Bone
 * @Package com.bone.c5.service
 * @date 2020/6/25 14:48
 */
public interface CodeService extends IService<Code> {
    String use(String username, CodeUseDTO codeUseDTO);
    List<Code> getAllUnUse();
    List<Code> create(CodeCreateDTO codeCreateDTO);
}
