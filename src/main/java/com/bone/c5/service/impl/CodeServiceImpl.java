package com.bone.c5.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bone.c5.dto.code.CodeCreateDTO;
import com.bone.c5.dto.code.CodeUseDTO;
import com.bone.c5.entity.Code;
import com.bone.c5.mapper.CodeMapper;
import com.bone.c5.mapper.UserMapper;
import com.bone.c5.service.CodeService;
import com.bone.c5.util.BizException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author Bone
 * @Package com.bone.c5.service
 * @date 2020/6/25 14:47
 */
@Service
public class CodeServiceImpl extends ServiceImpl<CodeMapper, Code> implements CodeService {

    @Resource
    private CodeMapper codeMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional
    public String use(String username, CodeUseDTO codeUseDTO) {
        Code code = codeMapper.getByCode(codeUseDTO.getCode());
        if (code == null) {
            throw new BizException("激活码无效");
        } else if (StringUtils.isNotBlank(code.getSteam64())) {
            throw new BizException("激活码已被使用");
        }
        String steam64 = userMapper.getByUsername(username).getSteam64();
        userMapper.setVip(steam64, code.getTime());
        codeMapper.setSteam64ByCode(code.getCode(), steam64);

        return "你的会员有效期：" + userMapper.getVipTime(steam64).getTime();
    }

    @Override
    public List<Code> getAllUnUse() {
        return codeMapper.getAllUnUse();
    }

    @Override
    public List<Code> create(CodeCreateDTO codeCreateDTO) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        List<Code> codes = new ArrayList<>();

        for (int i = 0; i < codeCreateDTO.getNumber(); i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < 9; j++) {
                int number = random.nextInt(62);
                sb.append(str.charAt(number));
            }
            Code code = new Code(-1, sb.toString(), codeCreateDTO.getTime(), "");
            codes.add(code);
            codeMapper.insert(code);
        }
        return codes;
    }
}
