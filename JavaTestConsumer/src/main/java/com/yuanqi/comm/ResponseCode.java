package com.yuanqi.comm;

/**
 * Created by fengqiang on 2019/7/26.
 */
public enum ResponseCode {

    SUCCESS(0, "success", "成功"),
    SYSTEM_ERROR(1002, "system_error", "系统异常"),
    PARAM_ERROR(1003, "param_error", "参数异常"),
    SQL_ERROR(1004, "sql_error", "数据库异常"),
    NEED_LOGIN(1005, "need_login", "请先登录!"),
    PHONE_OR_PASSWORD_ERROR(1006, "phone_or_password_error", "手机号或密码错误!"),
    PHONE_CODE_ERROR(1007, "phone_code_error", "验证码错误!"),
    PHONE_RESITTERED(1008, "phone_redistered", "该号码已被注册!"),
    PHONE_VALID_FALSE(1009, "phone_valid_false", "手机号格式错误!"),
    WXLOGIN_ERROR(1010, "wx_login_error", "微信未绑定手机号!"),
    SAMPLE_USER_NOT_EXIST(10001, "sample_user_not_exist", "用户不存在!");


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
