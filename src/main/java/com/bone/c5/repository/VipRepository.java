package com.bone.c5.repository;

import com.bone.c5.entity.UserEntity;
import com.bone.c5.entity.VipEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Bone
 * @Package com.bone.c5.repository
 * @date 2020/6/25 14:46
 */
public interface VipRepository extends JpaRepository<VipEntity, String> {
}
