package cn.bitqian.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器 对用户登录拦截..
 * @author echo lovely
 * @date 2020/10/21 16:16
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    // 拦截之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object userLogin = request.getSession().getAttribute("userLogin");

        if (userLogin == null) {
            request.setAttribute("msg", "请登录..");
            request.getRequestDispatcher("/login.html").forward(request, response);
            return false;
        }

        return true;
    }

}
