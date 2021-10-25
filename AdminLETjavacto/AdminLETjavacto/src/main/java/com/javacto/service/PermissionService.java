package com.javacto.service;

import com.javacto.po.Permission;

import java.util.List;

/**
 * describe
 * 作者：曾昭武
 */
public interface PermissionService {

    public List<Permission> findAll() ;
    public  void save(Permission permission);
}
