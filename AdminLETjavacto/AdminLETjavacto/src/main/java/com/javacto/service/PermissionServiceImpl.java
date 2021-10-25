package com.javacto.service;

import com.javacto.mapper.PermissionMapper;
import com.javacto.po.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * describe
 * 作者：曾昭武
 */
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;
    public List<Permission> findAll(){

        return  permissionMapper.findAll();
    }

    public  void save(Permission permission){
        permissionMapper.save(permission);
    }
}
