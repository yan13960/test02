package cn.itnanls.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {

    private Integer id;
    private String username;
    private String password;



}
