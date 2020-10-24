package cn.bitqian.config;

import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 国际化解析器
 * @author echo lovely
 * @date 2020/10/21 11:28
 */
public class MyLocaleResolver implements LocaleResolver {

    // 解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // 获取请求中的参数
        String parameter = request.getParameter("l");

        // System.out.println(parameter);

        // 获取默认的地区
        Locale localeDefault = Locale.getDefault();

        if (parameter != null) {
            // zh_CN 国家_地区
            String[] splitParameters = parameter.split("_");

            return new Locale(splitParameters[0], splitParameters[1]);
        }

        return localeDefault;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
