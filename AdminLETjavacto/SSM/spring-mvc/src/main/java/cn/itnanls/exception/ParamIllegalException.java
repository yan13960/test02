package cn.itnanls.exception;

import cn.itnanls.util.ResultCode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class ParamIllegalException extends RuntimeException {

    private Map<String,String>errors=new HashMap<>(4);

    private  int code;
    private String msg;

    private ResultCode resultCode;
    public ParamIllegalException(ResultCode resultCode,Map<String,String>errors) {
        this.code=resultCode.getCode();
        this.msg=resultCode.getMsg();
        this.errors=errors;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
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
