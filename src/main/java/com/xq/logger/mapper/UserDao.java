package com.xq.logger.mapper;

import com.xq.logger.bean.UserDTO;

public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(UserDTO record);

    int insertSelective(UserDTO record);

    UserDTO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserDTO record);

    int updateByPrimaryKey(UserDTO record);
}
