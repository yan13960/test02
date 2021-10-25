package cn.itnanls.controller;

import cn.itnanls.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 */
//@Component
@Controller
public class UserController {
      @Autowired
      private IUserService userService;

      public void showUser(Integer id){
          System.out.println(userService.findUserById(id));
      }
}
