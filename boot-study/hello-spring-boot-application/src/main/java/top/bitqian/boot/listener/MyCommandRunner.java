package top.bitqian.boot.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author echo lovely
 * @date 2021/4/10 10:06
 * @description your desc
 */

@Component
public class MyCommandRunner implements CommandLineRunner {
    @Override
    public void run(String... args) {
        System.out.println("MyCommandRunner ..... " + Arrays.toString(args));
    }
}
