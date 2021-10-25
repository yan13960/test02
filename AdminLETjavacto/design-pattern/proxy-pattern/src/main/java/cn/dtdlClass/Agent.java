package cn.dtdlClass;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 */
public class Agent implements InvocationHandler {
    private Object object;

    public Agent(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("BEGIN");
        Object invoke = method.invoke(object, args);
        System.out.println("END");
        return invoke;
    }
}