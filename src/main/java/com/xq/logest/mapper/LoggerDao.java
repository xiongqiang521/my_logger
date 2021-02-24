package com.xq.logest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xq.logest.bean.LoggerDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoggerDao extends BaseMapper<LoggerDTO> {
}
