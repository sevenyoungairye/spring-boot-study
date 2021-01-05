package top.bitqian.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.bitqian.config.AuthTokenCheck;
import top.bitqian.entity.Code2Session;
import top.bitqian.entity.WeiXinUser;
import top.bitqian.service.WeiXinUserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 微信登录 controller~
 * @author echo lovely
 * @date 2020/12/4 21:36
 */

@RestController
@Slf4j
public class WeiXinUserController {

    @Autowired
    private WeiXinUserService weiXinUserService;

    // 调用微信的接口获取 app_id
    @RequestMapping("/getCode/{jsCode}")
    public Code2Session getWinXinJson(@PathVariable("jsCode") String jsCode) {

        return weiXinUserService.getWinXinJson(jsCode);
    }

    // 用户提交wx_id 过来注册
    @RequestMapping("/wx_user/register")
    public boolean doRegister(WeiXinUser user) {

        // 账号存在..
        WeiXinUser tmpUser = weiXinUserService.getWeiXinUserByOpenId(user.getWxOpenId());

        if (tmpUser != null) {
            return false;
        }

        // 不存在，即注册
        user.setCreateDate(new Date(System.currentTimeMillis()));
        weiXinUserService.addWeiXinUser(user);

        return true;
    }

    @RequestMapping("/wx_user/login")
    public String doLogin(WeiXinUser weiXinUser) throws Exception {

        return weiXinUserService.doLogin(weiXinUser);
    }

    @AuthTokenCheck
    @RequestMapping("/wx_user/msg")
    public String testJwtToken(HttpServletRequest request) {

        Object userId = request.getAttribute("id");

        System.out.println("userId from page token~=======>" + userId);

        return "auth by token~" + userId;
    }


}
