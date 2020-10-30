package cn.bitqian.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * swagger配置类
 * @author echo lovely
 * @date 2020/10/28 19:35
 */
@Configuration
@EnableSwagger2 // 开启swagger2

public class SwaggerConfig {

    // 定制多个用户组， 多个人可编写多个文档接口..
    @Bean
    public Docket docket1() {

        return new Docket(DocumentationType.SWAGGER_2).groupName("bitqian666 group1");
    }

    @Bean
    public Docket docket12() {

        return new Docket(DocumentationType.SWAGGER_2).groupName("bitqian666 group2");
    }

    @Bean
    public Docket docket2() {

        return new Docket(DocumentationType.SWAGGER_2).groupName("bitqian666 group3");
    }

    @Bean
    public Docket docket3() {

        return new Docket(DocumentationType.SWAGGER_2).groupName("bitqian666 group4");
    }

    @Bean
    public Docket docket(Environment environment) {

        // 获取当前环境 是生产环境 启动swagger
        boolean isProFlag = environment.acceptsProfiles(Profiles.of("pro"));

        System.out.println("is dev environment....===========>" + isProFlag);

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(appInfo()).groupName("bitqian").
                enable(isProFlag). // 是否启动swagger 如果为false，则不能在浏览器中使用swagger
                select().
                apis(RequestHandlerSelectors.basePackage("cn.bitqian.swagger.controller")).
                // paths(PathSelectors.ant("/hello/**")).
                build();
    }

    // api 信息 接口文档的头部信息描述
    public ApiInfo appInfo() {

        Contact contact = new Contact("bitqian", "http://example.cn", "admin-@www.example.cn");

        return new ApiInfo("bitqian的swagger文档",
                "用来描述此接口的功能，内容。",
                "v1.0",
                "http://example.cn", contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }


}
