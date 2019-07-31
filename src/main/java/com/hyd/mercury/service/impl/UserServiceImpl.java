package com.hyd.mercury.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.hyd.mercury.common.ResultResponse;
import com.hyd.mercury.dao.UserMapper;
import com.hyd.mercury.entity.User;
import com.hyd.mercury.entity.UserWithBLOBs;
import com.hyd.mercury.service.UserService;
import com.hyd.mercury.util.MD5Util;
import com.hyd.mercury.util.RedisUtil;

@Service
public class UserServiceImpl implements UserService{
	
	private final String authKey = "A?x\"nbN7hp,$<|ItOU^@Cc#&1%qyX.iPdH~u-8Jm";

	@Autowired
	RedisUtil redisUtil;
	
	@Autowired
	UserMapper userMapper;
		
	@Override
	public ResultResponse userLogin(String data) {
		User user = JSON.parseObject(data,User.class);
		List<UserWithBLOBs> userList = userMapper.selectUserByParam(user);
		
		if(userList.isEmpty()) {
			return ResultResponse.ErrorResponse(897);
		}
		
		UserWithBLOBs loginer = userList.get(0);
		if(loginer.getIsHidden() == 1) {
			return ResultResponse.ErrorResponse(897);
		}
		
		if(loginer.getIsStop() == 1) {
			return ResultResponse.ErrorResponse(898);
		}
		
		String password = MD5Util.md5(user.getLoginPassword() + authKey);
		if(!loginer.getLoginPassword().equals(password)) {
			return ResultResponse.ErrorResponse(899);
		}
		
		String token = MD5Util.md5(loginer.getUuid() + new Date().getTime()).toUpperCase();
		loginer.setToken(token);

		redisUtil.set(loginer.getUuid(),token);
		loginer.setLoginPassword(null);
		

		/*try {
			WebSocketServer.sendMessageTo("ok", "uuuui");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		return ResultResponse.SuccessResponse(loginer);
	}

}
