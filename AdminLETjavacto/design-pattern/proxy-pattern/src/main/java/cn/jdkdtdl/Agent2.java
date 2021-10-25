package cn.jdkdtdl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 */
public class Agent2 implements InvocationHandler {
    private Object object;

    public Agent2(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("开启事务");
        Object invoke = method.invoke(object, args);
        System.out.println("提交事务");
        return invoke;
    }
}
