package cn.bitqian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 路由跳转
 * @author echo lovely
 * @date 2020/10/25 15:52
 */
@Controller
public class RouterController {

    @RequestMapping({"/", "/index"})
    public String toIndex() {

        return "views/index";
    }

    @RequestMapping(value = "/login")
    public String toLogin() {

        return "login";
    }

    // level1 three pages
    @RequestMapping(value = "/level1/{levelId}")
    public String level1(@PathVariable(value = "levelId") int levelId) {
        return "views/level1/level1-" + levelId;
    }

    // level2 three pages
    @RequestMapping(value = "/level2/{levelId}")
    public String level2(@PathVariable(value = "levelId") int levelId) {
        return "views/level2/level2-" + levelId;
    }

    // level3 three pages
    @RequestMapping(value = "/level3/{levelId}")
    public String level3(@PathVariable(value = "levelId") int levelId) {
        return "views/level3/level3-" + levelId;
    }


}
