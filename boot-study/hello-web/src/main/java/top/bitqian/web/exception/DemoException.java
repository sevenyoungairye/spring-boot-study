package top.bitqian.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author echo lovely
 * @description
 * <p>
 *     ResponseStatus 定义响应异常,
 *     默认以页面modelAndView响应, 如果有ExceptionHandler, 则可自定义响应
 *     在业务里面, 可抛出此异常, 然后就可以做出对应的响应...
 * </p>
 * @since 2021/4/3 18:43
 */

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "you don't have permission, forbidden..")
public class DemoException extends RuntimeException {

    private final Integer code = HttpStatus.FORBIDDEN.value();

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return "you don't have permission, forbidden..";
    }

    public DemoException() {
        super();
    }

    public DemoException(String message) {
        super(message);
    }
}
