package com.hyd.mercury.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.hyd.mercury.common.JsonResult;
import com.hyd.mercury.dao.AuthorityMapper;
import com.hyd.mercury.entity.Authority;
import com.hyd.mercury.util.RedisUtil;

/**
 * @author: 
 * @date: 
 * @description: preHandle在控制器方法调用之前执行，postHandle在控制器方法正常执行后执行，afterCompletion不管控制器方法执行成功与否，都会执行;拦截器优于过滤器的地方就是拦截器有handler这个参数可以了解到针对哪个具体的方法进行了拦截。
 */
@Component
public class AuthorityInterceptor implements HandlerInterceptor {
    
	@Autowired
	RedisUtil redisUtil;
	@Autowired
	AuthorityMapper authorityMapper;
	
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//处理跨域问题        
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PATCH, DELETE, PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        
		/*String type = request.getParameter("type");
        if(type != null && type.equals("login")) {
        	return true;
        }
        String authority = request.getParameter("authority");
        if(authority == null) {
        	sendError(response, 896);
//        	response.sendRedirect("/login"); 
        	return false;
        }
        JSONObject authorityJson = JSONObject.parseObject(authority);
        Object infomation = authorityJson.get("infomation");
        if(infomation == null) {
        	sendError(response, 896);
//        	response.sendRedirect("/login.html"); 
        	return false; 
        }
        
        JSONObject infomationJson = JSONObject.parseObject(infomation.toString());
        Object token = infomationJson.get("token");
        String useruuid = infomationJson.getString("useruuid");
        Object redisToken = redisUtil.get(useruuid);
        //验证 token
        if(!token.equals(redisToken)) {
        	sendError(response, 896);
//        	response.sendRedirect("/login.html"); 
        	return false;
        }
        //验证是否具备请求权限
        String res = authorityJson.getString("authority");
        
        if(res == "true") {
        	String pathname = infomationJson.getString("pathname");
            Authority authorityData = new Authority();
            authorityData.setIsHidden(0);
            authorityData.setIsStop(0);
            authorityData.setLink(pathname);
            
            List<Authority> authList = authorityMapper.selectAuthorityByParam(authorityData, useruuid, null, null);
            if(authList.isEmpty()) {
            	sendError(response, 401);
            	return false;
            }
        }*/
        
        return true;
    }
	
	public void sendError(HttpServletResponse response,Integer code) throws IOException {
		response.setCharacterEncoding("UTF-8");  
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null ;
        try{
            JSONObject res = new JSONObject();
            res.put("code",code);
            res.put("msg",JsonResult.getName(code));
            out = response.getWriter();
            out.append(res.toString());
        }
        catch (Exception e){
            e.printStackTrace();
            response.sendError(500);
        }
	}
	
	
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
//        System.out.println("postHandle");
//        Long start = (Long)request.getAttribute("startTime");
//        System.out.println("time intercept 耗时：" + (System.currentTimeMillis() - start));
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception ex) throws Exception {
//        System.out.println("afterCompletion");
//        Long start = (Long)request.getAttribute("startTime");
//        System.out.println("time intercept 耗时：" + (System.currentTimeMillis() - start));
//        System.out.println("ex is" + ex);
    }
}