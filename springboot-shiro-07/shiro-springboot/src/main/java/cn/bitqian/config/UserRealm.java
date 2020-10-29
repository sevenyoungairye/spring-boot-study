package cn.bitqian.config;

import cn.bitqian.entity.Users;
import cn.bitqian.mapper.UsersMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 用户认证
 * @author echo lovely
 * @date 2020/10/27 15:58
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UsersMapper usersMapper;

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        System.out.println("授权认证=> PrincipalCollection");

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        // 对user:add授权
        // authorizationInfo.addStringPermission("user:add");

        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();
        Users users = (Users) subject.getPrincipal();

        // 进行身份认证 设置当前用户的权限
        authorizationInfo.addStringPermission(users.getPermission());

        return authorizationInfo;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        System.out.println("登录认证=> AuthenticationToken");

        // 用户名 密码认证
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;

        // 页面用户名
        String tokenUsername = userToken.getUsername();

        // 数据库中是否存在该用户
        Users users = usersMapper.findUsersByUsersName(tokenUsername);

        if (users == null) {
            return null;
        }

        SecurityUtils.getSubject().getSession().setAttribute("loginUser", users);

        // principal 用户认证 用户里面存在权限
        return new SimpleAuthenticationInfo(users, users.getUserPassword(), ""); // 密码自动验证
    }
}
