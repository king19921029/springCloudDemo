package com.yuanqi.comm;

/**
 * Created by fengqiang on 2019/7/17.
 */

public enum ResponseCode {

    SUCCESS(0, "success", "成功"),
    SYSTEM_ERROR(1002, "system_error", "系统异常");

    private int code;
    private String msg;
    private String description;

    private ResponseCode(int code, String msg, String description) {
        this.code = code;
        this.msg = msg;
        this.description = description;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ResponseCode{");
        sb.append("code=").append(this.code);
        sb.append(", msg='").append(this.msg).append('\'');
        sb.append(", description='").append(this.description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}