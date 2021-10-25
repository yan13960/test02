package cn.itnanls.factoryBean;

import org.springframework.beans.factory.FactoryBean;

import java.sql.Driver;

/**
 *
 */
public class DriverFactoryBean implements FactoryBean<Driver> {
    @Override
    public Driver getObject() throws Exception {
        Driver driver=null;
        try {
            driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return driver;
    }

    @Override
    public Class<?> getObjectType() {
            return Driver.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
