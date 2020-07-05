package com.bone.c5.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BizException extends RuntimeException {
    protected Integer code;
    protected String msg;

    public BizException(String msg) {
        this(RestCodeEnum.INVALID_REQUEST.getCode(), msg);
    }

    public BizException() {
        this(RestCodeEnum.INVALID_REQUEST.getCode(), RestCodeEnum.INVALID_REQUEST.getMsg());
    }
}
