package com.qiein.erp.pk.exception;

/**
 * 异常枚举类
 */
public enum ExceptionEnum {
    //系统级错误
    UNKNOW_ERROR(-1, "未知错误"),
    RPC_ERROR(-2, "远程调用错误"),
    MYSQL_SQL_GRAMMAR_ERROR(-8, "sql语法错误"),
    DB_SPLIT_ERROR(-9, "系统表分割错误"),
    METHOD_ARGUMENT_TYPE_MISMATCH_ERROR(-10, "方法参数无法转换"),
    CAN_NOT_FIND_USER_FROM_REQ(-11, "未能从请求中获取到用户信息"),
    APOLLO_URL_NOT_SET(-12, "阿波罗地址未设置"),
    REMOTE_CALL_ERROR(-13, "远程调用错误"),
    //常用错误
    ADD_FAIL(1, "新增失败"),
    LOSE_FILED(2, "缺少必须条件"),
    //token验证相关
    TOKEN_NULL(100, "token不存在"),
    TOKEN_INVALID(101, "token失效"),
    TOKEN_VERIFY_FAIL(102, "token验证失败"),
    VERIFY_PARAM_INCOMPLETE(103, "token验证参数不全"),
    VERIFY_USER_NOT_FOUND(104, "未找到验证用户信息"),
    //http请求相关
    HTTP_METHOD_NOT_SUPPORT(200, "不支持的请求方法类型"),
    HTTP_BODY_NOT_READABLE(201, "HTTP请求体无法读取"),
    HTTP_PARAMETER_ERROR(202, "HTTP请求参数无法对应"),
    //服务
    SERVICE_WAS_IN(301, "服务已存在"),
    //人员
    USER_NOT_FOUND(400, "用户不存在"),
    USER_IS_DEL(401, "用户已被删除"),
    USER_IS_LOCK(402, "用户已锁定"),
    USERNAME_OR_PASSWORD_ERROR(403, "用户名或密码错误"),
    PHONE_ERROR(346, "手机号格式错误");

    private Integer code;
    private String msg;

    ExceptionEnum(Integer code, String msg) {
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