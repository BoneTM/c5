package com.bone.c5.vo.match;

import com.bone.c5.entity.Match;
import com.bone.c5.entity.Player;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author Bone
 * @Package com.bone.c5.vo.match
 * @date 2020/7/4 18:23
 */
@Data
@AllArgsConstructor
public class MatchDetailVO {
    private Match match;
    private List<Player> players;
}
