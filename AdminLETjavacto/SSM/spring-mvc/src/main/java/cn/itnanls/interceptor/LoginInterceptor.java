package cn.itnanls.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *登录拦截器  在进入DispatcherServlet：中央控制器之后拦截
 * 过滤器在进入DispatcherServlet：中央控制器之前过滤
 */
public class LoginInterceptor implements HandlerInterceptor {

    /*1. preHandle：Controller方法处理请求前执行，根据拦截器定义的顺序，正向执行。
    2. postHandle：Controller方法处理请求后执行，根据拦截器定义的顺序，逆向执行。需要所有的
       preHandle方法都返回true时才会调用。
    3. afterCompletion：View视图渲染后处理方法：根据拦截器定义的顺序，逆向执行。preHandle返
     回true就会调用。*/

    /*在方法进入中央处理器之后，进入controller之前执行
    * 返回false拦截 返回true放行*/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("user");
        if (user!=null){
            return true;
        }
        return false;
    }
    /*执行controller之后执行*/
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
    /*视图生成之后执行*/
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
