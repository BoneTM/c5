package com.bone.c5.service;

import com.bone.c5.dto.user.UserRegisterDTO;

import java.util.List;

/**
 * @author Bone
 * @Package com.bone.c5.service
 * @date 2020/6/27 16:07
 */
public interface LobbyService {
    String create(String username);
    Boolean playerJoin(String username);
    Boolean playerLeave(String username);
    List<String> playerList();
}
