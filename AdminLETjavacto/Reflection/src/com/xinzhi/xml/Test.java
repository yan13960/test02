package com.xinzhi.xml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class Test {
    public static void main(String[] args) {
        Student s1=new Student("张三",12,"男");
        Student s2=new Student("李四",13,"女");
        Student s3=new Student("王五",14,"男");
        List<Student> students = Arrays.asList(s1, s2, s3);

        Clazz clazz=new Clazz();
        clazz.setName("开发六部");
        clazz.setStudents(students);
        System.out.println(clazz);
    }
}
