package com.example.potato_serve.config;

import lombok.Getter;

@Getter
public enum ResCodeEnum implements ResponseCodeInterface {
    SUCCESS(0, "成功"),
    WARNING(1, "异常"),
    ERROR(-1, "出错啦"),
    ;

    ResCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private final Integer code;

    private final String msg;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
