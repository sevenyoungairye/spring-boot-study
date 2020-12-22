package cn.bitqian;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用mybatis 生成代码 all
 *
 * <a>
 *     https://baomidou.com/config/generator-config.html
 * </p>
 * @author echo lovely
 * @date 2020/11/17 09:07
 */

public class CodeGenerator {

    public static void main(String[] args) {

        // 代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();

        globalConfig.setFileOverride(false);
        globalConfig.setOpen(false);
        // 出掉接口
        globalConfig.setServiceName("%sService");

        // 设置输出目录
        globalConfig.setOutputDir(System.getProperty("user.dir") + "/src/main/java");
        globalConfig.setAuthor("echo lovely");
        globalConfig.setDateType(DateType.ONLY_DATE);

        // 开启swagger
        globalConfig.setSwagger2(true);

        autoGenerator.setGlobalConfig(globalConfig);

        // dataSource 配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/mybatis_study?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=Asia/Shanghai");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");

        dataSourceConfig.setDbType(DbType.MYSQL);

        autoGenerator.setDataSource(dataSourceConfig);

        // 包配置
        PackageConfig pkgConfig = new PackageConfig();
        pkgConfig.setParent("cn.bitqian");

        pkgConfig.setMapper("mapper");
        pkgConfig.setEntity("entity");
        pkgConfig.setService("service");
        pkgConfig.setController("controller");

        autoGenerator.setPackageInfo(pkgConfig);

        // 设置模板引擎
        autoGenerator.setTemplateEngine(null);
        autoGenerator.setTemplate(null);

        // 自定义策略
        StrategyConfig strategy = new StrategyConfig();

        // camel命名规则
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setControllerMappingHyphenStyle(true); // id_1_1
        strategy.setRestControllerStyle(true);
        // 开启lombok注解
        strategy.setEntityLombokModel(true);

        // 设置要生成的表
        strategy.setInclude("account");

        // 逻辑删除
        strategy.setLogicDeleteFieldName("deleted");
        // 自动填充配置

        List<TableFill> tableFillList = new ArrayList<>();
        TableFill fill1 = new TableFill("date", FieldFill.INSERT);
        tableFillList.add(fill1);

        // 设置填充的字段
        strategy.setTableFillList(tableFillList);

        // 乐观锁 字段
        strategy.setVersionFieldName("version");

        autoGenerator.setStrategy(strategy);

        // 开启代码生成...
        autoGenerator.execute();
    }


}
