package cn.itnanls.util;

/**
 *
 */
public enum  ResultCode {
    /**
     * 成功
     */
    SUCCESS(200, "success"),
    /**
     * 未知错误
     */
    UNKNOWN_ERROR(10001, "unkonwn error"),
    /**
     * 用户名错误或不存在
     */
    USERNAME_ERROR(10002, "username error or does not exist"),
    /**
     * 密码错误
     */
    PASSWORD_ERROR(10003, "password error"),
    /**
     * 用户名不能为空
     */
    USERNAME_EMPTY(10004, "username can not be empty"),
   /**
    * 业务统一异常
    */
    BUSINESS_ERROR(10005,"业务发生了问题"),

    /**
     * 参数异常*/
    PARAM_ERROR(10006,"参数非法");


    /**
     * 结果码
     */
    private Integer code;
    /**
     * 结果码描述
     */
    private String msg;
       ResultCode(Integer code, String msg) {
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
