package cn.itnanls.controller;

import cn.itnanls.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
@RequestMapping("user4")
public class UserController4 {

    @GetMapping("/showUser4")
    public String showUser(Model model)  {
        model.addAttribute("user","hello lucy1");
        return "user";
    }

    @GetMapping("/**")
    public String showUser2(Model model)  {
        model.addAttribute("user","hello lucy2");
        return "user";
    }

    @GetMapping("?howUser")
    public String showUser3(Model model)  {
        model.addAttribute("user","hello lucy3");
        return "user";
    }

    @GetMapping("*.png")
    public String showUser4(Model model)  {
        model.addAttribute("user","hello lucy4");
        return "user";
    }

    @PostMapping("/addUser4")
    public String addUser(Model model,HttpServletRequest request,HttpServletResponse response)  {
        System.out.println(request.getServerPort());
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user =new User(null ,username,password);
        model.addAttribute("user",user);
        return "user";
    }

    @PostMapping("/addUser5")
    public String addUser5(Model model,User user)  {
        model.addAttribute("user",user);
        return "user";
    }

    @PostMapping("/addUser6")
    public String addUser6(Model model, String username, @RequestParam("password")String password2)  {
        model.addAttribute("user",new User(null,username,password2));
        return "user";
    }

    @PostMapping("/addUser7")
    public String addUser7(Model model, @CookieValue String JSESSIONID)  {
        model.addAttribute("sessionId",JSESSIONID);
        return "user";
    }

    /*Model 无法跨越多个controller request和session可以 */
    @GetMapping("/showUser")
    public String showUser(Model model,HttpServletRequest request,HttpServletResponse response)  {
        request.setAttribute("user",new User(null,"jerry","123456"));
        return "forward:/user4/addUser8";
    }

    @GetMapping("/addUser8")
    public String addUser8(Model model, @RequestAttribute("user") User user)  {
        model.addAttribute("user",user);
        return "user";
    }

    @GetMapping("/showUser2")
    public String showUser2(HttpSession session)  {
        session.setAttribute("u",new User(null,"jerrys","123456"));
        return "forward:/user4/addUser9";
    }

    @GetMapping("/addUser9")
    public String addUser9(Model model,@SessionAttribute("u") User user)  {
        model.addAttribute("user",user);
        return "user";
    }

    @GetMapping("/showUser3")
    public String showUser3(HttpSession session)  {
        session.setAttribute("u",new User(null,"jerrys","123456"));
        return "forward:/user4/addUser10";
    }
    @GetMapping("/addUser10")
    public String addUser10(Model model,@RequestHeader("User-Agent") String agent)  {
        model.addAttribute("user",agent);
        return "user";
    }

    /*请求转发是服务器行为 url不会变化 向浏览器发了一个请求
    * 重定向是服务器行为 url会发生变化 像浏览器发了两个请求
    * 重定向和转发的区别:
1、作用方式不同，当使用转发时，JSP容器将使用一个内部的方法来调用目标页面，新的页面继续处理同一个请求，而浏览器将不会知道这个过程。 与之相反，重定向方式的含义是第一个页面通知浏览器发送一个新的页面请求；
2、页面显示不同，当使用重定向时，浏览器中所显示的URL会变成新页面的URL,，而当使用转发时，该URL会保持不变；
3、速度不同，重定向的速度比转发慢，因为浏览器还得发出一个新的请求；
4、作用对象效果不同，由于重定向方式产生了一个新的请求，所以经过一次重定向后，request内的对象将无法使用。通常情况下转发更快，而且能保持request内的对象；
5、页面转换不同，转发之后，浏览器中URL仍然指向开始页面，此时如果重载当前页面，开始页面将会被重新调用。*/
    @GetMapping("/showUser5")
    public String showUser5(HttpSession session)  {
        session.setAttribute("u",new User(null,"jerrys","123456"));
        return "redirect:https://www.baidu.com/";
        //return "redirect:forward:/user4/addUser10";
    }
}
