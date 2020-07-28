package com.bone.c5.vo.player;

import com.bone.c5.entity.StatsMatchesEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Bone
 * @Package com.bone.c5.vo.player
 * @date 2020/7/26 22:13
 */
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PlayerDetailVo {
    private String name;
    private List<StatsMatchesEntity> matches;
}
