package cn.dtdlClass;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 *
 */
public class Client2 {


    public static void main(String[] args) {
        //该设置用于输出cglib动态代理产生的类
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\class");
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(MaleSinger2.class);
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects,
                                    MethodProxy methodProxy) throws Throwable {
                System.out.println("---------");
                Object invoke = methodProxy.invokeSuper(o,objects);
                System.out.println("++++++++++");
                return invoke;
            }
        });
        MaleSinger2 maleSinger2 = (MaleSinger2)enhancer.create();
        maleSinger2.sing();
    }
}
