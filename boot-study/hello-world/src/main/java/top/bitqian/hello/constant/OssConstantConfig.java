package top.bitqian.hello.constant;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 此Java类与配置文件绑定了.
 * @author echo lovely
 * @date 2021/3/20 09:36
 */

/*
  1. 绑定方法1:
  @Component
  @ConfigurationProperties(prefix = "oss-constant")

  2. 绑定方法2:
  实体配置类, @ConfigurationProperties(prefix = "oss-constant")
  在配置类上开启和配置文件(yml, properties)绑定 :
  @EnableConfigurationProperties(value = {OssConstantConfig.class})
 */


@Data
@Component
@ConfigurationProperties(prefix = "oss-constant")
public class OssConstantConfig {

    private String endpoint;

    private String accessKey;

    private String secretKey;

    private String bucket;
}
