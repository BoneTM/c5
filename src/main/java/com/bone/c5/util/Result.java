package com.bone.c5.util;

import java.util.HashMap;

/**
 * @author Bone
 */
public class Result extends HashMap<String, Object> {

    public Result(RestCodeEnum restCodeEnum) {
        super.put("code", restCodeEnum.getCode());
        super.put("msg", restCodeEnum.getMsg());
    }

    public static Result build(RestCodeEnum restCodeEnum) {
        return new Result(restCodeEnum);
    }
    public Result data(Object object) {
        super.put("data", object);
        return this;
    }

    public Result msg(String msg) {
        super.put("msg", msg);
        return this;
    }

}
