package cn.itnanls.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SqlUser {

    private  Integer id;
    private  String userName;
    private  String password;
}
