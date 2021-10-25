package cn.itnanls.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User2 implements Serializable {

    private Integer id;
    private String username;
    private String password;
    //从@requeatParam中获取参数并且转化（自定义的转化器也是从requeatParam中获取）不能加@RequestBody
     //这个只能转换application/x-www-form-urlencoded的日期 不能转化json 只能解决入参格式化
    //@DateTimeFormat(pattern = "yyyy年MM月dd日")
    //既能解决入参格式化 又能解决出参格式化
    //对象和json互相转化的过程中按照此转化方式转化 @RequestBody中获取参数
    /*字符串转日期，
1，@DateTimeFormat（pattern = ...)
2，自定义的类型转换器
这两种方式都只能入参格式化。它只能对application/x-www-form-urlencoded方式传过来的数据进行转化，如果是application/json格式传过来的参数，不行！所以controller方法对应的形参，就不能加@RequestBody
3，@JsonFormat （patter = ...）jackson能够进行双向转化（ json字符串--Object ）入参格式化+出参格式化，能够转化application/json格式传过来的数据
4，双管齐下，@DateTimeFormat（或自定义的类型转化器） + @JsonFormat，这样urlencoded和json格式的数据都能够转化了。*/
    @JsonFormat(pattern = "yyyy年MM月dd日",timezone = "GMT-8")
    @DateTimeFormat(pattern = "yyyy年MM月dd日")
    private Date birthday;

}
