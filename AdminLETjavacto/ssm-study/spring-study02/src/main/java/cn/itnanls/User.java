package cn.itnanls;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private  String name;
    private Integer age;

    public User(String name) {
        this.name = name;
    }

    public void say(){
        System.out.println("hello ioc!");
    }


}
