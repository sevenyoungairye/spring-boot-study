package top.boy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author echo lovely
 * @version 0.0.1
 * @date 2021/03/11/16:48
 * @description tkMapper 生成器
 */

@MapperScan("top.boy.mapper")
@SpringBootApplication
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

}
