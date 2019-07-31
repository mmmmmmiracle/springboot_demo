package com.hyd.mercury.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.alibaba.fastjson.JSONObject;

public class BaseController {
	
	protected String useruuid = null;
	protected String data = null;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	@ModelAttribute
    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        
        String authority = request.getParameter("authority");
        this.data = request.getParameter("data");
		if(!StringUtils.isEmpty(authority)) {
	        Object infomation = JSONObject.parseObject(authority).get("infomation");
	        JSONObject infomationJson = JSONObject.parseObject(infomation.toString());
	        this.useruuid = infomationJson.getString("useruuid");
		}
    }
}
