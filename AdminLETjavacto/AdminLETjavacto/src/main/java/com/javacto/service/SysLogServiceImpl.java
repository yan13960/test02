package com.javacto.service;

import com.javacto.mapper.SysLogDao;
import com.javacto.po.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysLogServiceImpl implements  SysLogService{

    @Autowired
    private SysLogDao sysLogDao;
    public List<SysLog> findAll() throws Exception {
        return  sysLogDao.findAll();
    }

    public void save(SysLog log) throws Exception{
        sysLogDao.save(log);
    }
}
