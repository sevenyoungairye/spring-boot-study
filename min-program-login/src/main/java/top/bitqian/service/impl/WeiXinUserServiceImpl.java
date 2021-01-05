package top.bitqian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import top.bitqian.config.HttpClientUtil;
import top.bitqian.config.JwtUtil;
import top.bitqian.config.WeiXinPostParamConstant;
import top.bitqian.entity.Code2Session;
import top.bitqian.entity.WeiXinUser;
import top.bitqian.mapper.WeiXinUserMapper;
import top.bitqian.service.WeiXinUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author echo lovely
 * @since 2020-12-04
 */
@Service
public class WeiXinUserServiceImpl extends ServiceImpl<WeiXinUserMapper, WeiXinUser> implements WeiXinUserService {

    /**
     * 获取openid session_key
     * @param jsCode 小程序请求到的jsCode
     * @return 授权信息~
     */
    @Override
    public Code2Session getWinXinJson(String jsCode) {

        // https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
        StringBuilder url = new StringBuilder();
        url.append("https://api.weixin.qq.com/sns/jscode2session?appid=");
        url.append(WeiXinPostParamConstant.APP_ID);
        url.append("&secret=");
        url.append(WeiXinPostParamConstant.SECRET);
        url.append("&js_code=");
        url.append(jsCode);
        url.append("&grant_type=authorization_code");

        try {
            String weiXinJson = HttpClientUtil.httpGetRequest(url.toString());
            System.out.println(weiXinJson);

            return new ObjectMapper().readValue(weiXinJson, Code2Session.class);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Autowired
    private WeiXinUserMapper userMapper;

   public WeiXinUser getWeiXinUserByOpenId(String openId) {


       WeiXinUser tmpUser = new WeiXinUser();
       tmpUser.setWxOpenId(openId);
       QueryWrapper<WeiXinUser> queryWrapper = new QueryWrapper<>(tmpUser);

       return userMapper.selectOne(queryWrapper);

    }

    @Override
    public String doLogin(WeiXinUser user) throws Exception {

        // 登录需要：
        // 1. 根据小程序传来的openid验证数据库中的id，看是否存在~
        WeiXinUser weiXInUser = getWeiXinUserByOpenId(user.getWxOpenId());

        System.out.println("doLogin----->" + weiXInUser);

        if (weiXInUser != null) {
            // 2. 存在 返回jwt签名~  页面保存
            return JwtUtil.createToken(weiXInUser);
        }

        // 2. 不存在 return ""
        return null;
    }

    @Override
    public void addWeiXinUser(WeiXinUser user) {

       //  userMapper.addWeiXinUser(user);
        userMapper.insert(user);
    }
}
