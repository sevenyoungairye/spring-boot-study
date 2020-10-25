package cn.bitqian.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

/**
 * druid 配置类
 * @author echo lovely
 * @date 2020/10/23 22:01
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DruidDataSource druidDataSource() {

        return new DruidDataSource();
    }

    // 后台监控: web.xml ServletRegistrationBean
    // spring boot 内置了servlet 没有web.xml配置文件，所以用下面的方式配置
    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean servletRegistrationBean = new
                ServletRegistrationBean(new StatViewServlet(), "/druid/*");

        Map<String, String> initParameters = new HashMap<>();

        // 后台登录的账号密码
        // initParameters.put("jmxUsername", "admin"); // loginUsername
        // initParameters.put("jmxPassword", "123"); // loginPassword
        initParameters.put("loginUsername", "admin"); // loginUsername
        initParameters.put("loginPassword", "123"); // loginPassword

        // 允许访问 白名单
        initParameters.put("allow", "127.0.0.1");

        // initParameters.put("deny", "168.403.432.234"); 禁止访问黑名单

        servletRegistrationBean.setInitParameters(initParameters);

        return servletRegistrationBean;
    }

    /**
     * 过滤器
     * @return null
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

        // 过滤请求
        filterRegistrationBean.setFilter(new WebStatFilter());

        Map<String, String> initParameters = new HashMap<>();

        // 设置静态资源放行
        initParameters.put("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");

        filterRegistrationBean.setInitParameters(initParameters);

        return filterRegistrationBean;
    }


}
