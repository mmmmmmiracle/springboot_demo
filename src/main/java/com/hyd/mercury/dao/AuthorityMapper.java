package com.hyd.mercury.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hyd.mercury.entity.Authority;

@Mapper
public interface AuthorityMapper {
	
    int deleteByPrimaryKey(String uuid);

    int insert(Authority record);

    int insertSelective(Authority record);

    Authority selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Authority record);

    int updateByPrimaryKey(Authority record);
    
    List<Authority> selectAuthorityByParam(@Param("authority") Authority authority, @Param("useruuid") String useruuid, @Param("order") String order, @Param("type") String type);

}