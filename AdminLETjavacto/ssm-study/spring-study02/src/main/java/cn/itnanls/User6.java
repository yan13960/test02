package cn.itnanls;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
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
//@Component
public class User6 {
    private String name;

    @Autowired
    private Address2 address2;

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

    @Autowired
    private DataSource dataSource;


    public Address2 getAddress2() {
        return address2;
    }

    public void setAddress2(Address address) {
        this.address2 = address2;
    }
}
