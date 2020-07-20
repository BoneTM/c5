package com.bone.c5.repository;

import com.bone.c5.entity.StatsMatchesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author Bone
 * @Package com.bone.c5.repository
 * @date 2020/6/25 14:46
 */
public interface StatsMatchesRepository extends JpaRepository<StatsMatchesEntity, Integer> {
    Optional<List<StatsMatchesEntity>> findAllByOrderByStartTimeDesc();

    @Query("select m from StatsPlayersEntity p, StatsMatchesEntity m where p.steam64 = :steam and p.matchId = m.matchId order by m.startTime desc ")
    Optional<List<StatsMatchesEntity>> findAllBySteam(@Param("steam") String steam);
}
