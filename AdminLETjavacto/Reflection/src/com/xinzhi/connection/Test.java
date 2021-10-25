package com.xinzhi.connection;

import java.io.IOException;
import java.util.Properties;

/**
 *
 */
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        //1.加载配置文件
        Properties properties=new Properties();
        properties.load(Test.class.getClassLoader().getResourceAsStream("jdbc.properties"));

        Object object = Class.forName(properties.getProperty("type")).newInstance();
        if (object instanceof Connection){
            Connection connection=(Connection)object;
            connection.setHost(properties.getProperty("mysql.host"));
            connection.setPort(Integer.parseInt(properties.getProperty("mysql.port")));
            connection.setUsername(properties.getProperty("mysql.username"));
            connection.setPassword(properties.getProperty("mysql.password"));
            System.out.println(connection);
        }

    }
}
