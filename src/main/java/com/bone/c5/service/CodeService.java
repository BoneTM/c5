package com.bone.c5.service;

import com.bone.c5.dto.code.CodeCreateDTO;
import com.bone.c5.dto.code.CodeUseDTO;
import com.bone.c5.entity.CodeEntity;

import java.util.List;

/**
 * @author Bone
 * @Package com.bone.c5.service
 * @date 2020/6/25 14:48
 */
public interface CodeService {
    String use(String username, CodeUseDTO codeUseDTO);

    List<CodeEntity> getAllUnUse();

    void create(CodeCreateDTO codeCreateDTO);
}
