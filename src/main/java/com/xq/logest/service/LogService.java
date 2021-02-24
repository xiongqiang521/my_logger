package com.xq.logest.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xq.logest.bean.LoggerDTO;
import com.xq.logest.mapper.LoggerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @author XQ
 * @version v1.0
 * 2020/9/21 23:00
 */
@Service
public class LogService {
    @Autowired
    private LoggerDao loggerDao;

    public int save(LoggerDTO loggerDTO){
        return loggerDao.insert(loggerDTO);
    }

    public int delete(Serializable id){
        return loggerDao.deleteById(id);
    }

    public List<LoggerDTO> find(){
        return loggerDao.selectList(null);
    }

    public IPage<LoggerDTO> find(Page<LoggerDTO> page){
        return loggerDao.selectPage(page, null);
    }

}
