package top.bitqian.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;
import top.bitqian.web.entity.Pet;

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

    // spring mvc 封装数据时 底层有 100+转换器 用于数据类型的转换 WebDataBinder相关..
    @Override
    public void addFormatters(FormatterRegistry registry) {
        // string convert to pet when mvc wrapper data..
        registry.addConverter(
            (PetConverter) source -> {
                Pet p = new Pet();
                // the format like "id,name"
                if (!StringUtils.isEmpty(source) && source.contains(",")) {
                    String[] split = source.split(",");
                    p.setId(Integer.parseInt(split[0]));
                    p.setName(split[1]);
                    return p;
                }
                return p;
            }
        );
    }

    // convert 是泛型 使用lambda表达式的时候需要指定类型
    interface PetConverter extends Converter<String, Pet> {
        @Override
        Pet convert(String source);
    }
}
