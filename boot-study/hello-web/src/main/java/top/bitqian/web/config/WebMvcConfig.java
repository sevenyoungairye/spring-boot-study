package top.bitqian.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

/**
 * 定制化webMVC组件, 增加扩展功能
 * <p>
 *     <a href="https://docs.spring.io/spring-boot/docs/2.4.3/reference/pdf/spring-boot-reference.pdf">pls see ..</a>
 * </p>
 * @author echo lovely
 * @date 2021/3/20 14:53
 */

@Configuration(proxyBeanMethods = false)
public class WebMvcConfig implements WebMvcConfigurer {

    // 单体应用, 表单提交restful
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {

        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();

        // 设置参数为 key: _m, value: put/delete/patch...
        hiddenHttpMethodFilter.setMethodParam("_m");

        return hiddenHttpMethodFilter;
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();

        // 支持分号 矩阵url传参。
        urlPathHelper.setRemoveSemicolonContent(false);

        configurer.setUrlPathHelper(urlPathHelper);
    }
}
