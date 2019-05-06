package com.extSystem.controller;

//import java.util.Map;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.extSystem.model.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private JsonResult jsonResult;
    private String jsonStr;


    @RequestMapping("/normalLogin")
    public String forwardMyLogin() {
        System.out.println("登录");
        return "myLogin";
    }

    @RequestMapping("/login")
    public String forwardLogin() {
        System.out.println("登录");
        return "login";
    }

    @ResponseBody
    @RequestMapping("/clickLogin")
    public String clickLogin(HttpServletRequest request, HttpServletResponse response) {
        jsonResult = new JsonResult();
        Map<String, String[]> requestMap = request.getParameterMap();
        String[] value = null;
        for (String key : requestMap.keySet()) {
            value = requestMap.get(key);
            System.out.println(key + ":" + value.toString());
        }
        jsonResult.setCode(1);
        jsonResult.setMsg("登陆成功");
        jsonResult.setData(requestMap);
        request.getRequestDispatcher("/index.html");

        String jsonStr = JSONObject.toJSONString(jsonResult);
        System.out.println("jsonStr = " + jsonStr);
        return jsonStr;
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
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


    public JsonResult getJsonResult() {
        return jsonResult;
    }

    public void setJsonResult(JsonResult jsonResult) {
        this.jsonResult = jsonResult;
    }

}
