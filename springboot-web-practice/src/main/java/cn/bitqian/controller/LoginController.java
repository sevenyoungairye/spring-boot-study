package cn.bitqian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author echo lovely
 * @date 2020/10/21 15:22
 */
@Controller
public class LoginController {

    @RequestMapping("/user/login")
    public String doLogin(@RequestParam(value = "username") String username,
                          @RequestParam(value = "password") String password,
                          Model model, HttpSession session) {

        System.out.println(username + "\t" + password);

        // 账号不为空 并且 密码123
        if (!StringUtils.isEmpty(username) && "123".equals(password)) {
            session.setAttribute("userLogin", username);

            return "redirect:/index.html";
        }

        model.addAttribute("msg", "账号或者密码错误！");

        return "login";
    }

    @RequestMapping(value = "/sign/out")
    public String signOut(HttpSession session) {
        session.invalidate();
        return "redirect:login";
    }


}
