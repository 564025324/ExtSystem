package com.extSystem.controller;

//import java.util.Map;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	@RequestMapping("/normalLogin")
	public String forwardLogin() {
//		Map<String, String[]> reqMap = request.getParameterMap();
//		System.out.println(reqMap);

		return "login";
	}

	@ResponseBody
	@RequestMapping("/submitLogin")
	public String normalLogin() {
		return "login";
	}
}
