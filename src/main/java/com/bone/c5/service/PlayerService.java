package com.bone.c5.service;

import com.bone.c5.entity.PlayerEntity;
import com.bone.c5.vo.player.PlayerDetailVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Bone
 * @Package com.bone.c5.service
 * @date 2020/6/25 14:48
 */
public interface PlayerService {
    PlayerDetailVo getPlayerInfo(String steam);
    Page<PlayerEntity> pagePlayer(Pageable page);
}
