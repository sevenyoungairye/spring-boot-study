package top.bitqian.config;

import com.auth0.jwt.interfaces.Claim;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 拦截器
 * @author echo lovely
 * @date 2020/12/5 20:28
 */

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    /**
     * 拦截器需要被注册进..
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TokenInterceptor());
    }


}

class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

        System.out.println("进来l...");
        // 对方法进行拦截
        if (! (handler instanceof HandlerMethod)) {
            return true;
        }

        // 方法对象
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        Method methodTarget = handlerMethod.getMethod();

        // 对加了AuthTokenCheck注解 的方法进行token验证~
        boolean isTokenTarget = methodTarget.isAnnotationPresent(AuthTokenCheck.class);

        if (isTokenTarget) {
            // 进行token验证, 头部里面的token
            // String authorizeToken = request.getHeader("authorize_token");
            String authorizeToken = request.getParameter("authorize_token");

            try {
                Map<String, Claim> claimMap = JwtUtil.parseToken(authorizeToken);
                // 解析获取token中的用户id~ 也可根据相应的键获取其它信息
                Integer id = claimMap.get("id").asInt();

                String userName = claimMap.get("userName").asString();

                System.out.println(id + "\t" + userName);

                // 放入request中
                request.setAttribute("id", id);

                return true;
            } catch (Exception e) {

                return false;
            }

        }

        return true;

    }
}
