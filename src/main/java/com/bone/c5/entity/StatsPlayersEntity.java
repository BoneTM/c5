package com.bone.c5.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Bone
 * @Package com.bone.c5.entity
 * @date 2020/7/7 18:31
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "stats_players")
@IdClass(StatsPlayersEntityPK.class)
public class StatsPlayersEntity {
    @Id
    @Column(name = "match_id")
    private int matchId;

    @Id
    @Column(name = "steam64")
    private String steam64;

    @Column(name = "team")
    private String team;

    @Column(name = "rounds_played")
    private short roundsPlayed;

    @Column(name = "name")
    private String name;

    @Column(name = "kills")
    private short kills;

    @Column(name = "deaths")
    private short deaths;

    @Column(name = "assists")
    private short assists;

    @Column(name = "flashbang_assists")
    private short flashbangAssists;

    @Column(name = "teamkills")
    private short teamkills;

    @Column(name = "headshot_kills")
    private short headshotKills;

    @Column(name = "damage")
    private int damage;

    @Column(name = "bomb_plants")
    private short bombPlants;

    @Column(name = "bomb_defuses")
    private short bombDefuses;

    @Column(name = "v1")
    private short v1;

    @Column(name = "v2")
    private short v2;

    @Column(name = "v3")
    private short v3;

    @Column(name = "v4")
    private short v4;

    @Column(name = "v5")
    private short v5;

    @Column(name = "k2")
    private short k2;

    @Column(name = "k3")
    private short k3;

    @Column(name = "k4")
    private short k4;

    @Column(name = "k5")
    private short k5;

    @Column(name = "firstkill_t")
    private short firstkillT;

    @Column(name = "firstkill_ct")
    private short firstkillCt;

    @Column(name = "firstdeath_t")
    private short firstdeathT;

    @Column(name = "firstdeath_ct")
    private short firstdeathCt;


}
