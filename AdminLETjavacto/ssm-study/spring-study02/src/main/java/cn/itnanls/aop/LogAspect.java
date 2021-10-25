package cn.itnanls.aop;

/**
 *
 */
public class LogAspect {
    public void before(){
        System.out.println("执行方法之前打印一条日志！ -- 自定义形式");
    }

    public void after(){
        System.out.println("执行方法之后打印一条日志！ -- 自定义形式");
    }

}
