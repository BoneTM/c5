package com.bone.c5.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Bone
 * @Package com.bone.c5.entity
 * @date 2020/7/7 14:54
 */
@Entity
@Data
@Table(name = "code")
@NoArgsConstructor
@AllArgsConstructor
public class CodeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "time")
    private int time;

    @Column(name = "steam64")
    private String steam64;

}
