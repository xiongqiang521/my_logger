package com.xq.logger.bean;

import com.xq.logger.annotation.Logger;
import com.xq.logger.util.JsonUtil;
import lombok.Data;
import org.aspectj.lang.JoinPoint;

import java.io.Serializable;
import java.util.Date;

/**
 * logger
 *
 * @author
 */
@Data
public class LoggerDTO implements Serializable {

    public LoggerDTO(){}

    private Long id;

    /**
     * 1 debug;
     * 2 info;
     * 3 warn;
     * 4 error;
     */
    private Integer level;

    private String time;

    /**
     * 方法名
     */
    private String method;

    /**
     * 0 方法执行前;
     * 1 方法执行后;
     */
    private Byte type;

    /**
     * 进入方法的参数，以json格式表示
     * 出方法的返回结果
     */
    private String params;

    /**
     * 操作的用户
     */
    private Integer user;

    /**
     * 0 无异常;
     * 1 有异常;
     */
    private Byte isException;

    /**
     * 异常内容
     */
    private String exception;


}
