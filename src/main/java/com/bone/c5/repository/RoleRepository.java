package com.bone.c5.repository;

import com.bone.c5.entity.RoleEntity;
import com.bone.c5.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Bone
 * @Package com.bone.c5.repository
 * @date 2020/6/25 14:46
 */
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
}
