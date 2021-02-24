package com.xq.logest.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 自动日志打印配置
 *
 * @author XQ
 * @version v1.0
 * 2020/10/3 21:13
 */

@ConfigurationProperties(prefix = "logger")
@Data
public class LoggerConfigProperty {

    private boolean enableSpringAnnotation = true;
    private boolean enableDatabase = false;
    private String user = "";
    private Database database = null;

    @Data
    public static class Database {
        private String username;
        private String password;
        private String url;
        private String type;
    }
}
