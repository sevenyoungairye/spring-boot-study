package top.bitqian.web.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author echo lovely
 * @description
 * <p>
 *      自定义异常解析器
 * </p>
 * @since 2021/4/3 19:12
 */

@Order(value = Ordered.HIGHEST_PRECEDENCE) // 数值越小,越优先处理
// @Component
public class MyHandlerException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler,
                                         Exception ex) {

        // 没有token
        if (!StringUtils.hasText(request.getHeader("token"))) {

            try {
                response.sendError(4444, "no token..");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return new ModelAndView();
    }
}
