package top.bitqian.auto;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.bitqian.bean.HelloProperties;
import top.bitqian.service.HelloService;

/**
 * @author echo lovely
 * @date 2021/4/8 20:37
 * @description
 * <p>
 *     自动装配类
 * </p>
 */

@Configuration
@EnableConfigurationProperties(HelloProperties.class) // 1. 放入容器, 2. 配置文件与属性绑定
public class HelloAutoConfiguration {

    @ConditionalOnMissingBean
    @Bean
    public HelloService helloService() {

        return new HelloService();
    }

}
