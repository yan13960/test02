package cn.itnanls.exception;

import cn.itnanls.util.R;
import cn.itnanls.util.ResultCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局Controller层异常处理类
 */
@ControllerAdvice
public class GlobalExceptionResolver {


    @ExceptionHandler(ParamIllegalException.class)
    @ResponseBody
    public R paramIllegalExceptionHandler(ParamIllegalException e){
        // 输出日志  可能是文件或数据库
        // return R.of(ResultCode.BUSINESS_ERROR);
        e.printStackTrace();
        R r = R.of(e.getCode(), e.getMsg());
        r.setOtherMsg(e.getErrors());
        return r;
    }

   @ExceptionHandler(BusinessException.class)
   @ResponseBody
    public R businessExceptionHandler(BusinessException e){
    // 输出日志  可能是文件或数据库
        // return R.of(ResultCode.BUSINESS_ERROR);
       e.printStackTrace();
       return R.of(e.getCode(),e.getMsg());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R exceptionHandler(Exception e){
       e.printStackTrace();
        return R.of(ResultCode.UNKNOWN_ERROR);
    }
}