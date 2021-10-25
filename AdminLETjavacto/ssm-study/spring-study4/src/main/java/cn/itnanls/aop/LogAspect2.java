package cn.itnanls.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
@Aspect
public class LogAspect2 {
    //前置通知 方法执行之前
   /* @Before("execution( * cn.itnanls.service.impl.*.*(..))")
    public void before(){
        System.out.println("执行方法之前打印一条日志！ -- 自定义形式");
    }
    //后置通知 方法执行之后 有没有异常都会执行
    @After("execution( * cn.itnanls.service.impl.*.*(..))")
    public void after(){
        System.out.println("执行方法之后打印一条日志！ -- 自定义形式");
    }
    //环绕通知  会覆盖原有的方法内容
    @Around("execution( * cn.itnanls.service.impl.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("执行方法前");
        Object proceed =joinPoint.proceed();
        System.out.println("执行方法后");
        return proceed;
    }

    //返回通知  返回之后切入  有异常就不执行了
    @AfterReturning("execution( * cn.itnanls.service.impl.*.*(..))")
    public void returning(){
        System.out.println("returning！ -- 自定义形式");
    }

    //异常通知  发生异常会进行通知
    @AfterThrowing("execution( * cn.itnanls.service.impl.*.*(..))")
    public void throwing(){
        System.out.println("throwing！ -- 自定义形式");
    }*/


}
