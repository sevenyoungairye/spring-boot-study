package top.bitqian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import top.bitqian.hello.config.MyConfig;
import top.bitqian.hello.entity.Person;
import top.bitqian.hello.entity.Pet;

import java.util.Arrays;

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(basePackages = "top.bitqian.hello")
// @SpringBootApplication
public class HelloWorldApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext run =
                SpringApplication.run(HelloWorldApplication.class, args);

        // condition条件注解
        System.out.println("当前bean tom是否在容器: " + run.containsBean("tomcat"));
        System.out.println(run.containsBean("person01"));
        System.out.println(run.containsBean("tomcat01"));

        System.out.println("personInXML--->" + run.containsBean("personInXML"));

    }

    static void configurationDemo(ConfigurableApplicationContext run) {

        // 获取所有的bean的id
        Arrays.stream(run.getBeanDefinitionNames()).forEach(System.out::println);

        // 容器中的两只猫相等 默认单例
        Pet t1 = run.getBean("tomcat", Pet.class);
        Pet t2 = run.getBean("tomcat", Pet.class);
        System.out.println("两只猫 🐱" + (t1 == t2));

        // 获取容器中的组件
        Person p = run.getBean("person01", Person.class);
        System.out.println(p);

        MyConfig myConfig = run.getBean("myConfig", MyConfig.class);

        System.out.println("获取配置类\t" + myConfig);

        System.out.println(myConfig.person01() == p);

        System.out.println(myConfig.pet() == run.getBean("tomcat", Pet.class));

        System.out.println(myConfig.pet() == p.getPet());

        // 获取环境上下文
        /*Map<String, Object> envMap = run.getEnvironment().getSystemEnvironment();
        envMap.forEach((k, v) ->
            System.out.println(k + "\t" + v)
        );*/

        System.out.println("app name: " + run.getApplicationName());

        System.out.println("**************import********************");

        // import导组件到ioc中, 获取bean的名称
        Arrays.stream(run.getBeanNamesForType(Person.class)).forEach(System.out::println);

    }

}
