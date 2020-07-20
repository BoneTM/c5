package com.bone.c5.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Bone
 * @Package com.bone.c5.entity
 * @date 2020/7/7 14:50
 */
@Entity
@Data
@Table(name = "binder")
@NoArgsConstructor
@AllArgsConstructor
public class BinderEntity {
    @Id
    @Column(name = "steam64")
    private String steam64;

    @Column(name = "code")
    private String code;
}
