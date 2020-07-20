package com.bone.c5.service;

import com.bone.c5.entity.StatsMatchesEntity;
import com.bone.c5.vo.match.MatchDetailVO;

import java.util.List;

/**
 * @author Bone
 * @Package com.bone.c5.service
 * @date 2020/6/25 14:48
 */
public interface MatchService {
    MatchDetailVO getMatchDetailById(Integer matchId);

    List<StatsMatchesEntity> getAllMatch();

    List<StatsMatchesEntity> getMatchBySteam(String steam);
}
