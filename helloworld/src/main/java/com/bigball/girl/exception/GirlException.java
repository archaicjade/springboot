package com.bigball.girl.exception;

import com.bigball.girl.enums.ResultEnum;

public class GirlException extends RuntimeException {


    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();

    }

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


}
