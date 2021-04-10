package top.bitqian.boot.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author echo lovely
 * @date 2021/4/10 10:01
 * @description your desc
 */

public class MyContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("=====> MyContextInitializer initialize");
    }
}
