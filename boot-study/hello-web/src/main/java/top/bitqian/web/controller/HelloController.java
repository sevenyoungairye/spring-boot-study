package top.bitqian.web.controller;

import org.springframework.web.bind.annotation.*;
import top.bitqian.web.entity.Person;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author echo lovely
 * @date 2021/3/20 11:24
 */

@RestController
public class HelloController {

    /*@GetMapping(value = {"/index", "/index.html"})
    public String index() {

        return "index";
    }*/

    @PutMapping("/user")
    public String upd(HttpServletResponse response) {

        Cookie cookie = new Cookie("love", "missing");

        response.addCookie(cookie);
        return "put-way~";
    }

    // springMvc 数据交互注解
    @GetMapping("/user/{id}/info/{username}")
    public Map<String, Object> hello(@PathVariable("id") String id,
                                     @PathVariable("username") String username,
                                     // @PathVariable Map<String, String> iuMap,
                                     @RequestParam("key") String key,
                                     @RequestParam("value") String value,
                                     @RequestParam Map<String, String> paramMap,
                                     @RequestHeader("Host") String host,
                                     @RequestHeader Map<String, String> headers,
                                     @CookieValue("love") String love,
                                     @CookieValue("love") Cookie cookie
                                    ) {

        Map<String, Object> resMap = new HashMap<>();
        resMap.put("id", id);
        resMap.put("username", username);
        // resMap.put("iuMap", iuMap);

        resMap.put(key, key);
        resMap.put(value, value);
        resMap.put("所有参数map", paramMap);

        resMap.put("host", host);
        resMap.put("headers", headers);

        resMap.put("cookie-love", love);


       System.out.println(cookie.getName() + "=========>" + cookie.getValue());

        return resMap;
    }

    // @ResponseBody
    @PostMapping("/user")
    public Map<String, Object> bodyTest(@RequestBody Map<String, String>  map) {

        map.forEach((k, v) -> System.out.println(k + "\t" + v));

        return null;
    }


    // /car/{a};low=1;brand=byd,audi,da
    @GetMapping("/car/{a}")
    public Map<String, Object> matrixTest(@PathVariable("a") String path,
                                          @MatrixVariable("low") String low,
                                          @MatrixVariable("brand") List<String> brands) {

        Map<String, Object>  map = new HashMap<>();

        map.put("path", path);
        map.put("low", low);
        map.put("brands", brands);

        return map;
    }

    // /car/{boss};age=10/{emp};age=20
    @GetMapping("/car/{boss}/{emp}")
    public Map<String, Object> matrixTest1(@PathVariable("boss") String boss,
                                           @PathVariable("emp") String emp,
                                           @MatrixVariable(value = "age", pathVar = "boss") Integer bossAge,
                                           @MatrixVariable(value = "age", pathVar = "emp") Integer empAge
                                           ) {

        Map<String, Object>  map = new HashMap<>();

        map.put("boss", boss);
        map.put("emp", emp);
        map.put("bossAge", bossAge);
        map.put("empAge", empAge);

        return map;
    }

    @PostMapping("/person")
    public Person person(Person p) {
        return p;
    }

}
