package cn.itnanls.controller;

import cn.itnanls.entity.User;
import cn.itnanls.entity.User2;
import cn.itnanls.entity.User3;
import cn.itnanls.exception.BusinessException;
import cn.itnanls.exception.ParamIllegalException;
import cn.itnanls.util.ResultCode;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SpringMVC整个的执行流程
 * 1.用户发起请求到前端控制器（DispatcherServlet）
 * 2.前端控制器请求HandlerMapping查找Handler（一般是要执行的拦截器和处理器）（根据注解，xml进行查找）
 * 3.处理映射器HandlerMapping向前端控制器DispatcherServlet返回handler
 * 4.前端控制器调用处理适配器HandlerAdapter找到合适的处理器Handler执行handler
 * 5.处理器执行handler
 * 6.处理器Handler执行完之后给处理器适配器返回ModelAndView
 * 7.处理适配器向前端控制器返回ModelAndView
 * 8.前端控制器请求视图解析器去解析视图（jsp）
 * 9.视图解析器向前端控制器返回view对象
 * 10.前端控制器进行视图渲染
 * 11.前端控制器向用户响应结果
 */
@Controller
@RequestMapping("user7")
public class UserController7 {

    @PostMapping("/showUser" )
    @ResponseBody
    /*BindingResult 如果发生了异常 会帮助我们接收异常*/
    public User3 showUser(@RequestBody @Validated User3 user3, BindingResult br)  {
        List<ObjectError> allErrors = br.getAllErrors();
        if (allErrors.size()>0){
            Map<String,String> errors =new HashMap<>(4);
            for (ObjectError allError : allErrors) {
                String code = allError.getCode();
                String msg = allError.getDefaultMessage();
                errors.put(code,msg);
            }
            throw new ParamIllegalException(ResultCode.PARAM_ERROR,errors);
        }

        //在处理你的业务
        return user3;
    }

}
