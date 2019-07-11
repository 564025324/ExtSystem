package com.extSystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.extSystem.model.User;
import com.extSystem.service.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServer userServer;


    @RequestMapping("/getuserbyid")
    public String getUserById(int id){
        User user = userServer.getUserById(id);

        String result = JSONObject.toJSONString(user);
        System.out.println(result);
        return result;
    }

    @ResponseBody
    @RequestMapping("/getuserlist")
    public String getUserList() {
//        PageInfo<User> list = userServer.selectAll(2, 2);
        List<User> list = userServer.selectAll();
        for (User u : list) {
            System.out.println("username:" + u);
        }

        String result = JSONObject.toJSONString(list);
        System.out.println(result);
        return result;
    }

}
