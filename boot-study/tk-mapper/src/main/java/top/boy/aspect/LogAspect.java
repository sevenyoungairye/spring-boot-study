package top.boy.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * @author liJinZhong
 * @version 0.0.1
 * @date 2021/03/24/14:00
 * @description <p>
 *     日志, 切点demo, aop 编程...
 * </p>
 */

@Slf4j
@Aspect
@Component
public class LogAspect {

    // 定义切点, controller 下面的所有类进行aop
    @Pointcut(value = "execution(public * top.boy.controller.*.*(..))")
    public void webLog() {

    }

    // before 前置通知
    @Before(value = "webLog()")
    public void doBefore(JoinPoint joinPoint) {
        // 获取类型
        System.out.println(joinPoint.getTarget());

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();

        // TODO: 可将这些信息, 写入数据库, 获取到访问人信息
        log.info("IP {} HOST {}", request.getRemoteAddr(), request.getRemoteHost());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            log.info("获取请求头=============> {}, {}", key , request.getHeader(key));
        }

    }

    // 方法返回之前
    @AfterReturning(returning = "returnVal", pointcut = "webLog()")
    public void doAfterReturning(Object returnVal) {

        log.info("获取到切点方法的返回值...{}", returnVal);
    }

    // 能够获取到异常消息, 但是异常还会继续抛出(如果目标方法未被捕捉)。
    @AfterThrowing(pointcut = "webLog()", throwing = "throwable")
    public void afterThrowable(JoinPoint joinPoint, Throwable throwable) {

        log.error("异常类 {}", joinPoint.getTarget());

        throwable.getMessage();

        Signature signature = joinPoint.getSignature();
        System.out.println("方法名称：" + signature.getName() + "\t类名称：" + signature.getDeclaringTypeName());
    }

    // 目标方法执行后, 方法返回(afterReturning)之前
    @After(value = "webLog()")
    public void afterMethodStrutDo(JoinPoint joinPoint) {
        System.out.println("afterMethodStrutDo ============>" + joinPoint.getThis());
    }

    // 环绕通知(所有通知的最前面)
    /*
    1. 如果环绕, 先环绕
    2. 前置before
    3. 如果环绕, before完成 调用目标方法 后面是环绕结束
    4. 环绕完成, 后置通知after
    5. 返回调用结果 afterReturning

    异常情况：
        1. 进行前置通知before
        2. 环绕调用
        3. after
        4. AfterReturning
        5. AfterThrowing
     */
    @Around(value = "webLog()")
    public Object around(ProceedingJoinPoint pjp) {

        Object proceed = null;

        // 可以对方法返回值进行动态改变
        try {
            // 调用目标方法
            proceed = pjp.proceed();
            System.out.println("around===============>" + proceed);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return proceed;
    }

}
