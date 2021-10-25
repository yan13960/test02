package com.javacto.contoller;

import com.javacto.po.SysLog;
import com.javacto.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/log")
@Controller
public class SysLogAction {

    @Autowired
    private SysLogService logService;

    @RequestMapping("queryAll")
    public  String queryAll(Model model) throws Exception {

        List<SysLog> list = logService.findAll();
        model.addAttribute("sysLogs",list);

        return "syslog-list";
    }
}
