package cn.itnanls.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 *注入有状态的bean用@Configuration 就是需要注入值  @Bean  @Configuration
 * 注入无状态的bean用@Component  @Componen  @Value
 */
@Configuration
public class DateSourceConfig {
    @Bean
    public DataSource dataSource(){
        Map<String,String> config =new HashMap<>(4);
        config.put("driverClassName","com.mysql.cj.jdbc.Driver");
        config.put("password","1234");
        config.put("url","jdbc:mysql://127.0.0.1:3306/ssm2?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true&useSSL=false");
        config.put("username","root");
        try {
            return DruidDataSourceFactory.createDataSource(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
