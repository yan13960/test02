package com.xinzhi.sql;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 */
public class Test {

    public static String driverName;
    private static String url;
    private static String userName;
    private static String pwd;

    public static void main(String[] args)throws Exception {
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream("D:\\java\\IdeaProjects\\AdminLETjavacto\\Reflection\\src\\conf.properties");
        properties.load(inputStream);

        properties.setProperty("c","d");
        System.out.println(properties.getProperty("c"));

        System.out.println(properties.getProperty("target"));
        System.out.println(properties.getProperty("a"));
    }

    @org.junit.Test
    public void test() throws Exception{
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream("D:\\java\\IdeaProjects\\AdminLETjavacto\\Reflection\\src\\conf.properties");
        properties.load(inputStream);
        String target = properties.getProperty("target");

        Source source= (Source)Class.forName(target).newInstance();
        source.select();
    }

    @org.junit.Test
    public   void init() {
        //这个方法只有一个目的，拿到db.properties 的信息 通过键获取值
        ///1.创建Properties
        Properties ps = new Properties();
        //2.拿到文件路径  相对路径getClassLoader conf/pat.properties  绝对路径load
        String path = "conf.properties";
        //3.通过输出流读取db.properties 中的信息 数据
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream(path);

        try {
            //4.把读到到的数据 加载到Properties
            ps.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //5.通过键  获取值，值都在  Properties 对象中
        System.out.println(ps.get("db.driverName"));
        System.out.println(ps.getProperty("db.url"));

        //赋值  大家必需通过    System.out.println(ps.get("db.driverName")); 输出 有值了再赋值
        driverName = ps.getProperty("db.driverName");
        url = ps.getProperty("db.url");
        userName = ps.getProperty("db.userName");
        pwd = ps.getProperty("sbqSbqPwd");
        System.out.println(pwd);
    }
}
