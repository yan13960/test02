package cn.itnanls.core;


import cn.itnanls.dao.UserDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

/**
 *会话对象
 */
public class Session {
    /**
     * 每个会话持有一个链接
     */
    private Connection connection;

    private  Map<String, Map<String,DaoWrapper>> env;

    public Session(Connection connection, Map<String, Map<String, DaoWrapper>> env) {
        this.connection = connection;
        this.env = env;
    }


    public Connection getConnection() {
        return connection;
    }

    // 开始会话
    public void begin() {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 提交

    public void commit() {
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 回滚
    public void rollback() {
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*public <T> T getMapper(Class clazz) {
      T t =(T)  Proxy.newProxyInstance(Session.class.getClassLoader(),
                new Class[]{clazz}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println(123);
                        //根据xml的内容，和接口的名字生成实际的方法体
                        return null;
                    }
                });
      return t;
    }*/

    public <T> T getMapper(Class clazz) {
        T t = (T) Proxy.newProxyInstance(Session.class.getClassLoader(),
                new Class[]{clazz}, new SqlInvocationHandler(connection,env.get(clazz.getName())));
        return t;
    }
}
