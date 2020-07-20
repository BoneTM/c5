package com.bone.c5.repository;

import com.bone.c5.entity.ServerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Bone
 * @Package com.bone.c5.repository
 * @date 2020/6/25 14:46
 */
public interface ServerRepository extends JpaRepository<ServerEntity, Integer> {
}
