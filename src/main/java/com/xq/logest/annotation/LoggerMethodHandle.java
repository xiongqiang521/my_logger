package com.xq.logest.annotation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xq.logest.bean.LoggerDTO;
import com.xq.logest.service.LogService;
import com.xq.logest.util.JsonUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * 具体参考：<b>https://blog.csdn.net/f641385712/article/details/83543270</b>
 * @author XQ
 * @version v1.0
 * 2020/9/20 15:26
 */
@Aspect
@Component
public class LoggerMethodHandle {

    @Autowired
    private LogService logService;

    /**
     * 切入点
     */
    @Pointcut("@annotation(com.xq.logest.annotation.Logger)")
    private void pointcut() {

    }

    // @Around(value = "pointcut() && @annotation(myLog)")
    public Object around(ProceedingJoinPoint point, Logger myLog) throws Throwable {

        System.out.println("++++执行了around方法++++");
        //拦截的类名
        Class clazz = point.getTarget().getClass();
        //拦截的方法
        Method method = ((MethodSignature) point.getSignature()).getMethod();

        // 入参的数据
        Object[] args = point.getArgs();
        System.out.println(Arrays.toString(args));

        System.out.println("环绕通知-前：" + clazz);
        System.out.println("环绕通知-前：" + method);

        // String name = point.getSignature().getName();
        // System.out.println(name);

        try {
            //执行程序
            Object proceed = point.proceed();

            // 返回值
            System.out.println("环绕通知-后：" + proceed);

            return proceed;
        } catch (Throwable throwable) {
            // throwable.printStackTrace();
            // return throwable.getMessage();
            throw new Throwable(throwable);
        }
    }


    @Before(value = "pointcut() && @annotation(logger)")
    public void before(JoinPoint point, Logger logger) {

        Object[] args = point.getArgs();

        String method = ((MethodSignature) point.getSignature()).getMethod().toGenericString();
        try {
            saveData(method,
                    JsonUtil.write(args),
                    MethodTime.BEFORE,
                    logger);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println("前置通知：" + logger + "arg:" + Arrays.toString(args) + "method:" + method);
    }

    @AfterReturning(value = "pointcut() && @annotation(logger)", returning = "result")
    public void after(JoinPoint point, Logger logger, Object result)  {
        String method = ((MethodSignature) point.getSignature()).getMethod().toString();
        try {
            saveData(method,
                    JsonUtil.write(result),
                    MethodTime.AFTER,
                    logger);
        } catch (JsonProcessingException e) {

            e.printStackTrace();

        }
        System.out.println("后置通知：" + result + "result:" +result + "method:" +method);
    }

    @AfterThrowing(value = "pointcut() && @annotation(logger)", throwing = "exception")
    public void afterException(JoinPoint point, Logger logger, Exception exception) {
        Object[] args = point.getArgs();
        System.out.println(Arrays.toString(args));

        String s = exception.toString();
        System.out.println(s);

        StackTraceElement[] stackTraces = exception.getStackTrace();
        System.out.println("===============");
        for (StackTraceElement stackTrace : stackTraces) {
            System.out.println(stackTrace.toString());
        }
        System.out.println("===============");

        saveData(((MethodSignature) point.getSignature()).getMethod().toString(),
                exception.toString(),
                MethodTime.EXEC,
                logger);

    }

    private void saveData(String method, String objJson, MethodTime type, Logger logger) {
        LoggerDTO loggerDTO = new LoggerDTO();
        loggerDTO.setLevel(logger.level());
        loggerDTO.setMethod(method);
        loggerDTO.setType(type.getType());
        loggerDTO.setParams(objJson);

        loggerDTO.setTime(LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE));

        System.out.println(loggerDTO);
        logService.save(loggerDTO);

    }

}
