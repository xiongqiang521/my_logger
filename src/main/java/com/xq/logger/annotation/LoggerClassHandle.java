package com.xq.logger.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 具体参考：<b>https://blog.csdn.net/f641385712/article/details/83543270</b>
 *
 * @author XQ
 * @version v1.0
 * 2020/9/20 15:26
 */
@Aspect
@Component
public class LoggerClassHandle {

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    private void restController() {
    }

    @Pointcut("@within(org.springframework.stereotype.Controller)")
    private void controller(){
    }

    @Pointcut("@within(org.springframework.stereotype.Service)")
    private void service(){
    }

    @Pointcut("@within(org.springframework.stereotype.Component)")
    private void component(){
    }
    @Pointcut("@within(org.springframework.stereotype.Repository)")
    private void repository(){
    }


    @Pointcut("restController() || controller() || service() || component() || repository()")
    private void pointcut(){
    }

    @After("pointcut()")
    public void after(JoinPoint point) {
        System.out.println("class===>>>" + point);
    }

}
