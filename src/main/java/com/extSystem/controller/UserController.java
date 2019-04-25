package com.extSystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.extSystem.generator.model.User;
import com.extSystem.service.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServer userServer;

    @ResponseBody
    @RequestMapping("/getuserlist")
    public String getUserList() {
//        PageInfo<User> list = userServer.selectAll(2, 2);
        List<User> list = userServer.selectAll();
        String result = JSONObject.toJSONString(list);
        System.out.println(result);
        return result;
    }

}
