package top.bitqian.hello.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.bitqian.hello.constant.OssConstantConfig;
import top.bitqian.hello.constant.OssLoadConstant;
import top.bitqian.hello.entity.Car;
import top.bitqian.hello.entity.Person;
import top.bitqian.hello.entity.Pet;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author echo lovely
 * @date 2021/3/8 15:04
 */

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {

        return "hello, bit Q adorable";
    }

    @GetMapping("/people")
    public List<Person> people() {

        return Arrays.asList(
                new Person(1, "a", new Pet("tom")),
                new Person(2, "b", new Pet("jerry"))
        );
    }

    @GetMapping("/map")
    public Map<String, String> showInfo() {

        Map<String, String> map = new ConcurrentHashMap<>();

        map.put("name", "abc");
        map.put("age", "10");

        return map;
    }

    @Resource
    private Car myCar;

    @GetMapping("/car")
    public Car getCar(@Qualifier("car") Car car) { // param, bean config value.. is empty props by Qualifier

        // car 里面的属性值不会被yml里面的值绑定, 但是car会被初始化
        System.out.println(car);
        return myCar;
    }

    @Resource
    private OssConstantConfig ossConstantConfig;

    @GetMapping("/oss-yml")
    public Object getOssConfigByYml() {

        return this.ossConstantConfig;
    }

    @Resource
    private OssLoadConstant ossLoadConstant;

    @GetMapping("/oss-load")
    public Object getOssLoad() {

        return ossLoadConstant;
    }
}
