package cn.itnanls;

import cn.itnanls.controller.UserController;
import cn.itnanls.entity.SqlUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application6.xml")
public class SpringTest {
@Autowired
private  DataSource dataSource;
@Autowired
private UserController userController;


@Autowired
private JdbcTemplate jdbcTemplate;

@Test
public void iocTest(){
        /*System.out.println(dataSource);
        userController.showUser(1);
        System.out.println(address2);*/
       /* jdbcTemplate.execute("insert into user values(100,'a','b')");
    int update = jdbcTemplate.update("update user set username =? where id=?",
            new Object[]{"lucy", 100});
    System.out.println(update);*/

    RowMapper<SqlUser> rowMapper=new RowMapper<SqlUser>() {
        @Override
        public SqlUser mapRow(ResultSet rs, int rowNum) throws SQLException {
          SqlUser sqlUser =new SqlUser();
          sqlUser.setId(rs.getInt("id"));
          sqlUser.setUserName(rs.getString("username"));
          sqlUser.setPassword(rs.getString("password"));
            return sqlUser;
        }
    } ;
    List<SqlUser> query = jdbcTemplate.query("select id ,username,password from user",
            rowMapper);

    for (SqlUser sqlUser : query) {
        System.out.println(sqlUser);
    }
}
        }
