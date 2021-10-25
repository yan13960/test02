package com.javacto.contoller;

import com.javacto.po.Permission;
import com.javacto.po.Role;
import com.javacto.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/role")
public class RoleAction {


    @Autowired
    private RoleService roleService;
    /**
     * 查询用户
     */
    @RequestMapping("/queryAll")
    public  String queryAll(Model model){
        List<Role> list= roleService.queryAll();
        model.addAttribute("roleList",list);
        return "role-list";
    }


    @RequestMapping("/save")
    public  String save(Model model, Role role){
        String uuid= UUID.randomUUID().toString().replaceAll("-","");
        role.setId(uuid);
        roleService.insert(role);

        return "redirect:/rest/role/queryAll.do";
    }



    @RequestMapping("/findByIdAndPermission")
    public  String findByIdAndPermission(Model model, String roleId){

        List<Permission>  list = roleService.findOtherPermissions(roleId);

        model.addAttribute("permissionList",list);
        model.addAttribute("roleId",roleId);
        return "role-permission-add";
    }


    @RequestMapping("/addPermissionToRole")
    public  String addPermissionToRole(Model model, String roleId, String[] permissionIds){

        roleService.addPermissionToRole(roleId,permissionIds);
        return "redirect:/rest/role/queryAll.do";
    }
}
