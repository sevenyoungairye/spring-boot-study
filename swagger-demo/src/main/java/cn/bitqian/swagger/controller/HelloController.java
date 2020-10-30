package cn.bitqian.swagger.controller;

import cn.bitqian.swagger.entity.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * hello world
 * @author echo lovely
 * @date 2020/10/28 19:23
 */
@RestController
public class HelloController {

    @ApiOperation("get/post都可的hello接口")
    @RequestMapping(value = "/hello")
    public String hello() {

        return "hello";
    }

    @ApiOperation("get的hello接口, 返回一个空 user")
    @GetMapping(value = "/hello1")
    public User hello1() {

        return new User();
    }

    @ApiOperation("hello1 接口post way~")
    @PostMapping(value = "/hello1")
    public User hello1(@ApiParam("传递用户") User user) {

        return user;
    }

    @ApiOperation("登录接口 post way~")
    @PostMapping(value = "/login")
    public String login(@ApiParam("登录用户名") @RequestParam("username") String username,
                        @ApiParam("登录密码")  @RequestParam("password") String password) {

        return "ok" + "{" + username + ", " + password + "}";
    }


}
