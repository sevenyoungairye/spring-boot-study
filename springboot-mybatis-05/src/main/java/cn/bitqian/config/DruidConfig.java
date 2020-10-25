package cn.bitqian.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;

/**
 * @author echo lovely
 * @date 2020/10/25 11:26
 */
@Configuration
public class DruidConfig {

    // 自动装配
    @ConfigurationProperties(value = "spring.datasource")
    @Bean
    public DruidDataSource druidDataSource() {
        return new DruidDataSource();
    }

    // 注册 druid监控bean
    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");

        Map<String, String> initParameters = new HashMap<>();

        initParameters.put("loginUserName", "admin");
        initParameters.put("loginPassword", "123");

        initParameters.put("allow", "127.0.0.1");

        bean.setInitParameters(initParameters);

        return bean;
    }
}
