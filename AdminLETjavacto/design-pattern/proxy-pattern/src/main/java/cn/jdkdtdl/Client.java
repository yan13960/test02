package cn.jdkdtdl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 */
public class Client {
    public static void main(String[] args) {
        //该设置用于输出jdk动态代理产生的类
       /*System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles",
                "true");*/


        Singer maleSinger=new MaleSinger();

      /*  Singer singer1 = (Singer)Proxy.newProxyInstance(Client.class.getClassLoader(),
                new Class[]{Singer.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("协商");
                        Object invoke = method.invoke(maleSinger);
                        System.out.println(method.getName());
                        System.out.println("123");
                        return invoke;
                    }
                });
        singer1.sing();
        singer1.say();*/


        Singer singer2 = (Singer)Proxy.newProxyInstance(Client.class.getClassLoader(),
                new Class[]{Singer.class},
                new Agent2(maleSinger));
        singer2.sing();
        singer2.say();
    }
}
