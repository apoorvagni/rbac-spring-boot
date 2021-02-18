package com.jianglijie.rbac.enums;

/**
 * Created by jianglj on 2017/5/8.
 */
public enum ResultEnum {
    UNKONW_ERROR(9999, "未知错误"),
    SUCCESS(0, "成功"),
    LOGIN_ERROR(1, "用户名或密码错误"),
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
