package com.bigball.girl.util;

import com.bigball.girl.domain.Result;

public class ResultUtil {

    public static final Result result = new Result();

    public static Result success(Object object) {

        result.setCode(1);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        result.setCode(0);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

}
