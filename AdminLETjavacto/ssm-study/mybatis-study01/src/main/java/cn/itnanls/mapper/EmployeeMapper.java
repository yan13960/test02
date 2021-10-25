package cn.itnanls.mapper;

import cn.itnanls.entity.Employee;

import java.util.List;

/**
 *
 */
public interface EmployeeMapper {

    Employee findEmployeeById(Integer id);

    Employee findEmployeeById2(Integer id);

    /**
     * 获取所有的员工
     * @return
     */
    List<Employee> findAllEmployees();
}
