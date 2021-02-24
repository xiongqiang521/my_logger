package com.xq.logest.annotation;

import java.lang.annotation.*;

/**
 * @author XQ
 * @version v1.0
 * 2020/9/20 14:58
 */

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Logger {

    // 打印日志的内容，默认为
    String value() default "";

    // 日志等级：1 debug; 2 info; 3 warn; 4 error;
    int level() default 2;

    // 开启日志
    boolean able() default true;

    // 是否记录至数据库
    boolean database() default false;


}
