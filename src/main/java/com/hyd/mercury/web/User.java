package com.hyd.mercury.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class User extends Base {

	@GetMapping("/web/user/userInformation")
    public String greeting(HttpServletRequest request,HttpServletResponse response, Model model) {
		preFilledFragments(request, response,model);
        return "user/userInformation";
    }
	
}
