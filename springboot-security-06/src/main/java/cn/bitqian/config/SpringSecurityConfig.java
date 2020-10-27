package cn.bitqian.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @description spring security test
 * @author echo lovely
 * @date 2020/10/25 19:46
 */

@EnableWebSecurity // 启用安全框架
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    // 授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 链式编程
        http.authorizeRequests().antMatchers("/").permitAll(). // 首页允许所有人访问
                antMatchers("/level1/**").hasRole("vip1"). // vip1才能访问level1..
                antMatchers("/level2/**").hasRole("vip2").
                antMatchers("/level3/**").hasRole("vip3");

        // 没有权限默认会到登录页面，需要开启的登录页面
        // 账号 密码 与 表单的name要一致
        http.formLogin().loginPage("/login").loginProcessingUrl("/login"). // 指定一个特殊的页面登录!
                usernameParameter("username").passwordParameter("password");
        // 支持post请求
        http.csrf().disable();

        // 注销 退出登录到login 页面
        http.logout().logoutSuccessUrl("/login");

        // 记住我 cookie
        http.rememberMe().rememberMeParameter("remember"); //记住我表单
    }

    // 认证方式
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 内存数据
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).
                withUser("jack").password(new BCryptPasswordEncoder().encode("123")).roles("vip1", "vip2").
                and().withUser("root").password(new BCryptPasswordEncoder().encode("123")).roles("vip1", "vip2", "vip3").
                and().withUser("guest").password(new BCryptPasswordEncoder().encode("123")).roles("vip1");
    }

}
