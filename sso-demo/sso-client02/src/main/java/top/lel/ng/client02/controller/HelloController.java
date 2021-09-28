package top.lel.ng.client02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author echo lovely
 * @date 2021/9/27 22:10
 * @description 登录
 */

@Controller
public class HelloController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    // 登录成功后, 当前登录服务器地址回调, 即当前应用的地址
    @Value("${sso.currentIndexUrl:http://client02.com:10000/}")
    private String currentIndexUrl;

    // 单点服务器地址
    @Value("${sso.server.login.url:http://auth.sso.com:8888/req/login?callbackUrl=}")
    private String ssoServerLoginUrl;

    // 无权限
    @ResponseBody
    @GetMapping("/hello")
    public String hello() {

        return "hello";
    }


    @GetMapping(value = {"/", "/index", "index.html"})
    public String index(HttpSession session,@RequestParam(value = "token", required = false) String token) {

        // 如果登录成功 服务器回调会返回token
        // 根据token获取redis中的用户数据
        if (StringUtils.hasText(token)) {

            String loginUser = this.stringRedisTemplate.opsForValue().get(token);

            if (ObjectUtils.isEmpty(loginUser)) {
                return "redirect:" + ssoServerLoginUrl + currentIndexUrl;
            }
            session.setAttribute("loginUser", loginUser);
        }

        if (session.getAttribute("loginUser") == null) {

            return "redirect:" + ssoServerLoginUrl + currentIndexUrl;
        }

        return "index";
    }
}
