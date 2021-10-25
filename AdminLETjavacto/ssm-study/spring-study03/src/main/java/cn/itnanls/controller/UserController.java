package cn.itnanls.controller;

import cn.itnanls.Annotation.LogAnnotation;
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

      @LogAnnotation("show-show")
      public String showUser(Integer id){

          System.out.println(userService.findUserById(id));
            //int i=1/0;
           //throw  new RuntimeException("ERROR");

          try {
              Thread.sleep(1000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          return "adasdasdas";
      }
}
