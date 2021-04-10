package top.bitqian.boot.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author echo lovely
 * @date 2021/4/10 09:38
 * @description
 * <p>
 *     my listener, this will be running in boot starting...
 * </p>
 */

@Slf4j
public class MyRunListener implements SpringApplicationRunListener {

    public MyRunListener(SpringApplication application, String[] args) { }

    @Override
    public void starting() {
       log.info("boot starting....");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        log.debug("environmentPrepared...");
        environment.getPropertySources().forEach(r -> log.info("source===> {}", r.getName()));
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        log.info("contextPrepared, ioc prepare finished!");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        log.info("contextLoaded ioc is loading...");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        log.info("started.");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        log.info("running.");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        log.info("program failed...");
    }
}
