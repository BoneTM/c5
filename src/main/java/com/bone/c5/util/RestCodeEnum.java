package com.bone.c5.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Bone
 */

@AllArgsConstructor
@Getter
public enum RestCodeEnum {
    SUCCESS(200, "ok"),
    CREATED(201, "created"),
    DELETED(204, "deleted"),
    INVALID_REQUEST(400, "invalid request"),
    UNAUTHORIZED(401, "unauthorized"),
    CONFLICT(409, "conflict"),
    INTERNAL_SERVER_ERROR(500, "internal server error"),
    SERVER_BUSY(503, "server busy");

    private Integer code;
    private String msg;

}
