package com.javacto.contoller;

import com.javacto.po.Permission;
import com.javacto.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

/**
 * describe
 * 作者：曾昭武
 */
@Controller
@RequestMapping("/permission")
public class PermissionAction {

    @Autowired
    private PermissionService permissionService;
    /**
     * 查询用户
     */
    @RequestMapping("/queryAll")
    //@PreAuthorize("hasRole('ROLE_USER')")
   // @PreAuthorize("hasRole('ROLE_USER') and hasRole('ROLE_ADMIN')")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public  String queryAll(Model model){
        List<Permission> list= permissionService.findAll();
        model.addAttribute("permissionList",list);
        return "permission-list";
    }

    /**
     * 添加资源权限
     */

    @RequestMapping("/save")
    @PreAuthorize("authentication.principal.username == 'root'")
    public  String save(Model model, Permission permission){
        String uuid= UUID.randomUUID().toString().replaceAll("-","");
        permission.setId(uuid);
        permissionService.save(permission);
        return "redirect:/rest/permission/queryAll.do";
    }

}
