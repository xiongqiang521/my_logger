package com.xq.logger;

import com.xq.logger.annotation.LoggerMethodHandle;
import com.xq.logger.bean.UserDTO;
import com.xq.logger.controller.IndexController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyLoggerApplicationTests {

    @Autowired
    IndexController controller;

    @Autowired
    LoggerMethodHandle handle;

    @Test
    public void contextLoads() {
        System.out.println(controller.index("aa", new UserDTO()));
    }


}
