package cn.itnanls.aop;

import cn.itnanls.Annotation.LogAnnotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 *
 */
@Component
@Aspect
public class LogAspectAnno2 {
    //前置通知 方法执行之前
    //@Before("@annotation(org.springframework.stereotype.Controller)")
    @Before("@annotation(cn.itnanls.Annotation.LogAnnotation)")
    public void before(JoinPoint joinPoint){
        //获得代理对象
        Object target = joinPoint.getTarget();
        //获得被代理对象
        Object object = joinPoint.getThis();
        Object[] args = joinPoint.getArgs();


        //拿到方法的签名对象 拿到注解定义的值 默认是show
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        LogAnnotation annotation = method.getAnnotation(LogAnnotation.class);
        String value = annotation.value();
        System.out.println(value);
        System.out.println("执行方法之前打印一条日志！ -- 自定义形式");
    }

    //后置通知 方法执行之后 有没有异常都会执行
    //@After("@annotation(org.springframework.stereotype.Controller)")
    @After("@annotation(cn.itnanls.Annotation.LogAnnotation)")
    public void after(JoinPoint joinPoint){
        System.out.println("执行方法之后打印一条日志！ -- 自定义形式");
    }

    //环绕通知  会覆盖原有的方法内容
    //@Around("@annotation(org.springframework.stereotype.Controller)")
    @Around("@annotation(cn.itnanls.Annotation.LogAnnotation)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("方法执行前");
        long start = System.currentTimeMillis();
        //手动执行目标方法
        Object proceed =joinPoint.proceed()+"修改后";

        long end=  System.currentTimeMillis();
        System.out.println("方法执行后");
        System.out.println((end-start)+"毫秒");

        return proceed;
    }

    //返回通知  返回之后切入  有异常就不执行了
    //@AfterReturning("@annotation(org.springframework.stereotype.Controller)")
    @AfterReturning("@annotation(cn.itnanls.Annotation.LogAnnotation)")
    public void returning(JoinPoint joinPoint){
        System.out.println("returning！ -- 自定义形式");
    }

    //异常通知  发生异常会进行通知
    //@AfterThrowing("@annotation(org.springframework.stereotype.Controller)")
    @AfterThrowing(value = "@annotation(cn.itnanls.Annotation.LogAnnotation)",throwing ="ex" )
    public void throwing(JoinPoint joinPoint ,RuntimeException ex){
        System.out.println("抛出异常通知"+ex.getMessage());
        System.out.println("throwing！ -- 自定义形式");
    }


}
