package cn.itnanls.controller;

import cn.itnanls.entity.User4;
import cn.itnanls.util.R;
import cn.itnanls.util.ResultCode;
import org.springframework.web.bind.annotation.*;

/**
 * SpringMVC整个的执行流程
 * 1.发起请求到前端控制器（DispatcherServlet）
 * 2.前端控制器请求HandlerMapping查找Handler（一般是要执行的拦截器和处理器）（根据注解，xml进行查找）
 * 3.处理映射器HandlerMapping向前端控制器DispatcherServlet返回handler
 * 4.前端控制器调用处理适配器HandlerAdapter找到合适的处理器Handler执行handler
 * 5.处理器执行handler
 * 6.处理器Handler执行完之后给处理器适配器返回ModelAndView
 * 7.处理适配器向前端控制器返回ModelAndView
 * 8.前端控制器请求视图解析器去解析视图（jsp）
 * 9.视图解析器向前端控制器返回view
 * 10.前端控制器进行视图渲染
 * 11.前端控制器向用户响应结果
 */

@RestController
@RequestMapping("/user9/")
public class UserController9 {

    @GetMapping("{id}")
   public User4 getUserById(@PathVariable int id){
     return new User4(id,"zhangsan","123456");
    }

    @DeleteMapping("{id}")
    public R deleteUserById(@PathVariable int id){
        //数据库去删除
        return R.of(ResultCode.SUCCESS);
    }

    @PutMapping("{id}")
    public R updateUserById(@RequestBody User4 user4){
        System.out.println(user4);
        //先查询 在更新
        return R.of(ResultCode.SUCCESS);
    }

    @PostMapping("{id}")
    public R insertUserById( User4 user4){
        System.out.println(user4);
        //把user保存进去
        return R.of(ResultCode.SUCCESS);
    }
}
