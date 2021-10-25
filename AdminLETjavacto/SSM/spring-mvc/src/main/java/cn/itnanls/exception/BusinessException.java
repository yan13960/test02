package cn.itnanls.exception;

import cn.itnanls.util.ResultCode;

/**
 *统一的业务异常
 */
public class BusinessException extends RuntimeException {

    private  int code;
    private String msg;

    private  ResultCode resultCode;
    public BusinessException(ResultCode resultCode) {
        super((resultCode.getMsg()));
         this.code=resultCode.getCode();
         this.msg=resultCode.getMsg();
         this.resultCode=resultCode;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
}
