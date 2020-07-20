package com.bone.c5.repository;

import com.bone.c5.entity.CodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Bone
 * @Package com.bone.c5.repository
 * @date 2020/6/25 14:46
 */
public interface CodeRepository extends JpaRepository<CodeEntity, Integer> {
    Optional<List<CodeEntity>> findAllBySteam64(String steam64);
    Optional<CodeEntity> findByCode(String code);
}
