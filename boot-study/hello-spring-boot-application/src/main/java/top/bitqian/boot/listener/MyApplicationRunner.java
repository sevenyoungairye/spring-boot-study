package top.bitqian.boot.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author echo lovely
 * @date 2021/4/10 10:03
 * @description your desc
 */

@Component
public class MyApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) {

        System.out.println("-------- MyApplicationRunner, run");
        args.getOptionNames().forEach(System.out::println);
    }
}
