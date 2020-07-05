package com.bone.c5.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Bone
 * @Package com.bone.c5.entity
 * @date 2020/7/2 17:08
 */
@Data
@NoArgsConstructor
@TableName("stats_players")
public class Player {
    private Integer matchId;
    private String steam64;
    private String team;
    private Integer roundsPlayed;
    private String name;
    private Integer kills;
    private Integer deaths;
    private Integer assists;
    private Integer flashbangAssists;
    private Integer teamkills;
    private Integer headshotKills;
    private Integer damage;
    private Integer bombPlants;
    private Integer bombDefuses;
    private Integer v1;
    private Integer v2;
    private Integer v3;
    private Integer v4;
    private Integer v5;
    private Integer k2;
    private Integer k3;
    private Integer k4;
    private Integer k5;
    private Integer firstkillT;
    private Integer firstkillCt;
    private Integer firstdeathT;
    private Integer firstdeathCt;
}
