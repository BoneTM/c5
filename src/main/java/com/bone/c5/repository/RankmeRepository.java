package com.bone.c5.repository;

import com.bone.c5.entity.RankmeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Bone
 * @Package com.bone.c5.repository
 * @date 2020/6/25 14:46
 */
public interface RankmeRepository extends JpaRepository<RankmeEntity, Integer> {
    Optional<RankmeEntity> findBySteam(String steam);
}
