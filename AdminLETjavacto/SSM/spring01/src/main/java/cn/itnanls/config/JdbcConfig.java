package cn.itnanls.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 *注入有状态的bean用@Configuration 就是需要注入值  @Bean  @Configuration
 * 注入无状态的bean用@Component  @Componen  @Value
 */
@Configuration
public class JdbcConfig {
    //java代码实现JdbcTemplate的注入
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }
}
