package com.bone.c5.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Bone
 * @Package com.bone.c5.entity
 * @date 2020/7/7 14:54
 */
@Entity
@Data
@Table(name = "c5_vip_code")
@NoArgsConstructor
@AllArgsConstructor
public class VipCodeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "time")
    private Integer time;

    @Column(name = "steam")
    private String steam;
}
