package com.bone.c5.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Bone
 * @Package com.bone.c5.entity
 * @date 2020/7/7 18:31
 */
@Data
public class StatsPlayersEntityPK implements Serializable {
    @Id
    @Column(name = "match_id")
    private int matchId;
    @Id
    @Column(name = "steam64")
    private String steam64;
}
