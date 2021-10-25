package cn.itnanls.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.Date;

/**
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User3 implements Serializable {

    @Length(min = 2,max = 5,message = "你的名字长度不合法")
    private String username;
    private String password;
    @Max(value = 150)
    private  int age;
    @Email
    private String email;

}
