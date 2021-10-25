package cn.itnanls.controller;

import cn.itnanls.entity.User;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
@Controller
@RequestMapping("user5")
public class UserController5 {

    @RequestMapping(value = "addUser",method = RequestMethod.GET,
    params = {"username=zs","password!=123"} ,headers = {"a=1","b=2"})
    @ResponseBody
    public User addUser(Model model,HttpServletRequest request)throws Exception{
       return new User(1,"zhangsan","123456");
  }

    @RequestMapping(value = "addUser2",method = RequestMethod.GET
    ,produces = "application/json;charset=utf-8")
    @ResponseBody
    public void addUser2(Model model , HttpServletResponse response ) throws IOException {
        User user =new User(1,"ZHANGSAN","123");
        String userStr = JSONObject.toJSONString(user);
        response.getWriter().write(userStr);
        response.getWriter().close();
    }

    @RequestMapping(value = "addUser3",method = RequestMethod.GET
            ,produces = "application/json;charset=utf-8")
    public void addUser3(Model model,HttpServletRequest request,@RequestBody User user) throws Exception {
        System.out.println(request.getHeader("Content-Type"));
        System.out.println(user);
    }

    @RequestMapping(value = "addUser4",method = RequestMethod.GET
            ,produces = "application/json;charset=utf-8")
    /*@ResponseBody能将处理的结果放在响应体中，直接返回，不走视图解析器，写到浏览器上
     就是response.getWriter().write(user);如果传进来的是json格式的会自动转化成json格式的然后返回前端，传入什么类型的数据，就返回什么类型
     @RequestBody可以获取请求体的数据交给fastjson的转换器处理，负责默认使用x-ww-formurlencoded的方式获取值
     如果前端传进来的是可读的json格式，会自动转化成java格式的数据来接收
     @RequestBody 、@ResponseBody的作用
     @ResquestBody是从请求体中拿数据，@ResponseBody向响应体中放数据。
     我们配置了一个fastjson转化器，这个转化器的作用仅仅是：
     @RequestBody向请求体拿数据的时候，如果有json对象，尝试转为java对象；前端传入数据时
     @ResponseBody向响应体放数据的时候，如果数据是Java对象，尝试转为json返回前端
     而转化器不只一个选择，fastjson，还可以用jackson，这就是下节课的内容。*/
    @ResponseBody
    public User addUser4(Model model,HttpServletRequest request,@RequestBody User user) throws Exception {
       user.setUsername("李四+++++");
       System.out.println(user);
       return user;
    }

    @GetMapping("/showUser")
    @ResponseBody
    public String showUser(@RequestBody String asdasds)  {
        System.out.println(asdasds);
        System.out.println(123);
        return "返回浏览器";
    }

   /*@ResponseBody*/
    @RequestMapping(value = "/showUser2",method = RequestMethod.GET
            ,produces = "application/json;charset=utf-8")
    @ResponseBody
    public User showUser2( HttpServletResponse response,@RequestBody User user ) throws IOException {
        user.setUsername("aaaa");
        user.setId(3);
        user.setPassword("bbbb");
        System.out.println(user);
        return user;
    }
}
