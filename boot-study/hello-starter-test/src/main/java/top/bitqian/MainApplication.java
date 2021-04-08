package top.bitqian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.bitqian.service.HelloService;

import javax.annotation.Resource;

/**
 * @author echo lovely
 * @date 2021/4/8 21:02
 * @description <p>
 *     测试启动器
 * </p>
 */

@RestController
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Resource
    private HelloService helloService;

    @GetMapping("/hello")
    public Object hello() {

        return helloService.sayHello("bitQian");
    }
}
