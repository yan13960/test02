package com.xinzhi;

import org.junit.Test;

import java.lang.reflect.Field;
import java.net.URL;

/**
 *
 */

public class Animal {

    @Name(value = 5,fullName = "张")
    public   String Name;
    private  int age;


    //过期 提醒这个方法即将过时 不建议使用
    @Deprecated
    public void eat(){
        System.out.println(123);
    }

    @Deprecated
    public void  eat(String food){
        System.out.println(food);
    }
    @Deprecated
    public  String eat(String food,int age){
        return  food+age;
    }
    @Test
    public void optField(){

        Animal animal =new Animal();
        Class<Animal> animalClass = Animal.class;
        //获取字段，只能获取公共的字段（public）
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
        //能获取所有的字段包括private
        Field[] declaredFields = animalClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }
    }

    @Test
    public void optField2(){

        Animal animal =new Animal();
        Class<Animal> animalClass = Animal.class;
        //获取字段，只能获取公共的字段（public）
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
        //能获取所有的字段包括private
        try {
            Field field = animalClass.getDeclaredField("age");
            try {
                field.set(animal,12);
                System.out.println(field.get(animal));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //Animal animal=new Animal();
        //animal.eat();

        //1.通过类来获取
        Class<Animal> clazz1 = Animal.class;
        String name= clazz1.getName();
        System.out.println(name);

        //2.通过全类名来获取
        Class clazz2 = Class.forName("com.xinzhi.Animal");
        String name2=clazz2.getName();
        System.out.println(name2);

        //3.使用对象来获取
        Animal animal=new Animal();
        //Animal animal=new Dog();
        //Animal animal=new Cat();
        //上界通配符
        Class<? extends Animal> clazz3 = animal.getClass();
        String name3=clazz3.getName();
        System.out.println(name3);

        //获取类加载器
        ClassLoader classLoader = clazz3.getClassLoader();
        System.out.println(classLoader);

        //获取资源
        URL resource = clazz3.getResource("");
        System.out.println(resource);

        //得到父类
        Class superclass = clazz3.getSuperclass();
        System.out.println(superclass);

        //判断一个类是不是接口，数组等等
        boolean array = clazz3.isArray();
        boolean anInterface = clazz3.isInterface();
        System.out.println(array);
        System.out.println(anInterface);

        //重点，使用class对象实例化一个对象
        Object instance = clazz3.newInstance();
        System.out.println(111);
        System.out.println(instance);
    }
}
