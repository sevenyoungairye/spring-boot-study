package cn.bitqian.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * mybatis plus配置类
 * @author echo lovely
 * @date 2020/11/15 09:48
 */

@EnableTransactionManagement // 开启事务
@MapperScan("cn.bitqian.mapper")
@Configuration
public class MyBatisPlusConfig {

    // mybatis插件注册
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {

        // 乐观锁
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();

        // 添加乐观锁到插件中
        mybatisPlusInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());

        // 分页查询
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();

        // 添加分页查询到插件中
        mybatisPlusInterceptor.addInnerInterceptor(paginationInnerInterceptor);

        return mybatisPlusInterceptor;

    }


}
