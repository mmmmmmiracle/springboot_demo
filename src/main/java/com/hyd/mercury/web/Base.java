package com.hyd.mercury.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.jscookie.javacookie.Cookies;
import com.hyd.mercury.common.ResultResponse;
import com.hyd.mercury.entity.Authority;
import com.hyd.mercury.util.HttpUtil;
import com.hyd.mercury.util.RedisUtil;
import com.hyd.mercury.vo.UserAuthorityVo;


public class Base {
	
	@Autowired
	RedisUtil redisUtil;
	
    public ResultResponse sendHttpRequests(String url, String type, String data, String authority) {
    	//api url地址
        url = url + "?type=" + type + "&data= {data}&authority={authority}";
        //请求类型
        HttpMethod method =HttpMethod.GET;
        // 封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        // params.add("type", "ceshi");
        // params.add("data", "xdc");
        //发送http请求并返回结果
        ResultResponse result = HttpUtil.sendPostRequest(url,method,params,data,authority);
		return result;

    }
	
	public void preFilledFragments(HttpServletRequest request,HttpServletResponse response, Model model) {
		
		String username=null;
		String headimg=null;
		String sideBarHTMLCode=null;
		String userAuthorityStr=null;
		
		Cookies cookies = Cookies.initFromServlet( request, response );
    	//利用登录页面,强制刷新用户权限列表的Redis缓存
    	if(cookies.get("USERNAME")!=null) {
    		username = cookies.get("USERNAME");
    	}
		
    	if(cookies.get("HEADIMG")!=null) {
    		headimg = cookies.get("HEADIMG");
    	}		
		
    	if(cookies.get("USERUUID")!=null&&cookies.get("TOKEN")!=null) {
    		
    		Object userAuthorityObj = redisUtil.get("authority_"+cookies.get("USERUUID"));
    		  		
    		if(StringUtils.isEmpty(userAuthorityObj)) {
    			JSONObject infomationObj = new JSONObject();
    			infomationObj.put("useruuid", cookies.get("USERUUID"));
    			infomationObj.put("authorityuuid", "/");
    			infomationObj.put("token", cookies.get("TOKEN"));
    			String infomationStr = infomationObj.toString();
    			
    			JSONObject authorityObj = new JSONObject();
    			authorityObj.put("authority", false);
    			authorityObj.put("infomation", infomationStr);
    			String authorityStr = authorityObj.toString();
    			
    			String url = "http://127.0.0.1:8080/api/v2/Authority";
    			ResultResponse result = this.sendHttpRequests(url, "user_authority", "", authorityStr);
    			if(result.getCode() == 200) {
    				redisUtil.set("authority_"+cookies.get("USERUUID"),result.getData());
    				userAuthorityObj = result.getData();
    			}	
    		}
    		userAuthorityStr = JSONArray.toJSONString(userAuthorityObj);
//    		List<UserAuthorityVo> userAuthorityList = JSON.parseArray(str, UserAuthorityVo.class);
//    		
//    		StringBuilder strBulder = this.setSideBarHTMLCode(userAuthorityList,cookies.get("SELECTED_MODULE_UUID"),cookies.get("SELECTED_AUTHORITY_UUID"));
//    		sideBarHTMLCode = strBulder.toString();
    	}
    	
    	model.addAttribute("HEADIMG", "/static/assets/layouts/layout/img/photo2.jpg");
    	model.addAttribute("USERNAME", username);
    	model.addAttribute("sideBarHTMLCode", userAuthorityStr);
	}
	
/*	private StringBuilder setSideBarHTMLCode(List<UserAuthorityVo> userAuthorityList,String selectedModuleUUID,String selectedAuthorityUUID) {
//		String sideBarHTMLCode = "";
		StringBuilder sideBarHTMLCode = new StringBuilder();
		for(UserAuthorityVo module:userAuthorityList) {
			if(module.getAuthorityList()!=null && !module.getAuthorityList().isEmpty()) {
				sideBarHTMLCode = sideBarHTMLCode.append("<li class=\"nav-item "+(module.getUuid()==selectedModuleUUID?"active open":"")+"\"><a href=\"javascript:;\" class=\"nav-link nav-toggle\" data-uuid=\""+module.getUuid()+"\"><i class=\""+module.getIconName()+"\"></i><span class=\"title\"> "+module.getName()+"</span><span class=\"arrow\"></span></a>");
				sideBarHTMLCode = sideBarHTMLCode.append("<ul class=\"sub-menu\">");
				
				for(Authority authority:module.getAuthorityList()) {
                    sideBarHTMLCode = sideBarHTMLCode.append("<li class=\"nav-item start\"><a href=\"javascript:;\" data-link=\""+authority.getLink()+"\" data-uuid=\""+authority.getUuid()+"\" class=\"nav-link sec-lv "+(authority.getUuid()==selectedAuthorityUUID?"active":"")+"\"><i class=\"icon-list\"></i><span class=\"title\"> "+authority.getAuthName()+"</span></a></li>");                    					
				}
				sideBarHTMLCode = sideBarHTMLCode.append("</ul>");                    

                sideBarHTMLCode = sideBarHTMLCode.append("</li>");
				
			}
		}
		return sideBarHTMLCode;
	}*/
}
