package com.bone.c5.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author Bone
 * @Package com.bone.c5.entity
 * @date 2020/7/7 14:50
 */
@Entity
@Data
@Table(name = "c5_player")
@NoArgsConstructor
@AllArgsConstructor
public class PlayerEntity {
    @Id
    @Column(name = "steam")
    private String steam;

    @Column(name = "vip_time")
    private Timestamp vipTime;
}
