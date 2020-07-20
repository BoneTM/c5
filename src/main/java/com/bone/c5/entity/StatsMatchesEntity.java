package com.bone.c5.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "stats_matches")
@NoArgsConstructor
@AllArgsConstructor
public class StatsMatchesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private Integer matchId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "start_time")
    private Timestamp startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "end_time")
    private Timestamp endTime;

    @Column(name = "winner")
    private String winner;

    @Column(name = "map")
    private String map;

    @Column(name = "team1_name")
    private String team1Name;

    @Column(name = "team1_score")
    private short team1Score;

    @Column(name = "team2_name")
    private String team2Name;

    @Column(name = "team2_score")
    private short team2Score;

}
