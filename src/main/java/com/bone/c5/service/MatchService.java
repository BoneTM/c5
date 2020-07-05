package com.bone.c5.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bone.c5.dto.user.UserRegisterDTO;
import com.bone.c5.entity.Match;
import com.bone.c5.entity.Player;
import com.bone.c5.entity.User;
import com.bone.c5.vo.match.MatchDetailVO;

import java.util.List;

/**
 * @author Bone
 * @Package com.bone.c5.service
 * @date 2020/6/25 14:48
 */
public interface MatchService extends IService<Match> {
    MatchDetailVO getMatchDetailById(Integer matchId);
}
