package com.xinzhi;

import jdk.nashorn.internal.ir.annotations.Reference;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Name {

    @interface Reference{
        boolean next() default false;
    }

    int value() default 5;

    //枚举类型
    enum Status {FIXED, NORMAL};
    //声明枚举
    Status status() default Status.FIXED;
    //布尔类型
    boolean showSupport() default false;

    //String类型
    String fullName() default "张楠";
    //class类型
    Class<?> testCase() default Void.class;
    //注解嵌套
    Reference reference() default @Reference(next = true);
    //数组类型
    //long[] value2();
}
