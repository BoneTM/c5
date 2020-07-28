package com.bone.c5.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Bone
 * @Package com.bone.c5.entity
 * @date 2020/7/8 9:53
 */
@Entity
@Table(name = "c5_server")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "ip")
    private String ip;
    @Column(name = "port")
    private int port;
}
