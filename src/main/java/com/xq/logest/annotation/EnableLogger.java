package com.xq.logest.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author XQ
 * @version v1.0
 * 2020/10/3 23:50
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
@Documented
@Import(Logger.class)
public @interface EnableLogger {

}
