package cn.itnanls.entity;

/**
 *
 */
public class UserFactory {
    public static User getUser(String type){
        if ("男".equals(type)) {

            return new User(1,"男","4646544",null);
        }else {
            return new User(2,"女","564646",null);
        }
    }
}
