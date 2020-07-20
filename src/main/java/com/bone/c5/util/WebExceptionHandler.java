package com.bone.c5.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WebExceptionHandler {
    @ExceptionHandler
    public Result bizException(BizException bizException) {
        return new Result(RestCodeEnum.INVALID_REQUEST).msg(bizException.getMsg());
    }

    @ExceptionHandler
    public Result bindException(MethodArgumentNotValidException e) {
        StringBuilder msg = new StringBuilder();
        e.getBindingResult().getFieldErrors().forEach(x -> msg.append(x.getDefaultMessage() + "."));
        return new Result(RestCodeEnum.INVALID_REQUEST).msg(msg.toString());
    }

    @ExceptionHandler
    public Result unknownException(Exception e) {
        e.printStackTrace();
        return new Result(RestCodeEnum.INTERNAL_SERVER_ERROR);
    }
}
