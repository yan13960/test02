package cn.itnanls;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class User3 {
    private String name;

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
