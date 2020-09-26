package com.xq.logger.controller;

import com.xq.logger.annotation.Logger;
import com.xq.logger.bean.UserDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author XQ
 * @version v1.0
 * 2020/9/20 15:45
 */
@RestController
@Logger("test logger")
public class IndexController {
    @RequestMapping("/")
    @Logger("test logger")
    public String index(String username, @RequestBody UserDTO user) {
        LocalDateTime time = LocalDateTime.now();
        System.out.println(user.getUsername());
        return time.toString();
    }

    @RequestMapping("/1")
    // @Logger("test logger")
    public String index1(String username, @RequestBody UserDTO user) {
        LocalDateTime time = LocalDateTime.now();
        System.out.println(user.getUsername());
        return time.toString();
    }

}
