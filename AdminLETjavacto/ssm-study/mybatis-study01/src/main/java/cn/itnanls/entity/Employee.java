package cn.itnanls.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {
    private int id;
    private String name;

    //维护关系 1.一对一关系，需要什么表的信息，就写对应的表的实体类
    private Dept dept;
}
