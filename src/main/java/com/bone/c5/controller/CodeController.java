package com.bone.c5.controller;

import com.bone.c5.dto.code.CodeCreateDTO;
import com.bone.c5.dto.code.CodeUseDTO;
import com.bone.c5.dto.user.UserRegisterDTO;
import com.bone.c5.service.CodeService;
import com.bone.c5.service.UserService;
import com.bone.c5.util.RestCodeEnum;
import com.bone.c5.util.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Principal;

/**
 * @author Bone
 * @Package com.bone.c5.controller
 * @date 2020/6/25 14:45
 */
@RestController
public class CodeController {
    @Resource
    private CodeService codeService;

    @PostMapping("/admin/code")
    public Result createCode(@RequestBody @Validated CodeCreateDTO codeCreateDTO) {
        codeService.create(codeCreateDTO);
        return Result.build(RestCodeEnum.SUCCESS);
    }

    @GetMapping("/admin/code")
    public Result getCodes() {
        return Result.build(RestCodeEnum.SUCCESS).data(codeService.getAllUnUse());
    }

    @PutMapping("/code")
    public Result useCode(Principal principal, @RequestBody @Validated CodeUseDTO codeUseDTO) {
        return Result.build(RestCodeEnum.SUCCESS).data(codeService.use(principal.getName(), codeUseDTO));
    }

}
