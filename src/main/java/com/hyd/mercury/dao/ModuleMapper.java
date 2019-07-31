package com.hyd.mercury.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hyd.mercury.entity.Module;
import com.hyd.mercury.vo.UserAuthorityVo;

@Mapper
public interface ModuleMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Module record);

    int insertSelective(Module record);

    Module selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);
    
    List<UserAuthorityVo> selectModuleByParam(Module record);
}