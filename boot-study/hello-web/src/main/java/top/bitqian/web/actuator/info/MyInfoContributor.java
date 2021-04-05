package top.bitqian.web.actuator.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * @author echo lovely
 * @date 2021/4/5 20:54
 * @description
 * <p>
 *     自定义程序信息
 *     <a href="https://docs.spring.io/spring-boot/docs/2.3.7.RELEASE/reference/html/production-ready-features.html#production-ready-application-info">
 *         pls see
 *     </a>
 * </p>
 */

@Component
public class MyInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("app-info",
                Collections.singletonMap("author", "bitQian")).
                withDetail("website", "https://sevenyoungairye.github.io/");
    }
}
