package com.javacto.service;

import com.javacto.po.SysLog;

import java.util.List;

public interface SysLogService {

    public List<SysLog> findAll() throws Exception;

    public void save(SysLog log) throws Exception;
}
