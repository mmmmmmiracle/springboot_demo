package com.hyd.mercury.service;

import com.hyd.mercury.common.ResultResponse;

public interface UserService {
	
	//用户登录验证
	public ResultResponse userLogin(String user);
}
