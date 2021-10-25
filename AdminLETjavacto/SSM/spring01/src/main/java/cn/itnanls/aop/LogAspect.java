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

    public void around(){
        System.out.println("round之后打印一条日志！ -- 自定义形式");
    }

    public void returning(){
        System.out.println("returning！ -- 自定义形式");
    }

    public void throwing(){
        System.out.println("throwing！ -- 自定义形式");
    }


}
