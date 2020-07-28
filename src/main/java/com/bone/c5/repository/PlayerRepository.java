package com.bone.c5.repository;

import com.bone.c5.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Bone
 * @Package com.bone.c5.repository
 * @date 2020/6/25 14:46
 */
public interface PlayerRepository extends JpaRepository<PlayerEntity, Integer> {
    Optional<PlayerEntity> findBySteam(String steam);
}
