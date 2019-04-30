package com.extSystem.controller;

//import java.util.Map;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @RequestMapping("/normalLogin")
    public String forwardLogin() {
        System.out.println("登录");
        return "login";
    }

    @RequestMapping("/submit")
    public String normalLogin(HttpServletRequest req, HttpServletResponse resp, Model model) {
        if (req == null) {
            System.out.println("request is null");
        }

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username != null) {
            System.out.println(username);
            System.out.println(password);
            model.addAttribute("username", username);
            return "welcome";
        } else {
            return "error";
        }

    }


}
