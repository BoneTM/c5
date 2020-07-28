package com.bone.c5.repository;

import com.bone.c5.entity.AdminEntity;
import com.bone.c5.entity.SiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Bone
 * @Package com.bone.c5.repository
 * @date 2020/6/25 14:46
 */
public interface SiteRepository extends JpaRepository<SiteEntity, Integer> {
    Optional<SiteEntity> findByLabel(String label);
}
