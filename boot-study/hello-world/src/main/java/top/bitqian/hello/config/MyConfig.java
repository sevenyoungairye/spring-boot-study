package top.bitqian.hello.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import top.bitqian.hello.entity.Car;
import top.bitqian.hello.entity.Person;
import top.bitqian.hello.entity.Pet;

/*
 * @author echo lovely
 * @date 2021/3/7 22:24
 */

/**
 * configuration
 * proxyBeanMethods, 申明当前类配置类是否是代理类, 默认是true
 * true, 则在ioc容器中取值, top.bitqian.hello.config.MyConfig$$EnhancerBySpringCGLIB$$40b8636e@109f5dd8
 * false, 调用方法则创建新的对象, top.bitqian.hello.config.MyConfig@6826c41e
 *
 * 一般为false, 如果组件有相互依赖设置为默认true
 */

@ImportResource(value = {"classpath:beans.xml"})
@EnableConfigurationProperties(value = {Car.class})
// @ConditionalOnBean(name = "tomcat") // 有tomcat这个组件，则将所有bean注入容器
@ConditionalOnMissingBean(name = "tomcat") // 没有有tomcat这个组件，则将所有bean注入容器
@Import(value = {Person.class}) // 将person组件导入容器
@Configuration
public class MyConfig {

    // 将person组件放入容器，默认单例，实例名称为 方法名称
    @Bean
    public Person person01() {

        return new Person(1, "adorable..", pet());
    }

    // id 取值
    // @Bean("tomcat")
    @Bean("tomcat01")
    public Pet pet() {

        return new Pet("hello, tom");
    }

}
