package com.xq.logest;

import com.xq.logest.annotation.LoggerMethodHandle;
import com.xq.logest.config.LoggerConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyLoggerApplicationTests {


    @Autowired
    LoggerMethodHandle handle;


    @Autowired
    LoggerConfig loggerConfig;

    /**
     * 测试spring自动配置获取配置的信息
     */
    @Test
    public void test1() {
        System.out.println(loggerConfig.getProperty());
    }


}
