package com.student.crm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/9/28.
 */
@Controller
public class LoginController  {
    @RequestMapping("/login")
    public String login() {

        return "redirect:static/im/index.html";
    }

}
