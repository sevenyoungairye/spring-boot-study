package top.bitqian.service;

import org.springframework.web.bind.annotation.PathVariable;
import top.bitqian.entity.Code2Session;
import top.bitqian.entity.WeiXinUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author echo lovely
 * @since 2020-12-04
 */
public interface WeiXinUserService extends IService<WeiXinUser> {

    Code2Session getWinXinJson(@PathVariable("jsCode") String jsCode);

    WeiXinUser getWeiXinUserByOpenId(String openId);

    String doLogin(WeiXinUser weiXinUser) throws Exception;

    void addWeiXinUser(WeiXinUser user);

}
