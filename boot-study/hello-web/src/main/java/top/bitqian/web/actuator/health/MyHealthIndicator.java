package top.bitqian.web.actuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * @author echo lovely
 * @date 2021/4/5 20:17
 * @description
 * <p>
 *     <li>
 *         自定义健康检查..
 *     </li>
 *     根据业务, 此服务是否健康
 * </p>
 */

@Component
public class MyHealthIndicator extends AbstractHealthIndicator {

    @Override
    protected void doHealthCheck(Health.Builder builder) {

        // 业务判断
        if (Boolean.TRUE) {
            // 服务健康
            builder.status(Status.UP).
                    withDetails(Collections.singletonMap("msg", "the service is okk")).
                    withDetail("code", 200);
        } else {
            builder.status(Status.OUT_OF_SERVICE).withDetail("msg", "something wrong..");
        }

    }
}
