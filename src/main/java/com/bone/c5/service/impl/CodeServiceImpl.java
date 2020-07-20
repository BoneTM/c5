package com.bone.c5.service.impl;

import com.bone.c5.dto.code.CodeCreateDTO;
import com.bone.c5.dto.code.CodeUseDTO;
import com.bone.c5.entity.CodeEntity;
import com.bone.c5.entity.VipEntity;
import com.bone.c5.repository.CodeRepository;
import com.bone.c5.repository.UserRepository;
import com.bone.c5.repository.VipRepository;
import com.bone.c5.service.CodeService;
import com.bone.c5.util.BizException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * @author Bone
 * @Package com.bone.c5.service
 * @date 2020/6/25 14:47
 */
@Service
public class CodeServiceImpl implements CodeService {

    @Resource
    private CodeRepository codeRepository;
    @Resource
    private UserRepository userRepository;
    @Resource
    private VipRepository vipRepository;

    @Override
    @Transactional
    public String use(String username, CodeUseDTO codeUseDTO) {
        CodeEntity codeEntity = codeRepository.findByCode(codeUseDTO.getCode()).orElseThrow(() -> new BizException("激活码无效"));
        if (StringUtils.isNotBlank(codeEntity.getSteam64())) {
            throw new BizException("激活码已被使用");
        }
        String steam64 = userRepository.findByUsername(username).orElseThrow(() -> new BizException("用户未找到")).getSteam64();
        VipEntity vipEntity = vipRepository.findById(steam64).orElse(new VipEntity(steam64, new Timestamp(System.currentTimeMillis())));
        Calendar c = Calendar.getInstance();
        c.setTime(vipEntity.getTime());
        c.add(Calendar.DATE, codeEntity.getTime());
        vipEntity.setTime(new Timestamp(c.getTimeInMillis()));
        vipRepository.save(vipEntity);
        codeEntity.setSteam64(steam64);
        codeRepository.save(codeEntity);

        return "你的会员有效期：" + vipRepository.findById(steam64).orElseThrow(() -> new BizException("用户vip数据未找到")).getTime();
    }

    @Override
    public List<CodeEntity> getAllUnUse() {
        return codeRepository.findAllBySteam64("").get();
    }

    @Override
    public void create(CodeCreateDTO codeCreateDTO) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();

        for (int i = 0; i < codeCreateDTO.getNumber(); i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < 9; j++) {
                int number = random.nextInt(62);
                sb.append(str.charAt(number));
            }
            CodeEntity code = new CodeEntity(-1, sb.toString(), codeCreateDTO.getTime(), "");
            codeRepository.save(code);
        }
    }
}
