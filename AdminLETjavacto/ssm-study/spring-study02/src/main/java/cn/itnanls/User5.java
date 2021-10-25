package cn.itnanls;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class User5 {
    private String name;
    //@Autowired是按类型自动转配的，不支持id匹配。先bytype 在byname spring提供
    // 需要导入 spring-aop的包！
    /*  @Autowired
      @Qualifier("address2")*/

    /*@Resource如有指定的name属性，先按该属性进行byName方式查找装配，写了啥名字就找哪个；
      其次再进行默认的byName方式进行装配；
      如果以上都不成功，则按byType的方式自动装配。
      都不成功，则报异常。  javaee提供
      如果允许对象为null，设置required = false,默认为true*/
    @Resource(name = "address2")
    private Address address;
    //爱好
    private String[] hobbies;
    //职务
    private List<String> duties;
    //家庭关系
    private Map<String,String> familyTies;
    //购物车商品
    private Set<String> carts;
    //工作经历
    private Properties workExperience;
    //女儿 null注入
    private String daughter;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
