package com.hyd.mercury.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.hyd.mercury.common.ResultResponse;
import com.hyd.mercury.dao.AuthorityMapper;
import com.hyd.mercury.dao.ModuleMapper;
import com.hyd.mercury.entity.Authority;
import com.hyd.mercury.entity.Module;
import com.hyd.mercury.service.AuthorityService;
import com.hyd.mercury.vo.UserAuthorityVo;

@Service
public class AuthorityServiceImpl implements AuthorityService{
	
	@Autowired
	AuthorityMapper authorityMapper;
	
	@Autowired
	ModuleMapper moduleMapper;
	
	@Override
	public ResultResponse getUserAuthorityList(String data, String useruuid) {
		Authority authority = new Authority();
		if(!StringUtils.isEmpty(data)) {
			Authority authorityData = JSON.parseObject(data,Authority.class);
			if(authorityData != null) {
				authority = authorityData;
			}
		}
		
		authority.setIsHidden(0);
		authority.setIsStop(0);
		List<Authority> authorityList = authorityMapper.selectAuthorityByParam(authority, useruuid, "g.sort ASC,a.code ASC", null);
		
		Module moduleData = new Module();
		moduleData.setIsHidden(0);
		moduleData.setIsStop(0);
		List<UserAuthorityVo> moduleList = moduleMapper.selectModuleByParam(moduleData);
		
		for (UserAuthorityVo userAuthorityVo : moduleList) {
			for (Authority auth : authorityList) {
				if(userAuthorityVo.getUuid().equals(auth.getModuleUuid())) {
					
					if(userAuthorityVo.getAuthorityList() == null) {
						List<Authority> list = new ArrayList<Authority>();
						list.add(auth);
						userAuthorityVo.setAuthorityList(list);
					} else {
						userAuthorityVo.getAuthorityList().add(auth);
					}
				}
			}
		}
		
		return ResultResponse.SuccessResponse(moduleList);
	}

}
