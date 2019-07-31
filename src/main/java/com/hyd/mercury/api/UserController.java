package com.hyd.mercury.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hyd.mercury.common.BaseController;
import com.hyd.mercury.common.ResultResponse;
import com.hyd.mercury.service.UserService;

@RestController
public class UserController extends BaseController{

	@Autowired
	UserService userService;
	
	@GetMapping(value = { "/api/v2/User" }, produces = "application/json;charset=UTF-8")
	public ResultResponse index(@RequestParam(required = false) String type, String data) {
		if(type.equals("login")) {
			return userService.userLogin(data);
		} else if(type.equals("ceshi")){
			return ResultResponse.SuccessResponse(data);
		}
		return ResultResponse.SuccessResponse(data);
	}

	@GetMapping(value = { "/api/v2/User/{id}" }, produces = "application/json;charset=UTF-8")
	public ResultResponse read(@PathVariable String id, @RequestParam(required = false) String data) {
		return ResultResponse.SuccessResponse(data);
	}

	@PostMapping(value = { "/api/v2/User" }, produces = "application/json;charset=UTF-8")
	public ResultResponse save(@RequestBody(required = false) String data) {
		return ResultResponse.SuccessResponse(data);
	}

	@PutMapping(value = { "/api/v2/User/{id}" }, produces = "application/json;charset=UTF-8")
	public ResultResponse update(@PathVariable String id, @RequestBody(required = false) String data) {
		return ResultResponse.SuccessResponse(data);
	}

	@DeleteMapping(value = { "/api/v2/User/{id}" }, produces = "application/json;charset=UTF-8")
	public ResultResponse delete(@PathVariable String id, @RequestBody(required = false) String data) {
		return ResultResponse.SuccessResponse(data);
	}
}
