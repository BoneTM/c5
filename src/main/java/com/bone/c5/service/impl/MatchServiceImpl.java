package com.bone.c5.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bone.c5.dto.user.UserRegisterDTO;
import com.bone.c5.entity.Binder;
import com.bone.c5.entity.Match;
import com.bone.c5.entity.Player;
import com.bone.c5.entity.User;
import com.bone.c5.mapper.BinderMapper;
import com.bone.c5.mapper.MatchMapper;
import com.bone.c5.mapper.UserMapper;
import com.bone.c5.service.MatchService;
import com.bone.c5.service.UserService;
import com.bone.c5.vo.match.MatchDetailVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Bone
 * @Package com.bone.c5.service
 * @date 2020/6/25 14:47
 */
@Service
public class MatchServiceImpl extends ServiceImpl<MatchMapper, Match> implements MatchService {
    @Resource
    private MatchMapper matchMapper;


    @Override
    public MatchDetailVO getMatchDetailById(Integer matchId) {
        return new MatchDetailVO(matchMapper.selectById(matchId), matchMapper.getMatchDetailById(matchId));
    }
}
