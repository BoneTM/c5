package com.bone.c5.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@TableName("stats_matches")
public class Match {
    @TableId(type = IdType.AUTO)
    private Integer matchId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;
    private String winner;
    private String map;
    private String team1Name;
    private Integer team1Score;
    private String team2Name;
    private Integer team2Score;
}
