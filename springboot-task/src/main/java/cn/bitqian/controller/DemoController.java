package cn.bitqian.controller;

import cn.bitqian.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 任务测试
 * @author echo lovely
 * @date 2020/10/30 8:58
 */
@RestController
public class DemoController {

    @Autowired
    AsyncService asyncService;

    @GetMapping("/hello")
    public String hello() {

        asyncService.hello();

        return "ok";
    }

}
