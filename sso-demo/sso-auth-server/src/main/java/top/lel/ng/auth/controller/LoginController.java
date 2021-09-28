package top.lel.ng.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author echo lovely
 * @date 2021/9/27 22:52
 * @description 登录服务器处理客户端的请求
 */

@Controller
public class LoginController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    // 处理其它服务器的login请求..
    @GetMapping("/req/login")
    public String toLoginPage(@RequestParam("callbackUrl") String callbackUrl,
                              Model model,
                              @CookieValue(value = "token", required = false) String token
    )
    {
        if (StringUtils.hasText(token)) {
            // token 存在, 将当前sso下保存的cookie设置到请求的服务

            String tokenValue = this.stringRedisTemplate.opsForValue().get(token);
            // token 未过期, 否则继续登录..
            if (StringUtils.hasText(tokenValue)) {
                callbackUrl = callbackUrl + "?token=" + token;
                return "redirect:" + callbackUrl;
            }
        }

        model.addAttribute("callbackUrl", callbackUrl);

        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(String username, String password, @RequestParam("callbackUrl") String callBackUrl, HttpServletResponse response) {

        if (StringUtils.hasText(username) && StringUtils.hasText(password)) {

            // 登录成功.. 跳回请求服务器 client01.com
            String token = UUID.randomUUID().toString().replaceAll("-", "");
            // 保存当前登录信息， 这里只保存了用户名
            this.stringRedisTemplate.opsForValue().set(token, username, 30L, TimeUnit.MINUTES);

            // 登录的服务端应该将写cookie信息到浏览器, 下次有人登录时直接转到对应的模块, 这个请求就不用登录了
            // 取到session在跳转到原来的地址, 原来的模块可以根据token查到用户信息
            Cookie cookie = new Cookie("token", token);
            response.addCookie(cookie);

            // 将token回调给客户端 方便客户端从redis取到登录信息信息
            callBackUrl = callBackUrl + "?token=" + token;
            return "redirect:" +  callBackUrl;
        }

        return "";
    }
}
