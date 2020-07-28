package com.bone.c5.service.impl;

import com.bone.c5.entity.StatsMatchesEntity;
import com.bone.c5.entity.StatsPlayersEntity;
import com.bone.c5.repository.StatsMatchesRepository;
import com.bone.c5.repository.StatsPlayersRepository;
import com.bone.c5.service.MatchService;
import com.bone.c5.util.BizException;
import com.bone.c5.vo.match.MatchDetailVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Bone
 * @Package com.bone.c5.service
 * @date 2020/6/25 14:47
 */
@Service
public class MatchServiceImpl implements MatchService {
    @Resource
    private StatsMatchesRepository statsMatchesRepository;
    @Resource
    private StatsPlayersRepository statsPlayersRepository;


    @Override
    public MatchDetailVO getMatchDetailById(Integer matchId) {
        List<StatsPlayersEntity> statsPlayersEntities = statsPlayersRepository.findAllByMatchId(matchId).orElseThrow(() -> new BizException("比赛不存在"));
        return new MatchDetailVO(statsMatchesRepository.findById(matchId).orElseThrow(() -> new BizException("比赛不存在")), statsPlayersEntities);
    }

    @Override
    public Page<StatsMatchesEntity> pageMatch(Pageable page) {
        return statsMatchesRepository.findAllByOrderByStartTimeDesc(page);
    }

    @Override
    public List<StatsMatchesEntity> getMatchBySteam(String steam) {
        return statsMatchesRepository.findAllBySteam(steam);
    }

}
