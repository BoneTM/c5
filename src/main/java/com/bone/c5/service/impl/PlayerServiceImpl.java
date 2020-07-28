package com.bone.c5.service.impl;

import com.bone.c5.entity.PlayerEntity;
import com.bone.c5.repository.PlayerRepository;
import com.bone.c5.repository.StatsMatchesRepository;
import com.bone.c5.service.PlayerService;
import com.bone.c5.util.BizException;
import com.bone.c5.vo.player.PlayerDetailVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Bone
 * @Package com.bone.c5.service
 * @date 2020/6/25 14:47
 */
@Service
public class PlayerServiceImpl implements PlayerService {
    @Resource
    private PlayerRepository playerRepository;
    @Resource
    private StatsMatchesRepository statsMatchesRepository;

    @Override
    public PlayerDetailVo getPlayerInfo(String steam) {
        return PlayerDetailVo.builder().name("test").matches(statsMatchesRepository.findAllBySteam(steam)).build();
    }

    @Override
    public Page<PlayerEntity> pagePlayer(Pageable page) {
        return playerRepository.findAll(page);
    }
}
