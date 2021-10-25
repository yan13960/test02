package com.javacto.contoller;

import com.javacto.po.Role;
import com.javacto.po.UserInfo;
import com.javacto.service.UserService;
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
@RequestMapping("/user")
public class UserAction {

    @Autowired
    private UserService userService;
    /**
     * 查询用户
     */
    @RequestMapping("/queryAll")
    public  String queryAll(Model model){
        List<UserInfo> list= userService.queryAll();
        model.addAttribute("userList",list);
        return "user-list";
    }

    /**
     * 添加用户
     */

    @RequestMapping("/save")
    public  String save(Model model, UserInfo userInfo){
        String uuid= UUID.randomUUID().toString().replaceAll("-","");
        userInfo.setId(uuid);
        userService.insert(userInfo);

        return "redirect:/rest/user/queryAll.do";
    }

    /**
     * 根据id查询用户信息
     */
    @RequestMapping("/findById")
    public  String save(Model model, String userId){
        UserInfo userInfo= userService.findById(userId);
        model.addAttribute("user",userInfo);
        return "user-show";
    }

    @RequestMapping("/findByOtherRolesId")
    public  String findByOtherRolesId(Model model, String userId){
        //查询可以添加的用户权限信息
        List<Role> list = userService.findOtherRoles(userId);


        model.addAttribute("userId",userId);
        model.addAttribute("roleList",list);
        return "user-role-add";
    }


    @RequestMapping("/addRoleToUser")
    public  String addRoleToUser(Model model, String userId, String[] roleIds){
        userService.addRoleToUser(userId,roleIds);
        //调用业务层方法
        return "redirect:/rest/user/queryAll.do";
    }




}
