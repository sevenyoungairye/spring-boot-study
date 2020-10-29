package cn.bitqian.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * page router
 * @author echo lovely
 * @date 2020/10/27 15:54
 */
@Controller
public class MyController {

    @RequestMapping(value = {"/", "index", "index.html"})
    public String helloShiro(Model model) {
        model.addAttribute("msg", "hello shiro!");
        return "index";
    }

    @RequestMapping(value = "/add")
    public String add() {
        return "user/add";
    }

    @RequestMapping(value = "/update")
    public String update() {
        return "user/update";
    }

    @GetMapping(value = "/login")
    public String toLoginPage() {
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(String username, String password, Model model) {

        // 设置用户名 跟 密码
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);

        // 获取当前用户对象
        Subject subject = SecurityUtils.getSubject();

        try {
            // 执行了登录操作
            subject.login(usernamePasswordToken);

            return "index";
        } catch (UnknownAccountException uae) { // 账号不存在
            model.addAttribute("msg", "账号错误");
            return "login";
        } catch (IncorrectCredentialsException ice) { // 密码错误
            model.addAttribute("msg", "密码错误");
            return "login";
        }

    }

    @RequestMapping(value = "/unauthorized")
    @ResponseBody
    public String toUnauthorized() {
        return "未经授权，不许访问！";
    }

}
