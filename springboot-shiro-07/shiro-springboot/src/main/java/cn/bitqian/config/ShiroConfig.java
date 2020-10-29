package cn.bitqian.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro的配置类
 * @author echo lovely
 * @date 2020/10/27 16:03
 */
@Configuration
public class ShiroConfig {

    // 1. 自定义realm对象
    @Bean(name = "authorizingRealm")
    public AuthorizingRealm authorizingRealm() {
        return new UserRealm();
    }

    // 2. DefaultWebSecurityManager
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("authorizingRealm") AuthorizingRealm authorizingRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        // 关联UserRealm
        securityManager.setRealm(authorizingRealm);

        return securityManager;
    }

    // 3. ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") SecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        /**
         * anon 无需认证就可访问
         * authc 必须认证了才能访问
         * user 必须拥有 记住我 功能
         * perms 拥有对某个资源的权限
         * roles 角色权限
         */
        Map<String, String> filterMap = new LinkedHashMap<>();
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        // filterMap.put("/*", "authc");
        // 必须认证 才可用
        filterMap.put("/update", "authc");
        filterMap.put("/add", "authc");

        // 必须有某个资源的权限 授权 正常的情况下，没有授权会跳转到未授权页面
        // user:add 和 user:update 的权限
        filterMap.put("/add", "perms[user:add]");
        filterMap.put("/update", "perms[user:update]");

        // 设置登录请求
        shiroFilterFactoryBean.setLoginUrl("login");

        // 没有权限 跳转到提示到页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");

        return shiroFilterFactoryBean;
    }

    @Bean // 用来整合thymeleaf
    public ShiroDialect getShiroDialect() {

        return new ShiroDialect();
    }

}
