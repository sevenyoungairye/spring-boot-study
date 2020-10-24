package cn.bitqian.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author echo lovely
 * @date 2020/10/20 21:17
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    // ctrl + alt + b 快速查看自己的子类

    // 跳转对应的视图 login/index 为templates下面的页面
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");

        registry.addViewController("/index.html").setViewName("index");
    }

    /**
     * 自定义国际化组件 方法名得和超级接口是一致..
     * @return 自定义的组件
     */
    @Bean
    public LocaleResolver localeResolver() {

        return new MyLocaleResolver();
    }

    /**
     * 自定义拦截器，对除了登录页面，登录controller之外的进行拦截..
     * @param registry 自定义拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).
                addPathPatterns("/**").
                excludePathPatterns("/", "/login.html", "/user/login",
                        "/static/**", "/js/**", "/css/**", "/img/**", "/fonts/**");
    }

   /* @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }*/


}
