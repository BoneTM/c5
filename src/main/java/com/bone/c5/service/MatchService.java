package com.bone.c5.service;

import com.bone.c5.entity.StatsMatchesEntity;
import com.bone.c5.vo.match.MatchDetailVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Bone
 * @Package com.bone.c5.service
 * @date 2020/6/25 14:48
 */
public interface MatchService {
    MatchDetailVO getMatchDetailById(Integer matchId);

    Page<StatsMatchesEntity> pageMatch(Pageable page);
    
    List<StatsMatchesEntity> getMatchBySteam(String steam);
}
