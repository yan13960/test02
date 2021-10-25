package com.xinzhi;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 */
public class Test {
    @org.junit.Test
    public void optField2(){

        Animal animal =new Animal();
        Class<Animal> animalClass = Animal.class;
        //获取字段，只能获取公共的字段（public） getFields
        Field[] fields = animalClass.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
            try {
                //设置字段
                field.set(animal,"张三");
                //获取字段
                System.out.println(field.get(animal));
            } catch (IllegalAccessException e) {
                System.out.println("name必须是字符串");
                e.printStackTrace();
            }
        }

        System.out.println("-----------------------");
        //能获取所有的字段包括private getDeclaredField
        try {
            Field field = animalClass.getDeclaredField("age");

            try {
                //设置权限 暴力注入 能够注入private类型的字段
                field.setAccessible(true);
                field.set(animal,12);
                System.out.println(field.get(animal));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public  void  optMethod3() throws Exception{
        Animal animal =new Animal();

        Class<Animal> animalClass = Animal.class;
       // Animal animal = animalClass.newInstance();
        try {
          //调用无参的方法
            Method eat = animalClass.getMethod("eat");
            eat.invoke(animal);
          //调用有参的方法
            Method eat2 = animalClass.getMethod("eat", String.class);
            eat2.invoke(animal ,"骨头");
            Method eat3 = animalClass.getMethod("eat", String.class,int.class);
            Object food = eat3.invoke(animal, "骨头", 23);
            System.out.println(food);

            Class<?>[] parameterTypes = eat3.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println(parameterType);
            }

            Method[] declaredMethods = animalClass.getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {
                System.out.println(declaredMethod.getName());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

      @org.junit.Test
      //构造器的核心是用来new对象
      public  void optConstructor() throws Exception {
          Class animalClass = Class.forName("com.xinzhi.Animal");
          //1.通过构造器拿到对象
          Constructor<Animal> constructor = animalClass.getConstructor();
          //2.通过构造器创建对象  newInstance无参构造
          Animal animal = constructor.newInstance();
          animal.eat();
      }

     @org.junit.Test
      public void optConstructor2() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
          Class animalClass = Class.forName("com.xinzhi.Animal");
          Animal animal = (Animal) animalClass.newInstance();
          animal.eat();
      }
}
