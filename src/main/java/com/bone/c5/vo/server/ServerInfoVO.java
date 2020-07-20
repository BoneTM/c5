package com.bone.c5.vo.server;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Bone
 * @Package com.bone.c5.vo.server
 * @date 2020/7/8 10:00
 */
@Data
@Builder
@AllArgsConstructor
public class ServerInfoVO {
    private String ip;
    private Integer port;
    private String name;
    private String map;
    private byte numOfPlayers;
    private byte maxPlayers;
}
