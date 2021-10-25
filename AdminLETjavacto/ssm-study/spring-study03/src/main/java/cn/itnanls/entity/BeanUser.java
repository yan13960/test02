package cn.itnanls.entity;

import java.io.Serializable;

/**
 *
 */
public class BeanUser implements Serializable {
    private int id;
    private String username;
    private String password;
    public BeanUser() {
        System.out.println("--------构造--------");
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        System.out.println("--------注入--------");
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void init(){
        System.out.println("--------init初始化--------");
    }
    public void destroy(){
        System.out.println("--------destroy销毁--------");
    }
    @Override
    public String toString() {
        System.out.println("--------使用了--------");
        return "BeanUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
