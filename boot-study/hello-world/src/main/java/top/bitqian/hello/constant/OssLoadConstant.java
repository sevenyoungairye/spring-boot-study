package top.bitqian.hello.constant;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 加载oss对象存储配置
 * @author echo lovely
 * @date 2021/3/20 09:30
 */

@Data
@Component
public class OssLoadConstant implements InitializingBean {


    @Value("${oss-constant.endpoint}")
    private String endpoint;

    @Value("${oss-constant.access-key}")
    private String accessKeyId;

    @Value("${oss-constant.secret-key}")
    private String accessKeySecret;

    @Value("${oss-constant.bucket}")
    private String bucketName;

    public static String ENDPOINT;
    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;
    public static String BUCKET_NAME;

    @Override
    public void afterPropertiesSet() {
        // 初始化设置值
        ENDPOINT = this.endpoint;
        ACCESS_KEY_ID = this.accessKeyId;
        ACCESS_KEY_SECRET = this.accessKeySecret;
        BUCKET_NAME = this.bucketName;
    }

}
