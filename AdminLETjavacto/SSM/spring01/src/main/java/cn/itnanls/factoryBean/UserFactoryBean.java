package cn.itnanls.factoryBean;

import cn.itnanls.entity.User;
import cn.itnanls.entity.UserFactory;
import org.springframework.beans.factory.FactoryBean;

/**
 *
 */
public class UserFactoryBean implements FactoryBean<User> {

    @Override
    public User getObject() throws Exception {
        return UserFactory.getUser("男");
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
