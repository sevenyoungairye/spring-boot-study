package top.bitqian;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("top.bitqian.mapper")
@SpringBootApplication
public class MinProgramCommentApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinProgramCommentApplication.class, args);
    }

}
