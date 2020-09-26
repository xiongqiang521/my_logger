package com.xq.logger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xq.logger.bean.LoggerDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public interface LoggerDao extends BaseMapper<LoggerDTO> {
}
