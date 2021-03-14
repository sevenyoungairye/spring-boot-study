package top.bitqian.hello.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
// import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author echo lovely
 * @version 0.0.1
 * @date 2021/03/12/17:38
 * @description
 * <p>
 *     car -> 配置绑定, 将application.yml 中的属性绑定到Java实体类中
 * ConfigurationProperties
 *
 * 1. component + ConfigurationProperties 将yml配置文件注入到Java配置类中
 *
 * 2. ConfigurationProperties + EnableConfigurationProperties 将值注入到Java类中
 *
 * </p>
 */

// @Component
@ConfigurationProperties(value = "mycar")
@Data
public class Car {

    private String brand;

    private BigDecimal price;

}
