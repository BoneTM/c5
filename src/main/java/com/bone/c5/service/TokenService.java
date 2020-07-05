package com.bone.c5.service;

import com.bone.c5.dto.token.TokenCreateDTO;

public interface TokenService {
    String create(TokenCreateDTO tokenCreateDTO);
}
