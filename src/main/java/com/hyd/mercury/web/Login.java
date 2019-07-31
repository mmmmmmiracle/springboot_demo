package com.hyd.mercury.web;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.github.jscookie.javacookie.Cookies;
import com.github.jscookie.javacookie.Cookies.Attributes;
import com.hyd.mercury.util.RedisUtil;

@Controller
public class Login {

	@Autowired
	RedisUtil redisUtil;
	
    @GetMapping("/login")
    public String login(HttpServletRequest request,HttpServletResponse response) {
        this.clearData(request,response);    	
        return "login/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response)
    {
        this.clearData(request,response);
	  	return "login/login";
    }
    
    private void clearData(HttpServletRequest request,HttpServletResponse response) {
    	    	
    	Cookies cookies = Cookies.initFromServlet( request, response );
    	//利用登录页面,强制刷新用户权限列表的Redis缓存
    	if(cookies.get("USERUUID")!=null) {
    		redisUtil.set("authority_"+cookies.get("USERUUID"), null);
    	}
    	
    	//清空所有Cookie缓存
    	Map<String, String> allCookies = cookies.get();    	
    	for (Map.Entry<String, String> entry : allCookies.entrySet()) {
    		
    		cookies.remove( entry.getKey(), Attributes.empty().path( "/" ) ); // removed!

    	}
    	    	
    }

}

