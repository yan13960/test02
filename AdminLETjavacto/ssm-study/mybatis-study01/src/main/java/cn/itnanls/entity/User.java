package cn.itnanls.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 *从今往后，只需要在对应的类上加上这几个注解，就能完成对应的编译工作
 * @AllArgsConstructor：生成全参构造器。
 * @NoArgsConstructor：生成无参构造器。
 * @Getter/@Setter: 作用类上，生成所有成员变量的getter/setter方法；作用于成员变量上，生成该
 * 成员变量的getter/setter方法。可以设定访问权限及是否懒加载等。
 * @Data：作用于类上，是以下注解的集合：@ToString @EqualsAndHashCode @Getter @Setter
 * @RequiredArgsConstructor
 * @Log：作用于类上，生成日志变量。针对不同的日志实现产品，有不同的注解。
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
/*@Alias("user")*/
public class User implements Serializable {

    private Integer id;
    private String username;
    private String password;


    public static void main(String[] args) {
        User user=new User(1,"2","3");
        User user1=new User();
        user1.setId(2);
        System.out.println(user);
        System.out.println(user1);
    }
}
