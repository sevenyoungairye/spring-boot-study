package top.bitqian.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.bitqian.web.exception.DemoException;

/**
 * @author echo lovely
 * @description
 * <p>
 *     exception test...
 * </p>
 * @since 2021/4/3 18:50
 */

@RestController
public class MyErrorController {

    @GetMapping("/e/{id}")
    public Object respError(@PathVariable("id") Integer id) {

        if (id < 0) {
            throw new DemoException();
        }

        if (id == 0) {
            throw new DemoException("num < 0, error...");
        }

        return "okk";
    }

}
