package com.bone.c5.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Bone
 * @Package com.bone.c5.entity
 * @date 2020/7/7 14:54
 */
@Entity
@Data
@Table(name = "c5_config")
@NoArgsConstructor
@AllArgsConstructor
public class ConfigEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "message_prefix")
    private String messagePrefix;

    @Column(name = "vip_prefix")
    private String vipPrefix;

    @Column(name = "op_prefix")
    private String opPrefix;
}
