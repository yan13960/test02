package com.javacto.service;

import com.javacto.contoller.SysLogAction;
import com.javacto.po.SysLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 切面类，这里进行调用添加的操作
 */
@Component
@Aspect
public class LogAop {
    @Autowired
    private SysLogService logService;
    private Date visitTime;//开始时间
    private  Class clazz;//访问的类
    private  String methodName;//访问的方法名

    @Autowired
    private HttpServletRequest request;



    /**
     * 前置通知
     */
    @Before("execution(* com.javacto.contoller.*.*(..))")
    public  void  doBefore(JoinPoint jp){
        //获取前前时间
        visitTime=new Date();
        //得到访问的类
        clazz = jp.getTarget().getClass();
        //访问的方法名
        methodName = jp.getSignature().getName();
    }
    /**
     * 后置通知
     */
    @After("execution(* com.javacto.contoller.*.*(..))")
    public void  doAfter(JoinPoint jp) throws Exception {
        //获取操作时长
        long time = new Date().getTime() - visitTime.getTime();

        if(null!= clazz && clazz!= LogAop.class && clazz!= SysLogAction.class){

            //获取ip
            String ip =request.getRemoteAddr();
            //获取url
            String url = request.getRequestURI();
            //获取当前操作用户
            SecurityContext context = SecurityContextHolder.getContext();
            //从上下文获取当前登陆的用户对象
            User user =  (User)context.getAuthentication().getPrincipal();
            String username = user.getUsername();
            //把所有信息封装到SysLog
            SysLog sysLog = new SysLog();
            sysLog.setExecutionTime(time); //执行时长  sysLog.setIp(ip);
            sysLog.setMethod("[类名] " + clazz.getName() + "[方法名] " +methodName);
            sysLog.setUrl(url);
            sysLog.setUsername(username);
            sysLog.setVisitTime(visitTime);
            sysLog.setIp(ip);
            //调用业务层 完成操作
            logService.save(sysLog);


        }

    }

}
