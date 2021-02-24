package com.xq.logest.config;

/**
 * @author XQ
 * @version v1.0
 * 2020/10/3 22:08
 */

public class LoggerService {

    private LoggerConfigProperty property;

    public LoggerService(LoggerConfigProperty property) {
        this.property = property;
    }

    public String getProperty() {
        return property.toString();
    }

}
