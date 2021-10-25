package cn.itnanls.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept implements Serializable {

    private int id;
    private String name;

    //2.一对多关系，写一个list即可
    private List<Employee> employees;
}
