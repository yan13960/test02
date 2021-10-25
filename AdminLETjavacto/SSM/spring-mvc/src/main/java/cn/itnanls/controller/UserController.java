package cn.itnanls.controller;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;

/**
 *
 */

public class UserController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //ModelAndView 封装了模型和视图
        ModelAndView mv = new ModelAndView();
       //模型里封装数据
        mv.addObject("user","Hello springMVC!");
         //封装跳转的视图
        mv.setViewName("user");
        //不是有个视图解析器吗
        //这玩意就是为了省事的，自动给你加个前缀后缀
        //就成了 /jsp/user.jsp 不就是拼串吗
        return mv;

    }
}
