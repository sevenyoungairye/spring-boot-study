package top.bitqian.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * RequestAttribute 注解测试, 多层转发
 * 获取request域属性
 * @author echo lovely
 * @date 2021/3/20 21:08
 */

@Controller
public class RequestAttributeController {

    @GetMapping("/page")
    public String toSuccess(HttpServletRequest request) {

        request.setAttribute("msg", "hello-world");
        request.setAttribute("code", 200);

        return "forward:success";
    }

    @GetMapping("/success")
    @ResponseBody
    public Object toRes(@RequestAttribute("msg") String msg, HttpServletRequest request) {

        Object msg1 = request.getAttribute("msg");

        Map<String, Object> map = new HashMap<>();
        map.put("msg", msg);
        map.put("msg1", msg1);

        return map;
    }
}
