package top.bitqian.web.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author echo lovely
 * @since 2021/4/3 18:35
 * @description
 * <p>
 *     异常处理
 *     ExceptionHandler > ResponseStatus > mvc底层异常
 * </p>
 */

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(value = {DemoException.class})
    public Map<String, Object> handlerRespException(DemoException e) {

        Map<String, Object> restMap = new HashMap<>();

        restMap.put("code", e.getCode());
        restMap.put("msg", e.getMsg());

        return restMap;
    }

    @ExceptionHandler(value = {NullPointerException.class})
    public Map<String, Object> handlerGlobalException(NullPointerException e) {

        Map<String, Object> restMap = new HashMap<>();

        restMap.put("error", "null exception...");
        restMap.put("msg", e.getMessage());

        return restMap;
    }

}
