package cn.itnanls.dao;

import cn.itnanls.entity.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 根据ID查询用户表信息
 * 1.创建工程
 * 2.导入mybatis的jar包
 * 3.数据库初始化
 * 4.创建对应的实体类
 * 5.创建SqlMapConfig.xml配置文件并配置
 * 6.创建StudentMapping.xml 在这里写sql语句
 * 7.把StudentMapper.xml配置到SqlMapConfig.xml文件当中
 * 8.测试
 */
public interface StudentDao {
    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    @Select("select id,username,password from student where id=#{id}")
    Student selectStudentById(int id);
    /**
     * 删除一个用户
     * @param id
     * @return
     */
    @Delete("delete from student where id = #{id}")
    int deleteStudentById(int id);

    /**
     * 修改用户
     * @param Student
     * @return
     */
    @Update("update student set username=#{username},password=#{password} where id = #{id}")
    int updateStudent(Student Student);
    /**
     * 新增用户
     * @param
     * @param Student
     * @param
     * @return
     */
    @Insert("insert into student (id,username,password) values (#{id},#{username},#{password})")
    int saveStudent(Student Student);

    /**
     * 返回所有的用户
     * @return
     */

    List<Student> findAllStudents();

    /**
     * 根据id查找用户
     * @param Student
     * @return
     */
    List<Student> queryStudents(Student Student);

    /**
     * 查询名字相关的用户
     * @param name
     * @return
     */
    List<Student> findStudentsByName(String name);

    /**
     * 查询名字相关的用户  模糊查询
     * @param name
     * @return
     */
    List<Student> findStudentsByName2(String name);
}
