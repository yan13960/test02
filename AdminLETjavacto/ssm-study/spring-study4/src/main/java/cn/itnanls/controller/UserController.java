package cn.itnanls.controller;

import cn.itnanls.Annotation.LogAnnotation;
import cn.itnanls.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 *
 */
//@Component
@Controller
public class UserController {
    @Autowired
    private IUserService UserService;

    public void showUser(Integer id){
        System.out.println(UserService.findUserById(id));
    }

}
