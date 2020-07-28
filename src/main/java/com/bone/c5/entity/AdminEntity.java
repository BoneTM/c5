package com.bone.c5.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Bone
 * @Package com.bone.c5.entity
 * @date 2020/7/7 14:50
 */
@Entity
@Data
@Table(name = "c5_admin")
@NoArgsConstructor
@AllArgsConstructor
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
}
