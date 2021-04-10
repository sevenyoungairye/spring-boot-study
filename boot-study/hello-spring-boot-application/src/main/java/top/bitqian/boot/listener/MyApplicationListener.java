package top.bitqian.boot.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author echo lovely
 * @date 2021/4/10 09:57
 * @description your desc
 */

public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("MyApplicationListener onApplicationEvent...................");
    }
}
