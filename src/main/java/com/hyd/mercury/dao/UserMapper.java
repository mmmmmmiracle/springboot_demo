package com.hyd.mercury.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hyd.mercury.entity.User;
import com.hyd.mercury.entity.UserWithBLOBs;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(UserWithBLOBs record);

    int insertSelective(UserWithBLOBs record);

    UserWithBLOBs selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(UserWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(UserWithBLOBs record);

    int updateByPrimaryKey(User record);
    
    List<UserWithBLOBs> selectUserByParam(@Param("user") User user);
}