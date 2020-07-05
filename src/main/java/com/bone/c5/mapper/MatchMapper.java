package com.bone.c5.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bone.c5.entity.Match;
import com.bone.c5.entity.Player;

import java.util.List;

/**
 * @author Bone
 * @Package com.bone.c5.mapper
 * @date 2020/6/25 14:46
 */
public interface MatchMapper extends BaseMapper<Match> {
    List<Player> getMatchDetailById(Integer matchId);
}
