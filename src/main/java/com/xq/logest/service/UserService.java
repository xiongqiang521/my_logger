package com.xq.logest.service;

import com.xq.logest.bean.UserDTO;
import com.xq.logest.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author XQ
 * @version v1.0
 * 2020/9/29 23:51
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public int save(UserDTO userDTO){
        int insert = userDao.insert(userDTO);
        return insert;
    }

    public List<UserDTO> get(){
        List<UserDTO> userDTOList = userDao.selectAll();
        return userDTOList;
    }

}
