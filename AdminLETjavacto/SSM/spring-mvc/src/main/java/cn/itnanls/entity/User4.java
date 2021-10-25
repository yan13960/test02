package cn.itnanls.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User4 implements Serializable {

    private int id;
    private String username;
    private String password;
}
