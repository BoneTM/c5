package com.bone.c5.repository;

import com.bone.c5.entity.StatsMatchesEntity;
import com.bone.c5.entity.StatsPlayersEntity;
import com.bone.c5.entity.StatsPlayersEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Bone
 * @Package com.bone.c5.repository
 * @date 2020/6/25 14:46
 */
public interface StatsPlayersRepository extends JpaRepository<StatsPlayersEntity, StatsPlayersEntityPK> {
    Optional<List<StatsPlayersEntity>> findAllByMatchId(Integer matchId);
}
